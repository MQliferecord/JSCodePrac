/**
 * 列表转树
 */

let ListToTree = (List)=>{
    let res = []
    let map = {}
    for(let i =0;i<List.length;i++){
        map[List[i].id] = i
        List[i].children = []
    }
    for(let i =0;i<List.length;i++){
        let node = List[i]
        if(node.pid !== 0){
            List[map[node.pid]].children.push(node)
        }else{
            res.push(node)
        }
    }
    return res
}

let arr = [
    { id: 1, name: '部门1', pid: 0 },
    { id: 2, name: '部门2', pid: 1 },
    { id: 3, name: '部门3', pid: 1 },
    { id: 4, name: '部门4', pid: 3 },
    { id: 5, name: '部门5', pid: 4 },
    { id: 6, name: '部门6', pid: 0 },
]

console.log(ListToTree(arr))
