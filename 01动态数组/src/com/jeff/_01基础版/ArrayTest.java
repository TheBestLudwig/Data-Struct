package com.jeff._01基础版;



public class ArrayTest {

	public static void main(String[] args) {

		ArrayList list = new ArrayList();
		
	
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		list.set(3, 100);
		System.out.println(list);
		list.clear();
		System.out.println(list);


	}

}
