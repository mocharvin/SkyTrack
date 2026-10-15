import java.util.Scanner;

// ADT Tiket
class Tiket {
    private String kode, kodePenerbangan, status = "Dipesan", loket = "-";
    private Penumpang penumpang;
    private int kursi, harga;

    Tiket(String kode, Penumpang penumpang, String kodePenerbangan, int kursi, int harga) {
        this.kode = kode;
        this.penumpang = penumpang;
        this.kodePenerbangan = kodePenerbangan;
        this.kursi = kursi;
        this.harga = harga;
    }

    String getKode()          { return kode; }
    String getKodePenerbangan() { return kodePenerbangan; }
    String getStatus()        { return status; }
    Penumpang getPenumpang()  { return penumpang; }
    int getKursi()            { return kursi; }

    void checkIn(String loket) {
        this.status = "Sudah check-in";
        this.loket = loket;
    }

    void info() {
        System.out.println(kode + " | " + kodePenerbangan + " | Kursi " + kursi + " | "
                + penumpang.getNama() + " (" + penumpang.getJenis() + ") | Rp" + harga
                + " | " + status + " | Loket: " + loket);
    }
}

// ADT Penerbangan
class Penerbangan {
    private String kode, asal, tujuan, jam;
    private int kapasitas, harga;
    private SinglyLinkedList daftarTiket = new SinglyLinkedList();   // daftar penumpang

    Penerbangan(String kode, String asal, String tujuan, String jam, int kapasitas, int harga) {
        this.kode = kode;
        this.asal = asal;
        this.tujuan = tujuan;
        this.jam = jam;
        this.kapasitas = kapasitas;
        this.harga = harga;
    }

    String getKode()      { return kode; }
    int getKapasitas()    { return kapasitas; }
    int getHarga()        { return harga; }
    int sisaKursi()       { return kapasitas - daftarTiket.jumlah; }
    boolean terisi(int k) { return daftarTiket.cariKursi(k) != null; }

    Tiket pesan(String kodeTiket, Penumpang p, int kursi) {
        Tiket t = new Tiket(kodeTiket, p, kode, kursi, p.hitungHarga(harga));
        if (p.getJenis().equals("VIP")) daftarTiket.tambahDepan(t);   // VIP di depan
        else daftarTiket.tambahBelakang(t);
        return t;
    }

    boolean batalkan(String kodeTiket) { return daftarTiket.hapus(kodeTiket); }

    void tampilPenumpang() { daftarTiket.tampil(); }

    void tampilKursi() {
        for (int i = 1; i <= kapasitas; i++) System.out.print(terisi(i) ? "[X] " : "[" + i + "] ");
        System.out.println();
    }

    void info(int no) {
        System.out.println((no > 0 ? no + ". " : "") + kode + " | " + jam + " | Rp" + harga
                + " | Sisa kursi " + sisaKursi() + "/" + kapasitas);
        System.out.println("   " + asal + "  ->  " + tujuan);
    }
}

public class MainSkytrack {
    static Scanner in = new Scanner(System.in);
    static DoublyLinkedList penerbangan = new DoublyLinkedList();     // Doubly
    static SinglyLinkedList tiketSaya = new SinglyLinkedList();       // Singly
    static CircularLinkedList loket = new CircularLinkedList();       // Circular
    static int noTiket = 1;

    public static void main(String[] args) {
        dataDummy();
        int menu;
        do {
            clear();
            System.out.println("===== SKYTRACK =====");
            System.out.println("1. Lihat daftar penerbangan");
            System.out.println("2. Cari penerbangan (kode)");
            System.out.println("3. Lihat penumpang penerbangan");
            System.out.println("4. Pesan tiket");
            System.out.println("5. Tiket saya");
            System.out.println("6. Check-in");
            System.out.println("7. Batalkan tiket");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            menu = angka();
            clear();
            switch (menu) {
                case 1: lihat(); break;
                case 2: cari(); break;
                case 3: lihatPenumpang(); break;
                case 4: pesan(); break;
                case 5: tiketSaya.tampil(); break;
                case 6: checkIn(); break;
                case 7: batal(); break;
                case 0: System.out.println("Terima kasih!"); break;
                default: System.out.println("Menu tidak ada.");
            }
            if (menu != 0) {
                System.out.print("\nTekan Enter untuk kembali...");
                in.nextLine();
            }
        } while (menu != 0);
    }

