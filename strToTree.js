/**
 * 将对象字符串转成树形结构
 */

let strToTree = (str)=>{
    let obj = {}
    for(let key in str){
        let propertyNames = key.split('-')
        let lastPropertyName = propertyNames.pop()
        let newObj = obj
        for(let propertyName of propertyNames){
            newObj[propertyName] = newObj[propertyName]||{}
            newObj = newObj[propertyName]
        }
        newObj[lastPropertyName] = str[key]
    }
    return obj
}

let strarr = {  
    'a-b-c-d':1,  
    'a-b-c-e':2,  
    'a-b-f':3,  
    'a-j':4  
}
console.log(strToTree(strarr))