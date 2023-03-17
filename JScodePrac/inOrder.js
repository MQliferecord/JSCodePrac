/**
 * Promise串行执行
 */

function inOrder(arr){
    const res = []
    return new Promise((resolve)=>{
        arr.reduce((pre,cur)=>{
            return pre.then(cur).then(data=>res.push(data))
        },Promise.resolve())
        .then(()=>resolve(res))
    })
}

inOrder(arr).then(ans=>{
    console.log(ans)
})

//测试案例
const func = [
    ()=>new Promise((resolve)=>{
        setTimeout(()=>resolve(1),1000)
    }),
    ()=>new Promise((resolve)=>{
        setTimeout(()=>resolve(2),3000)
    }),
    ()=>new Promise((resolve)=>{
        setTimeout(()=>resolve(3),5000)
    }),
]