<!DOCTYPE html>
<html>
<head>
    <title>Tambah Pesan</title>
</head>
<body>
    <h2>Tambah Pesan</h2>
    <form action="simpanPesan.php" method="POST">
        <label for="Penerima">Penerima:</label>
        <input type="text" name="Penerima" required><br><br>
        
        <label for="judul">Judul:</label>
        <input type="text" name="judul" required><br><br>
        
        <label for="TextPesan">Pesan:</label>
        <textarea name="TextPesan" required></textarea><br><br>
        
        <input type="submit" name="submit" value="Simpan">
    </form>

    <form action="simpanPesan.php">
        <button type="submit">Ke Simpan Pesan</button>
    </form>
</body>
</html>