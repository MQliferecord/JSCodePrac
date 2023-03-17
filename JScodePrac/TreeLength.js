/**
 * 计算目录树的深度
*/

function treeLength(domTree){
    let count = 0;
    let queue = [domTree]
    while(queue.length>0){
        count++
        let size = queue.length
        for(let i = 0;i<size;i++){
            let node = queue.shift()
            let children = node.children
            if(children){
                queue.push(...children)
            }
        }
    }
    return count
}

/**
 * 测试案例
 */
const tree = {
    name: 'root',
    children: [
        { name: '叶子1-1' },
        { name: '叶子1-2' },
        {
            name: '叶子2-1',
            children: [{
                name: '叶子3-1',
                children: [{
                    name: '叶子4-1',
                    children: [{}]
                }]
            }]
        }
    ]
}
console.log(treeLength(tree))