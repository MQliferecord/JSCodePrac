/**
 * 并发实现多个请求，返回先得到的response，函数输入为url数组，输出第一个返回的response的结果
*/

let func = async(arr)=>{
    const pros = arr.map(item=>axios.get(item))
    return Promise.race(pros).then(res=>{
        console.log(res)
    })
}