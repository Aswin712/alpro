public class InterpolationSearch {

    public static int interpolationSearchHarga(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;
        int comparisons = 0;
        int step = 1;

        System.out.println("\n=== PROSES INTERPOLATION SEARCH (Harga) ===");
        System.out.println("Target: " + target);
        System.out.println("--------------------------------------------------");

        while (low <= high && target >= data[low] && target <= data[high]) {

            // Guard agar tidak terjadi pembagian dengan nol
            if (data[high] == data[low]) {
                comparisons++;
                if (data[low] == target) {
                    System.out.println("Langkah " + step + ": data[low] == data[high], cek langsung");
                    System.out.println("  >> COCOK! Ditemukan pada indeks " + low);
                    System.out.println("--------------------------------------------------");
                    System.out.println("Total perbandingan: " + comparisons);
                    return low;
                }
                break;
            }

            // Rumus interpolasi: pos = low + ((x - a[low]) * (high - low)) / (a[high] - a[low])
            long numerator = (long) (target - data[low]) * (high - low);
            int pos = low + (int) (numerator / (data[high] - data[low]));

            // Pastikan pos tetap dalam rentang
            if (pos < low) pos = low;
            if (pos > high) pos = high;

            comparisons++;

            System.out.println("Langkah " + step + ":");
            System.out.println("  Low = " + low + ", High = " + high);
            System.out.println("  Rumus: pos = " + low + " + ((" + target + " - " + data[low]
                    + ") * (" + high + " - " + low + ")) / (" + data[high] + " - " + data[low] + ")");
            System.out.println("  Posisi perkiraan (pos) = " + pos);
            System.out.println("  Bandingkan data[" + pos + "] = " + data[pos]
                    + " dengan target " + target);

            if (data[pos] == target) {
                System.out.println("  >> COCOK! Ditemukan pada indeks " + pos);
                System.out.println("--------------------------------------------------");
                System.out.println("Total perbandingan: " + comparisons);
                return pos;
            } else if (data[pos] < target) {
                System.out.println("  >> data[" + pos + "] < target, geser Low ke " + (pos + 1));
                low = pos + 1;
            } else {
                System.out.println("  >> data[" + pos + "] > target, geser High ke " + (pos - 1));
                high = pos - 1;
            }
            System.out.println();
            step++;
        }

        System.out.println(">> TIDAK DITEMUKAN.");
        System.out.println("--------------------------------------------------");
        System.out.println("Total perbandingan: " + comparisons);
        return -1;
    }
}