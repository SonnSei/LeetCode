package g0.p68文本左右对齐;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname Solution1
 * @Description TODO
 * @Date 2020/1/13 0:36
 * @Author SonnSei
 */
public class Solution1 {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        Stack<String> stack = new Stack<>();
        for (int i = words.length - 1; i >= 0; i--) {
            stack.push(words[i]);
        }

        List<String> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            int cnt =0;
            while (!stack.isEmpty() && cnt + stack.peek().length() + list.size() <= maxWidth) {
                cnt+=stack.peek().length();
                list.add(stack.pop());
            }
            int spaceCnt = maxWidth-cnt;
            StringBuilder tmp = new StringBuilder();
            if (list.size() == 1) {
                tmp.append(list.get(0));
                for (int i = 0; i < spaceCnt; i++) {
                    tmp.append(" ");
                }
                ret.add(tmp.toString());
            } else {
                int interval = spaceCnt/(list.size()-1);
                String s = "";
                for (int i = 0; i < interval; i++) {
                    s += " ";
                }
                int over = spaceCnt%((list.size()-1));

                for (int i = 0; i <list.size() ; i++) {
                    tmp.append(list.get(i));
                    tmp.append(s);
                    if (over > 0) {
                        tmp.append(" ");
                        over--;
                    }
                }
                ret.add(tmp.toString().trim());
            }

        }
        String last = ret.get(ret.size() - 1);
        String[] strings = last.split(" ");
        last = "";
        for (String item : strings) {
            if(item.trim().length()==0)continue;
            last += item;
            last += " ";
        }

        int diff = maxWidth - (last = last.trim()).length();
        for (int i = 0; i < diff; i++) {
            last += ' ';
        }
        ret.set(ret.size() - 1, last);
        return ret;
    }
}