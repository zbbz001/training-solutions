package stringmethods.url;

public class UrlManager {
    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;

    private final static String PROTOCOL_DELIMITER = "://";
    private final static String QUERY_DELIMITER = "?";
    private final static String PORT_DELIMITER = ":";

    public UrlManager(String url) {
        protocol = getProtocolFromUrl(url);
        port = getPortFromUrl(url);
        host = getHostFromUrl(url);
        path = getPathFromUrl(url);
        query = getQueryFromUrl(url);
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public String getQuery() {
        return query;
    }

    public boolean hasProperty(String key) {
        if(key == null || key.isBlank()) {
            throw new IllegalArgumentException("upsz");
        }

        return getQuery().contains("&" + key + "=") || getQuery().contains("?" + key + "=");
    }

    public String getProperty(String key) {
        if(key == null || key.isBlank()) {
            throw new IllegalArgumentException("upsz");
        }

        String[] queryElements = getQuery().substring(1).split("&");

        for(String queryElement:queryElements) {
            String[] queryElementTags = queryElement.split("=");
            if(queryElementTags.length != 2) {
                return null;
            }

            if(queryElementTags[0].equals(key)) {
                return queryElementTags[1];
            }
        }

        return null;
    }

    public String getProtocolFromUrl(String url) {
        int index = url.indexOf(PROTOCOL_DELIMITER);

        if (index == -1) {
            throw new IllegalArgumentException("Invalid url");
        }

        String protocol = url.substring(0, index);

        return protocol.toLowerCase();
    }

    public String getHostFromUrl(String url) {
        int portIndex;
        int index = url.indexOf(PROTOCOL_DELIMITER) + PROTOCOL_DELIMITER.length();
        url = url.substring(index);

        if (url.isBlank()) {
            throw new IllegalArgumentException("Invalid url");
        }

        int endIndex = url.indexOf("/");
        if (endIndex == -1) {
            portIndex = url.indexOf(PORT_DELIMITER);
            if (portIndex == -1) {
                return url.toLowerCase();
            }

            return url.substring(0, portIndex).toLowerCase();
        }

        url = url.substring(0, endIndex);
        portIndex = url.indexOf(PORT_DELIMITER);

        if (portIndex == -1) {
            return url.toLowerCase();
        }

        return url.substring(0, portIndex).toLowerCase();
    }

    public String getPathFromUrl(String url) {
        int index = url.indexOf(PROTOCOL_DELIMITER) + PROTOCOL_DELIMITER.length();
        url = url.substring(index);

        int endIndex = url.indexOf("/");
        if (endIndex == -1) {
            return "";
        }

        url = url.substring(endIndex);

        int queryIndex = url.indexOf(QUERY_DELIMITER);
        if (queryIndex == -1) {
            return url.toLowerCase();
        }

        return url.substring(0, queryIndex).toLowerCase();
    }

    public Integer getPortFromUrl(String url) {
        int index = url.indexOf(PROTOCOL_DELIMITER) + PROTOCOL_DELIMITER.length();
        url = url.substring(index);

        int portIndex = url.indexOf(PORT_DELIMITER);
        if (portIndex == -1) {
            return null;
        }

        int endIndex = url.indexOf("/");
        if (endIndex == -1) {
            return Integer.parseInt(url.substring(portIndex + 1));
        }

        return Integer.parseInt(url.substring(portIndex + 1, endIndex));
    }

    public String getQueryFromUrl(String url) {
        int index = url.indexOf(QUERY_DELIMITER);

        if (index == -1) {
            return null;
        }

        return url.substring(index);
    }
}
