/**
 * 交通灯
*/

function trans_(obj,timer){
    return new Promise((resolve)=>{
        setTimeout(()=>{
            console.log(obj)
            resolve()
        },timer)
    })
}

let main_ = ()=>{
    Promise.resolve()
    .then(()=>{
        trans_('red',1000)
    })
    .then(()=>{
        trans_('green',5000)
    })
    .then(()=>{
        trans_('blue',10000)
    })
}

main_()

