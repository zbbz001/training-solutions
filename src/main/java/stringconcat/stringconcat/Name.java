package stringconcat.stringconcat;

public class Name {
    private String familyname;
    private String middleName;
    private String givenName;
    private Title title;


    public Name(String familyname, String middleName, String givenName, Title title) {
        if (isEmpty(familyname) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        this.familyname = familyname.trim();
        this.middleName = middleName != null ? middleName.trim() : middleName;
        this.givenName = givenName.trim();
        this.title = title;
    }

    public Name(String familyname, String middleName, String givenName) {
        if (isEmpty(familyname) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        this.familyname = familyname.trim();
        this.middleName = middleName != null ? middleName.trim() : middleName;
        this.givenName = givenName.trim();
        this.title = title;
    }

    public String concatNameWesternStyle() {
        String formatedName = "";

        if (title != null) {
            formatedName = formatedName.concat(title.getTitleString());
            formatedName = formatedName.concat(" ");
        }

        formatedName = formatedName.concat(givenName);
        formatedName = formatedName.concat(" ");

        if (!isEmpty(middleName)) {
            formatedName = formatedName.concat(middleName);
            formatedName = formatedName.concat(" ");
        }

        formatedName = formatedName.concat(familyname);

        return formatedName;
    }

    public String concatNameHungarianStyle() {
        String formatedName = "";

        if (title != null) {
            formatedName = formatedName.concat(title.getTitleString());
            formatedName = formatedName.concat(" ");
        }
        formatedName = formatedName.concat(familyname);
        formatedName = formatedName.concat(" ");

        if (!isEmpty(middleName)) {
            formatedName = formatedName.concat(middleName);
            formatedName = formatedName.concat(" ");
        }

        formatedName = formatedName.concat(givenName);

        return formatedName;
    }

    public boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

}
