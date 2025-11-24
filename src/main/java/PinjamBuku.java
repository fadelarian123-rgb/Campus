import java.util.*;

class Buku {
    private String isbn;
    private String judul;

    public Buku(String isbn, String judul) {
        this.isbn = isbn;
        this.judul = judul;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getJudul() {
        return judul;
    }
}

class Mahasiswa {
    private String nim;
    private String nama;
    private ArrayList<Buku> daftarBuku = new ArrayList<>();

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public void pinjam(Buku buku) {
        daftarBuku.add(buku);
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public ArrayList<Buku> getDaftarBuku() {
        return daftarBuku;
    }
}
public class PinjamBuku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan NIM   : ");
        String nim = sc.nextLine();

        System.out.print("Masukkan Nama  : ");
        String nama = sc.nextLine();

        Mahasiswa mhs = new Mahasiswa(nim, nama);

        System.out.print("Jumlah buku yang dipinjam: ");
        int jumlah = sc.nextInt();
        sc.nextLine(); 
        for (int i = 1; i <= jumlah; i++) {
            System.out.println("\nData Buku ke-" + i);

            System.out.print("Masukkan ISBN  : ");
            String isbn = sc.nextLine();

            System.out.print("Masukkan Judul : ");
            String judul = sc.nextLine();

            Buku buku = new Buku(isbn, judul);
            mhs.pinjam(buku);
        }

        
        System.out.println("\n======================================================");
        System.out.println("NIM   : " + mhs.getNim());
        System.out.println("Nama  : " + mhs.getNama());

        System.out.println("------------------------------------------------------");
        System.out.printf("| %-3s | %-20s | %-50s |\n", "No", "ISBN", "Judul");
        System.out.println("------------------------------------------------------");

        int no = 1;
        for (Buku b : mhs.getDaftarBuku()) {
            System.out.printf("| %-3d | %-20s | %-50s |\n",
                    no, b.getIsbn(), b.getJudul());
            no++;
        }

        System.out.println("------------------------------------------------------");
    }
}
