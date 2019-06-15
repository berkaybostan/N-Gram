import java.util.List;

public class NGramIslemleri {


    public void islemlereBasladi(List<Dosya> dosyalar, int n) {
        for (Dosya dosya : dosyalar) {
            gramlariBul(dosya);
        }
    }


    public void gramlariBul(Dosya dosya) {
        for (String str : dosya.duzeltilmisKelimeler) {
            nGramlariBul(str, dosya, 2);
            nGramlariBul(str, dosya, 3);
        }
    }


    public void nGramlariBul(String str, Dosya dosya, int n) {

        if (str.length() == n) {
            int counter = 0;
            while (counter < n) {
                if (n == 2) {
                    dosya.nGram2.add(str.substring(counter));
                    ngramAdetlerineEkle(dosya, str.substring(counter), n);
                } else {
                    dosya.nGram3.add(str.substring(counter));
                    ngramAdetlerineEkle(dosya, str.substring(counter), n);
                }
                counter++;
            }
            return;
        }

        int counter = 0;
        String gram = "";
        while (counter < n) {
            if (str.length() > counter)
                gram += str.charAt(counter);
            counter++;
        }
        if (n == 2) {
            dosya.nGram2.add(gram);
            ngramAdetlerineEkle(dosya, gram, n);
        } else {
            dosya.nGram3.add(gram);
            ngramAdetlerineEkle(dosya, gram, n);
        }
        try {
            if (str.trim().length() > 0)
                nGramlariBul(str.substring(1), dosya, n);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private void ngramAdetlerineEkle(Dosya dosya, String gram, int n) {
        if (n == 2) {
            if (dosya.ikiGramAdetleri.containsKey(gram)) {
                dosya.ikiGramAdetleri.put(gram, dosya.ikiGramAdetleri.get(gram) + 1);
            } else {
                dosya.ikiGramAdetleri.put(gram, 1);
            }
        } else {
            if (dosya.ucGramAdetleri.containsKey(gram)) {
                dosya.ucGramAdetleri.put(gram, dosya.ucGramAdetleri.get(gram) + 1);
            } else {
                dosya.ucGramAdetleri.put(gram, 1);
            }
        }
    }
}
