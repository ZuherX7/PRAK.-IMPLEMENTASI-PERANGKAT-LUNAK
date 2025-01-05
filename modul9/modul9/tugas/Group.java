package modul9.tugas;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Group {

    // Mengembalikan daftar pengguna yang diurutkan berdasarkan pendaftaran terbaru
    public List<User> getUsersSortedByMostRecentlyRegistered() {
        List<User> users = new ArrayList<>();
        
        if (!userDirectoryExists()) {
            return users; // Jika direktori pengguna tidak ada, kembalikan daftar kosong
        }
        
        addFoundUsersTo(users);
        sortByMostRecentlyRegistered(users);
        
        return users;
    }

    // Memeriksa apakah direktori pengguna ada
    private boolean userDirectoryExists() {
        File directory = new File(persistencePath());
        return directory.exists() && directory.isDirectory();
    }

    // Menambahkan pengguna yang ditemukan ke dalam daftar
    private void addFoundUsersTo(List<User> users) {
        File[] files = new File(persistencePath()).listFiles();
        if (files != null) { // Cegah NullPointerException jika listFiles() mengembalikan null
            for (File file : files) {
                if (file.isDirectory()) {
                    // Simulasi pembuatan pengguna dengan nama file sebagai nama pengguna
                    // dan timestamp pendaftaran yang dihasilkan secara acak
                    long simulatedTimestamp = System.currentTimeMillis() - (long) (Math.random() * 1_000_000_000L);
                    users.add(new User(file.getName(), simulatedTimestamp));
                }
            }
        }
    }

    // Mengurutkan daftar pengguna berdasarkan pendaftaran terbaru
    private void sortByMostRecentlyRegistered(List<User> users) {
        Collections.sort(users, new User.UserComparatorByDescendingRegistration());
    }

    // Mendapatkan path direktori untuk data persistensi
    private String persistencePath() {
        // Ganti dengan path direktori yang sesuai
        return "path/to/user/directory";
    }
}

// Kelas User dan Comparator untuk pengguna
class User {
    private String name;
    private long registrationTimestamp;

    public User(String name, long registrationTimestamp) {
        this.name = name;
        this.registrationTimestamp = registrationTimestamp;
    }

    public String getName() {
        return name;
    }

    public long getRegistrationTimestamp() {
        return registrationTimestamp;
    }

    // Comparator untuk mengurutkan pengguna berdasarkan pendaftaran terbaru
    public static class UserComparatorByDescendingRegistration implements Comparator<User> {
        @Override
        public int compare(User u1, User u2) {
            // Mengurutkan berdasarkan timestamp pendaftaran secara descending
            return Long.compare(u2.getRegistrationTimestamp(), u1.getRegistrationTimestamp());
        }
    }
}

// Kelas utama untuk menjalankan dan menguji
class Main {
    public static void main(String[] args) {
        Group group = new Group();

        // Menampilkan pengguna yang diurutkan
        List<User> users = group.getUsersSortedByMostRecentlyRegistered();
        if (users.isEmpty()) {
            System.out.println("Tidak ada pengguna yang ditemukan.");
        } else {
            System.out.println("Daftar Pengguna yang Diurutkan:");
            for (User user : users) {
                System.out.println("Nama: " + user.getName() + ", Timestamp Pendaftaran: " + user.getRegistrationTimestamp());
            }
        }
    }
}
