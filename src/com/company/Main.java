package com.company;

public class Main {

    public static void main(String[] args) {

        HashTable hashtable = new HashTable(5);

        // insert to max capacity
        hashtable.insert("key-01", "value-01");
        hashtable.insert("key-02", "value-02");
        hashtable.insert("key-03", "value-03");
        hashtable.insert("key-04", "value-04");
        hashtable.insert("key-05", "value-05");

        // should return value-02
        System.out.println(hashtable.retrieve("key02"));

        // should return 5
        System.out.println(hashtable.getCapacity());
        // TODO: insert to cause resize

        // cause resize
        hashtable.resize();
        // should return 10
        System.out.println(hashtable.getCapacity());

        // should return value-02
        System.out.println(hashtable.retrieve("key-02"));

        // removes node at key-03
        hashtable.remove("key-03");

        // should return null
        System.out.println(hashtable.retrieve("key-03"));
    }
}
