package linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;

            node = node.next;
            if (node != null) {
                minHeap.offer(node);
            }
        }
        return head.next;
    }
}
