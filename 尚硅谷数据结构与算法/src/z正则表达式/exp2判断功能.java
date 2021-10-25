package z正则表达式;

/**
 * 验证一个手机号，必须以138或139开头
 */
public class exp2判断功能 {
    public static void main(String[] args) {
        String content = "13988889999";//字符串本身就有正则式方法
        if (content.matches("1(38|39)\\d{8}")) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }

    }
}
