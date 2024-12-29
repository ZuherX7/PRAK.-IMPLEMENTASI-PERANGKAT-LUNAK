package tugas8;

class Rectangle extends Shape {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Menggambar Persegi Panjang dengan sudut kiri atas di (" + topLeft.getX() + ", " + topLeft.getY() + "), lebar " + width + " dan tinggi " + height);
    }

    @Override
    public void erase() {
        System.out.println("Menghapus Persegi Panjang");
    }

    @Override
    public void move() {
        System.out.println("Memindahkan Persegi Panjang ke posisi baru");
    }

    @Override
    public void resize() {
        System.out.println("Mengubah ukuran Persegi Panjang dengan dimensi baru");
    }
}
