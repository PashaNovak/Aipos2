package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by G710 on 25.03.2017.
 */
public class ReadingPanel extends JPanel{
    final JTextField term = new JTextField(15);
    final JLabel label = new JLabel();
    final JTextArea area = new JTextArea();

    public ReadingPanel (final Controller cont){
        setLayout(null);

        JButton read = new JButton("Read");
        final JScrollPane scrollPane = new JScrollPane(area);
        term.setSize(420,30);
        term.setLocation(10, 10);
        read.setSize(150, 30);
        read.setLocation(440, 10);
        area.setSize(500, 200);
        area.setLocation(100, 80);
        scrollPane.setSize(500, 200);
        scrollPane.setLocation(10, 50);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resName = term.getText().trim();
                String result = cont.read(resName);
                if (result != null) {
                    area.setText(result);
                    System.out.println(result);
                } else {
                    area.setText("Wrong, please repeat!");
                }
            }
        });

        add(term);
        add(scrollPane);
        add(read);
    }
}
