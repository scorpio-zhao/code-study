package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SumToTarget {

    
	@Test
	public void run1(){
		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(twoSum(nums,0));
		System.out.println(threeSum(nums,0));
		
//		int[] nums = {1, 0, -1, 0, -2, 2};
//		System.out.println(fourSum(nums,0));
		
	}
    
    public List<List<Integer>> twoSum(int[] nums, int target) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length<2) return res;
    	Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target){
            	i++;
            }else if(s > target){
            	j--;
            }else{
            	res.add(Arrays.asList(nums[i], nums[j])); 
            	i++;
            	j--;
            }	
        }
        return res;
    }


	public List<List<Integer>> threeSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int len = nums.length;
		if(len<3) return res;
		Arrays.sort(nums);
		for (int i = 0; i < len-3; i++) {
//			if(nums[i]>0) break;
			if(i>0 && nums[i]==nums[i-1]) continue;
			int L=i+1;
			int R=len-1;
			while(L<R){
				int sum=nums[i]+nums[L]+nums[R];
				if(sum==target){
					res.add(Arrays.asList(nums[i],nums[L],nums[R]));
					while(L<R && nums[L]==nums[L+1]){L++;}
					while(L<R && nums[R]==nums[R-1]){R--;}
					L++;
					R--;
				}else if(sum>target){																																	
					R--;
				}else if(sum<target) {
					L++;
				}
			}
		}
		
		return res;
	}
    
	
	public List<List<Integer>> fourSum(int[] nums,int target){
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null||nums.length<4){
            return result;
        }
        Arrays.sort(nums);
        int length=nums.length;
        /*定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值*/
        for(int k=0;k<length-3;k++){
            /*当k的值与前面的值相等时忽略*/
            if(k>0&&nums[k]==nums[k-1]){
                continue;
            }
            int min1=nums[k]+nums[k+1]+nums[k+2]+nums[k+3];
            if(min1>target){
            	continue;
            }
            int max1=nums[k]+nums[length-1]+nums[length-2]+nums[length-3];
            if(max1<target){
            	continue;
            }
            for(int i=k+1;i<length-2;i++){
                if(i>k+1&&nums[i]==nums[i-1]){
                    continue;
                }
                int j=i+1;
                int h=length-1;
                
                /*开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++*/
                while (j<h){
                    int curr=nums[k]+nums[i]+nums[j]+nums[h];
                    if(curr==target){
                        result.add(Arrays.asList(nums[k],nums[i],nums[j],nums[h]));
                        while(j<h&&nums[j]==nums[j+1]){j++;}
                        while(j<h&&nums[h]==nums[h-1]){h--;}
                        j++;
                        h--;
                    }else if(curr>target){
                        h--;
                    }else {
                       j++;
                    }
                }
            }
        }
        return result;
    }

}







