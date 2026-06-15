package linkedlist;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int size = 0;

        while(curr != null) {
            size++;
            curr = curr.next;
        }

        curr = head;

        int rem = size - n;
        ListNode prev = null;
        while (rem > 0) {
            prev = curr;
            curr = curr.next;
            rem--;
        }
        if (prev != null) prev.next = curr.next;

        return (prev == null)? head.next : head;

    }
}
