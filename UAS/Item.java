// Class Item untuk menyimpan detail produk
public class Item {
    private String name;
    private int price;
    private String additionalInfo;

    // Constructor untuk item tanpa tambahan informasi
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
        this.additionalInfo = "";
    }

    // Constructor untuk item dengan tambahan informasi (warna atau varian)
    public Item(String name, int price, String additionalInfo) {
        this.name = name;
        this.price = price;
        this.additionalInfo = additionalInfo;
    }

    // Method untuk menampilkan informasi item
    public void showDetails(int itemNumber) {
        System.out.println("Item " + itemNumber + " : " + name);
        if (!additionalInfo.isEmpty()) {
            System.out.println(additionalInfo);
        }
        System.out.println("harga : " + price);
    }
}