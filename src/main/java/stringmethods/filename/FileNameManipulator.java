package stringmethods.filename;

public class FileNameManipulator {

    public char findLastCharacter(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Empty string!");
        }

        return str.charAt(str.trim().length() - 1);
    }

    public String findFileExtension(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Invalid file name!");
        }

        int lastIndexOfPoint = fileName.lastIndexOf('.');

        if (lastIndexOfPoint == -1) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        if (lastIndexOfPoint + 1 == fileName.length()) {
            throw new IllegalArgumentException("Invalid file name!");
        }

        if (lastIndexOfPoint == 0) {
            throw new IllegalArgumentException("Invalid file name!");
        }

        return fileName.substring(lastIndexOfPoint);
    }


    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (ext == null || ext.isBlank()) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        if (fileName.replace(ext, "").equals(".")) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        return findFileExtension(fileName).substring(1).equals(ext);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (searchedFileName == null || searchedFileName.isBlank()) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        if (actualFileName == null || actualFileName.isBlank()) {
            throw new IllegalArgumentException("Invalid argument!");
        }

        return searchedFileName.equalsIgnoreCase(actualFileName);
    }

    public String changeExtensionToLowerCase(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Empty string!");
        }

        if (fileName.charAt(0) == '.') {
            throw new IllegalArgumentException("Invalid argument!");
        }

        String extension = findFileExtension(fileName);

        int extensionLastOccurrence = fileName.lastIndexOf(extension);

        return fileName.substring(0, extensionLastOccurrence).concat(extension.toLowerCase());
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Empty string!");
        }

        return fileName.replace(present, target);
    }
}
