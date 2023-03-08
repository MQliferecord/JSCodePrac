/**
 * 防抖代码
 */

const throttle_ = function(fn,wait){
    let timer = 0
    return function(...args){
        const now = Date.now()
        if(now-timer>wait){
            fn(...args)
            timer = now
        }
    }
}