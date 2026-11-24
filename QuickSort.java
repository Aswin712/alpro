public class QuickSort {

    public static void quickSortAscending(int[] arr) {
        run(arr, true);
    }

    public static void quickSortDescending(int[] arr) {
        run(arr, false);
    }

    private static void run(int[] arr, boolean ascending) {
        if (arr.length == 0) return;
        System.out.println("Keterangan: pivot = elemen terakhir partisi, (x) = pivot setelah menetap "
                + "di posisi akhirnya (indentasi = kedalaman rekursi)");
        quickSort(arr, 0, arr.length - 1, 0, ascending);
    }

    private static void quickSort(int[] arr, int low, int high, int depth, boolean ascending) {
        // Base case: berhenti jika partisi kosong atau 1 elemen (low >= high)
        if (low < high) {
            String indent = "  ".repeat(depth);
            int pivot = arr[high];

            System.out.println(indent + "[PARTISI] indeks " + low + ".." + high
                    + " | pivot=" + pivot + " | " + sub(arr, low, high, -1));

            int pivotIndex = partition(arr, low, high, ascending);

            System.out.println(indent + "   hasil : " + sub(arr, low, high, pivotIndex));
            System.out.println(indent + "   pivot " + pivot + " menetap di indeks " + pivotIndex
                    + " | kiri: " + (pivotIndex - low) + " elemen, kanan: "
                    + (high - pivotIndex) + " elemen");

            quickSort(arr, low, pivotIndex - 1, depth + 1, ascending);
            quickSort(arr, pivotIndex + 1, high, depth + 1, ascending);
        }
    }

    private static int partition(int[] arr, int low, int high, boolean ascending) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // asc: elemen < pivot ke kiri | desc: elemen > pivot ke kiri
            boolean keKiri = ascending ? arr[j] < pivot : arr[j] > pivot;
            if (keKiri) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private static String sub(int[] arr, int from, int to, int pivotIdx) {
        StringBuilder sb = new StringBuilder("[");
        for (int k = from; k <= to; k++) {
            if (k > from) sb.append(" ");
            if (k == pivotIdx) sb.append("(").append(arr[k]).append(")");
            else sb.append(arr[k]);
        }
        return sb.append("]").toString();
    }
} 
    
