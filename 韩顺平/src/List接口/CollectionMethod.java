package List接口;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings({"all"})
public class CollectionMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        //add方法
        list.add("jack");
        list.add("tom");
        list.add("marry");
        list.add(10);
        list.add(true);

        System.out.println(list);
        //remove方法
        list.remove(0);//删除第1个元素
        System.out.println(list);
        list.remove("tom");//删除tom元素
        System.out.println(list);

        //contains
        System.out.println("contains marry?" + list.contains("marry"));
        //size
        System.out.println("size:" + list.size());
        //isEmpty
        System.out.println("empty?" + list.isEmpty());
        //clear
        list.clear();
        System.out.println(list);

        //addall添加多个元素,参数是另一个Collection对象
        ArrayList list2 = new ArrayList();
        list2.add("红楼梦");
        list2.add("西游记");
        list2.add("水浒传");
        list2.add("金瓶梅");

        list.addAll(list2);
        System.out.println(list);
        list.add("哈利波特");
        list.removeAll(list2);
        System.out.println(list);

        //Collection接口和常用方法
        //1.Iterator对象为迭代器，主要用于遍历Collection集合中的元素
        //2.所有实现了Collection接口的集合类都有一个iterator()方法，用于返回
        //一个实现了Iterator接口的对象，即可以返回一个迭代器
        //3.Iterator的结构
        //    boolean  hasNext();//如果还有元素，就返回true
        //    E next();//返回下一个元素
        //在调用iterator.next()方法前必须要调用iterator.hasNext()进行检测，
        //否则一下科记录无效，会抛出NoSuchElemmentException异常。

        //4.Iterator仅用于遍历集合，它本身不存放对象
        System.out.println("======================================");
        Collection col = new ArrayList();
        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("红楼梦", "曹雪芹", 25.6));
        col.add(new Book("小李飞刀", "古龙", 15.1));
        col.add("寻秦记");
        System.out.println(col);
        //现在遍历
        //1.先得到集合对应的迭代器
        Iterator iterator = col.iterator();
        //2.使用While循环遍历快，速生成while快捷键==>itit
        while (iterator.hasNext()) {//判断是否还有数据
            Object obj = iterator.next();//返回的下个元素类型是Object
            System.out.println(obj);
        }
        //3.当退出循环后，iteratior指向最后的元素，不能再取下一个
        //iterator.next();
        //4.如果希望再次遍历，需要重置迭代器
        iterator = col.iterator();//再次指向最前面。

    }
}

class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}