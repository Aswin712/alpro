public class InsertionSort {

    // Insertion Sort Ascending (Menaik)
    public static void insertionSortAscending(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Geser elemen yang lebih besar dari key ke kanan
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

            // Visualisasi setiap iterasi/pass
            System.out.print("Pass " + i + ": ");
            printArray(arr);
        }
    }

    // Insertion Sort Descending (Menurun)
    public static void insertionSortDescending(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Geser elemen yang lebih kecil dari key ke kanan
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

            // Visualisasi setiap iterasi/pass
            System.out.print("Pass " + i + ": ");
            printArray(arr);
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}