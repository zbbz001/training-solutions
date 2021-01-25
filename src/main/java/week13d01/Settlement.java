package week13d01;

import org.jetbrains.annotations.NotNull;

public class Settlement {
    private String postcode;
    private String name;
    private String additionalName;

    public Settlement() {
    }

    public Settlement(String postcode, String name, String additionalName) {
        this.postcode = postcode;
        this.name = name;
        this.additionalName = additionalName;
    }

    public static Settlement SettlementFromLine(String line) {
        Settlement settlement = new Settlement();

        String[] parts = line.split(";");
        settlement.postcode = parts[0];
        settlement.name = parts[1];

        if (parts.length > 2) {
            settlement.additionalName = parts[2];
        }

        return settlement;
    }

    @Override
    public String toString() {
        return "Settlement{" +
                "postcode='" + postcode + '\'' +
                ", name='" + name + '\'' +
                ", additionalName='" + additionalName + '\'' +
                '}';
    }

    public String getPostcode() {
        return postcode;
    }

    public String getName() {
        return name;
    }

    public String getAdditionalName() {
        return additionalName;
    }
}
