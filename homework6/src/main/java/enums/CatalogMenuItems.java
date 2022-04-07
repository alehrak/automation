package enums;

public enum CatalogMenuItems {
    ELECTRONICS("Электроника"),
    COMPUTERS_AND_NETWORKS("Компьютеры и сети"),
    APPLIANCES("Бытовая техника"),
    CONSTRUCTION_AND_REPAIR("Стройка и ремонт"),
    HOUSE_AND_GARDEN("Дом и сад"),
    AUTO_AND_MOTO("Авто и мото"),
    BEAUTY_AND_SPORTS("Красота и спорт"),
    CHILDREN_AND_MOTHERS("Детям и мамам"),
    WORK_AND_OFFICE("Работа и офис"),
    FOOD("Еда");

    private final String value;

    CatalogMenuItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
