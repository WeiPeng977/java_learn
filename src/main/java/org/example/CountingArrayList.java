package org.example;

import java.util.ArrayList;

public class CountingArrayList<E> extends ArrayList<E> {
    private int addCount = 0;  // 记录 add 方法被执行的次数

    @Override
    public boolean add(E e) {
        addCount++;  // 每次调用 add 方法时，计数器加一
        return super.add(e);
    }

    public int getAddCount() {
        return addCount;  // 返回 add 方法被执行的次数
    }
}