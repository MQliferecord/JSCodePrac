/**
 * js每隔一秒打印1，2，3，4，5
 */

let duration = function(number,timer){
    return new Promise(resolve=>{
        setTimeout(()=>{
            console.log(number)
            resolve()
        },timer)
    })
}

let main_ = async()=>{
    for(let i = 0;i<5;i++){
       await duration(i+1,5000)
    }
}

main_()