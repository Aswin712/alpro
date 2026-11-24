public class SelectionSort {

    // Selection Sort Ascending
    public static void selectionSortAscending(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            // Cari nilai terkecil di bagian belum terurut
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Tukar elemen terkecil ke posisi i
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;

            System.out.print("Pass " + (i + 1) + ": ");
            printArray(arr);
        }
    }

    // Selection Sort Descending
    public static void selectionSortDescending(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;

            // Cari nilai terbesar di bagian belum terurut
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            // Tukar elemen terbesar ke posisi i
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            System.out.print("Pass " + (i + 1) + ": ");
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