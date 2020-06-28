package algorithm;

import java.util.Arrays;

public class CommonPrefix {
	
	
	public static String replaceSpace(String[] strs) {
		if(!checkStrs(strs)){return null;}
		
		StringBuilder res = new StringBuilder();
		Arrays.sort(strs);
		int m =strs[0].length();
		int n =strs[strs.length-1].length();
		int min = Math.min(m, n);
		for (int i = 0; i < min; i++) {
			if(strs[0].charAt(i)==strs[strs.length-1].charAt(i)){
				res.append(strs[0].charAt(i));
			}else{
				break;
			}
		}
		return res.toString();
	}

	private static boolean checkStrs(String[] strs) {
		boolean flag = false;
		if (strs != null) {
			// 遍历strs检查元素值
			for (int i = 0; i < strs.length; i++) {
				if (strs[i] != null && strs[i].length() != 0) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	


	// 测试
	public static void main(String[] args) {
		String[] strs = { "customer", "car", "cat" };
		// String[] strs = { "customer", "car", null };//空串
		// String[] strs = {};//空串
		// String[] strs = null;//空串
		System.out.println(CommonPrefix.replaceSpace(strs));// c
	}
}