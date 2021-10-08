package com.jeff._03虚拟头结点的抽象接口单链表;
/*接口：只声明公共方法，而不用实现
 *谁来实现？ArrayList和LinkList通过implaments来实现
 *这是表结构的接口，为的是把ArrayList和LinkList的方法相同，
 */
public interface I_List<E>  {
    static final int ELEM_NOT_FOUND = -1;
    void add(int index,E e);
    void add(E e);
    E remove(int index);
    E set(int index,E e);
    E get(int index);
    int indexOf(E e);
    //以下几个一模一样，可以写进父类

    void clear();

}
