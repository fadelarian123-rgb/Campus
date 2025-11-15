import java.util.*;

class mataKuliah {
    private String kode;
    private String nama;
    private int sks;

    public mataKuliah (String kode,String nama,int sks){
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;

    }
    public String getKode() {
        return kode;
    }
    public String getNama() {
        return nama;
    }     
    public int getSks() {
        return sks;
    }   

    }
class mahasiswa {
    private String NIM;
    private String nama;
    private ArrayList <mataKuliah> daftarMK= new ArrayList<>();
    private int totalsks = 0;

    public mahasiswa (String NIM, String nama) {
        this.NIM = NIM;
        this.nama = nama;
    }
    public boolean tambahMataKuliah(mataKuliah mk) {
        if (totalsks + mk.getSks()>24) {
            return false;
        }
        daftarMK.add(mk);
        totalsks += mk.getSks();
        return true;
    }
    public void cetakKRS () {
        System.out.println("\n============ KARTU RENCANA STUDI ============");
        System.out.println("NIM  :" + NIM);
        System.out.println("Nama :" + nama);
        System.out.println("---------------------------------------------");
        System.out.println("Daftar Mata Kuliah :");
        for (mataKuliah mk : daftarMK) {
            System.out.println(mk.getKode() + " - " + mk.getNama() + " (" + mk.getSks() + " SKS )");
        }
        System.out.println("---------------------------------------------");
        System.out.println("Total SKS :" + totalsks);
        System.out.println("\nTTD KPS :");
        System.out.println("KPS - " + NIM + " / " + nama);
        System.out.println("=============================================");
    }   
}






public class pemdas {
    public static void main (String []args){
        Scanner scan = new Scanner (System.in);

        System.out.print("Masukkan NIM : ");
        String nim = scan.nextLine();

        System.out.print("Masukkan Nama : ");
        String Nama = scan.nextLine();

        mahasiswa mhs = new mahasiswa(nim, Nama);

        while (true) { 
            System.out.print("\nTambahkan Mata Kuliah? (ya/tidak): ");
            String pilih = scan.next();

            if (pilih.equalsIgnoreCase("tidak")) break;

            scan.nextLine();

            System.out.print("Kode Mata Kuliah : ");
            String kode = scan.nextLine();

            System.out.print("Nama Mata Kuliah : ");
            String namamk = scan.nextLine();

            System.out.print("Jumlah SKS : ");
            int sks = scan.nextInt();

            mataKuliah mk = new mataKuliah(kode, namamk, sks);

            if (mhs.tambahMataKuliah(mk)) {
                System.out.println("Mata Kuliah Berhasil Ditambahkan!");
            } else {
                System.out.println("Gagal Menambahkan! Total SKS Melebihi 24.");
            }
        }

        mhs.cetakKRS();

    }
}
