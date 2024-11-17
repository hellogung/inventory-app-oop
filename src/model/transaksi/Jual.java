package model.transaksi;

import model.Produk;

public class Jual implements Transaksi {
    private Produk produk;
    private int jumlah;

    public Jual(Produk produk, int jumlah) {
        this.produk = produk;
        this.jumlah = jumlah;
    }

    @Override
    public void proses() {
        boolean isTerjual = produk.kurangiStok(jumlah);
        if(!isTerjual){
            return;
        }
        
        System.out.printf("Penjualan %s (%s pcs) berhasil", produk.nama, jumlah);
    }
}
