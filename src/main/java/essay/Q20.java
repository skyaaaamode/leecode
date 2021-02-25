package essay;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author zhouzf32074
 * @Classname Q20
 * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/24 20:56
 */
public class Q20 {
    /**
     * 用队列实现
     * 1.依次放进队列中，当队列最后为空，说明字符串符合标准
     * 2.如果是向右开口的括号，继续放入
     * 3.如果是向左开口的括号，判断队列顶部这个元素能否匹配上，如果不匹配，返回false，匹配，删除
     * 4.特例：如果s不为偶数，返回false
     * @param s
     * @return
     */
    public static boolean method01(String s) {
        if(s.length()==0||s.length()%2!=0){
            return false;
        }
        if(!judgeDir(s.charAt(0))){
            return false;
        }
        LinkedList<Character> queue = new LinkedList<>();
        queue.add(s.charAt(0));
        for (int i=1;i<s.length();i++){
            if(judgeDir(s.charAt(i))){
                queue.add(s.charAt(i));
            }
            else {
                if(queue.size()==0){
                    return false;
                }
                Character pop = queue.removeLast();
                if(!match(s.charAt(i),pop)){
                    return false;
                }
            }
        }
        return queue.size()==0;
    }
    public static boolean judgeDir(char s){
        if(s=='('|| s=='['||s=='{'){
            return true;
        }
        return false;
    }

    public static boolean match(char find ,char real){
        HashMap<Character, Character> hashMap = new HashMap<>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        return hashMap.get(find)==real;
    }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("@")){
            String split = scanner.nextLine();
            boolean s = Q20.method01(split);
            System.out.println(s);
        }
    }
}
