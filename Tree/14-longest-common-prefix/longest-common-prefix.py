class Solution:
    class TrieNode:
        def __init__(self):
            self.child = [None]*26
    
    def insertion(self,node,str):
        for ch in str:
            idx = ord(ch)-97
            node.child[idx] = self.TrieNode()
            node = node.child[idx]
    def search(self,node,str):
        count = 0
        for ch in str:
            idx = ord(ch)-97
            if(node.child[idx] == None): return count
            count +=1
            node= node.child[idx]
        return count
    def longestCommonPrefix(self, strs: List[str]) -> str:
        root = self.TrieNode()
        self.insertion(root,strs[0])
        res = len(strs[0])
        for i in range(1,len(strs)):
            res = min(res,self.search(root,strs[i]))
        return strs[0][:res]
