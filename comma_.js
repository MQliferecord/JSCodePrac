/**
 * 千分符返回数字参数
 */

const comma_ = (number)=>{
    //获取正数还是负数
    let flag = ''
    if(number<0){
        flag = '-'
        number = Math.abs(number)
    }
    //获取整数部分 12300 和小数 00321
    let tmp = number.toString().split('.')[0].split('')
    let mini = number.toString().split('.')[1]

    //--------------处理整数-------------
    let count = 0
    let res_ = []
    //添加逗号['0','0','3',',','2','1']
    while(tmp.length>0){
        if(count == 3){
            res_.push(',')
            count = 0
        }
        res_.push(tmp.pop())
        count++
    }
    //反转拼接 12,300
    res_ = res_.reverse().join('')
    res_ = flag + res_

    //-------------处理小数-----------------
    if(mini){
        mini = mini.split('')
        let countmini = 0
        let resmini = []
        while(mini.length>0){
            if(countmini == 3){
                resmini.push(',')
                countmini = 0
            }
            resmini.push(mini.shift())
            countmini++
        }
        resmini.join('')
        res_ = res_ + '.' + resmini
    }
    return res_
}
console.log(comma_(-1234567))