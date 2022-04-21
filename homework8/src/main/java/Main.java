import enums.AttributeSettingsHistogramAndScatterPlot;
import enums.GridPageBoxes;
import enums.HistogramPageAndScatterPlotIntervals;
import enums.TablesSummaryPage;
import pages.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.authentication();
        SummaryPage summaryPage = new SummaryPage();
        // summaryPage.openTable(TablesSummaryPage.ALGO_PERFORMANCE);
        GridPage gridPage = new GridPage();
        //gridPage.openGridPage();
        // gridPage.openBox(GridPageBoxes.ID);
       // gridPage.openLinesInChart(11);
        HistogramPage histogramPage = new HistogramPage();
        //histogramPage.openHistogramPage();
        //histogramPage.selectionAttribute(AttributeSettingsHistogramAndScatterPlot.AVERAGE_FILL_PRICE);
       // histogramPage.selectionIntervals(HistogramPageAndScatterPlotIntervals.FIVE);
        ScatterPlotPage scatterPlotPage = new ScatterPlotPage();
        //scatterPlotPage.openScatterPlotPage();
        //scatterPlotPage.selectXAttribute(AttributeSettingsHistogramAndScatterPlot.AVERAGE_FILL_PRICE);
        // scatterPlotPage.selectYAttribute(AttributeSettingsHistogramAndScatterPlot.BENCHMARK_PRICE);
        //scatterPlotPage.selectIntervals(HistogramPageAndScatterPlotIntervals.FIVE);
        Thread.sleep(5000);
    }
}
