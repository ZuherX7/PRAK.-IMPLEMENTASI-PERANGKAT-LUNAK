<?php
// File: simpanPesan.php
session_start();

// Simulasi: Pastikan $_SESSION['id'] tetap bernilai 66 untuk testing
if (!isset($_SESSION['id'])) {
    $_SESSION['id'] = 66; // ID user login tetap
}

$idPengirim = $_SESSION['id'];
$idPenerima = isset($_POST['Penerima']) ? $_POST['Penerima'] : null;
$judul = isset($_POST['judul']) ? $_POST['judul'] : null;
$TextPesan = isset($_POST['TextPesan']) ? $_POST['TextPesan'] : null;
$date = date('Y-m-d');

// Koneksi ke database
$conn = new mysqli("localhost", "root", "", "modul7");

// Cek koneksi
if ($conn->connect_error) {
    die("Koneksi gagal: " . $conn->connect_error);
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Simpan data ke database
    $sql = "INSERT INTO pesan (IDPengirim, IDPenerima, Judul, TextPesan, WaktuPesan) 
            VALUES (?, ?, ?, ?, ?)";

    $stmt = $conn->prepare($sql);
    $stmt->bind_param("iisss", $idPengirim, $idPenerima, $judul, $TextPesan, $date);

    echo "<h2>Hasil Operasi</h2>";
    if ($stmt->execute()) {
        echo "<p>Pesan berhasil ditambahkan.</p>";
    } else {
        echo "<p>Pesan gagal ditambahkan: " . $stmt->error . "</p>";
    }

    // Tutup statement
    $stmt->close();
}

// Hapus pesan jika ada permintaan hapus
if (isset($_GET['hapus'])) {
    $idPesan = intval($_GET['hapus']);
    $deleteSql = "DELETE FROM pesan WHERE IDPesan = ?";
    $deleteStmt = $conn->prepare($deleteSql);
    $deleteStmt->bind_param("i", $idPesan);

    if ($deleteStmt->execute()) {
        echo "<p>Pesan berhasil dihapus.</p>";
    } else {
        echo "<p>Pesan gagal dihapus: " . $deleteStmt->error . "</p>";
    }

    $deleteStmt->close();
}

// Query untuk menampilkan semua isi tabel pesan
$result = $conn->query("SELECT * FROM pesan");

// Tampilkan tabel HTML
echo "<h2>Daftar Pesan</h2>";
echo "<table border='1' cellpadding='8' cellspacing='0'>";
echo "<tr>
        <th>IDPesan</th>
        <th>IDPengirim</th>
        <th>IDPenerima</th>
        <th>Judul</th>
        <th>TextPesan</th>
        <th>WaktuPesan</th>
        <th>Aksi</th>
      </tr>";

if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        echo "<tr>
                <td>" . htmlspecialchars($row['IDPesan']) . "</td>
                <td>" . htmlspecialchars($row['IDPengirim']) . "</td>
                <td>" . htmlspecialchars($row['IDPenerima']) . "</td>
                <td>" . htmlspecialchars($row['Judul']) . "</td>
                <td>" . htmlspecialchars($row['TextPesan']) . "</td>
                <td>" . htmlspecialchars($row['WaktuPesan']) . "</td>
                <td><a href='simpanPesan.php?hapus=" . htmlspecialchars($row['IDPesan']) . "'>Hapus</a></td>
              </tr>";
    }
} else {
    echo "<tr><td colspan='7'>Tidak ada data dalam tabel pesan.</td></tr>";
}

echo "</table>";

echo "<form action='Form_TambahPesan.php'>
        <button type='submit'>Kembali ke Tambah Pesan</button>
      </form>";

// Pastikan IDPesan selalu auto increment
$conn->query("ALTER TABLE pesan AUTO_INCREMENT = 1");

// Tutup koneksi
$conn->close();
?>