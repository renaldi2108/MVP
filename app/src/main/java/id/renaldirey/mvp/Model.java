package id.renaldirey.mvp;

/**
 * Created by IT Cermat on 12/08/2017.
 */

public class Model {
    private String nama, jeniskelamin;
    private Integer umur;

    public Model(String nama, String jeniskelamin, Integer umur){
        this.nama = nama;
        this.jeniskelamin = jeniskelamin;
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }
}
