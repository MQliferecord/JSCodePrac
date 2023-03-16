/**
 * 树形结构转链表
 */


let treeToList = (tree)=>{
    let res = []
    let queue = [tree]
    while(queue.length>0){
        let node = queue.shift()
        let children = node.children
        if(children){
            queue.push(...children)
        }
        res.push(node.text)
    }
    return res    
}
const data = [
    {
        id: 1,
        text: '节点1',
        parentId: 0,
        children: [
            {
                id: 2,
                text: '节点1_1',
                parentId: 1
            }
        ]
    }
]
console.log(treeToList(data[0]))
