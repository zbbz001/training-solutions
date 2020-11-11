package controlselection.accents;

public class WithoutAccents {

    public static final String LETTERS_WITH_ACCENTS = "áéíóöőúüűÁÉÍÓÖŐÚÜŰ";

    public static final String LETTERS_WITHOUT_ACCENTS = "aeiooouuuAEIOOOUUU";

    public String convertToCharWithoutAccents(String inputChar) {
        int index = LETTERS_WITH_ACCENTS.indexOf(inputChar);
        if (index >= 0) {
            return LETTERS_WITHOUT_ACCENTS.substring(index, index + 1);
        } else {
            return inputChar;
        }
    }

    public static void main(String[] args) {
        WithoutAccents withoutAccents = new WithoutAccents();
        System.out.println(withoutAccents.convertToCharWithoutAccents("á"));
        System.out.println(withoutAccents.convertToCharWithoutAccents("ú"));
        System.out.println(withoutAccents.convertToCharWithoutAccents("b"));
    }
}