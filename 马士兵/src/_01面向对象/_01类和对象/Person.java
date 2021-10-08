package _01面向对象._01类和对象;

public class Person {
    String name;
    int age;
    char sex;

    public Person() {
    }

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void eat(){
        System.out.println("我喜欢吃饭！");
    }

    @Override
    public String toString() {
        return "Person[" + name + "," +  age +","+ sex +']';
    }


}
