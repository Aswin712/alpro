public class MergeSort {

    public static void mergeSortAscending(int[] arr) {
        run(arr, true);
    }

    public static void mergeSortDescending(int[] arr) {
        run(arr, false);
    }

    private static void run(int[] arr, boolean ascending) {
        if (arr.length == 0) return;
        System.out.println("Keterangan: [DIVIDE] = membagi array, [MERGE] = menggabungkan "
                + "(indentasi = kedalaman rekursi)");
        mergeSort(arr, 0, arr.length - 1, 0, ascending);
    }

    private static void mergeSort(int[] arr, int left, int right, int depth, boolean ascending) {
        // Base case: berhenti jika sub-array hanya 1 elemen (left == right)
        if (left < right) {
            int mid = left + (right - left) / 2;
            String indent = "  ".repeat(depth);

            System.out.println(indent + "[DIVIDE] " + sub(arr, left, right) + " -> "
                    + sub(arr, left, mid) + " | " + sub(arr, mid + 1, right));

            mergeSort(arr, left, mid, depth + 1, ascending);
            mergeSort(arr, mid + 1, right, depth + 1, ascending);

            String kiri = sub(arr, left, mid);
            String kanan = sub(arr, mid + 1, right);
            merge(arr, left, mid, right, ascending);

            System.out.println(indent + "[MERGE]  " + kiri + " + " + kanan + " -> "
                    + sub(arr, left, right));
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, boolean ascending) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++) rightArray[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            // <= (asc) dan >= (desc) menjaga kestabilan urutan
            boolean ambilKiri = ascending ? leftArray[i] <= rightArray[j]
                    : leftArray[i] >= rightArray[j];
            if (ambilKiri) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static String sub(int[] arr, int from, int to) {
        StringBuilder sb = new StringBuilder("[");
        for (int k = from; k <= to; k++) {
            if (k > from) sb.append(" ");
            sb.append(arr[k]);
        }
        return sb.append("]").toString();
    }
}