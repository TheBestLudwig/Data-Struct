/**
 * @Auther: jeff
 * @Date: 2021/10/30 - 10 - 30 - 22:22
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class numberToCharAndString {public static void main(String[] args) {

    String calc = "78+9*6+3*2";
    String s = "";
    for (int i = 0; i < calc.length(); i++) {
        System.out.println(String.valueOf(calc.charAt(i)));
    }
    for (int i = 0; i <calc.length() ; i++) {
//	            if (isDigit(calc.charAt(i))){
//	                s += String.valueOf(calc.charAt(i));
//	                System.out.println(s);
//	            }

        //int ii = Integer.parseInt(s);
        //System.out.println(ii);
        s = "";
    }
}
    static boolean isOper(char c){
        return c == ('+'|'-'|'*'|'/');
    }
    static boolean isDigit(char c){
        return c == ('1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9'|'0');
    }

}