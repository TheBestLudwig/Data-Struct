package com.jeff._02泛型版;


import java.util.Objects;

public class ArrayTest {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		
	
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		list.set(4, 100);
		System.out.println(list);
		System.out.println(list.indexOf(3));
		list.clear();
		System.out.println(list);

		//装入Person对象
		ArrayList<Person> ll = new ArrayList<>();

		Person pp = new Person("吴用",49);
		ll.add(new Person("宋江",38));
		ll.add(new Person("武松",32));
		ll.add(new Person("吴用",49));
		ll.add(new Person("史进",21));
		ll.add(new Person("刘唐",42));

		System.out.println(ll);
		ll.set(4,new Person("李逵",30));

		System.out.println(ll);
		System.out.println(ll.indexOf(pp));


	}

}

class Person{
	private String name;
	private int age;

	public Person(String name, int age) {
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

	@Override
	public String toString() {
		return '('+ name + ", " + age +')';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return age == person.age &&
				Objects.equals(name, person.name);
	}
}