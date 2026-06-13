/*
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 ) return "";
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            // String s = strs[i];
            // int j =0;
            // while((j<prefix.length() && j<s.length())&& s.charAt(j)==prefix.charAt(j)){
            //     j++;
            // }
            // prefix = prefix.substring(0,j);
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
            }
            if(prefix.isEmpty())break;
        }
        return prefix;
    }
}
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        TrieNode root = insert(strs[0]);
        int res = strs[0].length();
        for(int i=0;i<strs.length;i++){
            res = Math.min(res,search(root,strs[i]));
        }
        return strs[0].substring(0,res);
    }
    class TrieNode{
        TrieNode[] child = new TrieNode[26];
    }
    TrieNode insert(String s){
        TrieNode root = new TrieNode();
        if(s.isEmpty()) return root;
        TrieNode node = root;
        for(char c:s.toCharArray()){
            int idx = c-'a';
            node.child[idx] = new TrieNode();
            node = node.child[idx];
        }
        return root;
    }
    int search(TrieNode node,String s){
        int count =0;
        for(char c:s.toCharArray()){
            int idx = c-'a';
            if(node.child[idx] == null) break;
            node =node.child[idx];
            count++;
        }
        return count;
    }
}
