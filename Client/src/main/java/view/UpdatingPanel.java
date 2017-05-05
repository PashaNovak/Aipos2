package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by G710 on 25.03.2017.
 */
public class UpdatingPanel extends JPanel{
    final JTextField term = new JTextField(15);
    final JTextArea def = new JTextArea(200, 200);
    final JLabel label = new JLabel();

    public UpdatingPanel (final Controller cont){
        setLayout(null);

        JButton update = new JButton("Update");
        final JScrollPane scrollPane = new JScrollPane(def);

        term.setSize(210,30);
        term.setLocation(10, 10);
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
                String resName = term.getText().trim();
                String resDef = def.getText();
                String result = cont.update(resName, resDef);
                if (result != null) {
                    label.setText("Yours definition updated successful");
                } else {
                    label.setText("Wrong! Please, repeat!");
                }
            }
        });

        add(term);
    //    add(def);
        add(update);
        add(label);
        add(scrollPane);
    }
}
