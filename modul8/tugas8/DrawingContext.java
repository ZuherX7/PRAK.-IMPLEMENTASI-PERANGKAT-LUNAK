package tugas8;

class DrawingContext {
    public void setPoint(Point point) {
        System.out.println("Menetapkan titik di (" + point.getX() + ", " + point.getY() + ")");
    }

    public void clearScreen() {
        System.out.println("Membersihkan layar");
    }

    public int getVerticalSize() {
        return 1080; // Ukuran contoh
    }

    public int getHorizontalSize() {
        return 1920; // Ukuran contoh
    }
}
