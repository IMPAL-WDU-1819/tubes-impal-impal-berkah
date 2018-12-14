package air.craft;

public class modelpesawat {
    private String Namapesawat;
    private String harga;
    private String designer;
    private String kodepesawat;
    private String deskripsi;
    private String gambar;

    public modelpesawat() {
    }

    public String getNamapesawat() {
        return Namapesawat;
    }

    public void setNamapesawat(String namapesawat) {
        Namapesawat = namapesawat;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getKodepesawat() {
        return kodepesawat;
    }

    public void setKodepesawat(String kodepesawat) {
        this.kodepesawat = kodepesawat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
