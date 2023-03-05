/**
 * 获取树结构中的name:getName
 */

let data = [
    {
        "name": "1-1",
        "kind": "oo",
        "children": [
            {
                "name": "2-2",
                "kind": "ii",

            },
            {
                "name": "3-3",
                "children": [
                    {
                        "name": "4-4",
                        "children": [
                            {
                                "name": '707'
                            }
                        ]
                    }
                ]
            }
        ]
    },
    {
        "name": "5-5",
    },
    {
        "name": "6-6"
    }
]

let getNameSingle = (tree)=>{
    let res = []
    let queue = [tree]
    let name = "name"
    while(queue.length>0){
        let node = queue.shift()
        res.push(node[name])
        let children = node.children
        if(children){
            queue.push(...children)
        }
    }
    return res
}
let getName = (data)=>{
    let res = []
    for(let i = 0;i<data.length;i++){
        res.push(getNameSingle(data[i]))
    }
    return res.flat(Infinity)
}

console.log(getName(data))

