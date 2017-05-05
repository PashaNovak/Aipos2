package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by G710 on 25.03.2017.
 */
public class DeletingPanel extends JPanel{
    final JTextField term = new JTextField(15);
    final JLabel label = new JLabel();

    public DeletingPanel (final Controller cont){
        setLayout(null);

        JButton delete = new JButton("Delete");

        term.setSize(200,30);
        term.setLocation(10, 10);
        delete.setSize(90, 30);
        delete.setLocation(210, 10);
        label.setSize(200, 30);
        label.setLocation(50, 10);

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resName = term.getText().trim();
                String result = cont.delete(resName);
                if (result != null) {
                    label.setText("Definition deleted successful");
                } else {
                    label.setText("Wrong! Please, repeat!");
                }
            }
        });

        add(term);
        add(label);
        add(delete);
    }
}
