package enums;

public enum TablesSummaryPage {
    ALGO_PERFORMANCE("Algo Performance"),
    ORDERS_BY_INSTRUMENT_ALGO("Orders by instrument / algo (top 10)"),
    PRICE_IMPROVEMENT_BY_INSTRUMENT_ALGO("Price improvement by instrument / algo (top 10)"),
    PRICE_IMPROVEMENT_BY_CURRENCY("Price improvement by currency"),
    ORDERS_BY_ALGO("Orders by algo"),
    ORDERS_BY_INSTRUMENT("Orders by instrument (top 10)"),
    ALGO_PERFORMANCE_TIMELINE("Algo performance timeline (by 6 hours)"),
    ORDERS_BY_ALGO_TIMELINE("Orders by algo timeline (by 6 hours)");

    private final String value;

    TablesSummaryPage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
