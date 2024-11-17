package firstproject.modul4.Tugas;

public class KasirController {
    private Produk produk;
    private KasirView view;

    public KasirController(Produk produk, KasirView view) {
        this.produk = produk;
        this.view = view;
    }

    public void showProductInfo() {
        view.displayProductInfo(produk.getName(), produk.getPrice(), produk.getStock());
    }

    public void processTransaction(int qty) {
        if (qty > produk.getStock()) {
            view.displayMessage("Stok tidak mencukupi!");
        } else {
            int totalPrice = qty * produk.getPrice();
            produk.setStock(produk.getStock() - qty);
            view.displayTransactionResult(totalPrice);
        }
    }
}
