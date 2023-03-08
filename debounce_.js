/**
 * 节流代码
 */
const debounce_ = function (fn, wait) {
    let timer
    return function () {
        if (!fn) clearTimeout(timer)
        timer = setTimeout(() => {
            fn(...args)
            clearTimeout(timer)
        }, wait)
    }
}