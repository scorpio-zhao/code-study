package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

public class SortTest {

	public static void main(String[] args) {
//		String a = "abc";
//		System.out.println(a.hashCode());
//		new demo().run3();
		
		 TreeMap<Person, String> pdata = new TreeMap<Person, String>();
		 pdata.put(new Person("张三", 30), "zhangsan");
		 pdata.put(new Person("李四", 20), "lisi");
		 pdata.put(new Person("王五", 10), "wangwu");
		 pdata.put(new Person("⼩红", 5), "xiaohong");
		 // 得到key的值的同时得到key所对应的值
		 Set<Person> keys = pdata.keySet();
		 for (Person key : keys) {
		 System.out.println(key.getAge() + "-" + key.getName());
		 }

		
		
	}
	
	public void run6(){
		
	}
	
	
	public void run5(){
		 ArrayList<Integer> arrayList = new ArrayList<Integer>();
		 arrayList.add(-1);
		 arrayList.add(3);
		 arrayList.add(3);
		 arrayList.add(-5);
		 arrayList.add(7);
		 arrayList.add(4);
		 arrayList.add(-9);
		 arrayList.add(-7);
		 System.out.println("原始数组:");
		 System.out.println(arrayList);
		 // void reverse(List list)：反转
		 Collections.reverse(arrayList);
		 System.out.println("Collections.reverse(arrayList):");
		 System.out.println(arrayList);
		 // void sort(List list),按⾃然排序的升序排序
		 Collections.sort(arrayList);
		 System.out.println("Collections.sort(arrayList):");
		 System.out.println(arrayList);
		 // 定制排序的⽤法
		 Collections.sort(arrayList, new Comparator<Integer>() {
			 @Override
			 public int compare(Integer o1, Integer o2) {
				 return o2.compareTo(o1);
			 }
		 });
		 System.out.println("定制排序后：");
		 System.out.println(arrayList);
	}
	
	public void run4(){
		new PriorityQueue<>();
		new LinkedList<>();
		new ArrayList<>();
		new Vector<>();
		new Stack<>();
//		new LinkedStack<>();
	}
	public void run3(){
		// *************复制 copy****************
		// copyOf 方法实现数组复制,h为数组，6为复制的长度
		int[] h = { 1, 2, 3, 3, 3, 3, 6, 6, 6, };
		int i[] = Arrays.copyOf(h, 6);
		System.out.println("Arrays.copyOf(h, 6);：");
		// 输出结果：123333
		for (int j : i) {
			System.out.print(j);
		}
		// 换行
		System.out.println();
		// copyOfRange将指定数组的指定范围复制到新数组中
		int j[] = Arrays.copyOfRange(h, 6, 11);
		System.out.println("Arrays.copyOfRange(h, 6, 11)：");
		// 输出结果66600(h数组只有9个元素这里是从索引6到索引11复制所以不足的就为0)
		for (int j2 : j) {
			System.out.print(j2);
		}
		// 换行
		System.out.println();
	}
	
	public void run2(){
		// *************查找 binarySearch()****************
		char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
		// 排序后再进行二分查找，否则找不到
		Arrays.sort(e);
		System.out.println("Arrays.sort(e)" + Arrays.toString(e));
		System.out.println("Arrays.binarySearch(e, 'c')：");
		int s = Arrays.binarySearch(e, 'c');
		System.out.println("字符c在数组的位置：" + s);
	}

	public void run1(){
		String[] strs = { "abcdehg", "abcdefg", "abcdeag" };
		Arrays.sort(strs);
		System.out.println(Arrays.toString(strs));//[abcdeag, abcdefg, abcdehg]
	}

	public void run(){
		// *************排序 sort****************
		int a[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
		// sort(int[] a)方法按照数字顺序排列指定的数组。
		Arrays.sort(a);
		System.out.println("Arrays.sort(a):");
		for (int i : a) {
			System.out.print(i);
		}
		// 换行
		System.out.println();

		// sort(int[] a,int fromIndex,int toIndex)按升序排列数组的指定范围
		int b[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
		Arrays.sort(b, 2, 6);
		System.out.println("Arrays.sort(b, 2, 6):");
		for (int i : b) {
			System.out.print(i);
		}
		// 换行
		System.out.println();

		int c[] = { 1, 3, 2, 7, 6, 5, 4, 9 };
		// parallelSort(int[] a) 按照数字顺序排列指定的数组(并行的)。同sort方法一样也有按范围的排序
		Arrays.parallelSort(c);
		System.out.println("Arrays.parallelSort(c)：");
		for (int i : c) {
			System.out.print(i);
		}
		// 换行
		System.out.println();

		// parallelSort给字符数组排序，sort也可以
		char d[] = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
		Arrays.parallelSort(d);
		System.out.println("Arrays.parallelSort(d)：");
		for (char d2 : d) {
			System.out.print(d2);
		}
		// 换行
		System.out.println();
	}
}

class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	 /**
	 * TODO重写compareTo⽅法实现按年龄来排序
	 */
	 @Override
	public int compareTo(Person o) {
		if (this.age < o.getAge()) {
			return 1;
		} else if (this.age > o.getAge()) {
			return -1;
		}
		return age;
	}
}
