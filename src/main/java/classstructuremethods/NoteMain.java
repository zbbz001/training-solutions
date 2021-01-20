package classstructuremethods;

public class NoteMain {
    public static void main(String[] args) {
        Note note = new Note();
        note.setName("Cody Coder");
        note.setTopic("Top Secret");
        note.setText("xxxxxx xxxxxxxx xxxxxxxxx xxxxxx");

        System.out.println("Na nézzük, hogy ki mit írt!");
        System.out.println(note.getNoteText());
    }
}
