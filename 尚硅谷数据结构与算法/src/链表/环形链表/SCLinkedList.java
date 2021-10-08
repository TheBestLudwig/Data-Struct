package 链表.环形链表;

public class SCLinkedList {
    public static void main(String[] args) {
        SCNode node1 = new SCNode(1, "宋江", "及时雨");
        SCNode node2 = new SCNode(2, "吴用", "智多星");
        SCNode node3 = new SCNode(3, "林冲", "豹子头");
        SCNode node4 = new SCNode(4, "王英", "矮脚虎");
        SCNode node5 = new SCNode(5, "杨志", "青面兽");

        SCHList l = new SCHList();
        l.addToTail(node1);
        l.addToTail(node2);
        l.addToTail(node3);
        l.addToTail(node4);
        l.addToTail(node5);

        l.showList();
        System.out.println(l.getHead().next);

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
        this.next = this;
    }


    @Override
    public String toString() {
        if (no <= 0) return "head";
        return "(" + no + "," + name + "," + nickName + ")";
    }
}

class SCHList {
    private SCNode head = new SCNode(-1, "", "");


    public SCNode getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //add方法
    public void addFromHead(SCNode node) {//头插
        if (node == null) return;
        SCNode cur = head.next;
        while (cur.next != head.next) {//cur.next存在么？
            cur = cur.next;
        }
        node.next = head.next;
        cur.next = node;
    }

    public void addToTail(SCNode node) {//尾插
        if (node == null) return;
        if (Size()==0) {
            head.next = node;
            node.next = head.next;
        } else if(Size()==1){
            head.next.next = node;
            node.next = head.next;
        }else{
            SCNode cur = head.next;
                while (cur != head.next) {
                    cur = cur.next;
            }
            cur.next = node;
            node.next = head.next;
        }


    }

    public void addByOrder(SCNode node) {//有序插
        if (node == null) return;
    }

    public void showList() {
        if (isEmpty()) {
            System.out.println("链表为空...");
            return;
        }
        SCNode cur = head.next;
        System.out.print("{");
        if (Size()==0) System.out.println("null}");
        else if (Size()==1) System.out.println(head.next+"head.next");
        else{
            while (cur.next != head.next) {
                System.out.print(cur + "->");
                cur = cur.next;
            }
            System.out.println("head.next}");
        }


    }

    public int Size() {
        int n = 0;
        if (head.next == null) return n;

        SCNode cur = head.next;
        while (cur.next != head.next) {
            cur = cur.next;
            n++;

        }
        return n;
    }

}

