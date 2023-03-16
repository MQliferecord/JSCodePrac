/**
 * 寄生组合式继承
 * 请补全JavaScript代码，实现以下功能：
1. 给"Human"构造函数的原型对象添加"getName"方法，返回当前实例"name"属性
2. 将"Chinese"构造函数继承于"Human"构造函数
3. 给"Chinese"构造函数的原型对象添加"getAge"方法，返回当前实例"age"属性
 */

function Human(name){
    this.name = name 
    this.kindom = 'animal'
    this.color = ['yellow','white','brown','black']
}
function Chinese(name,age){
    Human.call(this,name)
    this.age = age
    this.color = 'yellow'
}
Human.prototype.getName = function(){
    return this.name
}

Chinese.prototype.getAge = function(){
    return this.age
}

function inhertType(subType,ParType){
    const fn = function(){
        this.constructor = subType
    }
    fn.prototype = ParType.prototype
    subType.prototype = new fn()
}
inhertType(Chinese,Human)
