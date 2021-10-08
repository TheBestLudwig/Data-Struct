package 时间和日期;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Date;

public class Date_Time {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.toString());
        System.out.println(d.toLocaleString());
        System.out.println(d.getYear());
        System.out.println(System.currentTimeMillis());
    }
}
