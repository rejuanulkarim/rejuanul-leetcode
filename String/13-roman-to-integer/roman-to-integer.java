/*
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I',1,
            'V',5,
            'X',10,
            'L',50,
            'C',100,
            'D',500,
            'M',1000
        );
        Map<Character, Integer> pMap = Map.of(
            'I',1,
            'V',2,
            'X',3,
            'L',4,
            'C',5,
            'D',6,
            'M',7
        );

        char[] chars = s.toCharArray();
        int res = 0;
        int p = 0;
        for(int i=chars.length -1;i>=0;i--){
            if(pMap.get(chars[i]) >= p){
                res += map.get(chars[i]);
            }else{
                res -= map.get(chars[i]);
            }
            p=pMap.get(chars[i]);
        }
        return res;
    }
}
*/

class Solution {
    int value(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public int romanToInt(String s) {
        int res = 0, flag = 0;
        for(int i =s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            int num = value(ch);
            if(num >= flag){
                res += num;
            }else{
                res -= num;
            }
            flag = num;
        }
        return res;

    }
}