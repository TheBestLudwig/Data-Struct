package b链表.a单链表;


import java.util.Stack;

public class SingleLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "吴用", "智多星");
        Node node3 = new Node(3, "林冲", "豹子头");
        Node node4 = new Node(4, "王英", "矮脚虎");
        Node node5 = new Node(5, "杨志", "青面兽");

        Node node6 = new Node(6, "时迁 ", "鼓上蚤");
        Node node7 = new Node(7, "张青", "菜园子");
        Node node8 = new Node(8, "史进", "九纹龙");
        Node node9 = new Node(9, "花荣", "小李广");
        Node node10 = new Node(10, "秦明", "霹雳火");

        System.out.println(node1);
        HeroList list = new HeroList();
        HeroList list2 = new HeroList();

        list.addToTail(node1);
        list.addToTail(node3);
        list.addToTail(node5);
        list.addToTail(node6);
        list.addToTail(node7);

        list2.addToTail(node2);
        list2.addToTail(node4);
        list2.addToTail(node8);
        list2.addToTail(node9);
        list2.addToTail(node10);


//        list.addByOrder(node1);
//        list.addByOrder(node3);
//        list.addByOrder(node5);
//        list.addByOrder(node4);
//        list.addByOrder(node2);


        list.showList();
        System.out.println("==============");
        list2.showList();
        System.out.println("==============");
//        System.out.println(list.prevNode(1));
//
//
//        list.remove(4);
//        list.showList();
//        list.set(new Node(3,"小林","绿帽哥"));
//        list.showList();
//        System.out.println(list.Size());
//        System.out.println(list.nFromLast(1));
//        list.reverse2();
//        list.showList();
//        list.reversePrint();
        HeroList list3 = new HeroList();
        list3.merge(list, list2);
        list3.showList();


    }
}


class Node {
    public int no;
    public String name;
    public String nickName;
    public Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.next = null;
    }


    @Override
    public String toString() {
        if (no <= 0) return "head";
        return "(" + no + "," + name + "," + nickName + ")";
    }
}

class HeroList {//带一个编号为0的头结点
    private Node head = new Node(-1, "", "");
    //private Node tail = head;

    //判空
    public boolean isEmpty() {
        return head.next == null;
    }


    //add方法（尾插和有序插）
    public void addFromHead(Node node){
        if (node == null)return;
        node.next = head.next;
        head.next = node;
    }
    public void addToTail(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void addByOrder(Node node) {
        if (node == null) return;
        Node temp = head;
        while (temp.next != null && node.no > temp.next.no) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    //remove方法
    public void remove(int no) {
        if (isEmpty()) {
            System.out.println("链表为空...");
            return;
        }
        Node prev = prevNode(no);
        if (prev == null) {
            System.out.println("删除失败！");
        } else {
            prev.next = prev.next.next;
        }
    }

    //set方法，这里意为传入的节点编号如果是已在表中的，就修改该编号下的节点信息。
    public void set(Node node) {
        if (isEmpty()) return;
        Node prev = prevNode(node.no);
        if (prev == null) {
            System.out.println("编号不存在，不要乱改");
            return;
        }
        prev.next.name = node.name;
        prev.next.nickName = node.nickName;
    }

    //get方法
    public Node prevNode(int no) {//查找编号为no的上一个节点，并返回指向它的指针
        if (no <= 0) {//编号范围判定
            System.out.println("输入编号有误");
            return null;
        }
        if (isEmpty()) return null;//空表排除
        Node temp = head;
        while (temp.next != null) {//temp没到最后一个节点，往后移
            if (temp.next.no == no) {//如果temp下一个节点的值是no时，就提前返回temp
                return temp;
            } else {
                temp = temp.next;
            }
        }
        return null;//直到最后一个节点也没有找到对应的no,就意味着没有找到，返回空
    }


    //Size 求单链表长度===>新浪面试题
    public int Size() {
        int size = 0;
        if (isEmpty()) return 0;
        Node cur = head.next;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    //取倒数第n个节点===>新浪面试题
    public Node nFromLast(int n) {
        int size = Size();
        if (n <= 0 || n > size) return null;
        Node cur = head.next;
        for (int i = 0; i < size - n; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //链表反转===>腾讯面试题
    public void reverse() {
        Node newhead = new Node(-1, "", "");
        Node cur = head.next;
        while (cur != null) {
            head.next = head.next.next;
            cur.next = newhead.next;
            newhead.next = cur;
            cur = head.next;
        }
        head = newhead;

    }

    public void reverse2() {
        if (head.next == null || head.next.next == null) return;
        Node newhead = new Node(-1, "", "");
        Node cur = head.next;
        Node temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = newhead.next;
            newhead.next = cur;
            cur = temp;
        }
        head.next = newhead.next;
    }

    /**
     * 逆序打印单链表
     * ===>1.先反转后打印，问题是破坏原链表，不建议
     * ===>2.利用栈，将各个结点压入到栈中，利用先进后出特点实现
     */
    public void reversePrint() {
        if (head.next == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop() + "->");
        }
        System.out.println("x");
    }


    //归并排序:两个有序链表合并成一个有序链表//还是要找前一个元素
    public void  merge(HeroList l1, HeroList l2) {//既然是用list3.merge调用，那里面就含有指定list3的this
        Node t1 = l1.head;
        Node t2 = l2.head;
        Node x = null;
        while (t1.next != null && t2.next != null) {
            if (t1.next.no < t2.next.no) {
                x = t1.next;
                t1.next = x.next;
                this.addToTail(x);
            } else if (t2.next.no < t1.next.no) {
                x = t2.next;
                t2.next = x.next;
                this.addToTail(x);
            }
        }
        x = this.head;
        while (x.next!=null){
            x = x.next;
        }//找到链表的尾节点
        if (t1.next == null) {
            x.next = t2.next;//把剩余链表挂在this链表的后面
        }else if (t2.next == null){
            x.next = t1.next;
        }
    }

    //打印方法


    public void showList() {
        if (isEmpty()) {
            System.out.println("链表为空...");
            return;
        }
        Node temp = head;
        System.out.print("{");
        while (temp != null) {
            System.out.print(temp + "->");
            temp = temp.next;
        }
        System.out.println("x}");
    }

}