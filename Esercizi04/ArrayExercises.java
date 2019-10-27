import java.util.Arrays;

public class ArrayExercises {
    public static void stampaArray(int[] arr) {
        System.out.print("[");

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + (i == arr.length-1 ? "" : ", "));

        System.out.println("]");
    }

    public static double mediaValori(int[] arr) {
        double sum = 0;

        for (int i : arr)
            sum += i;

        return sum/arr.length;
    }

    public static int[] selezionaPari(int[] arr) {
        int l = 0;

        for (int i : arr)
            if (i%2 == 0)
                l++;


        int[] tmp = new int[l];
        for (int i = 0, j = 0; j < l; i++)
            if(arr[i]%2 == 0)
                tmp[j++] = arr[i];

        return tmp;
    }

    public static int[] eliminaDuplicati(int[] arr) {
        int l = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j])
                    break;
                if (j == i-1)
                    l++;
            }
        }

        int[] res = new int[l];
        res[0] = arr[0];
        for (int i = 1, k = 1; k < l; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j])
                    break;
                if (j == i-1)
                    res[k++] = arr[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 14, 14, 0, 21, 0, 21, 3, 7, 7, 0, 3, 4, 2, 3};
        stampaArray(eliminaDuplicati(arr));
    }
}