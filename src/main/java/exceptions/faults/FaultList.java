package exceptions.faults;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;


public class FaultList {
    public static final String SPEPARATOR = ",";

    public List<String> processLines(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("The list cannot be null.");
        }

        List<String> faultList = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(SPEPARATOR);

            if (isSerialNumber(parts[0])) {
                ProcessingResult result = processLine(parts);

                if (result != ProcessingResult.NO_ERROR) {
                    faultList.add(parts[0] + "," + result.getCode());
                }
            }
        }

        return faultList;
    }

    private ProcessingResult processLine(String[] parts) {
        if (parts.length != 3) {
            return ProcessingResult.WORD_COUNT_ERROR;
        }
        String value = parts[1];
        String date = parts[2];

        boolean isValue = isValue(value);
        boolean isDate = isDate(date);

        if (!isValue && !isDate) {
            return ProcessingResult.VALUE_AND_DATE_ERROR;
        } else if (!isValue) {
            return ProcessingResult.VALUE_ERROR;
        } else if (!isDate) {
            return ProcessingResult.DATE_ERROR;
        }

        return ProcessingResult.NO_ERROR;
    }

    private boolean isDate(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy.MM.d."));
        } catch (DateTimeParseException dateTimeParseException) {
            return false;
        }

        return true;
    }

    private boolean isValue(String value) {
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    private boolean isSerialNumber(String serialNumber) {
        try {
            Integer.parseInt(serialNumber);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

}
