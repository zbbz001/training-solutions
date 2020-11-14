package stringbuilder;

public class NameBuilder {
    public boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        StringBuilder concatedName = new StringBuilder();

        if (title != null) {
            concatedName.append(title.writtenFormat).append(" ");
        }

        concatedName.append(givenName).append(" ");

        if (middleName != null && !middleName.isBlank()) {
            concatedName.append(middleName).append(" ");
        }

        concatedName.append(familyName);

        return concatedName.toString();
    }


    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }

        StringBuilder concatedName = new StringBuilder();

        if (title != null) {
            concatedName.append(title.writtenFormat).append(" ");
        }

        concatedName.append(familyName).append(" ");

        if (middleName != null && !middleName.isBlank()) {
            concatedName.append(middleName).append(" ");
        }

        concatedName.append(givenName);

        return concatedName.toString();
    }

    public String insertTitle(String name, Title title, String where) {
        StringBuilder concatedName = new StringBuilder(name);
        int wherePos = concatedName.indexOf(where);

        concatedName.insert(wherePos + 1, title.writtenFormat + " ");

        return concatedName.toString();
    }

    public String deleteNamePart(String name, String delete) {
        StringBuilder concatedName = new StringBuilder(name);
        int strPos = concatedName.indexOf(delete);

        concatedName.delete(strPos, strPos + delete.length());

        return concatedName.toString();
    }
}
