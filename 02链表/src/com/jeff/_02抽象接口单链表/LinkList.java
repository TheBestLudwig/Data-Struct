package com.jeff._02抽象接口单链表;

/*
 * 这是第二版，要实现接口与实现的分离
 * 链表与数组都有增删改查等方法，可否复用，单纯的继承不能实现，它们的实现部分天差
 * 地远，但是接口却一致，这个是可以分离出来的
 * 有哪些接口？
 *
 */
public class LinkList<E> extends Abs_List<E>{
    Node<E> first;

//这里构造器可以不要。构造器存在的意义就是初始化，而int会自动初始化为0，引用类型自动初始化为null。
//    public LinkList() {
//        size = 0;
//        first = null;
//    }

    //add
    public void add(int index,E e){
        rangeCheck(index);
        if (index == 0){
            first =  new Node<>(e,first);

        }else{
            Node<E> prev = node(index-1);
            prev.next = new Node<>(e,prev.next);
        }
        size++;
    }

    public void add(E e){
        add(size,e);
    }

    //remove
    public E remove(int index){
        rangeCheck(index);
        E old = node(index).elem;
        if (index ==0){
            first = node(0).next;
        }else {
            Node<E> prev = node(index-1);
            prev.next = prev.next.next;
        }
        size--;

        return old;
    }

    //set
    public E set(int index,E e){
        E old = node(index).elem;
        node(index).elem = e;

        return old;
    }


    //get
    public E get(int index){
        return node(index).elem;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }


    //node
    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> theOne = first;
        for (int i = 0; i<index;i++){
            theOne = theOne.next;
        }
        return theOne;
    }

    @Override
    public String toString() {
        String ss = "[|size:"+size+"|->";
        for (int i = 0; i < size; i++) {
            ss += node(i).toString();
        }
        ss+="null]";
        return ss;
    }

    private static class Node<E>{
        E elem;
        Node<E> next;

        public Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }

        @Override
        public String toString() {
            return "("+elem+")->";
        }
    }
    public int indexOf(E e) {
        if (e == null){
            for (int i = 0; i <size ; i++) {
                if (get(i) == null)return i;
            }
            return ELEM_NOT_FOUND;
        }else{
            for (int i = 0; i < size; i++) {
                if (e.equals(get(i)))return i;
            }
            return ELEM_NOT_FOUND;
        }
    }

}
