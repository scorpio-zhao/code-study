package algorithm;

import java.util.Scanner;

import org.junit.Test;

public class BigStringNumAdd {
    private static String AddLongInterger(String str1, String str2) {
    	StringBuilder sb1 = new StringBuilder(str1);
    	StringBuilder sb2 = new StringBuilder(str2);
    	if(sb1.length()>sb2.length()){
    		while(sb1.length()!=sb2.length()){
    			sb2.insert(0, 0);
    		}
    	}else if(sb1.length()<sb2.length()){
    		while(sb1.length()!=sb2.length()){
    			sb1.insert(0, 0);
    		}
    	}
    	
    	StringBuilder res = new StringBuilder();
    	int temp=0;
    	boolean flag = false;
    	for (int i = sb1.length()-1; i >= 0 ; i--) {
    		int int1 = Integer.valueOf(String.valueOf(sb1.charAt(i)));
    		int int2 = Integer.valueOf(String.valueOf(sb2.charAt(i)));
			temp=int1+int2;
			if(flag == true){
				temp++;
			}
			if(temp<=9){
				res.append(temp);
				flag = false;
			}else{
				res.append(temp-10);
				flag = true;
			}
		}
    	//最后最高位的计算如果需要进位便补1
    	if(flag==true){
    		res.append(1);
    	}
    	return res.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String addend=scanner.next();
        String augend=scanner.next();
        System.out.println(AddLongInterger(addend,augend));
    }
    
    
    @Test
    public void run(){
    	int sum = 0;
    	int count = 0;
    	for(int i=0; i<10; i++){
    		for(int j=0; j<10; j++){
    			sum++;
        		if(i+j>=10){
        			count++;
        			System.out.print(i+"+"+j+"="+(i+j)+"  ");
        		}
        		
        	}
    	}

    	System.out.println();
    	System.out.println("sum: "+sum+" count: "+count);
    }
    
    
    
}
