package z正则表达式;

/**
 * 按照#或得-或得~或者数字分割串
 */
public class exp3分割功能 {
    public static void main(String[] args) {
        String content = "hello#abc-jack12smith~北京";
        String[] split = content.split("#|-|~|\\d+");
        for (String s : split) {
            System.out.println(s);
        }
        //注:split的类型是字符串数组
    }


}
