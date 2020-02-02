package g12;

/**
 * @Classname Solution1206
 * @Description 设计跳表
 * @Date 2019/12/16 16:25
 * @Created by SunCheng
 */
public class Solution1206 {
    class Skiplist {
        private final int MAX_LEVEL =16;
        private final double RATE = 0.5;

        private class Node{
            private int data = -1;
            private int maxLevel = 0;
            private Node[] forwards = new Node[MAX_LEVEL];
        }

        private int levelCount;
        private Node head;
        public Skiplist() {
            levelCount = 1;
            head = new Node();
        }

        public boolean search(int target) {
            return getNode(target)!=null;
        }

        public Node getNode(int target) {
            Node p = head;
            for (int i = levelCount - 1; i >= 0; i--) {
                while (p.forwards[i] != null && p.forwards[i].data < target) {
                    p = p.forwards[i];
                }
            }
            if (p.forwards[0] != null && p.forwards[0].data == target) {
                return p.forwards[0];
            }
            return null;
        }

        public void add(int num) {
            int level = randomLevel();
            Node newNode = new Node();
            newNode.data = num;
            newNode.maxLevel = level;
            Node[] update = new Node[level];
            for (int i = 0; i < level; i++) {
                update[i] = head;
            }
            Node p = head;
            for (int i = level - 1; i >= 0; i--) {
                while (p.forwards[i] != null && p.forwards[i].data < num) {
                    p = p.forwards[i];
                }
                update[i] = p;
            }
            for (int i = 0; i < level; i++) {
                newNode.forwards[i] = update[i].forwards[i];
                update[i].forwards[i] = newNode;
            }

            if (levelCount < level) {
                levelCount = level;
            }
        }

        public boolean erase(int num) {
            Node[] update = new Node[levelCount];
            Node p = head;
            for (int i = levelCount-1; i >=0 ; i--) {
                while (p.forwards[i] != null && p.forwards[i].data < num) {
                    p = p.forwards[i];
                }
                update[i] = p;
            }
            if (p.forwards[0] != null && p.forwards[0].data == num) {
                for (int i = levelCount - 1; i >= 0; i--) {
                    if (update[i].forwards[i] != null && update[i].forwards[i].data == num) {
                        update[i].forwards[i] = update[i].forwards[i].forwards[i];
                    }
                }
                while (levelCount > 1 && head.forwards[levelCount-1] == null) {
                    levelCount--;
                }
                return true;
            }
            return false;
        }
        private int randomLevel() {
            int level = 1;
            while (Math.random() < RATE && level < MAX_LEVEL) {
                level++;
            }
            return level;
        }
    }
}
