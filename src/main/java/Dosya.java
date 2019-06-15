import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dosya {
    private Kategori kategori;
    private List<String> kelimeler;
    List<String> duzeltilmisKelimeler = new ArrayList<>();
    List<String> nGram2 = new ArrayList();
    List<String> nGram3 = new ArrayList();
    HashMap<String, Integer> ikiGramAdetleri = new HashMap<>();
    HashMap<String, Integer> ucGramAdetleri = new HashMap<>();
    private String dosyaAdi;

    public Dosya(Kategori kategori, List<String> kelimeler, String dosyaAdi) {
        this.kategori = kategori;
        this.kelimeler = kelimeler;
        this.dosyaAdi = dosyaAdi;
    }

    public Dosya() {

    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public List<String> getKelimeler() {
        return kelimeler;
    }

    public void setKelimeler(List<String> kelimeler) {
        this.kelimeler = kelimeler;
    }

    public String getDosyaAdi() {
        return dosyaAdi;
    }

    public void setDosyaAdi(String dosyaAdi) {
        this.dosyaAdi = dosyaAdi;
    }
}
