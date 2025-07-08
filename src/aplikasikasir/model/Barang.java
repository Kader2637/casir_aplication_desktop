/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasikasir.model;

/**
 *
 * @author LEGION
 */
public class Barang {
    private String nama, kode, deskripsi;
    private int stok;
    private String harga;

    public Barang(String nama, String kode, int stok, String harga, String deskripsi) {
        this.nama = nama;
        this.kode = kode;
        this.stok = stok;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    public String getNama() { return nama; }
    public String getKode() { return kode; }
    public int getStok() { return stok; }
    public String getHarga() { return harga; }
    public String getDeskripsi() { return deskripsi; }


}

