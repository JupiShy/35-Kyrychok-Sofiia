package Application;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.*;
import java.awt.*;
import Task2.Item2d;
import Task3.View;
import Task3.ViewResult;

/**
 * Вікно з відображенням графіку
 *
 * @author Sofiia Kyrychok
 */
public class GraphFrame extends JFrame {

    private final XYSeries numSeries;

    /**
     * Відображення графіку
     *
     * @param title назва вікна
     */
    public GraphFrame(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(new BorderLayout());

        XYSeriesCollection dataset = new XYSeriesCollection();
        numSeries = new XYSeries("Ratio");
        dataset.addSeries(numSeries);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Graph",
                "Numbers",
                "Amount",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        this.add(chartPanel, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Перемалювати графік
     *
     * @param view нові дані для графіку
     */
    public void updateGraph(View view) {
        numSeries.clear();

        for (Item2d item : ((ViewResult) view).getItems()) {
            numSeries.add(item.getNum(), item.getResult());
        }
        this.repaint();
    }

    /**
     * Створити графік
     *
     * @param view дані для графіку
     */
    public void addData(View view) {
        for (Item2d item : ((ViewResult) view).getItems()) {
            numSeries.add(item.getNum(), item.getResult());
        }
    }
}
