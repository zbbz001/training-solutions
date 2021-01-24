package lambdaintro;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OfficeDocumentReader {

    public List<File> listOfficeDocuments(File path) {
        List<File> fileList = Arrays.asList(path.listFiles(file -> file.isFile() && file.getName().toLowerCase().matches(".*\\.(docx|xlsx|pptx)$")));
        fileList.sort(Comparator.comparing(File::getName));

        return fileList;
    }
}
