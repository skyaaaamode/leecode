package utils;

public class PrintUtils {
    //TODO 泛型怎么用
    public static void printArray(int[] s){
        for (int i:s){
            System.out.println(i);
        }
    }
//    public static void printListNode(ListNode listNode){
//        while (listNode!=null){
//            System.out.println(listNode.val);
//            listNode=listNode.next;
//        }
//    }
    //TODO 泛型怎么用
    public static void printArray(Integer[] s){
        for (int i:s){
            System.out.println(i);
        }
    }
    //TODO 添加输出的字符串格式的转换
    public static void printArray(Integer[] s,String decode){
        for (int i:s){
            System.out.println(i);
        }
    }
}
