package utils;

import stracture.ListNode;

public class PrintUtils {
    //TODO 泛型怎么用
    public static void printArray(int[] s){
        for (int i:s){
            System.out.println(i);
        }
    }
    public static void printListNode(ListNode listNode){
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

}
