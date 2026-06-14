package linkedlist;

public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr = new ListNode(0);
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode head = curr;

        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                curr.next = node2;
                node2 = node2.next;
            } else {
                curr.next = node1;
                node1 = node1.next;
            }
            curr = curr.next;
        }

        if (node1 != null) {
            curr.next = node1;
        } else {
            curr.next = node2;
        }
        return head.next;
    }
}
