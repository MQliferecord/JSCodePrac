/**
 * 观察者模式
 */

class Observed{
    constructor(){
        this.observed = []
    }
    addObserved(fn){
        this.observed.push(fn)
    }
    notify(){
        this.observed.forEach(cb=>cb.updated())
    }
}

class Observer{
    constructor(work){
        this.work = work
    }
    updated(){
        console.log(this.work)
    }
}