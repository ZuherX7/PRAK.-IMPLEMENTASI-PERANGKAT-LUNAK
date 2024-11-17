package firstproject.modul4.Tugas;

public class KasirView {
    public void displayProductInfo(String name, int price, int stock) {
        System.out.println("Nama Barang : " + name);
        System.out.println("Harga Barang : " + price);
        System.out.println("Stok Barang : " + stock);
    }

    public void displayTransactionResult(int totalPrice) {
        System.out.println("\nJumlah Bayar : " + totalPrice);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
