//输入两个链表，找出它们的第一个公共结点。
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        ListNode pL=pHead1;
        ListNode pS=pHead2;
        int len1=getLen(pHead1);
        int len2=getLen(pHead2);
        int len=len1-len2;
        if(len<0){
            pL=pHead2;
            pS=pHead1;
            len=-len;
        }
        while(len!=0){
            pL=pL.next;
            len--;
        }
        while(pL!=pS){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS&&pL!=null){
            return pL;
        }
        return null;
    }
    public int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        return len;
    }
}

//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
//重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode deleteDuplication(ListNode pHead){
        ListNode dummy=new ListNode(-1);
        dummy.next=pHead;
        ListNode pre=dummy;
        ListNode cur=dummy.next;
        while(cur!=null){
            if(cur.next!=null&&cur.next.val==cur.val){
                while(cur.next!=null&&cur.next.val==cur.val){
                    cur=cur.next;
                }
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}

//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead==null){
            return null;
        }
        ListNode fast=pHead;
        ListNode slow=pHead;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=pHead;
        while(slow!=fast){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}

//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指
//针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参
//数中的节点引用，否则判题程序会直接返回空）
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null){
            return null;
        }
        RandomListNode cur=pHead;
        while(cur!=null){
            RandomListNode clone=new RandomListNode(cur.label);
            clone.next=cur.next;
            cur.next=clone;
            cur=cur.next.next;
        }
        cur=pHead;
        while(cur!=null&&cur.next!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }else{
                cur.next.random=null;
            }
            cur=cur.next.next;
        }
        cur=pHead;
        RandomListNode newHead=cur.next;
        while(cur!=null&&cur.next!=null){
            RandomListNode curNext=cur.next;
            cur.next=cur.next.next;
            cur=curNext;
        }
        return newHead;
    }
}