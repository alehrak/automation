package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class HistogramPage {
    private static Logger logger = Logger.getLogger(HistogramPage.class);
    private static final String CSS_COLLECTION_BARS = "g[class='bar_container']";
    private static final String XPATH_BOUNDARIES_AND_ORDERS_BAR = "//div[@class='tooltip']";
    private static final String XPATH_HISTOGRAM_PAGE = "//div[@class='app-title'][text()='Histogram']";


    public void openHistogramPage() {
        $x(XPATH_HISTOGRAM_PAGE).click();
    }

    public ElementsCollection getHistogramElements() {
        ElementsCollection bars = Selenide.$$(CSS_COLLECTION_BARS)
                .shouldHave(CollectionCondition.sizeGreaterThan(1));
        logger.info("count bars on page = " + bars.size());
        return bars;
    }

    public void hoverBar(SelenideElement bar) {
        logger.info("cursor is hovered over the bar = " + bar);
        bar.hover();
    }

    public String[] checkVisibilityBordersAndCountOrders(SelenideElement bar) {
        hoverBar(bar);
        String parameters = $x(XPATH_BOUNDARIES_AND_ORDERS_BAR).getText();
        logger.info("boundaries and orders bar: "+ bar.toString()+ " = " + parameters);
        return parameters.split("\n");
    }
}
