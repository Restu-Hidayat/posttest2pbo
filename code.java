code:
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package postetesttttt;

/**
 *
 * @author Asus GK
 */
public class Postetesttttt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
    
}
import java.util.Scanner;


class KelasPenerbangan {
    private String namaKelas;
    private int hargaTiket;
    private int tiketTersedia;

    
    public KelasPenerbangan(String namaKelas, int hargaTiket, int tiketTersedia) {
        this.namaKelas = namaKelas;
        this.hargaTiket = hargaTiket;
        this.tiketTersedia = tiketTersedia;
    }

     
    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    
    public int getHargaTiket() {
        return hargaTiket;
    }

    public void setHargaTiket(int hargaTiket) {
        this.hargaTiket = hargaTiket;
    }

  
    public int getTiketTersedia() {
        return tiketTersedia;
    }

    public void setTiketTersedia(int tiketTersedia) {
        this.tiketTersedia = tiketTersedia;
    }

    
    public void tampilkanInfoKelas() {
        System.out.println("Kelas: " + namaKelas);
        System.out.println("Harga Tiket: Rp " + hargaTiket);
        System.out.println("Tiket Tersedia: " + tiketTersedia);
    }

    
    public boolean cekKetersediaan(int jumlahTiket) {
        return jumlahTiket <= tiketTersedia;
    }

    
    public void kurangiTiket(int jumlahTiket) {
        tiketTersedia -= jumlahTiket;
    }
}


class Ekonomi extends KelasPenerbangan {
   
    public Ekonomi(int tiketTersedia) {
        
        super("Ekonomi", 1000000, tiketTersedia);
    }
}

// Subclass Bisnis
class Bisnis extends KelasPenerbangan {
    // Constructor
    public Bisnis(int tiketTersedia) {
        // Memanggil constructor superclass dengan harga tiket yang sesuai
        super("Bisnis", 3000000, tiketTersedia);
    }
}

// Class PembelianTiket
class PembelianTiket {
    private String namaPembeli;
    private KelasPenerbangan kelasPenerbangan;
    private int jumlahTiket;

   
    public PembelianTiket(String namaPembeli, KelasPenerbangan kelasPenerbangan, int jumlahTiket) {
        this.namaPembeli = namaPembeli;
        this.kelasPenerbangan = kelasPenerbangan;
        this.jumlahTiket = jumlahTiket;
    }

    
    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    
    public KelasPenerbangan getKelasPenerbangan() {
        return kelasPenerbangan;
    }

    public void setKelasPenerbangan(KelasPenerbangan kelasPenerbangan) {
        this.kelasPenerbangan = kelasPenerbangan;
    }

    
    public int getJumlahTiket() {
        return jumlahTiket;
    }

    public void setJumlahTiket(int jumlahTiket) {
        this.jumlahTiket = jumlahTiket;
    }

  
    public int hitungTotalHarga() {
        return jumlahTiket * kelasPenerbangan.getHargaTiket();
    }

   
    public void tampilkanDetailPembelian() {
        System.out.println("Nama Pembeli: " + namaPembeli);
        kelasPenerbangan.tampilkanInfoKelas();
        System.out.println("Jumlah Tiket: " + jumlahTiket);
        System.out.println("Total Harga: Rp " + hitungTotalHarga());
    }
}

public class TiketPesawat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek kelas penerbangan menggunakan inheritance
        KelasPenerbangan ekonomi = new Ekonomi(50);
        KelasPenerbangan bisnis = new Bisnis(30);

        // Meminta pengguna memasukkan nama
        System.out.println("Masukkan nama pembeli:");
        String namaPembeli = scanner.nextLine();

        // Meminta pengguna memilih kelas penerbangan
        System.out.println("Pilih kelas penerbangan:");
        System.out.println("1. Ekonomi");
        System.out.println("2. Bisnis");
        int pilihanKelas = scanner.nextInt();

        // Meminta jumlah tiket yang ingin dibeli
        System.out.println("Masukkan jumlah tiket yang ingin dibeli:");
        int jumlahTiket = scanner.nextInt();

        KelasPenerbangan kelasDipilih = null;

        // Proses pemilihan kelas
        if (pilihanKelas == 1) {
            kelasDipilih = ekonomi;
        } else if (pilihanKelas == 2) {
            kelasDipilih = bisnis;
        } else {
            System.out.println("Pilihan kelas tidak valid.");
            System.exit(0);
        }

        // Mengecek ketersediaan tiket
        if (kelasDipilih.cekKetersediaan(jumlahTiket)) {
            // Membuat objek PembelianTiket
            PembelianTiket pembelian = new PembelianTiket(namaPembeli, kelasDipilih, jumlahTiket);
            pembelian.tampilkanDetailPembelian();
            
            // Mengurangi tiket yang tersedia setelah pembelian
            kelasDipilih.kurangiTiket(jumlahTiket);
        } else {
            System.out.println("Maaf, tiket " + kelasDipilih.getNamaKelas() + " tidak mencukupi.");
        }

        scanner.close();
    }
}
