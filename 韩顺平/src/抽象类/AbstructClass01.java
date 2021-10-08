package 抽象类;

public abstract class AbstructClass01 {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.caculateTime();
        BB bb = new BB();
        bb.caculateTime();
    }
}
abstract class Template{//模板设计模式
    public abstract void job();
    public void caculateTime(){
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("执行时间："+(end - start));
    }
}

class AA extends Template{
    public void job(){
        long start = System.currentTimeMillis();
        long num = 0;
        for (long i = 1; i <= 8000000; i++) {
            num += i;
        }
    }
}
class BB extends Template{
    public void job() {
        long start = System.currentTimeMillis();
        long num = 0;
        for (long i = 1; i <= 888888888; i++) {
            num *= i;
        }
    }
}

class CC{
    public void caculateTime(){
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        job();
        System.out.println("执行时间："+(end - start));
    }
    public void job() {
        long num = 0;
        for (long i = 1; i <= 999900000; i++) {
            num *= i;
        }
    }
}