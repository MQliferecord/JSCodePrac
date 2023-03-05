/**
 * 对象树遍历
 */

let treeResult = (tree)=>{
    let res = []
    let queue = [tree]
    while(queue.length>0){
        let node = queue.shift()
        let children = node.children
        if(children){
            queue.push(...children)
        }
        res.push(node.name)
    }
    return res
}
const tree = {
    name: 'root',
    children: [
        {
            name: 'c1',
            children: [
                {
                    name: 'c11',
                    children: []
                },
                {
                    name: 'c12',
                    children: []
                }
            ]
        },
        {
            name: 'c2',
            children: [
                {
                    name: 'c21',
                    children: []
                },
                {
                    name: 'c22',
                    children: []
                }
            ]
        }
    ]
}
console.log(treeResult(tree))