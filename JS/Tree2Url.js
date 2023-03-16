/**
 * 树形结构获取路径名
 */

const treeData = [
    {
        name: "root",
        children: [
            { name: "src", children: [{ name: "index.html" }] },
            { name: "public", children: [] },
        ],
    },
];


const getUrl = (dom)=>{
    let res = []
    let dfs = (data,tmp="")=>{
        if(!data.children||data.children.length == 0){
            tmp = tmp + data.name
            res.push(tmp)
            return
        }
        let children = data.children
        for(let i = 0;i<children.length;i++){
            tmp = tmp + data.name + "/"
            dfs(children[i],tmp)
            if(tmp - "/" - data.name){
                tmp = tmp - "/" - data.name 
            }else{
                tmp = "" 
            }
        }
    }
    dfs(dom,"")
    return res
}
console.log(getUrl(treeData[0]))