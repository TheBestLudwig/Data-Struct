package _01面向对象._01类和对象;

public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "jack";
        p.age = 10;
        p.sex = '男';

        Person pp = new Person("mary",12,'女');
        System.out.println(p);
        System.out.println(pp);
    }
}
