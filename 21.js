/**
 * 现有如下json（简化为对象）
 * 已知每个节点id唯一，编写findNode(id)，返回路径，如findNode(5 输出 1->4->5
 */
let json = {
    id: 1,
    children: [
        { id: 2, children: [{ id: 3, children: [] }] },
        {
            id: 4,
            children: [
                { id: 5, children: [] },
                { id: 6, children: [] },
            ],
        },
        { id: 7, children: [] },
    ],
}

let findNode = (json,id)=>{
    let res = []
    let dfs = (vnode,tmp=[])=>{
        if(vnode.id == id){
            tmp.push(vnode.id)
            tmp.forEach(item=>res.push(item))
            return
        }
        let children = vnode.children
        if(children&&children.length>0){
            for(let i = 0;i<children.length;i++){
                tmp.push(vnode.id)
                dfs(children[i],tmp)
                tmp.pop(vnode.id)
            }
        }
    }
    dfs(json)
    return res
}

console.log(findNode(json,5).join("->"))

