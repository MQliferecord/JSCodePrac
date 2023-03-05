/***
 * Promise.race()
 */

Promise.prototype.race_ = function(pros){
    return new Promise((resolve,reject)=>{
        pros.forEach(pro=>{
            pro.then(res=>{
                resolve(res)
            },err=>{
                reject(err)
            })
        })
    })
}