// Satu Node dipakai oleh ketiga jenis linked list
class Node {
    Object data;
    Node next, prev;   // prev hanya dipakai Doubly

    Node(Object data) { this.data = data; }
}

// SINGLY: daftar tiket/penumpang (node hanya punya next)
class SinglyLinkedList {
    Node head;
    int jumlah;

    void tambahDepan(Tiket t) {
        Node n = new Node(t);
        n.next = head;
        head = n;
        jumlah++;
    }

    void tambahBelakang(Tiket t) {
        Node n = new Node(t);
        if (head == null) head = n;
        else {
            Node b = head;
            while (b.next != null) b = b.next;
            b.next = n;
        }
        jumlah++;
    }

    Tiket cari(String kode) {
        for (Node b = head; b != null; b = b.next)
            if (((Tiket) b.data).getKode().equalsIgnoreCase(kode)) return (Tiket) b.data;
        return null;
    }

    Tiket cariKursi(int kursi) {
        for (Node b = head; b != null; b = b.next)
            if (((Tiket) b.data).getKursi() == kursi) return (Tiket) b.data;
        return null;
    }

    boolean hapus(String kode) {
        Node sebelum = null;
        for (Node b = head; b != null; sebelum = b, b = b.next) {
            if (((Tiket) b.data).getKode().equalsIgnoreCase(kode)) {
                if (sebelum == null) head = b.next;
                else sebelum.next = b.next;
                jumlah--;
                return true;
            }
        }
        return false;
    }

    void tampil() {
        if (head == null) System.out.println("(kosong)");
        for (Node b = head; b != null; b = b.next) ((Tiket) b.data).info();
    }
}

// DOUBLY: daftar penerbangan (bisa dibaca maju & mundur)
class DoublyLinkedList {
    Node head, tail;
    int jumlah;

    void tambah(Penerbangan p) {
        Node n = new Node(p);
        if (head == null) head = tail = n;
        else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        jumlah++;
    }

    Penerbangan cari(String kode) {
        for (Node b = head; b != null; b = b.next)
            if (((Penerbangan) b.data).getKode().equalsIgnoreCase(kode)) return (Penerbangan) b.data;
        return null;
    }

    Penerbangan ambil(int index) {   // mulai dari 0
        if (index < 0 || index >= jumlah) return null;
        Node b = head;
        for (int i = 0; i < index; i++) b = b.next;
        return (Penerbangan) b.data;
    }

    void tampilMaju() {
        int no = 1;
        for (Node b = head; b != null; b = b.next) ((Penerbangan) b.data).info(no++);
    }

    void tampilMundur() {
        int no = jumlah;
        for (Node b = tail; b != null; b = b.prev) ((Penerbangan) b.data).info(no--);
    }
}

// CIRCULAR: loket check-in bergiliran (node terakhir kembali ke node pertama)
class CircularLinkedList {
    Node tail, giliran;

    void tambah(String loket) {
        Node n = new Node(loket);
        if (tail == null) {
            tail = n;
            n.next = n;
            giliran = n;
        } else {
            n.next = tail.next;
            tail.next = n;
            tail = n;
        }
    }

    String ambilGiliran() {
        String loket = (String) giliran.data;
        giliran = giliran.next;
        return loket;
    }
}