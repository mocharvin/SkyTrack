<img width="4128" height="1024" alt="Gemini_Generated_Image_su3qbpsu3qbpsu3q" src="https://github.com/user-attachments/assets/8d047732-dd94-468b-aaf5-f107dd73ae1d" />
<div>
  <h1 align="center"> SkyTack </h1>
  <p>Program SKYTRACK merupakan aplikasi konsol berbasis Java yang berfokus pada layanan sistem reservasi dan antrean tiket pesawat langsung dari sudut pandang penumpang.</p>

  <h2>Fitur Utama:</h2>
    <h3>🔍 Mencari & Melihat Jadwal Penerbangan:</h3>
      <p>Menampilkan daftar rute penerbangan yang tersedia (bisa dilihat urut maju atau mundur) serta mencari detail penerbangan spesifik berdasarkan kode penerbangannya.</p>
    <h3>👀 Melihat Informasi Penumpang & Kursi:</h3>
      <p>Memantau daftar penumpang dan ketersediaan nomor kursi secara visual ([...] untuk kursi kosong dan [X] untuk kursi terisi).</p>
    <h3>🎫 Pemesanan Tiket Pesawat:</h3>
      <p>Menginput nama penumpang, memilih kelas penerbangan (Reguler atau VIP yang menyertakan fasilitas seperti lounge dan bagasi ekstra), serta memilih lokasi kursi secara bebas.</p>
    <h3>⚙️ Kelola Tiket Saya:</h3>
      <p>Menampilkan seluruh daftar tiket yang telah dipesan oleh pengguna beserta detail statusnya.</p>
    <h3>💻 Layanan Check-in Otomatis:</h3>
      <p>Melakukan check-in tiket yang secara otomatis membagikan nomor loket keberangkatan bergiliran (dengan jalur prioritas khusus penumpang VIP).</p>
    <h3>❌ Pembatalan Tiket:</h3>
      <p>Membatalkan pesanan tiket selama belum melakukan check-in, sehingga nomor kursi tersebut akan otomatis kembali kosong dan bisa dipesan ulang.</p>

  <h2>Aspek CRUD dalam Implementasi Kode:</h2>
    <p>Berdasarkan kode program SKYTRACK yang telah kami buat, program ini sudah memenuhi seluruh aspek CRUD (Create, Read, Update, Delete) sebagai dasar sistem informasi. Berikut adalah rincian implementasi aspek CRUD di dalam kodenya:</p>
    <h3>1. Create (Menambahkan Data)</h3>
    <ul>
      <li>Memesan Tiket: Method pesan() membuat objek Tiket baru dan menyimpannya ke dalam daftar penerbangan serta daftar tiketSaya.</li>
      <li>Inisialisasi Data Dummy: Method dataDummy() menambahkan daftar Penerbangan awal dan Loket ke dalam Linked List.</li>
    </ul>
    <h3>2. Read (Melihat/Menampilkan Data)</h3>
    <ul>
      <li>Melihat Daftar Penerbangan: Method lihat() dan penerbangan.tampilMaju() / tampilMundur() menampilkan seluruh rute penerbangan.</li>
      <li>Mencari Penerbangan: Method cari() mencari detail penerbangan berdasarkan kodenya.</li>
      <li>Melihat Tiket Saya: Executed via tiketSaya.tampil() untuk melihat daftar tiket yang sudah dipesan.</li>
      <li>Melihat Denah Kursi & Penumpang: Method tampilKursi() dan tampilPenumpang() pada class Penerbangan.</li>
    </ul>
    <h3>3. Update (Mengubah Data)</h3>
    <ul>
      <li>Proses Check-in: Method checkIn() mengubah variabel status tiket dari "Dipesan" menjadi "Sudah check-in", serta memperbarui informasi loket keberangkatan.</li>
    </ul>
    <h3>4. Delete (Menghapus Data)</h3>
    <ul>
      <li>Membatalkan Tiket: Method batal() menghapus data tiket dari tiketSaya dan dari daftarTiket di objek Penerbangan menggunakan method hapus(kode). Hal ini juga secara otomatis mengosongkan kembali nomor kursi yang sebelumnya terisi.</li>
    </ul>
</div>
