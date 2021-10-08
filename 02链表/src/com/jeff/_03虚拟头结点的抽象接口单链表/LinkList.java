package com.jeff._03虚拟头结点的抽象接口单链表;

/*
 *  增加一个虚拟头结点（不推荐），只是学习一种思路
 *  (1)构造器初始化时即创建一个值为空的虚拟头结点
 *  (2)因为头面添加了虚拟头结点，Node<E> node(int index)的初始条件应是从first.next开始遍历，即真正的0号结点开始
 *  (3)不再需要对index==0进行分支处理，Node<E> prev = (index ==0)?first:node(index-1)确定prev后，操作统一
 *  (4)不再需要对index==0进行分支处理，Node<E> prev = (index ==0)?first:node(index-1)确定prev后，操作统一
 */
public class LinkList<E> extends Abs_List<E> {
    Node<E> first;

    //构造器中增加一行代码，生成一个值为空的头结点
    public LinkList() {
        first = new Node<>(null,null);//(1)
    }

    //add
    public void add(int index,E e){//(3)
        rangeCheck(index);
        Node<E> prev = (index ==0)?first:node(index-1);
        prev.next = new Node<>(e,prev.next);

        size++;
    }

    public void add(E e){
        add(size,e);
    }

    //remove
    public E remove(int index){//(4)
        rangeCheck(index);
        Node<E> old = node(index);
        Node<E> prev = (index == 0)?first:node(index-1);
        prev.next = prev.next.next;

        size--;

        return old.elem;
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
        Node<E> theOne = first.next;//(2)
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
