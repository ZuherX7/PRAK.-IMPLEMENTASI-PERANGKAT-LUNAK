import java.util.ArrayList;
import java.util.List;

public class Household implements Kategori {
    private List<Item> items = new ArrayList<>();

    public Household() {
        items.add(new Item("Lemari Kayu", 3500, "Varian : Kayu Jati"));
    }

    @Override
    public void showItems() {
        System.out.println("4. Kategori HouseHold");
        int i = 1;
        for (Item item : items) {
            item.showDetails(i++);
        }
        System.out.println();
    }
}