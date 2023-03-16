/**
 * new()
 */

const new_ = (Parent,...args)=>{
    const son = {}
    son.__proto__ = Parent.prototype
    let ans = Parent.call(this,...args)
    return ans instanceof Object? ans:son
}
