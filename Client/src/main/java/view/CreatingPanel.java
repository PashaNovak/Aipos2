package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatingPanel extends JPanel {

    final JTextField term = new JTextField(15);
    final JTextArea def = new JTextArea(200, 200);
    final JLabel label = new JLabel();
    public String nameDef = "";

    public CreatingPanel (final Controller cont){
        setLayout(null);

        JButton create = new JButton("create");
        JScrollPane scrollPane = new JScrollPane(def);

        term.setSize(300,30);
        term.setLocation(10, 10);
        create.setSize(100, 30);
        create.setLocation(320, 10);
        def.setSize(500, 200);
        def.setLocation(10, 50);
        label.setSize(200, 30);
        label.setLocation(390, 10);
        scrollPane.setSize(500, 200);
        scrollPane.setLocation(10, 50);
        def.setLineWrap(true);
        def.setWrapStyleWord(true);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resName = term.getText().trim();
                String resDef = def.getText();
                String result = cont.create(resName, resDef);
                if (result != null) {
                    label.setText("Yours definition created successful");
                } else {
                    label.setText("Wrong! Please, repeat!");
                }
            }
        });

        add(term);
        //add(def);
        add(create);
        add(label);
        add(scrollPane);
    }

    public String nameDefinition(){
        nameDef = term.getText();
        return nameDef;
    }
}
