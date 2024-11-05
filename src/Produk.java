public class Produk {
    private String kode;
    private String nama;
    private String kategori;
    private int stok;
    private double harga;
    private double totalNilai;


    public Produk(String kode, String nama, int stok, double harga, String kategori) {
        this.kode = kode;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.kategori = kategori;
        this.totalNilai = harga * stok;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public int getStok() {
        return stok;
    }

    public double getHarga() {
        return harga;
    }

    public double getTotalNilai() {
        return totalNilai;
    }

    @Override
    public String toString() {
        return "Produk{" +
                " kode='" + kode + '\'' +
                ", nama='" + nama + '\'' +
                ", kategori='" + kategori + '\'' +
                ", stok='" + stok + '\'' +
                ", harga='" + harga + '\'' +
                ", totalNilai=" + totalNilai +
                " }";
    }
}
