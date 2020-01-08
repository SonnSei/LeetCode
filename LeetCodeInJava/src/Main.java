
import java.util.*;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/12/18 19:22
 * @Created by SunCheng
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        char[] chars = sc.nextLine().toCharArray();
        char[] directionL = {'N', 'W', 'S', 'E'};
        char[] directionr = {'N', 'E', 'S', 'W'};

        // L,R
        int[] turn = {0,0};
        for (char c :
                chars) {
            if (c == 'L')
                turn[0]++;
            else
                turn[1]++;
        }
        boolean L = true;
        if(turn[0]<turn[1])L = false;
        int index = Math.abs(turn[0]-turn[1])%4;
        if(L)
            System.out.println(directionL[index]);
        else
            System.out.println(directionr[index]);
    }
}
