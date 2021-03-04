package covid;

public class Zip {
    private Long id;
    private String zip_code;
    private String settlement;
    private String settlement_part;

    public Zip(Long id, String zip_code, String settlement, String settlement_part) {
        this.id = id;
        this.zip_code = zip_code;
        this.settlement = settlement;
        this.settlement_part = settlement_part;
    }

    public String getSettlement() {
        return settlement;
    }

    public Long getId() {
        return id;
    }

    public String getZip_code() {
        return zip_code;
    }

    @Override
    public String toString() {
        return "Zip{" +
                "zip_code='" + zip_code + '\'' +
                ", settlement='" + settlement + '\'' +
                ", settlement_part='" + settlement_part + '\'' +
                '}';
    }
}
