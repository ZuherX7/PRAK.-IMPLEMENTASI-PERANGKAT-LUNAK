import java.util.ArrayList;
import java.util.List;

public class Fashion implements Kategori {
    private List<Item> items = new ArrayList<>();

    public Fashion() {
        // Menambahkan item fashion
        items.add(new Item("Kemeja", 100, "Warna Baju : Merah"));
        items.add(new Item("Jeans", 200, "Warna Baju : Biru"));
    }

    @Override
    public void showItems() {
        System.out.println("2. Kategori Fashion");
        int i = 1;
        for (Item item : items) {
            item.showDetails(i++);
        }
        System.out.println();
    }
}