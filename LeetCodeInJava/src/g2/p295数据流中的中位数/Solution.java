package g2.p295数据流中的中位数;

import java.util.PriorityQueue;

/**
 * @Classname Solution
 * @Description
 * @Date 2020/2/13 17:12
 * @Author SonnSei
 */
public class Solution {
    class MedianFinder {
        int size;
        PriorityQueue<Integer> rightHeap;
        PriorityQueue<Integer> leftHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            size = 0;
            rightHeap = new PriorityQueue<>();
            leftHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }

        public void addNum(int num) {
            size++;
            if ((size & 1) == 1) {
                rightHeap.add(num);
                leftHeap.add(rightHeap.poll());
            } else {
                leftHeap.add(num);
                rightHeap.add(leftHeap.poll());
            }
        }

        public double findMedian() {
            if ((size & 1) == 1)
                return leftHeap.peek();
            return (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }
    }
}
