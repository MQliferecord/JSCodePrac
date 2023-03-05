/**
 * 判断有无符合路径和->打印所有的路径
 */

const data3 = [
    {
        id: 1,
        name: '前端',
        children: [
            {
                id: 2,
                name: 'html',
                children: [
                    { id: 5, name: 'vue', children: [] },
                    { id: 6, name: 're', children: [] },
                ]
            },
            {
                id: 3,
                name: 'html',
                children: [
                    { id: 7, name: 'vue', children: [] },
                    { id: 8, name: 're', children: [] },
                ]
            }
        ]
    }
]

function findNodePath(data,targetName){
    let res = []
    let dfs = (vnode,tmp=[])=>{
        if(vnode.name == targetName){
            res.push(tmp.concat(vnode.id))
            return
        }
        let children = vnode.children
        if(children&&children.length>0){
            for(let i =0;i<children.length;i++){
                dfs(children[i],tmp.concat(vnode.id))
            }
        }
    }
    dfs(data)
    return res
}
console.log(findNodePath(data3[0],'vue'))