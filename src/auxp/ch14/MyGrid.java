package auxp.ch14;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class MyGrid extends Pane {

    private int size;

    public MyGrid() {
        this(8);
    }

    public MyGrid(int size) {
        this.size = size;
    }

    public void paint() {
        double width = getWidth();
        double height = getHeight();

        getChildren().clear();
        for (int i = 1; i < size; i++) {
            // horizontal lines
            double y = (height / size) * i;
            Line h = new Line(0, y, width, y);
            // vertical lines
            double x = (width / size) * i;
            Line v = new Line(x, 0, x, height);

            getChildren().addAll(h, v);
        }
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
