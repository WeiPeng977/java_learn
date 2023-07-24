package org.example.algorithm;

class HashEntry {
    int key;
    int value;

    HashEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LinearProbingHashTable {
    private int size;
    private int capacity;
    private HashEntry[] table;

    public LinearProbingHashTable(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.table = new HashEntry[capacity];
    }

    // 哈希函数
    private int hash(int key) {
        return key % capacity;
    }

    // 插入键值对
    public void insert(int key, int value) {
        if (size == capacity) {
            System.out.println("哈希表已满，无法插入新的键值对！");
            return;
        }

        int index = hash(key);
        while (table[index] != null) {
            // 线性探测找到下一个可用槽位
            index = (index + 1) % capacity;
        }

        table[index] = new HashEntry(key, value);
        size++;
    }

    // 查找键对应的值
    public Integer search(int key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key == key) {
                return table[index].value;
            }
            // 继续探测下一个槽位
            index = (index + 1) % capacity;
        }

        return null; // 未找到键对应的值
    }

    // 删除键值对
    public void delete(int key) {
        int index = hash(key);
        while (table[index] != null) {
            if (table[index].key == key) {
                table[index] = null;
                size--;
                return;
            }
            // 继续探测下一个槽位
            index = (index + 1) % capacity;
        }
    }

    public static void main(String[] args) {
        LinearProbingHashTable hashTable = new LinearProbingHashTable(10);

        hashTable.insert(2, 20);
        hashTable.insert(3, 30);
        hashTable.insert(12, 120);
        hashTable.insert(22, 220);

        System.out.println("Key 3对应的值：" + hashTable.search(3)); // 输出：Key 3对应的值：30

        hashTable.delete(3);
        System.out.println("Key 3对应的值：" + hashTable.search(3)); // 输出：Key 3对应的值：null
    }
}