    static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else System.out.print("\033[H\033[2J");
        } catch (Exception e) { }
    }

    static int angka() {
        try { return Integer.parseInt(in.nextLine().trim()); }
        catch (Exception e) { return -1; }
    }

    static String kodeTiket() { return String.format("T%03d", noTiket++); }

    static void dataDummy() {
        loket.tambah("Loket 1");
        loket.tambah("Loket 2");
        loket.tambah("Loket 3");

        Penerbangan a = new Penerbangan("GA101", "CGK Bandara Soekarno-Hatta", "DPS Bandara Ngurah Rai", "08:00", 10, 1200000);
        Penerbangan b = new Penerbangan("JT202", "SUB Bandara Juanda", "LOP Bandara Lombok", "10:30", 10, 800000);
        Penerbangan c = new Penerbangan("QZ303", "LOP Bandara Lombok", "CGK Bandara Soekarno-Hatta", "13:15", 10, 1500000);
        Penerbangan d = new Penerbangan("ID404", "KNO Bandara Kualanamu", "YIA Bandara Yogyakarta", "15:45", 10, 1100000);
        penerbangan.tambah(a);
        penerbangan.tambah(b);
        penerbangan.tambah(c);
        penerbangan.tambah(d);

        // Penumpang lain yang sudah memesan
        a.pesan(kodeTiket(), new PenumpangReguler("Andi"), 1);
        a.pesan(kodeTiket(), new PenumpangVIP("Bella"), 2);
        a.pesan(kodeTiket(), new PenumpangReguler("Candra"), 5);
        b.pesan(kodeTiket(), new PenumpangReguler("Dewi"), 3);
        c.pesan(kodeTiket(), new PenumpangVIP("Eko"), 4);
        d.pesan(kodeTiket(), new PenumpangReguler("Fani"), 7);
    }

    static Penerbangan pilihPenerbangan() {
        penerbangan.tampilMaju();
        System.out.print("\nPilih nomor penerbangan: ");
        Penerbangan p = penerbangan.ambil(angka() - 1);
        if (p == null) System.out.println("Nomor tidak tersedia.");
        return p;
    }

    static void lihat() {
        System.out.print("1. Maju  2. Mundur : ");
        System.out.println();
        if (angka() == 2) penerbangan.tampilMundur();
        else penerbangan.tampilMaju();
    }

    static void cari() {
        System.out.print("Kode penerbangan: ");
        Penerbangan p = penerbangan.cari(in.nextLine().trim());
        if (p == null) System.out.println("Tidak ditemukan.");
        else p.info(0);
    }

    static void lihatPenumpang() {
        Penerbangan p = pilihPenerbangan();
        if (p != null) {
            System.out.println("\nDaftar penumpang:");
            p.tampilPenumpang();
        }
    }

    static void pesan() {
        Penerbangan p = pilihPenerbangan();
        if (p == null) return;
        if (p.sisaKursi() == 0) {
            System.out.println("Penerbangan penuh.");
            return;
        }

        System.out.print("Nama penumpang: ");
        String nama = in.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong.");
            return;
        }

        Penumpang reguler = new PenumpangReguler(nama);
        Penumpang vip = new PenumpangVIP(nama);
        System.out.println("1. Reguler - Rp" + reguler.hitungHarga(p.getHarga()) + " (" + reguler.getFasilitas() + ")");
        System.out.println("2. VIP     - Rp" + vip.hitungHarga(p.getHarga()) + " (" + vip.getFasilitas() + ")");
        System.out.print("Pilih jenis: ");
        int jenis = angka();
        if (jenis != 1 && jenis != 2) {
            System.out.println("Jenis tidak valid.");
            return;
        }

        System.out.println("\nKursi ([X] = terisi):");
        p.tampilKursi();
        int kursi;
        while (true) {
            System.out.print("Pilih nomor kursi (0 = batal): ");
            kursi = angka();
            if (kursi == 0) return;
            if (kursi < 1 || kursi > p.getKapasitas()) System.out.println("Kursi tidak ada.");
            else if (p.terisi(kursi)) System.out.println("Kursi sudah terisi.");
            else break;
        }

        Tiket t = p.pesan(kodeTiket(), jenis == 1 ? reguler : vip, kursi);
        tiketSaya.tambahBelakang(t);
        System.out.println("\nPemesanan berhasil:");
        t.info();
    }

    static void checkIn() {
        tiketSaya.tampil();
        System.out.print("\nKode tiket: ");
        Tiket t = tiketSaya.cari(in.nextLine().trim());
        if (t == null) System.out.println("Tiket tidak ditemukan.");
        else if (!t.getStatus().equals("Dipesan")) System.out.println("Sudah check-in.");
        else {
            String l = loket.ambilGiliran();
            t.checkIn(l);
            System.out.println("Check-in berhasil, silakan ke " + l
                    + (t.getPenumpang().getJenis().equals("VIP") ? " (jalur prioritas)." : "."));
        }
    }

    static void batal() {
        tiketSaya.tampil();
        System.out.print("\nKode tiket yang dibatalkan: ");
        Tiket t = tiketSaya.cari(in.nextLine().trim());
        if (t == null) System.out.println("Tiket tidak ditemukan.");
        else if (!t.getStatus().equals("Dipesan")) System.out.println("Sudah check-in, tidak bisa dibatalkan.");
        else {
            penerbangan.cari(t.getKodePenerbangan()).batalkan(t.getKode());
            tiketSaya.hapus(t.getKode());
            System.out.println("Tiket dibatalkan, kursi " + t.getKursi() + " kembali tersedia.");
        }
    }
}