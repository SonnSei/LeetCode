package p303区域和检索数组不可变;

import org.omg.CORBA.Object;

/**
 * @Classname SegmentTree
 * @Description
 * @Date 2020/1/14 23:41
 * @Author SonnSei
 */
public class SegmentTree<E> {
    private interface Merger<E> {
        E merge(E l, E r);
    }

    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = (left + right) >>> 1;
        buildSegmentTree(leftTreeIndex, left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    private int rightChild(int index) {
        return (index << 1) + 2;
    }

    private int leftChild(int index) {
        return (index << 1) + 1;
    }


    public E query(int queryL, int qureyR) {
        return query(0, 0, data.length - 1, queryL, qureyR);
    }

    private E query(int treeIndex, int left, int right, int queryL, int qureyR) {
        if (left == queryL && right == qureyR) return tree[treeIndex];
        int mid = (left + right) >>> 1;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(queryL>=mid+1)
            return query(rightTreeIndex, mid + 1, right, queryL, qureyR);
        if(qureyR<=mid)
            return query(leftTreeIndex, left, mid, queryL, qureyR);
        E leftResult = query(leftTreeIndex, left, mid, queryL, qureyR);
        E rightResult = query(rightTreeIndex, mid + 1, right, queryL, qureyR);
        return merger.merge(leftResult, rightResult);
    }
}
