/***
 * call()
 */
Array.prototype.call_ = function(thisArg,...args){  
    thisArg = thisArg||window
    args = args||{}
    thisArg.func = this
    let res = thisArg.func(...args)
    delete thisArg.func
    return res
}