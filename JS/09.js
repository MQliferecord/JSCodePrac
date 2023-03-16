/**
 * JS异步数据流，实现并发异步请求，结果顺序输出
*/

let func = async function(arr){
    let pros = arr.map(item=>axios.get(item))
    return Promise.all(pros).then(res=>{
        console.log(res)
    })
}