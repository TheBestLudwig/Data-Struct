package 链表.双向链表;

public class DoubleLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "吴用", "智多星");
        Node node3 = new Node(3, "林冲", "豹子头");
        Node node4 = new Node(4, "王英", "矮脚虎");
        Node node5 = new Node(5, "杨志", "青面兽");

        HeroList list = new HeroList();
        list.addByOrder(node1);
        list.addByOrder(node3);
        list.addByOrder(node5);
        list.addByOrder(node4);
        list.addByOrder(node2);

        list.showList();

        System.out.println(list.curNode(2));
        list.remove(2);
        list.showList();
        list.set(new Node(3,"冲哥","猛将兄"));
        list.showList();
        System.out.println(list.Size());
    }
}


class Node{
    public int no;
    public String name;
    public String nickName;
    public Node prev;
    public Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.prev = null;
        this.next = null;
    }

    @Override
    public String toString() {
        if (no <=0 )return "head";
        return "(" + no + "," + name + "," + nickName + ")";
    }
}

class HeroList{
    private Node head = new Node(0,"","");

    public Node getHead(){
        return head;
    }

    //判空
    public boolean isEmpty() {
       return head.name == null;
    }

    //遍历双向链表
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

    //add方法（尾插和有序插）
    public void addToTail(Node node) {
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        node.prev = temp;
        node.next = temp.next;
        temp.next = node;
    }
    public void addByOrder(Node node){
        if (node == null)return;
        Node temp = head;
        while (temp.next !=null && temp.next.no < node.no){
            temp  = temp.next;
        }//此时temp指向node应插入的地点之前
        node.next = temp.next;
        node.prev = temp;
        if (temp.next !=null){
            temp.next.prev = node;//1，如果是最后一个元素，则不需要这一步
        }

        temp.next = node;//2这两个不能交换位置,如1在前，则temp.next已改变了指向，取它的prev就会少一根指针

    }

    //remove方法
    public void remove(int no) {
        if (isEmpty()) {
            System.out.println("链表为空...");
            return;
        }
        Node cur = curNode(no);
        if (cur == null) {
            System.out.println("删除失败！");
        } else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
    }

    //set方法，这里意为传入的节点编号如果是已在表中的，就修改该编号下的节点信息。
    public void set(Node node) {
        if (isEmpty())return;
        Node cur = curNode(node.no);
        if (cur == null){
            System.out.println("编号不存在，不要乱改");
            return;
        }
        cur.name = node.name;
        cur.nickName = node.nickName;
    }

    //get方法
    public Node curNode(int no) {//查找编号为no的节点，并返回指向它的指针
        if (no <= 0) {//编号范围判定
            System.out.println("输入编号有误");
            return null;
        }
        if (isEmpty()) return null;//空表排除
        Node cur = head.next;
        while (cur != null) {//cur没到最后一个节点，往后移
            if (cur.no == no) {//如果cur节点的值是no时，就是查找的这个值
                return cur;
            }else {
                cur = cur.next;
            }
        }
        return null;//直到最后一个节点也没有找到对应的no,就意味着没有找到，返回空
    }


    //Size 求链表长度
    public int Size(){
        int size = 0;
        if (isEmpty())return 0;
        Node cur = head.next;
        while (cur != null){
            cur = cur.next;
            size++;
        }
        return size;
    }



}