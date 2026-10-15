<img width="4128" height="1024" alt="Gemini_Generated_Image_su3qbpsu3qbpsu3q" src="https://github.com/user-attachments/assets/8d047732-dd94-468b-aaf5-f107dd73ae1d" />
<div>
  <h1 align="center"> SKYTRACK: Sistem Reservasi Tiket Pesawat</h1>
  <p>Program SKYTRACK merupakan aplikasi konsol berbasis Java yang berfokus pada layanan sistem reservasi dan antrean tiket pesawat langsung dari sudut pandang penumpang.</p>

  <h2>Kelompok: Pengen Jago Ngoding</h2>
  <h2>Anggota:</h2>
  <ol>
    <li>Lalu Hajiril Akbar (F1D02510066)</li>
    <li>Miftahurrahman (F1D02510074)</li>
    <li>Muhamad Arvin (F1D02510078)</li>
    <li>Andika Ramdhanu (F1D02510104)</li>
  </ol>

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

<h2>Implementasi pada ADT, Inheritance, dan Linked List</h2>
    <h3>1. Abstract Data Type (ADT)</h3>
    <p>ADT diterapkan melalui pembungkusan data (encapsulation) ke dalam kelas bertipe entitas khusus yang menyembunyikan detail atribut secara private:</p>
    <ul>
      <li>Tiket: Membungkus data tiket seperti kode, status, kursi, harga, dan objek Penumpang beserta method operasionalnya seperti checkIn().</li>
      <li>Penerbangan: Membungkus atribut penerbangan (asal, tujuan, jam, kapasitas) beserta data internal daftarTiket berbasis SinglyLinkedList. Memiliki method operasional seperti pesan(), batalkan(), dan sisaKursi().</li>
    </ul>
    <h3>2. Inheritance (Pewarisan) & Polymorphism</h3>
    <p>Inheritance diterapkan pada hirarki kelas penumpang untuk membedakan tipe dan fasilitas:</p>
    <ul>
      <li>Penumpang bertindak sebagai super-class (parent).</li>
      <li>PenumpangReguler dan PenumpangVIP merupakan sub-class (child) yang meng-ingat atribut nama melalui super(nama).</li>
      <li>Polymorphism (Method Overriding): Method getJenis(), getFasilitas(), dan hitungHarga() di-override oleh kelas turunan. Misal, PenumpangVIP meng-override harga menjadi 1,5x lipat dan mengubah daftar fasilitasnya. </li>
    </ul>
    <h3>3. Linked List</h3>
    <p>Program ini mengimplementasikan tiga struktur variabel Node penunjuk data:</p>
    <ul>
      <h4>Singly Linked List</h4>
        <li>Struktur: Memiliki penunjuk head dan pointer next.</li>
        <li>Penggunaan: Menyimpan daftar tiket per penerbangan (daftarTiket) dan tiket milik pengguna (tiketSaya). Penumpang VIP disisipkan di depan (tambahDepan) untuk prioritas, sedangkan Reguler disisipkan di belakang (tambahBelakang).</li>
      <h4>Doubly Linked List</h4>
        <li>Struktur: Memiliki penunjuk head & tail serta dua pointer (next dan prev).</li>
        <li>Penggunaan: Menyimpan daftar penerbangan. Digunakan untuk traversal dua arah, yaitu melihat jadwal dari awal (tampilMaju) maupun dari paling akhir (tampilMundur).</li>
      <h4>Circular Linked List</h4>
        <li>Struktur: Pointer next dari node terakhir (tail) selalu menunjuk kembali ke node pertama (head).</li>
        <li>Penggunaan: Mengatur antrean loket check-in (loket) secara bergiliran (round-robin) melalui method ambilGiliran().</li>
    </ul>

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

  <p align="center">PROGRAM STUDI TEKNIK INFORMATIKA</p>
  <p align="center">FAKULTAS TEKNIK</p>
  <p align="center">UNIVERSITAS MATARAM</p>
  <p align="center">2026/2027</p>
</div>
