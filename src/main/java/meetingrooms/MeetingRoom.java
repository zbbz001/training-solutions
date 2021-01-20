package meetingrooms;

public class MeetingRoom {
    String name;
    int length;
    int width;

    public MeetingRoom(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Az iroda neve: " + name + "\n" +
                "  szélessége: " + length + "\n" +
                "  hosszúsága: " + width + "\n" +
                "  területe: " + getArea()+ "\n";
    }

}
