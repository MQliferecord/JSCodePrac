/**
 * 使用promise封装ajax请求
 */
let promiseAjax = ()=>{
    return new Promise(resolve=>{
        const xhr = new XMLHttpRequest()
        xhr.open('get','http://127.0.0.1:3000/Ajaxload')
        xhr.send()
        xhr.onreadystatechange = function(){
            if(xhr.readyState == 4){
                if(xhr.status == 200){
                    resolve()
                    console.log(xhr.response)
                }
            }
        }
    })
}