package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by G710 on 05.05.2017.
 */
public class UpdatingDialog extends JDialog {

    final JTextArea def = new JTextArea(200, 200);
    final JLabel label = new JLabel();

    public UpdatingDialog(final Controller cont, DataTablePanel table){

        setLayout(null);

        JButton update = new JButton("update");
        final JScrollPane scrollPane = new JScrollPane(def);
        update.setSize(100, 30);
        update.setLocation(230, 10);
        def.setSize(500, 200);
        def.setLocation(10, 50);
        label.setSize(200, 30);
        label.setLocation(300, 10);
        scrollPane.setSize(500, 200);
        scrollPane.setLocation(10, 50);
        def.setLineWrap(true);
        def.setWrapStyleWord(true);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resName = table.dtm.getValueAt(table.table.getSelectedRow(), 0).toString();
                String resDef = def.getText();
                String result = cont.update(resName, resDef);
                if (result != null) {
                    label.setText("Yours definition updated successful");
                } else {
                    label.setText("Wrong, please repeat!");
                }
            }
        });

        add(update);
        add(label);
        add(scrollPane);
    }
}
