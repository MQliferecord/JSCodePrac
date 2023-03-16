const calcuLen = function(s){
    let ansLen = 0;
    let map = new Map()
    let le = 0
    let ri = le
    while(ri<s.length()){
        if(map.has(s[ri])&&map.get(s[ri])>=le){
            le = map.get(s[ri])+1
        }
        map.set(s[ri],ri)
        ansLen = Math.max(ansLen,ri-le+1)
        ri++
    }
    return ansLen
}