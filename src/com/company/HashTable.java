package com.company;

public class HashTable {

    private int capacity;
    private LinkedList[] storage;
    // TODO: automatically resize
    private int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.storage = new LinkedList[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    private int hashMod(String key) {
        // using a simple ASCII modulo hash
        // TODO: impliment DJB2

        int total = 0;
        for (int i = 0; i < key.length(); i++) {
            Character c = key.charAt(i);
            total += (int) c;
        }
        return total % capacity;
    }

    public void insert(String key, String value) {

        int index = hashMod(key);
        ListNode newNode = new ListNode(key, value);

        // if storage at index is empty -> create LL
        if (storage[index] == null) {
            storage[index] = new LinkedList();
        }
        // insert new node
        storage[index].addToHead(newNode);
    }

    public String remove(String key) {

        int index = hashMod(key);
        LinkedList ll = storage[index];

        if (ll != null) {
            ListNode node = ll.getHead();
            while (node != null) {
                if (node.getKey() == key) {
                    ll.remove(node);
                    return node.getValue();
                }
                node = node.getNext();
            }
        }
        return null;
    }

    public String retrieve(String key) {

        int index = hashMod(key);
        LinkedList ll = storage[index];

        if (ll != null) {
            ListNode node = ll.getHead();

            while (node != null) {
                if (node.getKey() == key) {
                    return node.getValue();
                }
                node = node.getNext();
            }
        }
        return null;
    }

    public void resize() {

        capacity *= 2;
        // create new storage
        LinkedList[] newStorage = new LinkedList[capacity];

        // copy over each node from previous storage
        for (int i = 0; i < storage.length; i++) {

            LinkedList ll = storage[i];
            if (ll != null) {
                ListNode node = ll.getHead();
                while (node != null) {
                    int newIndex = hashMod(node.getKey());

                    if (newStorage[newIndex] == null) {
                        newStorage[newIndex] = new LinkedList();
                    }

                    // add to new storage
                    newStorage[newIndex].addToHead(node);
                    node = node.getNext();
                }
            }
        }

    }
}
