package offer;

/**
 * @author Daniel
 * @title: 面试题5：替换空格
 * @description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @date 2019-03-11 17:29
 */
public class Question5 {
    private static String replaceSpace(StringBuffer str) {
        String replace = "02%";
        int preTotal = str.length();
        // 空格的个数
        int count = 0;
        for (int i = 0; i < preTotal; i++)
            if (str.charAt(i) == ' ')
                count++;

        if (count == 0 || preTotal == 0)
            return str.toString();

        int newTotal = preTotal + count * 2;
        StringBuffer newStr = new StringBuffer(newTotal);
        for (int i = preTotal - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ')
                newStr.append(replace);
            else
                newStr.append(str.charAt(i));
        }
        return newStr.reverse().toString();
    }

    /**
     * 标准答案
     */
    private static String replaceSpaceStandard(StringBuffer str) {
        int spacenum = 0;//spacenum为计算空格数
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                spacenum++;
        }
        int indexold = str.length() - 1;//indexold为为替换前的str下标
        int newlength = str.length() + 2 * spacenum;//计算空格转换成%20之后的str⻓长度
        int indexnew = newlength - 1;//indexold为为把空格替换为%20后的str下标
        str.setLength(newlength);//使str的⻓长度扩⼤大到转换成%20之后的⻓长度,防⽌止下标越界,setLength⽅方法
        for (; indexold >= 0 && indexold < newlength; --indexold) {
            if (str.charAt(indexold) == ' ') {//charAt⽅方法
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            } else {
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello world");
        System.out.println(replaceSpace(str));
    }
}
