import java.awt.*;
import javax.swing.*;

public class KelasPengguna extends JPanel {
    // Atribut untuk username dan password
    protected String username; 
    protected String password;

    // Metode untuk menyimpan username dan password
    public void penyimpanan(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println("Data tersimpan!");
    }

    // Override metode paint untuk menggambar UI
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Gambar persegi panjang
        g2.setColor(new Color(80, 204, 55)); // Warna hijau
        g2.fillRect(100, 0, 200, 400);

        // Gambar lingkaran dinamis
        int numCircles = 6;
        for (int i = numCircles; i > 1; i--) {
            int radius = i * 7;
            int mouseX = MouseInfo.getPointerInfo().getLocation().x - getLocationOnScreen().x;
            int mouseY = MouseInfo.getPointerInfo().getLocation().y - getLocationOnScreen().y;

            if (mouseX > 100 && mouseX < 300) {
                g2.setColor(Color.WHITE); // Lingkaran putih saat kursor dalam area
            } else {
                g2.setColor(new Color(80, 204, 55)); // Lingkaran hijau default
            }
            g2.fillOval(mouseX - radius / 2, mouseY - radius / 2, radius, radius);
        }
    }

    // Main method untuk menjalankan program
    public static void main(String[] args) {
        // Membuat frame untuk menampilkan UI
        JFrame frame = new JFrame("Kelas Pengguna UI");
        KelasPengguna panel = new KelasPengguna();

        // Pengaturan frame
        frame.add(panel);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Contoh penyimpanan data
        panel.penyimpanan("user123", "password123");
    }
}
