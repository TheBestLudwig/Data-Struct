package com.jeff._01基础单链表;

/*
 * 这是第一版，引入泛型的单链表，实现了不同种类元素的增删改查
 */
public class LinkList<E> {
    private int size;
    Node<E> first;

    public LinkList() {
        size = 0;
        first = null;
    }

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


    //node
    private Node<E> node(int index){
        rangeCheck(index);
        Node<E> theOne = first;
        for (int i = 0; i<index;i++){
            theOne = theOne.next;
        }
        return theOne;
    }

    //size
    public int size(){
        return size;
    }

    //isEmpty
    public boolean isEmpty(){
        return size ==0 && first == null;
    }


    //clear
    public void clear(){
        size = 0;
        first = null;
    }

    public int indexOf(E e){
        if (e == null){
            for (int i = 0; i < size; i++) {
                if (get(i) == null)return i;
            }
            return -1;
        }
        else {
            for (int i = 0; i <size ; i++) {
                if (e.equals(get(i)))return i;
            }
            return -1;
        }
    }

    //rangeCheck
    public void rangeCheck(int index){
        if (index <0 ||index >size)
            throw new IndexOutOfBoundsException("Size:"+size+",Index:"+index);
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


}
