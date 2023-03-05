/**
 * 使用setTimeout封装setInterval
*/

let setInterval_ = function(fn,timer){
    return new Promise((resolve)=>{
        setTimeout(()=>{
            fn()
            setInterval_(fn,timer)
            resolve()
        },timer)
    })
}

//测试案例
let fns = function(){
    console.log('hello')
}
setInterval_(fns,1000)