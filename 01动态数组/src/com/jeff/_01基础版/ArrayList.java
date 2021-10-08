package com.jeff._01基础版;
//纯int版本
public class ArrayList {
	private int size;
	private int[] elements;
	private static final int CAPACITY = 10;
	private static final int NOTFOUNT = -1;
/*
 * ArrayList不需要capacity属性，因为是用数组实现，数组自带elements.length
 */
//构造函数
	public ArrayList(int capacity) {
		capacity = (capacity < CAPACITY)?CAPACITY:capacity;
		elements = new int[capacity];
	}
	public ArrayList() {
		this(CAPACITY);
	}
	
	public void clear() {
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size ==0;
	}
	public boolean contains(int element) {
		return indexOf(element) != NOTFOUNT;
	}
	public int  get(int index) {
		if (index <0 ||index >=size) {
			throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
		}
		return elements[index];
	}
	public int set(int index,int element) {
		if (index <0 ||index >=size) {
			throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
		}
		int temp = elements[index];
		elements[index] = element;
		return temp;
	}
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if(elements[i] == element) return i;	
		}
		return NOTFOUNT;
	}
	//调用带位置的add，位置默认为最后面
	public void add(int element) {
		this.add(size, element);
	}
	/***
	 * 指定位置插入元素
	 * 		1.指定位置应在合理范围，即[0,size]
	 * 		2.容量满了应自动扩容
	 * 		3.为了插入，从最后一个元素开始依次后移，直到index位置元素也后移，
	 * 	随后将element放到element[index]处
	 * 		4.插入后，数组的size属性应增加1
	 */
	public void add(int index,int element) {
		if (index <0 ||index >size) {
			throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
		}
		//扩容
		if (size >= elements.length) {
			expend();
		}
		for (int i = size; i >index; i--) {
			elements[i] = elements[i-1];
		}
		elements[index] = element;
		size++;
	}
	public int  remove(int index) {
		if (index <0 ||index >=size) {
			throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
		}
		int old = elements[index];
		for (int i = index; i < size; i++) {
			elements[i] = elements[i+1];
		}
		size--;
		return old;
	}
	public void expend() {
		int[] arrays = new int[size * 2];
		for (int i = 0; i < elements.length; i++) {
			arrays[i] = elements[i];
		}
		elements = arrays;
	}
	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		if (size == 0) {
			return "[]";
		}else {
			String tmp = "[";
		for (int i = 0; i < size; i++) {
			tmp =tmp + elements[i]+",";
		}
		int index = tmp.lastIndexOf(",");
		StringBuilder sb = new StringBuilder(tmp);
		sb.setCharAt(index, ']');//改变指定位置的字符
		tmp = sb.toString();
		return tmp;
		}
		
	}
}
