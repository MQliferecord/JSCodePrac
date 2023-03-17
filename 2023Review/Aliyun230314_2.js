/**
 * 串联多个 Promise 请求
假设我们需要向后端发送一系列顺序相关的请求，最后得到这些请求的结果，需要实现一个 promise 的串联函数

// 顺序相关的请求序列
const promise1 = () => asyncRequestA();
const promise2 = () => asyncRequestB();
const promise3 = () => asyncRequestC();
// 串联这些请求
chainPromise([promise1, promise2, promise3]).then(([result1, result2, result3]) => {
  // promise1 promise2 promise3 按序执行完毕，分别得到结果 result1, result2, result3
});
需求：
1. 实现 chainPromise 函数
请在不使用 async / await 语法的前提下完成

2. 实现单个 promise 失败后重新执行的配置
即 promise 失败后允许继续尝试发送几次请求，重传次数用完则认为失败，进入 catch

chainPromise([promise1, promise2, promise3], { limit: 3 }).then(([result1, result2, result3]) => {
  // 每一环节允许三次重传
});
预览
控制台
 */

function chainPromise(pros,limit = 3) {
  if(limit == 0){
    throw new Error("error")
  }
  return new Promise((resolve, reject) => {
    let res = []
    pros.forEach(pro=>{
      pro().then(result=>{
        res.push(result)
      },err=>{
        chainPromise(pros,limit-1)
      })
    })
    if (res.length == pros.length) {
      resolve(res)
    }
  })
}

