package b链表.c环形链表;

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList cs = new CircleSingleLinkedList();
        cs.add(5);
        cs.show();
        cs.countBoy(1,2,5);
    }
}

//创建单环链表
class CircleSingleLinkedList {
    private Boy first;

    public void add(int nums) {
        if (nums <= 0) {
            System.out.println("nums不正确");
            return;
        }

        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy bb = new Boy(i);
            if (i == 1) {
                first = bb;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(bb);
                bb.setNext(first);
                curBoy = bb;
            }
        }

    }

    public void show() {
        if (first == null) return;
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //约瑟夫问题出队分析，根据输入生成小孩出圈顺序
    /**1.创建一个辅助指针helper指向环形链表的最后节点（第一个节点的前一节点）
     * 2.报数，第一个节点报1，第二个节点报2，实际m=2时，只往前走一步
     * 3.当小孩报数时，让first和helper指针同时向前移m-1次
     * 4.这时将first指向的节点出圈（删除并输出编号），即
     * first = first.next;
     * helper.next = first;
     * */
    /**
     * @param startNo：从第几个小孩开始数数
     * @param countNum：表示数几下
     * @param nums：表示开始有几个小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //helper和first定位，向后移动startNo
        for (int i = 0;i< startNo-1;i++){
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，first和helper同时后移countNum-1次，然后出圈
        while (true){
            if (helper == first){//此时圈中只有一个节点
                break;
            }
            for (int i = 0;i< countNum-1;i++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first指向的节点就是出圈节点
            System.out.printf("%d->",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("%d\n",first.getNo());
    }


}


//创建Boy节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}