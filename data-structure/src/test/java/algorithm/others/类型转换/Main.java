package algorithm.others.类型转换;

/**
 * @program: java-interview
 * @description:
 * @author: aabo
 * @create: 2024-10-08 22:15
 **/
public class Main {

    public static void main(String[] args) {

        // String转数字
        String strInt = "12345";
        int intNum = Integer.parseInt(strInt);
        String strDouble = "12345.12345";
        double doubleNum = Double.parseDouble(strDouble);
        System.out.println(intNum);
        System.out.println(doubleNum);
        // 数字转String
        strInt = String.valueOf(intNum);
        strDouble = String.valueOf(doubleNum);
        System.out.println(strInt);
        System.out.println(strDouble);
        // int转double
        double intToDouble = Double.valueOf(intNum);
        int doubleToInt = (int) doubleNum;
        System.out.println(intToDouble);
        System.out.println(doubleToInt);
        // 向上取整
        int ceil = (int) Math.ceil(doubleNum);
        System.out.println(ceil);
        // 向下取整
        int floor = (int) Math.floor(doubleNum);
        System.out.println(floor);
        // 四舍五入
        long round = Math.round(doubleNum);
        System.out.println(round);
        // 保留几位小数
        String format = String.format("%.2f", doubleNum);
        System.out.println(format);

    }

}
