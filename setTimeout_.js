/**
 * 使用setInterval实现setTimeout
 */

let setTimeout_ = (fn,timer)=>{
    let interval = setInterval(()=>{
        fn()
        clearInterval(interval)
    },timer)
    interval()
}