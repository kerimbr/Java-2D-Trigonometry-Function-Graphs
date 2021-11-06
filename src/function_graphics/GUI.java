package function_graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JButton showGraphicsButton;
    private JLabel title;
    private JCheckBox sin;
    private JCheckBox cos;
    private JCheckBox tan;
    private JCheckBox cot;
    private JPanel panelMain;

    public GUI() {
        showGraphicsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        FunctionGraphicsPanel functionGraphicsPanel = new FunctionGraphicsPanel(
                                sin.isSelected(),
                                cos.isSelected(),
                                tan.isSelected(),
                                cot.isSelected()
                        );
                        functionGraphicsPanel.setVisible(true);
                    }
                });
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fonksiyon Grafikleri Kullanıcı Arayüzü");
        frame.setContentPane(new GUI().panelMain);
        frame.setSize(1024,768);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
