package holdingObjects.array;

import java.util.Arrays;

import static jdk.nashorn.internal.objects.Global.print;

public class ArrayCopy {

    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];

        Arrays.fill(i,47);
        Arrays.fill(j,99);

        print("i = "+Arrays.toString(i));
    }
}



