package com.jeff._02抽象接口单链表;
/*
 *这是表结构的父类，为的是把ArrayList和LinkList的相同部分整合起来
 * 即                I_List接口
 *                       |                  (实现)
 *                   Abs_List (该类不对外公开，外界是不知道有这个类的，只是为了用来抽取公共代码，服务于库作者)
 *                    /      \              （继承）
 *                   /        \
 *              ArrayList     LinkList
 *
 * 1、公共接口在I_List中声明
 * 2、动态数组和链表中一模一样的部分在Abs_List中实现，Abs_List<E> implements I_List<E>
 *      接口中的方法不必实现，所以为Abs_List前添加abstract关键字
 * 3、ArrayList和LinkList分别extends Abs_List<E>,实现接口I_List<E>中声明未实现的方法。
 */


public abstract class Abs_List<E> implements I_List<E>{
    protected int size;//表的大小,父类中有了，LinkList中就应去掉，否则就是两个size，值会不一样

    //size
    public int size(){
        return size;
    }

    //isEmpty
    public boolean isEmpty(){
        return size ==0;
    }

    //rangeCheck
    public void rangeCheck(int index){
        if (index <0 ||index >size)
           throw new IndexOutOfBoundsException("Size:"+size+",Index:"+index);
    }


}
