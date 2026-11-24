public class BubbleSort {

    // Bubble Sort Ascending
    public static void bubbleSortAscending(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                // Ascending: jika kiri > kanan, tukar
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.print("Pass " + (i + 1) + ": ");
            printArray(arr);

            if (!swapped) { //loop dalam selesai dan swaappedd masih false
                System.out.println("Tidak ada pertukaran, data sudah terurut.");
                break;
            }
        }
    }

    // Bubble Sort Descending
    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                // Descending: jika kiri < kanan, tukar
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.print("Pass " + (i + 1) + ": ");
            printArray(arr);

            if (!swapped) {
                System.out.println("Tidak ada pertukaran, data sudah terurut.");
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
