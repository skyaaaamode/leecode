package medium;


import stracture.ListNode;
import utils.EncodeConvert;
import utils.PrintUtils;

import java.util.Scanner;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q02 {
    /**
     * 解法01：1）引入一个额外的计算变量etra，取值为0和1，进位为1，不进为0   2）两个游标分别从两个链表开始，不断地计算加值
     * 3）游标到达终点
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode f=head;
        int etra=0;
        ListNode p=l1;
        ListNode q=l2;
        while (p!=null&&q!=null){
            //加法进位的逻辑
            ListNode newhere = new ListNode((p.val + q.val+etra) % 10);
            etra=(p.val+q.val+etra)>=10?1:0;
            f.next=newhere;
            f=f.next;
            p=p.next;
            q=q.next;
        }
        while (p==null&&q!=null){
            ListNode newhere = new ListNode(( q.val+etra) % 10);
            etra=(q.val+etra)>=10?1:0;
            f.next=newhere;
            f=f.next;
            q=q.next;
        }
       while (q==null&&p!=null){
            ListNode newhere = new ListNode(( p.val+etra) % 10);
            f.next=newhere;
            f=f.next;
            etra=(p.val+etra)>=10?1:0;
            p=p.next;
        }
            if(etra!=0){
                ListNode newhere = new ListNode(etra % 10);
                f.next=newhere;
            }

        return head.next;
    }

    /**
     * 专业题解
     * @param
     */
    public ListNode addTwoNumbers02(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            ListNode listNode01 = EncodeConvert.String2ListNode(scanner.nextLine(), ",");
            ListNode listNode02 = EncodeConvert.String2ListNode(scanner.nextLine(), ",");
            ListNode result = Q02.addTwoNumbers(listNode01, listNode02);
            PrintUtils.printListNode(result);

        }
    }
}
