import java.util.Random;
import java.util.Scanner;

public class Main {

    // ===== TAMBAHAN: dataset username untuk demo Binary Search =====
    private static final String[] USERNAMES = {
        "Salma", "Abel", "bahlil", "mr_beast", "Lucia6", "pakcik",
        "n_pigai", "jensen_huang", "huss_huss_huss", "pra_bowo", "lenovo",
        "sama_sama", "indra_k", "joko_w", "kirain_d", "lukman_h",
        "mega_wati", "alice_Huang", "tokiro_n", "oppo", "vivo"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dataset Modul 2: 100 Data Pengikut Influencer (Top 100 Influencer)
        int[] originalFollowers = generateFollowerData(100);

        while (true) {
            System.out.println("\n===== Z-App: Top 100 Influencer Ranking Engine =====");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Shell Sort");
            System.out.println("5. Merge Sort");
            System.out.println("6. Quick Sort");
            System.out.println("7. Binary Search");               // TAMBAHAN
            System.out.println("8. Interpolation Search");       // TAMBAHAN
            System.out.println("0. Keluar");
            System.out.print("Pilih algoritma pengurutan: ");                   
            int algo = scanner.nextInt();

            if (algo == 0) {
                System.out.println("Terima kasih. Program selesai.");
                break;
            }

            if (algo < 1 || algo > 8) {                          // UBAH: dulu > 6
                System.out.println("Pilihan menu tidak valid.");
                continue;
            }

            // ===== TAMBAHAN: routing ke fitur pencarian =====
            if (algo == 7) {
                jalankanMenuBinarySearch(scanner);
                continue;
            }
            if (algo == 8) {
                cariHargaInterpolation(scanner);
                continue;
            }
            // ================================================

            System.out.println("\n--- Pilih Urutan ---");
            System.out.println("1. Ascending (Menaik)");
            System.out.println("2. Descending (Menurun)");
            System.out.print("Pilih urutan: ");
            int order = scanner.nextInt();

            if (order != 1 && order != 2) {
                System.out.println("Pilihan urutan tidak valid.");
                continue;
            }

            // Salin array agar data master asli tidak berubah
            int[] data = originalFollowers.clone();

            System.out.println("\n==============================================");
            System.out.print("Array Asli (100 Data Followers Influencer):\n");
            printArray(data);
            System.out.println("==============================================");

            switch (algo) {
                case 1:
                    if (order == 1) {
                        System.out.println("\n--- Proses Bubble Sort Ascending ---");
                        BubbleSort.bubbleSortAscending(data);
                    } else {
                        System.out.println("\n--- Proses Bubble Sort Descending ---");
                        BubbleSort.bubbleSortDescending(data);
                    }
                    break;

                case 2:
                    if (order == 1) {
                        System.out.println("\n--- Proses Selection Sort Ascending ---");
                        SelectionSort.selectionSortAscending(data);
                    } else {
                        System.out.println("\n--- Proses Selection Sort Descending ---");
                        SelectionSort.selectionSortDescending(data);
                    }
                    break;

                case 3:
                    if (order == 1) {
                        System.out.println("\n--- Proses Insertion Sort Ascending ---");
                        InsertionSort.insertionSortAscending(data);
                    } else {
                        System.out.println("\n--- Proses Insertion Sort Descending ---");
                        InsertionSort.insertionSortDescending(data);
                    }
                    break;

                case 4:
                    if (order == 1) {
                        System.out.println("\n--- Proses Shell Sort Ascending ---");
                        ShellSort.shellSortAscending(data);
                    } else {
                        System.out.println("\n--- Proses Shell Sort Descending ---");
                        ShellSort.shellSortDescending(data);
                    }
                    break;

                case 5:
                    if (order == 1) {
                        System.out.println("\n--- Proses Merge Sort Ascending ---");
                        MergeSort.mergeSortAscending(data);
                    } else {
                        System.out.println("\n--- Proses Merge Sort Descending ---");
                        MergeSort.mergeSortDescending(data);
                    }
                    break;

                case 6:
                    if (order == 1) {
                        System.out.println("\n--- Proses Quick Sort Ascending ---");
                        QuickSort.quickSortAscending(data);
                    } else {
                        System.out.println("\n--- Proses Quick Sort Descending ---");
                        QuickSort.quickSortDescending(data);
                    }
                    break;
            }

            System.out.println("==============================================");
            System.out.print("Hasil Akhir yang Terurut:\n");
            printArray(data);
            System.out.println("==============================================");
        }

        scanner.close();
    }

