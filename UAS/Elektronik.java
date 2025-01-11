import java.util.ArrayList;
import java.util.List;

public class Elektronik implements Kategori {
    private List<Item> items = new ArrayList<>();

    public Elektronik() {
        // Menambahkan item elektronik
        items.add(new Item("Komputer i7", 1000));
        items.add(new Item("TV Samsung 32 inch", 1500));
    }

    @Override
    public void showItems() {
        System.out.println("1. Kategori Elektronik");
        int i = 1;
        for (Item item : items) {
            item.showDetails(i++);
        }
        System.out.println();
    }
}