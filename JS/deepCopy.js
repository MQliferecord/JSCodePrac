/** 
 * 深拷贝
 */

const __deepCopy = target=>{
    if(typeof target === null||typeof target !== 'object'){
        return target
    }
    const copyTarget = new target.constructor()
    for(let key in target){
        if(target.hasOwnProperty){
            copyTarget[key] = __deepCopy(target[key])
        }
    }
    return copyTarget
}