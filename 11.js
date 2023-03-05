/**
 * 处理高并发，100条数据，带宽为10，跑满带宽
 */

let asyncPool = (arr,limit)=>{
    //输入数据长度
    let len = arr.length
    //所有执行的任务
    let result = []
    //正在执行的数据
    let exeting = []
    let asyncPool_ = async()=>{
        //所有的任务执行完毕后，返回resolve
        if(arr.length == 0){
            return Promise.resolve()
        }
        //单个任务取出
        let item = arr.shift()
        //给任务封装成axios请求
        let p = Promise.resolve().then(()=>axios.get(item))
        //放进待办任务队列
        exeting.push(p)
        //放进总队列中
        result.push(p)

        //-----------关键代码：封装成异步------------
        let r = Promise.resolve()

        //总任务长度小于池子长度，递归调用，全部并发
        if(len<=limit){
            if(arr.length == 0){
                r = Promise.race(exeting)
            }
            r.then(()=>asyncPool_())
        }
        //池子已满，开启并发
        if(exeting.length>=limit){
            r = Promise.race(exeting)
        }
        return r.then((res,index)=>{
            exeting.splice(index,1)
            asyncPool_()
        })
    }
    return asyncPool_.then(()=>Promise.all(result))
}