    // ===== TAMBAHAN: sub-menu Binary Search =====
    private static void jalankanMenuBinarySearch(Scanner scanner) {
        while (true) {
            System.out.println("\n===== BINARY SEARCH =====");
            System.out.println("1. Cari Nama Pengguna");
            System.out.println("2. Cari Harga Produk");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih: ");
            int pilih = scanner.nextInt();
            scanner.nextLine(); // buang newline agar nextLine() berikutnya bersih

            if (pilih == 0) {
                return;
            }

            switch (pilih) {
                case 1:
                    cariUsernameBinary(scanner);
                    break;
                case 2:
                    cariHargaBinary(scanner);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    // ===== TAMBAHAN: Binary Search — Username =====
    private static void cariUsernameBinary(Scanner scanner) {
        System.out.println("\n=== Binary Search — Cari Nama Pengguna ===");
        System.out.println("Dataset Username Z-App (20 entri, terurut alfabetis):");
        for (int i = 0; i < USERNAMES.length; i++) {
            System.out.printf("%2d. %s%n", i, USERNAMES[i]);
        }
        System.out.print("\nMasukkan username yang dicari: ");
        String target = scanner.nextLine().trim();

        int idx = BinarySearch.binarySearchUsername(USERNAMES, target);

        System.out.println("\n===== HASIL AKHIR =====");
        if (idx != -1) {
            System.out.println("Status    : DITEMUKAN");
            System.out.println("Indeks    : " + idx);
            System.out.println("Username  : " + USERNAMES[idx]);
        } else {
            System.out.println("Status    : TIDAK DITEMUKAN");
            System.out.println("Username \"" + target + "\" tidak ada dalam basis data Z-App.");
        }
    }

    // ===== TAMBAHAN: Binary Search — Harga =====
    private static void cariHargaBinary(Scanner scanner) {
        int[] prices = generatePriceData(50);

        System.out.println("\n=== Binary Search — Cari Harga Produk ===");
        System.out.println("Dataset Harga Toko Z-App (50 entri, terurut & berjarak merata):");
        printArray(prices);

        System.out.print("\nMasukkan harga yang dicari: ");
        int target = scanner.nextInt();

        int idx = BinarySearch.binarySearchHarga(prices, target);

        System.out.println("\n===== HASIL AKHIR =====");
        if (idx != -1) {
            System.out.println("Status : DITEMUKAN");
            System.out.println("Indeks : " + idx);
            System.out.println("Harga  : Rp " + prices[idx]);
        } else {
            System.out.println("Status : TIDAK DITEMUKAN");
            System.out.println("Harga Rp " + target + " tidak ada di toko Z-App.");
        }
    }

    // ===== TAMBAHAN: Interpolation Search — Harga =====
    private static void cariHargaInterpolation(Scanner scanner) {
        int[] prices = generatePriceData(50);

        System.out.println("\n=== Interpolation Search — Cari Harga Produk ===");
        System.out.println("Dataset Harga Toko Z-App (50 entri, terurut & berjarak merata):");
        printArray(prices);

        System.out.print("\nMasukkan harga yang dicari: ");
        int target = scanner.nextInt();

        int idx = InterpolationSearch.interpolationSearchHarga(prices, target);

        System.out.println("\n===== HASIL AKHIR =====");
        if (idx != -1) {
            System.out.println("Status : DITEMUKAN");
            System.out.println("Indeks : " + idx);
            System.out.println("Harga  : Rp " + prices[idx]);
        } else {
            System.out.println("Status : TIDAK DITEMUKAN");
            System.out.println("Harga Rp " + target + " tidak ada di toko Z-App.");
        }
    }

    // ===== TAMBAHAN: generator 50 harga berjarak merata =====
    private static int[] generatePriceData(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (i + 1) * 10000;
        }
        return arr;
    }

    // ===== TIDAK BERUBAH dari Modul 2 =====
    private static int[] generateFollowerData(int size) {
        Random rand = new Random(42); // Fixed seed agar data konsisten setiap kali program dijalankan
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + rand.nextInt(99000); // Jumlah follower berkisar 1.000 - 100.000
        }
        return arr;
    }

    // ===== TIDAK BERUBAH dari Modul 2 =====
    public static void printArray(int[] arr) {
        for (int num : arr) { //enchanced for loop
            System.out.print(num + " ");
        }
        System.out.println();
    }
}