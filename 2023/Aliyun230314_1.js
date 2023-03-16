const treeData = [
  {
    id: 1001,
    name: 'AA',
    children: [
      {
        id: 1002,
        name: 'BB',
        children: [
          {
            id: 1006,
            name: 'FF',
          },
          {
            id: 1007,
            name: 'GG',
          },
        ],
      },
      {
        id: 1003,
        name: 'CC',
        children: [
          {
            id: 1004,
            name: 'DD',
            children: [
              {
                id: 1008,
                name: 'HH'
              },
            ],
          },
          {
            id: 1005,
            name: 'EE',
            children: [
              {
                id: 1009,
                name: 'II'
              },
            ],
          },
        ],
      },
    ],
  },
];

/** 
  要求输出的格式：
  AA
    BB
      FF
      GG
    CC
      DD
        HH
      EE
        II
 */

function Tree2List(tree) {
  const res = []
  let dfs = (res,node,cnt = 0)=>{
    res.push({"name":node.name,"id":cnt})
    let children = node.children
    if(!node.children||!node.children.length){
      return
    }
    children.forEach(child=>{
      dfs(res,child,cnt+1)
    })
  }
  dfs(res,tree,0)
  return res
}

/**
AA-0
BB-1
CC-1
DD-2
*/

function Result(arr) {
  for (let i = 0; i < arr.length; i++) {
    let str = ""
    for(let j =0;j<arr[i].id;j++){
      str += "*"
    }
    str = str.replace(/\*/g," ")+arr[i].name
    console.log(str)
  }
}


let arr = Tree2List(treeData[0])
console.log(arr)
let res = Result(arr)
console.log(res)

