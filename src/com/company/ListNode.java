package com.company;

public class ListNode {
    private String key;
    private String value;
    private ListNode next;

    public ListNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public void setNext(ListNode listnode) {
        this.next = listnode;
    }

    public ListNode getNext() {
        return this.next;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
