package exam03retake02;

public class BalatonStation {
    private long id;
    private String station;
    private double lat;
    private double lon;
    private String description;
    private int level;
    private String groupId;
    private String stationType;

    private static final char LINE_END_CHAR = ',';
    private static final String DATA_SEPARATOR = ":";

    private static final String DATA_FIELD_NAME_ID = "\"id\"";
    private static final String DATA_FIELD_NAME_STATION = "\"allomas\"";
    private static final String DATA_FIELD_NAME_LAT = "\"lat\"";
    private static final String DATA_FIELD_NAME_LON = "\"lng\"";
    private static final String DATA_FIELD_NAME_DESCRIPTION = "\"description\"";
    private static final String DATA_FIELD_NAME_LEVEL = "\"level\"";
    private static final String DATA_FIELD_NAME_GROUP_ID = "\"groupId\"";
    private static final String DATA_FIELD_NAME_STATION_TYPE = "\"stationType\"";

    public BalatonStation(long id, String station, double lat, double lon, String description, int level, String groupId, String stationType) {
        this.id = id;
        this.station = station;
        this.lat = lat;
        this.lon = lon;
        this.description = description;
        this.level = level;
        this.groupId = groupId;
        this.stationType = stationType;
    }

    public BalatonStation() {

    }

    public BalatonStation stationFromString(String[] stationLines) {
        id = parseIdFromString(stationLines[0]);
        station = parseStationFromString(stationLines[1]);
        lat = parseLatFromString(stationLines[2]);
        lon = parseLonFromString(stationLines[3]);
        description = parseDescriptionFromString(stationLines[4]);
        level = parseLevelFromString(stationLines[5]);
        groupId = parseGroupIdFromString(stationLines[6]);
        stationType = parseStationTypeFromString(stationLines[7]);

        return new BalatonStation(id, station, lat, lon, description, level, groupId, stationType);
    }

    private String parseStationTypeFromString(String stationLine) {
        if (!stationLine.contains(DATA_FIELD_NAME_STATION_TYPE)) {
            return "";
        }

        return clearQuotationMarks(split(stationLine));
    }

    private String parseGroupIdFromString(String stationLine) {
        if (!stationLine.contains(DATA_FIELD_NAME_GROUP_ID)) {
            return "";
        }

        return clearQuotationMarks(split(stationLine));
    }

    private int parseLevelFromString(String stationLine) {
        if (!stationLine.contains(DATA_FIELD_NAME_LEVEL)) {
            return 0;
        }

        return Integer.parseInt(split(stationLine));
    }

    private String parseDescriptionFromString(String stationLine) {
        if (!stationLine.contains(DATA_FIELD_NAME_DESCRIPTION)) {
            return "";
        }

        return clearQuotationMarks(split(stationLine));
    }

    private double parseLonFromString(String stationLine) {
        if (!stationLine.contains(DATA_FIELD_NAME_LON)) {
            return 0;
        }

        return Double.parseDouble(clearQuotationMarks(split(stationLine)));
    }

    private double parseLatFromString(String stationLine) {
        if (!stationLine.contains(DATA_FIELD_NAME_LAT)) {
            return 0;
        }

        return Double.parseDouble(clearQuotationMarks(split(stationLine)));
    }

    private String parseStationFromString(String stationLine) {
        if (!stationLine.contains(DATA_FIELD_NAME_STATION)) {
            return "";
        }

        return clearQuotationMarks(split(stationLine));
    }

    private long parseIdFromString(String stationLine) {
        if (!stationLine.contains(DATA_FIELD_NAME_ID)) {
            return 0;
        }

        return Long.parseLong(split(stationLine));
    }

    private String clearQuotationMarks(String str) {
        return str.replaceAll("\"", "");
    }

    private String split(String str) {
        String[] parts = str.split(DATA_SEPARATOR);

        if (parts.length == 2) {
            return removeLastChar(parts[1].trim());
        }

        return "";
    }

    public String removeLastChar(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == LINE_END_CHAR) {
            str = str.substring(0, str.length() - 1);
        }

        return str;
    }

    public int getLevel() {
        return level;
    }

    public String getStation() {
        return station;
    }
}
