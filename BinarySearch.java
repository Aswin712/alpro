public class BinarySearch {

    // ============ BINARY SEARCH UNTUK USERNAME (String) ============
    public static int binarySearchUsername(String[] data, String target) {
        int low = 0;
        int high = data.length - 1;
        int comparisons = 0;
        int step = 1;

        System.out.println("\n=== PROSES BINARY SEARCH (Username) ===");
        System.out.println("Target: \"" + target + "\"");
        System.out.println("--------------------------------------------------");

        while (low <= high) {
            int mid = low + (high - low) / 2;
            comparisons++;

            System.out.println("Langkah " + step + ":");
            System.out.println("  Low   = " + low);
            System.out.println("  High  = " + high);
            System.out.println("  Mid   = " + mid);
            System.out.println("  Bandingkan data[" + mid + "] = \"" + data[mid]
                    + "\" dengan target \"" + target + "\"");

            int cmp = data[mid].compareToIgnoreCase(target);

            if (cmp == 0) {
                System.out.println("  >> COCOK! Ditemukan pada indeks " + mid);
                System.out.println("--------------------------------------------------");
                System.out.println("Total perbandingan: " + comparisons);
                return mid;
            } else if (cmp < 0) {
                System.out.println("  >> data[" + mid + "] < target, geser Low ke " + (mid + 1));
                low = mid + 1;
            } else {
                System.out.println("  >> data[" + mid + "] > target, geser High ke " + (mid - 1));
                high = mid - 1;
            }
            System.out.println();
            step++;
        }

        System.out.println(">> TIDAK DITEMUKAN. Ruang pencarian habis (low > high).");
        System.out.println("--------------------------------------------------");
        System.out.println("Total perbandingan: " + comparisons);
        return -1;
    }

    // ============ BINARY SEARCH UNTUK HARGA (numerik) ============
    public static int binarySearchHarga(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        int comparisons = 0;
        int step = 1;

        System.out.println("\n=== PROSES BINARY SEARCH (Harga) ===");
        System.out.println("Target: " + target);
        System.out.println("--------------------------------------------------");

        while (low <= high) {
            int mid = low + (high - low) / 2;
            comparisons++;

            System.out.println("Langkah " + step + ":");
            System.out.println("  Low   = " + low);
            System.out.println("  High  = " + high);
            System.out.println("  Mid   = " + mid);
            System.out.println("  Bandingkan data[" + mid + "] = " + data[mid]
                    + " dengan target " + target);

            if (data[mid] == target) {
                System.out.println("  >> COCOK! Ditemukan pada indeks " + mid);
                System.out.println("--------------------------------------------------");
                System.out.println("Total perbandingan: " + comparisons);
                return mid;
            } else if (data[mid] < target) {
                System.out.println("  >> data[" + mid + "] < target, geser Low ke " + (mid + 1));
                low = mid + 1;
            } else {
                System.out.println("  >> data[" + mid + "] > target, geser High ke " + (mid - 1));
                high = mid - 1;
            }
            System.out.println();
            step++;
        }

        System.out.println(">> TIDAK DITEMUKAN. Ruang pencarian habis (low > high).");
        System.out.println("--------------------------------------------------");
        System.out.println("Total perbandingan: " + comparisons);
        return -1;
    }
}