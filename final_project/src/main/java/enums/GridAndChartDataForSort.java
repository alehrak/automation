package enums;

public enum GridAndChartDataForSort {
    STRING_COLUMNS("Instrument"),
    TIMESTAMP("Start time"),
    FLOATING_POINT("Avg fill price"),
    INTEGER("Num of executions");

    private final String value;

    GridAndChartDataForSort(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
