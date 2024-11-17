package service.transaksi;

import model.Produk;

public class Beli implements Transaksi {
    private Produk produk;
    private int jumlah;

    public Beli(Produk produk, int kuantitas) {
        this.produk = produk;
        this.jumlah = kuantitas;
    }

    @Override
    public void proses() {
        produk.tambahStok(jumlah);
        System.out.printf("Pembelian %s (%s pcs) berhasil", produk.getNama(), jumlah);
    }
}
