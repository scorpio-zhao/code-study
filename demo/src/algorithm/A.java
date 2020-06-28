package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;



class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }
    
    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        size++;
    }
    
    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stack1.pop();
    }
}

class TQueue{
	LinkedList<Integer> list1,list2;
	public TQueue(){
		list1 = new LinkedList<Integer>();
		list2 = new LinkedList<Integer>();
	}
	
    public void appendTail(int value) {
    	list1.addLast(value);
    }
    
    public int deleteHead(){
    	if(!list2.isEmpty()){
    		return list2.removeLast();
    	}
    	if(list1.isEmpty()){
    		return -1;
    	}
    	while(!list1.isEmpty()){
    		list2.addLast(list1.removeLast());
    	}
    	return list2.removeLast();
    }
}

class SQueue{
	Stack<Integer> stack1,stack2;
	public SQueue(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
    public void appendTail(int value) {
    	stack1.push(value);
    }
    
    public int deleteHead(){
    	if(!stack2.isEmpty()){
    		return stack2.pop();
    	}
    	if(stack1.isEmpty()){
    		return -1;
    	}
    	while(!stack1.isEmpty()){
    		stack2.push(stack1.pop());
    	}
    	return stack2.pop();
    }
}

class Solution1 {
   
    public int fib(int n) {
    	 int a=0,b=1,sum;
    	 for (int i = 0; i < n; i++) {
			sum = (a+b)%1000000007;
			a = b;
			b = sum;
		}
    	return a;
    }
    
    public int fib1(int N) {
        if(N==0 || N==1){
            return N;
        }
        return fib(N-1)+fib(N-2);
    }
    
    public int findRepeatNumber(int[] nums) {
//    	List<Integer> mlist = Arrays.asList(nums);
//    	List<Integer> list1 = Stream.of(nums).collect(Collectors.toList());
    	HashSet<Integer> set = new HashSet<>();
    	for (int i = 0; i < nums.length; i++) {
			if(!set.add(nums[i])){
				return nums[i];
			}
		}
    	return -1;
    }
    
    public Set<Character> mostChar(String str){
    	char[] arrStr = str.toCharArray();
    	HashMap<Character,Integer> map = new HashMap<>();
    	for (int i = 0; i < arrStr.length; i++) {
    		char key = arrStr[i];
			if(map.containsKey(key)){
				map.put(key, map.get(key)+1);
			}else{
				map.put(key, 1);
			}
		}
    	
    	int valueMax = Collections.max(map.values());
    	Set<Character> set = new HashSet<Character>();
    	for (HashMap.Entry<Character, Integer> mapEntry : map.entrySet()) {
    		if(mapEntry.getValue() == valueMax){
    			set.add(mapEntry.getKey());
    		}
		}
    	return  set;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target)
                return false;
            if (Arrays.binarySearch(matrix[i], target) >= 0){
                return true;
            }
        }
        return false;

    }
    

}


public class A{
	
	
    @Test
    public void run2(){
    	int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19}};
    	Solution1 s = new Solution1();
    	System.out.println(s.searchMatrix(matrix, 4));
    	System.out.println(s.searchMatrix(matrix, 20));
    }
	
    @Test
    public void run1(){
    	Solution1 s = new Solution1();
    	System.out.println(s.mostChar("abbcca"));
    }
	
	public static void main(String[] args) {
//		 CQueue obj = new CQueue();
//		 TQueue obj = new TQueue();
		 SQueue obj = new SQueue();
		 obj.appendTail(1);
		 obj.appendTail(2);
		 obj.appendTail(3);
//		 System.out.println(obj.);
		 int param_1 = obj.deleteHead();
		 System.out.println(param_1);
		 int param_2 = obj.deleteHead();
		 System.out.println(param_2);
		 int param_3 = obj.deleteHead();
		 System.out.println(param_3);
	}
	
    @Test
    public void run(){
    	Solution1 s = new Solution1();

    	System.out.println(s.fib(100));

//    	System.out.println(s.fib1(100));
    }
}