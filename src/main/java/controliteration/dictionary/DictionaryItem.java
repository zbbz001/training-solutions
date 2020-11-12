package controliteration.dictionary;

import java.util.List;

public class DictionaryItem {
    private String word;
    private List<String> translations;

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        this.translations = translations;
    }

    public void addTranslations(List<String> newTranslations) {
        for(String newTranslation:newTranslations) {
            if(!translations.contains(newTranslation)) {
                translations.add(newTranslation);
            }
        }
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }
}
