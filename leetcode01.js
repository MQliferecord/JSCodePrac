const sum = function(nums,target){
    let map_ = new Map()
    let arr = []
    nums.forEach((num,index)=>{
        let tmp = target - num
        if(map_.has(tmp)){
            arr.push(index)
            arr.push(map_.get(tmp))
        }
        map_.set(num,index)
    })
    return arr
}