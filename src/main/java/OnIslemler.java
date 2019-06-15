import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

public class OnIslemler {

    public OnIslemler() {
        DosyaOkuyucu dosyaOkuyucu = new DosyaOkuyucu();
        dosyaOkuyucu.dosyalariOku();

        System.out.println("dosya okuma islemi tamamlandi");

        ZemberekAdimlari zemberekAdimlari = new ZemberekAdimlari();
        zemberekAdimlari.islemlereBasladi(dosyaOkuyucu.magazinDosyalari);
        zemberekAdimlari.islemlereBasladi(dosyaOkuyucu.saglikDosyalari);
        zemberekAdimlari.islemlereBasladi(dosyaOkuyucu.siyasiDosyalari);
        zemberekAdimlari.islemlereBasladi(dosyaOkuyucu.sporDosyalari);
        zemberekAdimlari.islemlereBasladi(dosyaOkuyucu.ekonomiDosyalari);

        System.out.println("dogal dil isleme adimlari tamamlandi");

        NGramIslemleri ikiGram = new NGramIslemleri();
        ikiGram.islemlereBasladi(dosyaOkuyucu.magazinDosyalari, 2);
        ikiGram.islemlereBasladi(dosyaOkuyucu.saglikDosyalari, 2);
        ikiGram.islemlereBasladi(dosyaOkuyucu.siyasiDosyalari, 2);
        ikiGram.islemlereBasladi(dosyaOkuyucu.sporDosyalari, 2);
        ikiGram.islemlereBasladi(dosyaOkuyucu.ekonomiDosyalari, 2);

        System.out.println("2gram isleme adimlari tamamlandi");

        NGramIslemleri ucGram = new NGramIslemleri();
        ucGram.islemlereBasladi(dosyaOkuyucu.magazinDosyalari, 3);
        ucGram.islemlereBasladi(dosyaOkuyucu.saglikDosyalari, 3);
        ucGram.islemlereBasladi(dosyaOkuyucu.siyasiDosyalari, 3);
        ucGram.islemlereBasladi(dosyaOkuyucu.sporDosyalari, 3);
        ucGram.islemlereBasladi(dosyaOkuyucu.ekonomiDosyalari, 3);

        System.out.println("3gram isleme adimlari tamamlandi");

        /**
         * 50 den fazla
         */
        HashMap<String, Integer> toplamdakiNgramlar = new HashMap<>();
        for (Dosya dosya : dosyaOkuyucu.magazinDosyalari) {
            for (Map.Entry<String, Integer> stringIntegerEntry : dosya.ikiGramAdetleri.entrySet()) {
                if (stringIntegerEntry.getKey().length() > 1 && toplamdakiNgramlar.containsKey(stringIntegerEntry.getKey())) {
                    toplamdakiNgramlar.put(stringIntegerEntry.getKey(), toplamdakiNgramlar.get(stringIntegerEntry.getKey()) + stringIntegerEntry.getValue());
                } else {
                    if (stringIntegerEntry.getKey().length() > 1)
                        toplamdakiNgramlar.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
            for (Map.Entry<String, Integer> stringIntegerEntry : dosya.ucGramAdetleri.entrySet()) {
                if (stringIntegerEntry.getKey().length() > 1 && toplamdakiNgramlar.containsKey(stringIntegerEntry.getKey())) {
                    toplamdakiNgramlar.put(stringIntegerEntry.getKey(), toplamdakiNgramlar.get(stringIntegerEntry.getKey()) + stringIntegerEntry.getValue());
                } else {
                    if (stringIntegerEntry.getKey().length() > 1)
                        toplamdakiNgramlar.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
        }
        for (Dosya dosya : dosyaOkuyucu.sporDosyalari) {
            for (Map.Entry<String, Integer> stringIntegerEntry : dosya.ikiGramAdetleri.entrySet()) {
                if (stringIntegerEntry.getKey().length() > 1 && toplamdakiNgramlar.containsKey(stringIntegerEntry.getKey())) {
                    toplamdakiNgramlar.put(stringIntegerEntry.getKey(), toplamdakiNgramlar.get(stringIntegerEntry.getKey()) + stringIntegerEntry.getValue());
                } else {
                    if (stringIntegerEntry.getKey().length() > 1)
                        toplamdakiNgramlar.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
            for (Map.Entry<String, Integer> stringIntegerEntry : dosya.ucGramAdetleri.entrySet()) {
                if (stringIntegerEntry.getKey().length() > 1 && toplamdakiNgramlar.containsKey(stringIntegerEntry.getKey())) {
                    toplamdakiNgramlar.put(stringIntegerEntry.getKey(), toplamdakiNgramlar.get(stringIntegerEntry.getKey()) + stringIntegerEntry.getValue());
                } else {
                    if (stringIntegerEntry.getKey().length() > 1)
                        toplamdakiNgramlar.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
        }
        for (Dosya dosya : dosyaOkuyucu.siyasiDosyalari) {
            for (Map.Entry<String, Integer> stringIntegerEntry : dosya.ikiGramAdetleri.entrySet()) {
                if (stringIntegerEntry.getKey().length() > 1 && toplamdakiNgramlar.containsKey(stringIntegerEntry.getKey())) {
                    toplamdakiNgramlar.put(stringIntegerEntry.getKey(), toplamdakiNgramlar.get(stringIntegerEntry.getKey()) + stringIntegerEntry.getValue());
                } else {
                    if (stringIntegerEntry.getKey().length() > 1)
                        toplamdakiNgramlar.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
            for (Map.Entry<String, Integer> stringIntegerEntry : dosya.ucGramAdetleri.entrySet()) {
                if (stringIntegerEntry.getKey().length() > 1 && toplamdakiNgramlar.containsKey(stringIntegerEntry.getKey())) {
                    toplamdakiNgramlar.put(stringIntegerEntry.getKey(), toplamdakiNgramlar.get(stringIntegerEntry.getKey()) + stringIntegerEntry.getValue());
                } else {
                    if (stringIntegerEntry.getKey().length() > 1)
                        toplamdakiNgramlar.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
        }
        for (Dosya dosya : dosyaOkuyucu.saglikDosyalari) {
            for (Map.Entry<String, Integer> stringIntegerEntry : dosya.ikiGramAdetleri.entrySet()) {
                if (stringIntegerEntry.getKey().length() > 1 && toplamdakiNgramlar.containsKey(stringIntegerEntry.getKey())) {
                    toplamdakiNgramlar.put(stringIntegerEntry.getKey(), toplamdakiNgramlar.get(stringIntegerEntry.getKey()) + stringIntegerEntry.getValue());
                } else {
                    if (stringIntegerEntry.getKey().length() > 1)
                        toplamdakiNgramlar.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
            for (Map.Entry<String, Integer> stringIntegerEntry : dosya.ucGramAdetleri.entrySet()) {
                if (stringIntegerEntry.getKey().length() > 1 && toplamdakiNgramlar.containsKey(stringIntegerEntry.getKey())) {
                    toplamdakiNgramlar.put(stringIntegerEntry.getKey(), toplamdakiNgramlar.get(stringIntegerEntry.getKey()) + stringIntegerEntry.getValue());
                } else {
                    if (stringIntegerEntry.getKey().length() > 1)
                        toplamdakiNgramlar.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
        }
        for (Dosya dosya : dosyaOkuyucu.ekonomiDosyalari) {
            for (Map.Entry<String, Integer> stringIntegerEntry : dosya.ikiGramAdetleri.entrySet()) {
                if (stringIntegerEntry.getKey().length() > 1 && toplamdakiNgramlar.containsKey(stringIntegerEntry.getKey())) {
                    toplamdakiNgramlar.put(stringIntegerEntry.getKey(), toplamdakiNgramlar.get(stringIntegerEntry.getKey()) + stringIntegerEntry.getValue());
                } else {
                    if (stringIntegerEntry.getKey().length() > 1)
                        toplamdakiNgramlar.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
            for (Map.Entry<String, Integer> stringIntegerEntry : dosya.ucGramAdetleri.entrySet()) {
                if (stringIntegerEntry.getKey().length() > 1 && toplamdakiNgramlar.containsKey(stringIntegerEntry.getKey())) {
                    toplamdakiNgramlar.put(stringIntegerEntry.getKey(), toplamdakiNgramlar.get(stringIntegerEntry.getKey()) + stringIntegerEntry.getValue());
                } else {
                    if (stringIntegerEntry.getKey().length() > 1)
                        toplamdakiNgramlar.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
        }
        System.out.println("50 den fazla gecen heceler tespit edildi");

        List<File> dosyaListesi = new ArrayList<>();
        for (Kategori kategori : Kategori.values()) {
            File klasor = new File(kategori.name());
            File[] files = klasor.listFiles();
            for (File file : files) {
                dosyaListesi.add(file);
            }
        }
        int secilecekDosyaMiktari = dosyaListesi.size() / 4;
        int rastgeleDosyaIndexleri[] = new int[secilecekDosyaMiktari];


        for (int i = 0;i<secilecekDosyaMiktari;i++) {
            rastgeleDosyaIndexleri[i] = new Random().nextInt(dosyaListesi.size()-1);
        }

        JFrame frame = new JFrame("Naive Bayes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        JTextArea ellidenFazlaHeceler = new JTextArea();
        JTextArea testKumesi = new JTextArea();
        JTextArea egitimKumesi = new JTextArea();

        JScrollPane spEllidenFazlaHeceler = new JScrollPane(ellidenFazlaHeceler);
        spEllidenFazlaHeceler.setBorder(new TitledBorder("2-3 Gramlar"));
        JScrollPane spTestKumesi = new JScrollPane(testKumesi);
        spTestKumesi.setBorder(new TitledBorder("Test Kümesi"));
        JScrollPane spEgitimKumesi = new JScrollPane(egitimKumesi);
        spEgitimKumesi.setBorder(new TitledBorder("Eğitim Kümesi"));

        Dimension dimension = new Dimension(500, 100);
        spEllidenFazlaHeceler.setMaximumSize(dimension);
        spEllidenFazlaHeceler.setMinimumSize(dimension);
        spEllidenFazlaHeceler.setSize(dimension);
        spEllidenFazlaHeceler.setPreferredSize(dimension);
        spTestKumesi.setMaximumSize(dimension);
        spTestKumesi.setMinimumSize(dimension);
        spTestKumesi.setSize(dimension);
        spTestKumesi.setPreferredSize(dimension);
        spEgitimKumesi.setMaximumSize(dimension);
        spEgitimKumesi.setMinimumSize(dimension);
        spEgitimKumesi.setSize(dimension);
        spEgitimKumesi.setPreferredSize(dimension);

        int atla = 0;
        for (Map.Entry<String, Integer> toplamNGram50 : toplamdakiNgramlar.entrySet()) {
            if (toplamNGram50.getValue() >= 50) {
                ellidenFazlaHeceler.append(toplamNGram50.getKey() + " (" + toplamNGram50.getValue() + ")" + "\t");
            }
            if (atla % 10 == 0) {
                ellidenFazlaHeceler.append("\n");
            }
            atla++;
        }

        for (int index : rastgeleDosyaIndexleri) {
            testKumesi.append(dosyaListesi.get(index).getAbsolutePath() + "\n");
        }

        for (int i = 0; i < dosyaListesi.size(); i++) {
            if(!Arrays.asList(rastgeleDosyaIndexleri).contains(i)){
                egitimKumesi.append(dosyaListesi.get(i).getAbsolutePath()+"\n");
            }
        }

        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        panel.add(spEllidenFazlaHeceler);
        panel.add(spTestKumesi);
        panel.add(spEgitimKumesi);


        frame.setContentPane(panel);
        frame.setSize(600, 1000);
        frame.setVisible(true);
    }


}
