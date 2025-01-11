import java.util.ArrayList;
import java.util.List;

public class Food implements Kategori {
    private List<Item> items = new ArrayList<>();

    public Food() {
        // Menambahkan item makanan
        items.add(new Item("Pizza Italia", 500, "Varian : Pan Pizza"));
        items.add(new Item("Steak Wagyu A6", 300, "Varian : Well Done"));
    }

    @Override
    public void showItems() {
        System.out.println("3. Kategori Makanan");
        int i = 1;
        for (Item item : items) {
            item.showDetails(i++);
        }
        System.out.println();
    }
}