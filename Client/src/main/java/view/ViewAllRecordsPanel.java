package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by G710 on 01.04.2017.
 */
public class ViewAllRecordsPanel extends JPanel {
    final JTextArea def = new JTextArea(200, 200);

    public ViewAllRecordsPanel (final Controller cont){
        setLayout(null);
        JScrollPane scrollPane = new JScrollPane(def);
        JButton watch = new JButton("All");

        watch.setSize(70,30);
        watch.setLocation(10, 220);
        def.setSize(500, 200);
        def.setLocation(10, 10);
        scrollPane.setSize(500, 200);
        scrollPane.setLocation(10, 10);

        def.setLineWrap(true);
        def.setWrapStyleWord(true);

        watch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = cont.read("ALL");
                if (result != null) {
                    def.setText(result);
                } else {
                    def.setText("Wrong! Please, repeat!");
                }
            }
        });

        add(watch);
        add(scrollPane);
    }
}
