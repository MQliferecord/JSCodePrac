/**
 * 请求五秒未完成就终止
 */

/**
 * 计时函数
 * @param {number} timer 
 */
let duration = function(timer){
    return new Promise(reject=>{
        setTimeout(()=>{
            console.log('reject')
            reject()
        },timer)
    })
}

let fns = function(){
    const xhr = new XMLHttpRequest()
    xhr.open('get','http://127.0.0.1:3000/delay')
    xhr.send()
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4){
            if(xhr.status == 200){
                console.log(xhr.response)
            }
        }
    }
}

let main_ = ()=>{
    Promise.race([fns(),duration(5000)])
}

main_()


