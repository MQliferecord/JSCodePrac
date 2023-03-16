var Trie = function() {
    this.tree = []
};

/** 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    this.tree.push(word)
};

/** 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    let flag = false;
    this.tree.forEach(item=>{
        if(item == word){
            flag = true
        }
    })
    return flag;
};

/** 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    let flag = false;
    this.tree.forEach(item=>{
        if(item.length>=prefix.length){
            if(item.slice(0,prefix.length) == prefix){
                flag = true;
            }
        }
    })
    return flag;
};

let tree = new Trie()
tree.insert("apple")
console.log(tree.search("apple"))