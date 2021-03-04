package covid;

public class Citizen {
    private Long id;
    private String name;
    private Zip zip;
    private int age;
    private String email;
    private String ssn;

    public Citizen(String name, Zip zip, int age, String email, String ssn) {
        this.name = name;
        this.zip = zip;
        this.age = age;
        this.email = email;
        this.ssn = ssn;
    }

    public Citizen(Long id, String name, Zip zip, int age, String email, String ssn) {
        this.name = name;
        this.zip = zip;
        this.age = age;
        this.email = email;
        this.ssn = ssn;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Zip getZip() {
        return zip;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSsn() {
        return ssn;
    }
}
