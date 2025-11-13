import java.util.Scanner;
import java.util.ArrayList;

class Barang {
    private final String nama;
    private final int jumlah;
    private final double hargaSatuan;

    public Barang(String nama, int jumlah, double hargaSatuan) {
        this.nama = nama;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getHargaSatuan() {
        return hargaSatuan;
    }

    public double getHargaTotal() {
        return jumlah * hargaSatuan;
    }
}

public class FilkomMart {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            ArrayList<Barang> daftarBarang = new ArrayList<>();
            
            System.out.print("Masukkan jumlah barang yang dibeli: ");
            int n = scan.nextInt();
            scan.nextLine();
            
            for (int i = 1; i <= n; i++) {
                System.out.println("\nBarang ke-" + i);
                System.out.print("Nama barang: ");
                String nama = scan.nextLine();
                
                System.out.print("Jumlah satuan: ");
                int jumlah = scan.nextInt();
                
                System.out.print("Harga satuan: ");
                double harga = scan.nextDouble();
                scan.nextLine();
                
                daftarBarang.add(new Barang(nama, jumlah, harga));
            }
            
            System.out.println("\n========== STRUK FILKOMMART ==========");
            System.out.printf("%-20s %-10s %-12s %-12s\n", "Nama Barang", "Jumlah", "Harga", "Total");
            System.out.println("===============================================");
            
            double totalBelanja = 0;
            for (Barang b : daftarBarang) {
                System.out.printf("%-20s %-10d Rp%-10.2f Rp%-10.2f\n",
                        b.getNama(), b.getJumlah(), b.getHargaSatuan(), b.getHargaTotal());
                totalBelanja += b.getHargaTotal();
            }
            
            System.out.println("===============================================");
            System.out.printf("Total Belanja: Rp%.2f\n", totalBelanja);
            System.out.println("===============================================");
            System.out.println("Terima kasih telah berbelanja di FilkomMart!");
        }
    }
}

