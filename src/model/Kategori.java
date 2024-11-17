package model;

// class Kategori
public class Kategori {
    private String nama;

    public Kategori(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Kategori " + this.nama;
    }

}
