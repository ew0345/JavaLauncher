package main;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TomeCalc {
    JFrame container;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TomeCalc window = new TomeCalc();
                window.container.setVisible(true);

                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Windows".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {}
        });
    }

    public TomeCalc() {
        initialize();
        container.setTitle("Tome Calc");
    }

    private void initialize() {
        container = new JFrame();
        container.setResizable(false);
        container.setBounds(100, 100, 250, 215);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.getContentPane().setLayout(null);
        container.setLocationRelativeTo(null);

        ImageIcon icon3 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(SCC.class.getResource("/main/Icon3.png")));

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 250, 20);
        container.getContentPane().add(mb);

        JMenu mFile = new JMenu("File");
        mb.add(mFile);

        JMenuItem miReturn = new JMenuItem("Return to Launcher");
        mFile.add(miReturn);

        JLabel lUserLevel = new JLabel("User Level");
        lUserLevel.setBounds(4, 35, 90, 14);
        container.getContentPane().add(lUserLevel);

        JSpinner userLevel = new JSpinner();
        userLevel.setBounds(94, 32, 51, 20);
        userLevel.setValue(120);
        container.getContentPane().add(userLevel);

        JLabel lSpotLevel = new JLabel("Spot Level");
        lSpotLevel.setBounds(4, 60, 99, 14);
        container.getContentPane().add(lSpotLevel);

        JSpinner spotLevel = new JSpinner();
        spotLevel.setBounds(94, 57, 51, 20);
        spotLevel.setValue(120);
        container.getContentPane().add(spotLevel);

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(34, 85, 89, 23);
        container.getContentPane().add(btnCalculate);

        JLabel chance = new JLabel("%");
        chance.setVisible(false);
        chance.setBounds(34, 120, 200, 20);
        container.getContentPane().add(chance);

        JLabel image = new JLabel(new ImageIcon(icon3.getImage()));
        image.setBounds(150, 35, 90, 50);
        container.getContentPane().add(image);

        JLabel madeby = new JLabel("Made by Ew0345");
        madeby.setBounds(150, 89, 86, 14);
        container.getContentPane().add(madeby);

        userLevel.addChangeListener((ChangeEvent e) -> {
            if ((int) userLevel.getValue() <= 0) userLevel.setValue(1);
            if ((int) userLevel.getValue() >= 121) userLevel.setValue(120);
        });

        spotLevel.addChangeListener((ChangeEvent e) -> {
            if ((int) spotLevel.getValue() <= 0) spotLevel.setValue(1);
            if ((int) spotLevel.getValue() >= 121) spotLevel.setValue(120);
        });

        btnCalculate.addActionListener((ActionEvent e) -> {
            double ul = (int) userLevel.getValue();
            double sl = (int) spotLevel.getValue();

            BigDecimal tc = new BigDecimal((ul + sl) / 250000);
            tc = tc.setScale(6, RoundingMode.CEILING);
            chance.setText("Tome Chance: "+tc+"%");
            chance.setVisible(true);
        });

        miReturn.addActionListener((ActionEvent e) -> {
            Launcher.main(null);
            this.container.dispose();
        });
    }
}