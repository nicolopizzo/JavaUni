import java.util.ArrayList;

public class ArrayListExercises {
    public static void selezionaPari(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++)
            if (arr.get(i)%2 == 1)
                arr.remove(i);
    }

    public static void eliminaDuplicati(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++)
            if (arr.indexOf(arr.get(i)) != i)
                arr.remove(i--);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(14);
        arr.add(14);
        arr.add(0);
        arr.add(21);
        arr.add(0);
        arr.add(21);
        arr.add(3);

        eliminaDuplicati(arr);

        System.out.println(arr);
    }
}