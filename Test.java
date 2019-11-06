//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        int carry=0;
        while(l1!=null||l2!=null||carry!=0){
            int num1=l1==null?0:l1.val;
            int num2=l2==null?0:l2.val;
            int num=num1+num2+carry;
            carry=num/10;
            cur.next=new ListNode(num%10);
            cur=cur.next;
            if(l1!=null){
                l1=l1.next;
            }if(l2!=null){
                l2=l2.next;
            }
        }
        return dummy.next;
    }
}

给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单
个数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1=reverse(l1);
        ListNode head2=reverse(l2);
        int carry=0;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while(head1!=null||head2!=null||carry!=0){
            int num1=head1==null?0:head1.val;
            int num2=head2==null?0:head2.val;
            int num=num1+num2+carry;
            carry=num/10;
            cur.next=new ListNode(num%10);
            cur=cur.next;
            if(head1!=null){
                head1=head1.next;
            }if(head2!=null){
                head2=head2.next;
            }
        }
        return reverse(dummy.next);
    }
    public ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        ListNode newHead=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return newHead;
    }
}

