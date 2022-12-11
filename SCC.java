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

public class SCC {
    JFrame container;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SCC window = new SCC();
                window.container.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}
    }

    public SCC() {
        initialize();
        container.setTitle("SCC");
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
        userLevel.setValue(100);
        container.getContentPane().add(userLevel);

        JLabel lEnemyLevel = new JLabel("Enemy Level");
        lEnemyLevel.setBounds(4, 60, 99, 14);
        container.getContentPane().add(lEnemyLevel);

        JSpinner enemyLevel = new JSpinner();
        enemyLevel.setBounds(94, 57, 51, 20);
        enemyLevel.setValue(100);
        container.getContentPane().add(enemyLevel);

        JButton btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(34, 85, 89, 23);
        container.getContentPane().add(btnCalculate);

        JLabel chance = new JLabel("%");
        chance.setVisible(false);
        chance.setBounds(34, 120, 200, 20);
        container.getContentPane().add(chance);

        JCheckBox gameGen = new JCheckBox("Gen 7+");
        gameGen.setVisible(true);
        gameGen.setBounds(10, 140, 61, 13);
        container.getContentPane().add(gameGen);

        JCheckBox iceType = new JCheckBox("User is Ice Type");
        iceType.setVisible(true);
        iceType.setBounds(85, 140, 102, 13);
        container.getContentPane().add(iceType);

        JLabel image = new JLabel(new ImageIcon(icon3.getImage()));
        image.setBounds(150, 35, 90, 50);
        container.getContentPane().add(image);

        JLabel madeby = new JLabel("Made by Ew0345");
        madeby.setBounds(150, 89, 86, 14);
        container.getContentPane().add(madeby);

        userLevel.addChangeListener((ChangeEvent e) -> {
            if ((int) userLevel.getValue() > 100) userLevel.setValue(100);
            if ((int) userLevel.getValue() < 1) userLevel.setValue(1);
        });

        enemyLevel.addChangeListener((ChangeEvent e) -> {
            if ((int) enemyLevel.getValue() > 100) enemyLevel.setValue (100);
            if ((int) enemyLevel.getValue() < 1) enemyLevel.setValue(1);
        });

        btnCalculate.addActionListener((ActionEvent e) -> {
            int acc = ((int) userLevel.getValue() - (int) enemyLevel.getValue()) + 30;

            if (gameGen.isSelected() && !iceType.isSelected()) acc -= 10;

            if (acc > 100) acc = 100;
            if (acc < 0) acc = 0;

            if ((int) userLevel.getValue() < (int) enemyLevel.getValue()) acc = 0;

            chance.setText("Chance to hit: "+acc+"%");
            chance.setVisible(true);
        });

        miReturn.addActionListener((ActionEvent e) -> {
            Launcher.main(null);
            this.container.dispose();
        });
    }
}