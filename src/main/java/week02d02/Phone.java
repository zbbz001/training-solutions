package week02d02;

public class Phone {
    private int mem;
    private String type;


    public Phone(String type, int mem) {
        this.mem = mem;
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
