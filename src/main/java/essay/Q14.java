package essay;

import java.util.Scanner;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: leecode
 * @Package: essay
 * @Description: note
 * @Author: zhouzf32074
 * @CreateDate: 2020/11/8 22:30
 * @UpdateUser: zhouzf32074
 * @UpdateDate: 2020/11/8 22:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * Copyright © 2020 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Q14 {
    /**
     * 解法一：暴力破解
     */
    public static String commonPre(String a,String b){
        if(a==null||a==""||b==null||b==""){
            return "";
        }
        char[] strA=a.toCharArray();
        char[] strB=b.toCharArray();
        int i=0,j=0;
        while (i<strA.length&&j<strB.length){
            if(strA[i]!=strB[j]){
               break;
            }
            i++;
            j++;
        }
        return a.substring(0,i);
    }
    public static String method01(String[] s){
        if(s==null||s.length==0){
            return "";
        }
        if(s.length==1){
            return s[0];
        }
        int index=1;
        String result=s[0];
        while (index<s.length&&result.length()!=0){
            String next = commonPre(result, s[index]);
            result=next;
            index++;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("@")){
            String[] split = scanner.nextLine().split(",");
            String s = Q14.method01(split);
            System.out.println(s);
        }
    }
}
