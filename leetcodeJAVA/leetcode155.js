/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
实现 MinStack 类:
MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。
 */
var MinStack = function() {
    this.cache = [];
    this.minVal = Number.MAX_VALUE
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    this.cache.push(val)
    this.minVal = Math.min(this.minVal,val)
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.cache.pop()
    this.minVal = Number.MAX_VALUE
    for(let key in this.cache){
        this.minVal = Math.min(this.minVal,this.cache[key])
    }
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    this.minVal = Number.MAX_VALUE
    for(let key in this.cache){
        this.minVal = Math.min(this.minVal,this.cache[key])
    }
    return this.cache.slice(-1)
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.minVal
};