/**
 * 发布订阅模式
 */

class ans{
    constructor(){
        this.subscriber = []
    }
    on(fn,key){
        if(!this.subscriber[key]){
            this.subscriber[key] = []
        }
        this.subscriber[key] = fn
    }
    remove(fn,key){
        let fns = this.subscriber[key]
        if(!fns){
            return false
        }
        if(!fn){
            return fns&&(fns.length == 0)
        }
        fns.forEach((item,index)=>{
            if(item==fn){
                fns.splice(index,1)
            }
        })
    }
    emit(...args){
        this.subscriber.forEach(cb=>cb(...args))
    }
    one(key,fn){
        const ons_ = (argument)=>{
            fn(argument)
            this.remove(fn,key)
        }
        ons_.initialCallback = fn
        this.on(key,fn)
    }
}