/**
 * instanceof
 */

const instanceof_ = (object,target)=>{
    if(object.__proto__ === target.prototype){
        return true
    }
    const proto = target.prototype
    if(proto){
        instanceof_(object.prototype,proto)
    }else{
        return false
    }
}