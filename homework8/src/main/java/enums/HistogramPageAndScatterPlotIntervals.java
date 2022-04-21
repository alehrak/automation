package enums;

public enum HistogramPageAndScatterPlotIntervals {
    FIVE(5),
    TEN(10),
    TWENTY_FIVE(25),
    FIFTY(50);

    private final Integer value;

    HistogramPageAndScatterPlotIntervals(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
