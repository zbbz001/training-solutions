package controlselection.consonant;

public class ToConsonant {

    public static final String VOWELS = "aáeéiíoóöőuúüű";
    public static final String ALPHABET = "aábcdeéfghiíjklmnoóöőpqrstuúüűvwxyz";

    public String convertToConsonant(String letter) {
        while(VOWELS.indexOf(letter) >= 0) {
            int index = ALPHABET.indexOf(letter) + 1;

            if(index + 1 > ALPHABET.length()) {
                throw new StringIndexOutOfBoundsException("No more consonant");
            }

            letter = ALPHABET.substring(index, index + 1);
        }

        if(ALPHABET.indexOf(letter) < 0){
            throw new IllegalArgumentException("No letter or not lowercase letter");
        }

        return letter;
    }

    public static void main(String[] args) {
        ToConsonant toConsonant = new ToConsonant();

        System.out.println(toConsonant.convertToConsonant("a"));
        System.out.println(toConsonant.convertToConsonant("z"));
        System.out.println(toConsonant.convertToConsonant("ó"));
    }
}
