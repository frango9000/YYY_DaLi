package auxp.ch17.splitter;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class SplitterTabbedPane extends TabPane {

    public SplitterTabbedPane() {
        Tab join = new Tab("Join");
        join.setContent(new FileSplitPane());
        Tab split = new Tab("Split ");
        split.setContent(new FileSplitPane(true));

        setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        setTabDragPolicy(TabDragPolicy.FIXED);
        getTabs().addAll(split, join);
    }
}
