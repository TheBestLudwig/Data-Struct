package reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
@SuppressWarnings({"all"})
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //根据配置文件re.properties指定信息，创建cat对象并调用hi

        //传统方法
//        Cat cat = new Cat();
//        cat.hi();


        //
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\JAVA_CODE\\Data-Struct\\韩顺平\\src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath="+classfullpath);
        System.out.println("methodName="+methodName);


        //使用反射机制
        //1.加载类，返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //2.通过cls得到你加载的类reflection.Cat的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型为："+o.getClass());//运行类型
        //3.通过cls得到你加载类reflection.Cat的methodName"hi"的方法对象
        //即：在反射中，可以把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(methodName);
        //4.通过method1来调用方法，即通过方法对象来实现调用方法
        method1.invoke(o);//传统方法：对象.方法（）；反射机制：方法.invoke(对象);



    }
}
