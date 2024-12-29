package tugas8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Sistem Manajemen Bentuk!");
        System.out.println("Pilih opsi:");
        System.out.println("1. Buat Lingkaran");
        System.out.println("2. Buat Persegi Panjang");
        System.out.println("3. Buat Poligon");
        System.out.println("4. Keluar");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Bersihkan buffer

        switch (choice) {
            case 1:
                System.out.println("Masukkan koordinat pusat (x y): ");
                double centerX = scanner.nextDouble();
                double centerY = scanner.nextDouble();

                System.out.println("Masukkan radius: ");
                float radius = scanner.nextFloat();

                Circle circle = new Circle(radius, new Point(centerX, centerY));
                System.out.println("Lingkaran dibuat!");
                System.out.println("Luas: " + circle.area());
                System.out.println("Keliling: " + circle.circumference());
                circle.draw();
                break;

            case 2:
                System.out.println("Masukkan koordinat pojok kiri atas (x y): ");
                double topLeftX = scanner.nextDouble();
                double topLeftY = scanner.nextDouble();

                System.out.println("Masukkan lebar dan tinggi: ");
                double width = scanner.nextDouble();
                double height = scanner.nextDouble();

                Rectangle rectangle = new Rectangle(new Point(topLeftX, topLeftY), width, height);
                System.out.println("Persegi Panjang dibuat!");
                rectangle.draw();
                break;

            case 3:
                System.out.println("Masukkan jumlah titik sudut: ");
                int numVertices = scanner.nextInt();

                Point[] vertices = new Point[numVertices];
                for (int i = 0; i < numVertices; i++) {
                    System.out.println("Masukkan koordinat untuk titik sudut " + (i + 1) + " (x y):");
                    double vertexX = scanner.nextDouble();
                    double vertexY = scanner.nextDouble();
                    vertices[i] = new Point(vertexX, vertexY);
                }

                Polygon polygon = new Polygon(vertices);
                System.out.println("Poligon dibuat!");
                polygon.draw();
                break;

            case 4:
                System.out.println("Keluar dari program. Selamat tinggal!");
                break;

            default:
                System.out.println("Pilihan tidak valid. Silakan mulai ulang program.");
                break;
        }

        scanner.close();
    }
}
