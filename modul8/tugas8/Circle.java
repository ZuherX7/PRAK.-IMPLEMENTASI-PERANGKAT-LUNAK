package tugas8;

class Circle extends Shape {
    private float radius;
    private Point center;

    public Circle(float radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Menggambar Lingkaran dengan pusat di (" + center.getX() + ", " + center.getY() + ") dan radius " + radius);
    }

    @Override
    public void erase() {
        System.out.println("Menghapus Lingkaran");
    }

    @Override
    public void move() {
        System.out.println("Memindahkan Lingkaran ke posisi baru");
    }

    @Override
    public void resize() {
        System.out.println("Mengubah ukuran Lingkaran dengan radius baru");
    }
}
