/**
 * loader异步手撕
 */

const loader = ()=>{
    const callback = this.async()

    setTimeout(()=>{
       console.log("loaderAsync")  
       callback(null,source,map,meta)  
    },500)
}