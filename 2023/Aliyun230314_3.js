/**
 * 实现一个简易的模块管理机制
const IModules = (function() {
  function define(moduleName, dependencyList, factory) {
        // moduleName  source
          dependencyList   import,
          factory  fn
  }
  
  function use(dependencyList, func) {
    // 完善模块使用逻辑
  }
  
  return {
    define,
    use,
  };
})();

// 代码块 a
IModules.define('utils', () => {
  return {
    getDocumentTitle: () => document.title,
    getTime: () => Date.now();
  };
});

// 代码块 b
IModules.define('log', ['utils',''], (utils) => {
  return (...args) => {
       console.log('自定义 console 输出: ', ...args, utils.getTime()); 
  };
});

IModules.use(['utils', 'log'], (utils, log) => {
    // 一些业务逻辑
  log(utils.getDocumentTitle(), '打点成功');
});
需求
1. 补全 IModules 的逻辑，实现简易 AMD 模块管理机制
补全后下面的代码应该可以正常执行

2. 如果代码块 a 与 b 顺序对换后执行有问题，请完善你的代码
 */

const IModules = (function () {
  let sourceMap = new Map()
  let node = []

  function define(moduleName, dependencyList, factory) {
    if (!Array.isArray(dependencyList)) {
      //dependencyList没有填
      factory = dependencyList
      dependencyList = []
    }
    node.push({ "name": moduleName, "dep": dependencyList, "fn": factory })
    sourceMap.set(moduleName, dependencyList)
  }
  function use(dependencyList, func) {
    let cnt = 0
    let args = []
    const dfs = (dep) => {
      if (sourceMap.has(dep)) {
        let nodeRelate = sourceMap.get(dep)
        let nodeCur = node[cnt++]
        args.push(nodeCur)
        dfs(nodeRelate)
      }
    }
    for (let i = 0; i < dependencyList.length; i++) {
      dfs(dependencyList[i])
    }
    for(let i =0;i<args.length;i++){
      func(args[i].fn)
    }
  }
    return {
      define,
      use,
    }
  
})();

IModules.define('utils', () => {
  return {
    getDocumentTitle: () => document.title,
    getTime: () => Date.now()
  };
});

IModules.define('log', ['utils'], (utils) => {
  return (...args) => {
    console.log('自定义 console 输出: ', ...args, utils.getTime());
  };
});

IModules.use(['utils', 'log'], (utils, log) => {
  //...
  log(utils.getDocumentTitle(), '打点成功');
});