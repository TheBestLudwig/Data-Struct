package com.jeff._02抽象接口单链表;


public class LinkListTestT<E> {
    public static void main(String[] args) {
        LinkList<Integer> ll = new LinkList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(0,100);
        System.out.println(ll);
        LinkList<Person> lp = new LinkList<>();

        Person pp = new Person("KATE",14);
        lp.add(new Person("JACK",10));
        lp.add(new Person("MARY",11));
        lp.add(new Person("ROSE",12));
        lp.add(new Person("JHON",13));
        lp.add(new Person("KATE",14));
        System.out.println(lp);
        lp.remove(0);
        System.out.println(lp);
        System.out.println("KATE的位置为："+lp.indexOf(pp));
        lp.clear();
        System.out.println(lp);

    }

}
