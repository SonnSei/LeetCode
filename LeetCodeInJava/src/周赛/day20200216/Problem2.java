package 周赛.day20200216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname Problem2
 * @Description
 * @Date 2020/2/16 10:18
 * @Author SonnSei
 */
public class Problem2 {
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);
        System.out.println(productOfNumbers.getProduct(1));
        productOfNumbers.add(0);
        productOfNumbers.add(2);
        productOfNumbers.add(5);
        productOfNumbers.add(4);
        System.out.println(productOfNumbers.getProduct(2));
        System.out.println(productOfNumbers.getProduct(3));
        System.out.println(productOfNumbers.getProduct(4));
        productOfNumbers.add(8);
        System.out.println(productOfNumbers.getProduct(2));
    }

    /**
     * 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
     *
     * 1. add(int num)
     *
     * 将数字 num 添加到当前数字列表的最后面。
     * 2. getProduct(int k)
     *
     * 返回当前数字列表中，最后 k 个数字的乘积。
     * 你可以假设当前列表中始终 至少 包含 k 个数字。
     * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
     */
    static class ProductOfNumbers {
        List<Integer> record;
        public ProductOfNumbers() {
            record  = new ArrayList<>();
            record.add(1);
        }

        public void add(int num) {
            if (num == 0) {
                record = new ArrayList<>();
                record.add(1);
            } else {
                record.add(record.get(record.size() - 1) * num);
            }
        }

        public int getProduct(int k) {
            if (k >= record.size()) {
                return 0;
            }
            return record.get(record.size() - 1) / record.get(record.size() - k-1 );
        }
    }
}
