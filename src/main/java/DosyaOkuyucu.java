import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DosyaOkuyucu {
    List<Dosya> magazinDosyalari;
    List<Dosya> saglikDosyalari;
    List<Dosya> siyasiDosyalari;
    List<Dosya> sporDosyalari;
    List<Dosya> ekonomiDosyalari;

    public void dosyalariOku() {
        magazinDosyalari = haberleriOku(Kategori.magazin);
        saglikDosyalari = haberleriOku(Kategori.saglik);
        siyasiDosyalari = haberleriOku(Kategori.siyasi);
        sporDosyalari = haberleriOku(Kategori.spor);
        ekonomiDosyalari = haberleriOku(Kategori.ekonomi);
    }


    public List<Dosya> haberleriOku(Kategori kategori) {
        List<Dosya> dosyalar = new ArrayList<>();
        File klasor = new File(kategori.name());
        File[] files = klasor.listFiles();

        for (File file : files) {
            Dosya dosya = dosyayiOku(file.getAbsolutePath(), kategori);
            dosyalar.add(dosya);
        }
        return dosyalar;
    }

    public Dosya dosyayiOku(String path, Kategori kategori) {
        Dosya dosya = new Dosya();
        try {
            File fileDir = new File(path);
            dosya.setDosyaAdi(fileDir.getName());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "ISO8859-9"));
            List<String> kelimeler = new ArrayList<>();
            String str;

            while ((str = in.readLine()) != null) {
                String[] parcalanmisStr = str.split(" ");
                for (String s : parcalanmisStr) {
                    ekle(noktalamariSil(s).toLowerCase(), kelimeler);
                }
            }
            dosya.setKelimeler(kelimeler);
            dosya.setKategori(kategori);
            in.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dosya;
    }

    private void ekle(String s, List<String> kelimeler) {
        if (!kelimeler.contains(s)) {
            kelimeler.add(s);
        }
    }

    public String noktalamariSil(String s) {
        String res = "";
        for (Character c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c))
                res += c;
        }
        return res;
    }
}
