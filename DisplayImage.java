package JDBC;

import JDBC.Project.ConnectionProvider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DisplayImage extends javax.swing.JFrame {
    private JButton Button;
    private JTextField Field;
    private JLabel ImageLable;
    private JPanel panel;

    public DisplayImage() {
        initComponents();
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = Field.getText().trim();
                int id = Integer.parseInt(str);
                ImageIcon icon = Helper.getImageIconById(id, ConnectionProvider.getConnection());
                if (icon == null) {
                    JOptionPane.showMessageDialog(null, "No image is found of your id");
                } else {
                    ImageLable.setIcon(icon);
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Create components
//        Button = new JButton("Get Image");
//        Field = new JTextField(15); // Text field with 15 columns
//        ImageLable = new JLabel();
        panel = new JPanel();

        // Set layout for the panel
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // Add components to the panel
        panel.add(new JLabel("Enter Image ID:")); // Optional label for clarity
        panel.add(Field);
        panel.add(Button);
        panel.add(ImageLable);

        // Add the panel to the frame
        this.add(panel);

        // Set default close operation and frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400); // Set a preferred size for the window

        // Center the frame on screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DisplayImage f = new DisplayImage();
                f.setVisible(true);
            }
        });


    }

}
