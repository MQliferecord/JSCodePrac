/**
 * 题目：
 *    new Quene()
 *      .task(1000, () => {
 *           console.log(1)
        })
        .task(2000, () => {
            console.log(2)
        })
        .task(1000, () => {
            console.log(3)
        })
        .start()

      function Quene() { ... } 
 */

let Queue = ()=>{
    this.queue = []
}
Queue.prototype.task = (timer,fn)=>{
    let fns = ()=>{
        new Promise(resolve=>{
            setTimeout(()=>{
                fn()
                resolve()
            },timer)
        })
    }
    this.queue.push(fns)
    return
}
Queue.prototype.start = ()=>{
    this.queue.reduce((pre,cur)=>{
        pre.then(cur)
    },Promise.resolve())
}
