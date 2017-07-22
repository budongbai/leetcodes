package com.budongbai.offer;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> A, B;

    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        if (A.size() != B.size()) {
            if (A.size() != 0) {
                return A.peek();
            }
        } else if (B.size() != 0) {
            return (A.peek() + B.peek()) / 2.0;
        }
        return 0d;
    }
}
