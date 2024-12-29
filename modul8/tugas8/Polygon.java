package tugas8;

class Polygon extends Shape {
    private Point[] vertices;

    public Polygon(Point[] vertices) {
        this.vertices = vertices;
    }

    public Point[] getVertices() {
        return vertices;
    }

    public void setVertices(Point[] vertices) {
        this.vertices = vertices;
    }

    @Override
    public void draw() {
        System.out.println("Menggambar Poligon dengan titik-titik:");
        for (Point vertex : vertices) {
            System.out.println("(" + vertex.getX() + ", " + vertex.getY() + ")");
        }
    }

    @Override
    public void erase() {
        System.out.println("Menghapus Poligon");
    }

    @Override
    public void move() {
        System.out.println("Memindahkan Poligon ke posisi baru");
    }

    @Override
    public void resize() {
        System.out.println("Mengubah ukuran Poligon");
    }
}
