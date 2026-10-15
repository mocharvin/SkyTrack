// INHERITANCE: class induk + 2 class turunan
class Penumpang {
    protected String nama;

    Penumpang(String nama) { this.nama = nama; }

    String getNama()              { return nama; }
    String getJenis()             { return "Penumpang"; }
    String getFasilitas()         { return "-"; }
    int hitungHarga(int harga)    { return harga; }
}

class PenumpangReguler extends Penumpang {
    PenumpangReguler(String nama) { super(nama); }

    @Override String getJenis()      { return "Reguler"; }
    @Override String getFasilitas()  { return "Kursi ekonomi, bagasi 20 kg"; }
}

class PenumpangVIP extends Penumpang {
    PenumpangVIP(String nama) { super(nama); }

    @Override String getJenis()      { return "VIP"; }
    @Override String getFasilitas()  { return "Lounge, check-in prioritas, bagasi 40 kg"; }
    @Override int hitungHarga(int harga) { return harga * 3 / 2; }   // 1,5x
}
