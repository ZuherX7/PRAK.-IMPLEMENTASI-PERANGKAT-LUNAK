import java.util.ArrayList;
import java.util.List;

public class Katalog {
    private List<Kategori> kategoriList = new ArrayList<>();

    public void tambahKategori(Kategori kategori) {
        kategoriList.add(kategori);
    }

    public void showKatalog() {
        System.out.println("Katalog Toko");
        System.out.println("Kategori");
        for (Kategori kategori : kategoriList) {
            kategori.showItems();
        }
    }
}