/***
 * 浅拷贝
 */

const __shallowCopy = target =>{
    if(typeof target===null||typeof target!=='object'){
        return target
    }
    const copyTarget = new target.constructor()
    for(let key in target){
        copyTarget[key] = target[key]
    }
    return copyTarget
}