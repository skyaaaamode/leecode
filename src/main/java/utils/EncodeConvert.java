package utils;

import stracture.ListNode;

public class EncodeConvert {
    //TODO 流是不是逼格高一点
    public static int[] arrayString2Integer(String[] s) {
        int[] ints = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            ints[i] = Integer.parseInt(s[i]);
        }
        return ints;
    }

    //String转换成ListNode
    public static ListNode String2ListNode(String s, String separator) {
        String[] split = s.split(separator);
        ListNode result = new ListNode(0);
        ListNode p = result;
        for (String i : split) {
            ListNode listNode = new ListNode(Integer.parseInt(i));
            result.next = listNode;
            result = result.next;
        }
        return p.next;
    }
}
