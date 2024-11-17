package firstproject.modul4.Tugas;

import java.util.Scanner;

public class Kasir {
    public static void main(String[] args) {
        // Inisialisasi Model, View, dan Controller
        Produk produk = new Produk("GeForce GTX 1060Ti", 3000, 10);
        KasirView view = new KasirView();
        KasirController controller = new KasirController(produk, view);

        // Menampilkan info produk awal
        controller.showProductInfo();

        // Transaksi pembelian
        Scanner scanner = new Scanner(System.in);
        System.out.println("Transaksi Pembelian");
        System.out.print("Jumlah barang: ");
        int qty = scanner.nextInt();
        controller.processTransaction(qty);

        // Menampilkan info produk setelah transaksi
        controller.showProductInfo();
    }
}
