package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created by G710 on 25.03.2017.
 */
public class Main extends JFrame {
    private Controller cont;

    public Main() throws HeadlessException {
        super("Information guide on local area network technologies");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(
                Toolkit.getDefaultToolkit().getScreenSize().width / 5 * 2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 5 * 2));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        cont = new Controller();

        add(createTabbedPane(), BorderLayout.CENTER);
        setVisible(true);
    }

    private Component createTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
        tabbedPane.addTab("Create", null, new CreatingPanel(cont), "Create new record");
        tabbedPane.addTab("Read", null, new ReadingPanel(cont), "Read existing record");
        tabbedPane.addTab("Update", null, new UpdatingPanel(cont), "Update existing record");
        tabbedPane.addTab("Delete", null, new DeletingPanel(cont), "Delete existing record");
        tabbedPane.addTab("All", null, new ViewAllRecordsPanel(cont), "Watch all records");
        tabbedPane.addTab("Table", null, new DataTablePanel(cont), "Table with data");
        return tabbedPane;
    }
}

