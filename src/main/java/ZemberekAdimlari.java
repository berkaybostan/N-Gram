import zemberek.morphology.TurkishMorphology;
import zemberek.morphology.analysis.SingleAnalysis;
import zemberek.morphology.analysis.WordAnalysis;

import java.util.List;

public class ZemberekAdimlari {

    public void islemlereBasladi(List<Dosya> dosyalar) {
        for (Dosya dosya : dosyalar) {
            dogalDilIsle(dosya);
        }
    }

    public void dogalDilIsle(Dosya dosya) {
        TurkishMorphology morphology = null;
        try {
            morphology = TurkishMorphology.createWithDefaults();
            WordAnalysis results = null;
            for (String kelime : dosya.getKelimeler()) {
                results = morphology.analyze(kelime);
                for (SingleAnalysis result : results) {
                    String duzeltilmisKelime = result.getStem();
                    if (duzeltilmisKelime != null && duzeltilmisKelime.length() > 1) {
                        ekle(dosya.duzeltilmisKelimeler,result.getStem());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void ekle(List<String> duzeltilmisKelimeler, String stem) {
        if(!duzeltilmisKelimeler.contains(stem)){
            duzeltilmisKelimeler.add(stem);
        }
    }
}
