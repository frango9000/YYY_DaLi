package auxp.ch14;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;

public class Chart2 extends Pane {

    public void paint() {
        double centerX = getWidth() / 2;
        double scaleX = getWidth() / 500;
        double centerY = getHeight() / 2;
        double scaleY = getHeight() / 500;

        ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
                new PieChart.Data("Apple", 13),
                new PieChart.Data("HTC", 25),
                new PieChart.Data("Samsung", 10),
                new PieChart.Data("Others", 22));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Smartphone Brands");

        getChildren().clear();
        getChildren().add(chart);
    }

    @Override
    protected void setWidth(double value) {
        super.setWidth(value);
        paint();
    }

    @Override
    protected void setHeight(double value) {
        super.setHeight(value);
        paint();
    }
}
