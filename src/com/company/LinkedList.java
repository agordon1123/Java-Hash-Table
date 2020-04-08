package com.company;

public class LinkedList {

    private ListNode head;
    private int length;

    public LinkedList() {
        this.head = null;
        this.length = 0;
    }

    public ListNode getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public LinkedList(ListNode head) {
        this.head = head;
        this.length = 0;
    }

    private void increaseLength() {
        this.length += 1;
    }

    private void decreaseLength() {
        if (this.length <= 0) {
            this.length = 0;
        } else {
            this.length -= 1;
        }
    }

    public void addToHead(ListNode listnode) {

        ListNode copy = this.head;
        this.head = listnode;

        if (copy != null) {
            this.head.setNext(copy);
            increaseLength();
        }
    }

    public ListNode remove(ListNode targetNode) {

        if (this.head == null) {
            return null;
        }

        ListNode node = this.head;
        ListNode prev = null;

        while (node != null) {
            if (node == targetNode) {
                // found value
                if (prev == null) {
                    // at head
                    this.head = null;
                } else {
                    prev.setNext(node.getNext());
                    decreaseLength();
                }
                return node;
            }
            prev = node;
            node = node.getNext();
        }
        return null;
    }


}
