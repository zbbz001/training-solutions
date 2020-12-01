package defaultconstructor.date;

public class SimpleDateFormatter {
    private static final CountryCode DEFAULT_COUNTRY_CODE = CountryCode.HU;

    public SimpleDateFormatter() {

    }

    public String formatDateString(SimpleDate simpleDate) {
        return formatDateStringByCountryCode(DEFAULT_COUNTRY_CODE, simpleDate);
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        if(countryCode == CountryCode.HU) {
            return simpleDate.getYear() + "-" + simpleDate.getMonth() + "-" + simpleDate.getDay();
        } else if(countryCode == CountryCode.EN) {
            return simpleDate.getDay() + "-" + simpleDate.getMonth() + "-" + simpleDate.getYear();
        } else {
            return simpleDate.getMonth() + "-" + simpleDate.getDay() + "-" + simpleDate.getYear();
        }
    }
}
