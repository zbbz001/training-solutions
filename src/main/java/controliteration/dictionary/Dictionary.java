package controliteration.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dictionary {

    private List<DictionaryItem> dictionaryItems = new ArrayList<>();

    public void addItem(String newWord, List<String> newTranslations) {
        boolean insertNew = false;
        for(DictionaryItem dictionaryItem:dictionaryItems) {
            if(dictionaryItem.getWord().equals(newWord)) {
              dictionaryItem.addTranslations(newTranslations);
              insertNew = true;
            }
        }

        if(!insertNew) {
            dictionaryItems.add(new DictionaryItem(newWord, newTranslations));
        }
    }

    public List<String> findTranslations(String translation) {
        for(DictionaryItem dictionaryItem:dictionaryItems) {
            if(dictionaryItem.getWord().equals(translation)) {

                return dictionaryItem.getTranslations();
            }
        }

        return new ArrayList<>();
    }


    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        List<String> translations = new ArrayList<>();
        translations.add("tale");
        translations.add("story");

        dictionary.addItem("mese", translations);

        System.out.println(dictionary.findTranslations("mese"));

        translations.add("legend");
        dictionary.addItem("mese", translations);
        System.out.println(dictionary.findTranslations("mese"));
    }
}
