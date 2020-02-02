package g4;

/**
 * @Classname Solution492
 * @Description TODO
 * @Date 2019/12/22 22:56
 * @Author Cheng
 */
public class Solution492 {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};
    }
}
