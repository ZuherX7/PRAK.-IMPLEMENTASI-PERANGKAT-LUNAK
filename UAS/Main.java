public class Main {
    public static void main(String[] args) {
        Katalog katalog = new Katalog();
        
        katalog.tambahKategori(new Elektronik());
        katalog.tambahKategori(new Fashion());
        katalog.tambahKategori(new Food());
        katalog.tambahKategori(new Household());
        
        katalog.showKatalog();
    }
}