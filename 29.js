/**
 * bind()
 */

Array.prototype.bind_ = function(thisArg,...args1){
    let this_ = this
    return function(...args2){
        return this_.call(thisArg,...args1,...args2)
    }
}