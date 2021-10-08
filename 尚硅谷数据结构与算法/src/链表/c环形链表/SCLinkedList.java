package 链表.c环形链表;

public class SCLinkedList {
    public static void main(String[] args) {
        SCNode node1 = new SCNode(1, "宋江", "及时雨");
        SCNode node2 = new SCNode(2, "吴用", "智多星");
        SCNode node3 = new SCNode(3, "林冲", "豹子头");
        SCNode node4 = new SCNode(4, "王英", "矮脚虎");
        SCNode node5 = new SCNode(5, "杨志", "青面兽");

        SCHList l = new SCHList();
        l.add(node1);
        l.add(node2);
        l.add(node3);
        l.add(node4);
        l.add(node5);
        System.out.println(l.Size());
        l.showList();
        System.out.println(l.getHead());

    }
}

class SCNode {
    public int no;
    public String name;
    public String nickName;
    public SCNode next;

    public SCNode(int no, String name, String nickName) {
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

class SCHList {
    private SCNode head = null;


    public SCNode getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //add方法

    public void add(SCNode node) {//尾插
        if (node == null) return;
        if (Size()==0) {
            head= node;
            node.next = head;
        } else{
            SCNode cur = head.next;
                while (cur.next !=head) {
                    cur = cur.next;
            }
            cur.next = node;
            node.next = head;
        }
    }

    public void showList() {
        if (isEmpty()) {
            System.out.println("链表为空...");
            return;
        }
        SCNode cur = head;
        if (Size()==0){
            System.out.println("null");
            return;
        }else if (Size()==1){
            System.out.print("{"+cur+"->");
        }else {
            System.out.print("{");
            while (cur.next !=head) {
                System.out.print(cur + "->");
                cur = cur.next;
            }
            System.out.print(cur + "->");
        }

        System.out.println("head}");
    }

    public int Size() {

        if (head == null) return 0;
        int n = 2;
        SCNode cur = head.next;
        if (cur.next == head)return 1;
        while (cur.next != head) {
            cur = cur.next;
            n++;

        }
        return n;
    }

}

