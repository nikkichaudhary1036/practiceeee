import java.util.*;

public class SortByFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int freqA = freq.get(arr[i]);
                int freqB = freq.get(arr[j]);

                if (freqA < freqB) {
                    swap(arr, i, j);
                } else if (freqA == freqB && arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }

        System.out.println("Sorted by frequency:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
