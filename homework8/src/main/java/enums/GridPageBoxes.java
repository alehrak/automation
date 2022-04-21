package enums;

public enum GridPageBoxes {
    ID("Id"),
    TYPE("Type"),
    INSTRUMENT("Instrument"),
    SIDE("Side"),
    AVERAGE_FILL_PRICE("Avg fill price"),
    NUM_OF_EXECUTIONS("Num of executions"),
    ACCOUNT("Account"),
    PARTICIPATION_RATE("Participation rate"),
    EXECUTION_PRICE_VOLATILITY("Execution price volatility"),
    PRICE("Price imp. (amount)");

    private final String value;

    GridPageBoxes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
