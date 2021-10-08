package com.jeff._02泛型版;

/**泛型版本
 * 与base版的区别
 * 1.数据存诸不同。元素类型由int变成了Person、Car等Object
	elements位于堆区，存放对象数组的地址，对象数组elements[0]等元素中存储的是真实对象的地址，与base不同
 * 2.加入泛型特征<>	
 * 3.对应方法应改写，如对象相等、空值处理等。
 *
 */

public class ArrayList<E> {
	private int size;
	private E[] elements;
	private static final int CAPACITY = 10;
	private static final int NOTFOUNT = -1;
/*
 * ArrayList不需要capacity属性，因为是用数组实现，数组自带elements.length
 */
//构造函数
	public ArrayList(int capacity) {
		capacity = (capacity>CAPACITY)?capacity:CAPACITY;
		elements = (E[])new Object[CAPACITY];
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
	public boolean contains(E element) {
		return indexOf(element) != NOTFOUNT;
	}
	public E  get(int index) {
		if (index <0 ||index >=size) {
			throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
		}
		return elements[index];
	}
	public E set(int index,E element) {
		if (index <0 ||index >=size) {
			throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
		}
		E temp = elements[index];
		elements[index] = element;
		return temp;
	}
	public int indexOf(E element) {
		if (element == null){
			for (int i = 0;i<size;i++){
				if(get(i)== null)return i;
			}
			return NOTFOUNT;
		}
		else{
			for (int i = 0; i < size; i++) {
				if(element.equals(elements[i])) return i;
			}
			return NOTFOUNT;
		}
	}
	//调用带位置的add，位置默认为最后面
	public void add(E element) {
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
	public void add(int index,E element) {
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
	public E  remove(int index) {
		if (index <0 ||index >=size) {
			throw new IndexOutOfBoundsException("Index:"+index+",Size:"+size);
		}
		E old = elements[index];
		for (int i = index; i < size; i++) {
			elements[i] = elements[i+1];
		}
		size--;
		return old;
	}
	public void expend() {
		E[] arrays = (E[]) new Object[size * 2];
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
