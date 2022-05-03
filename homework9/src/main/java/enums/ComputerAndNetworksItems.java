package enums;

public enum ComputerAndNetworksItems {
    LAPTOPS_COMPUTERS_MONITORS("Ноутбуки, компьютеры, мониторы"),//наверное специально без пробела?))
    ACCESSORIES("Комплектующие"),
    DATA_STORAGE("Хранение данных"),
    NETWORK_EQUIPMENT("Сетевое оборудование");

    private final String value;

    ComputerAndNetworksItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
