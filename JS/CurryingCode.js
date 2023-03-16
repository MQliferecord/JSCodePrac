/***
 * 柯里化编程
 */

const currying = (fn)=>{
    return function func(a){
        if(fn.length == 1)return fn(a)
        fn = fn.bind(this,a)
        return func
    }
}
