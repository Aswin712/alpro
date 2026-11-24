public class ShellSort {

    // Shell Sort Ascending (Menaik)
    public static void shellSortAscending(int[] arr) {
        int n = arr.length;
        int pass = 1;

        // Memulai dengan gap besar, lalu memperkecil gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap]; // memeriksa elemen yg berjarak gap.
                }
                arr[j] = temp;
            }

            // Visualisasi setiap fase gap
            System.out.print("Pass " + pass + " (Gap " + gap + "): ");
            printArray(arr);
            pass++;
        }
    }

    // Shell Sort Descending (Menurun)
    public static void shellSortDescending(int[] arr) {
        int n = arr.length;
        int pass = 1;

        // Memulai dengan gap besar, lalu memperkecil gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] < temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }

            // Visualisasi setiap fase gap
            System.out.print("Pass " + pass + " (Gap " + gap + "): ");
            printArray(arr);
            pass++;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}