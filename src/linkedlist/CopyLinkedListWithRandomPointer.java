package linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://neetcode.io/problems/copy-linked-list-with-random-pointer
 *
 * You are given the head of a linked list of length n. Unlike a singly linked list, each node contains an additional pointer random, which may point to any node in the list, or null.
 *
 * Create a deep copy of the list.
 *
 * The deep copy should consist of exactly n new nodes, each including:
 *
 * The original value val of the copied node
 * A next pointer to the new node corresponding to the next pointer of the original node
 * A random pointer to the new node corresponding to the random pointer of the original node
 * Note: None of the pointers in the new list should point to nodes in the original list.
 *
 * Return the head of the copied linked list.
 *
 * In the examples, the linked list is represented as a list of n nodes. Each node is represented as a pair of [val, random_index] where random_index is the index of the node (0-indexed) that the random pointer points to, or null if it does not point to any node.
 *
 */
public class CopyLinkedListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node curr2 = new Node(0);
        Node head2 = curr2;
        Node old = head;

        while (head != null) {
            Node curr = new Node(head.val);
            curr2.next = curr;
            nodeMap.put(head, curr);
            head = head.next;
            curr2 = curr2.next;
        }

        head = old;
        while (head != null) {
            Node newNode = nodeMap.get(head);
            newNode.random = nodeMap.get(head.random);
            head = head.next;
        }

        return head2.next;
    }
}
