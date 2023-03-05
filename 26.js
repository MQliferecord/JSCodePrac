/**
 * Promise.all()
 */

Promise.prototype.all_ = function(pros){
    const res = []
    const count = 0
    return new Promise((resolve,reject)=>{
        const ans = (value,index)=>{
            count++
            res[index] = value
            if(count === pros.length){
                resolve(res)
            }
        }
        pros.forEach((item,index)=>{
            if(item instanceof Promise){
                item.then((pro)=>{
                    ans(pro,index)
                },err=>{
                    reject(err)
                })
            }else{
                ans(item,index)
            }
        })
    })
}