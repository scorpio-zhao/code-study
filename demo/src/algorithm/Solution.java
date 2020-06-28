package algorithm;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
	public static int longestPalindrome(String s) {
		if (s == null) {
			return 0;
		}

		int count = 0;
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				set.remove(s.charAt(i));
				count++;
			} else {
				set.add(s.charAt(i));
			}
		}
		return set.isEmpty() ? count*2 : count*2 +1;
	}

	public static boolean isPalindrome(String s) {
		if(s.length() == 0) return true;
		
		int l=0;
		int r=s.length()-1;
		while(l<r){
			if(!Character.isLetterOrDigit(s.charAt(l))){
				l++;
			}else if(!Character.isLetterOrDigit(s.charAt(r))){
				r--;
			}else{
				if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
					return false;
				}
				l++;
				r--;
			}
		}
		return true;
	}
	
	public static int BracketDepth(String s) {
		int count =0;
		int maxDepth = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='('){
				count++;
			}else if(s.charAt(i)==')'){
				count--;
			}
			maxDepth = Math.max(maxDepth, count);
		}
		return maxDepth;
	}
	
    public static boolean checkBracket(String str) {
        Stack<Character> sc = new Stack<Character>();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i]=='(') {
                sc.push(c[i]);
            }
            else if (c[i]==')') {
            	if(sc.size()==0){
            		return false;
            	}
                if (sc.peek()=='(') {
                    sc.pop();
                }
            }
        }

        if (sc.empty()) {
            return true;
        }else {
        	return false;
        }
    }
	
	public static void main(String[] args) {
//		System.out.println(longestPalindrome("abccccdd"));
//		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//		System.out.println(BracketDepth("(())()((()))"));
//		System.out.println(checkBracket("(())()((()))"));
		System.out.println(checkBracket("(()))(()())()))"));
		new SimpleDateFormat();
		new ConcurrentHashMap();
	}
	
}





















