package view;

import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataTablePanel extends JPanel {
    DefaultTableModel dtm = new DefaultTableModel(new String[] {"Name"}, 0);
    JTable table = new JTable(dtm);
    JScrollPane scrollPane = new JScrollPane(table);
    String[] newData = new String[1];

    public DataTablePanel(final Controller cont){
        setLayout(null);
        //table.setBounds(300, 200, 200, 200);
        table.setSize(500, 200);

        JButton create = new JButton("Create");
        JButton update = new JButton("Update");
        JButton delete = new JButton("Delete");
        JButton read = new JButton("Read");

        scrollPane.setSize(500, 200);
        create.setSize(100, 30);
        update.setSize(100, 30);
        delete.setSize(100, 30);
        read.setSize(100, 30);

        scrollPane.setLocation(10, 10);
        create.setLocation(520, 10);
        update.setLocation(520, 50);
        delete.setLocation(520, 90);
        read.setLocation(520, 130);

        CreatingDialog creatingDialog = new CreatingDialog(cont, this);
        UpdatingDialog updatingDialog = new UpdatingDialog(cont, this);

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creatingDialog.setVisible(true);
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRowCount() > 1){
                    JOptionPane.showMessageDialog(null, "Please, choose only one term!");
                } else if (table.getSelectedRowCount() == 1){
                    updatingDialog.setVisible(true);
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = cont.delete(dtm.getValueAt(table.getSelectedRow(), 0).toString());
                if (result != null){
                    dtm.removeRow(table.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "This definition was deleting successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong, please repeat!");
                }

            }
        });

        read.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(scrollPane);
        add(create);
        add(update);
        add(delete);
        add(read);
    }
}
