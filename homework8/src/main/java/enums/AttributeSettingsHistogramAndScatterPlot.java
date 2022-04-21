package enums;

public enum AttributeSettingsHistogramAndScatterPlot {
    AVERAGE_FILL_PRICE("Avg fill price"),
    EXEC_SIZE("Exec size"),
    NUM_OF_EXECUTIONS("Num of executions"),
    PRICE("Price"),
    SIZE("Size"),
    EXECUTION_PRICE_VOLATILITY("Execution price volatility"),
    PERMANENT_MARKET_IMPACT("Permanent market impact"),
    REALIZED_MARKET_IMPACT("Realized market impact"),
    PARTICIPATION_RATE("Participation rate"),
    SHORTFALL("Shortfall"),
    MULTIPLIER("Multiplier"),
    TICK_SIZE("Tick size"),
    CURRENCY_CODE("Currency code"),
    SEQUENCE_NUMBER("Sequence number"),
    DB_SEQUENCE_NUMBER("Db sequence number"),
    BENCHMARK_PRICE("Benchmark price"),
    PRICE_TICKS("Price imp. (ticks)"),
    PRICE_AMOUNT("Price imp. (amount)");

    private final String value;

    AttributeSettingsHistogramAndScatterPlot(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
