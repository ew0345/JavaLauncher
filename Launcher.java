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
import javax.swing.JOptionPane;
import java.io.IOException;

public class Launcher {
    JFrame container;
    final String version = "1.0.1";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Launcher window = new Launcher();
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

        /*try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}*/
    }

    public Launcher() {
        initialize();
        container.setTitle("Launcher");
    }

    private void initialize() {
        // Setup JFrame
        container = new JFrame();
        container.setResizable(false);
        container.setBounds(100, 100, 250, 215);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.getContentPane().setLayout(null);
        container.setLocationRelativeTo(null);

        ImageIcon icon3 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(Launcher.class.getResource("/main/Icon3.png")));

        JLabel image = new JLabel(new ImageIcon(icon3.getImage()));
        image.setBounds(150, 35, 90, 50);
        container.getContentPane().add(image);

        JLabel madeby = new JLabel("Made by Ew0345");
        madeby.setBounds(150, 89, 86, 14);
        container.getContentPane().add(madeby);

        // Setup UI Elements
       JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 250, 20);
        container.getContentPane().add(mb);

        JMenu mFile = new JMenu("File");
        mb.add(mFile);

        JMenuItem miAbout = new JMenuItem("About");
        mFile.add(miAbout);

        JSeparator hs = new JSeparator();
        mFile.add(hs);

        JMenuItem miExit = new JMenuItem("Exit");
        mFile.add(miExit);

        JButton btnOpenSCC = new JButton("Open SCC");
        btnOpenSCC.setToolTipText("Opens the Sheer Cold Calculator");
        btnOpenSCC.setBounds(10, 30, 95, 28);
        container.getContentPane().add(btnOpenSCC);

        JButton btnOpenArch = new JButton("Open Tome Calc");
        btnOpenArch.setToolTipText("Open the RS3 Archaeology Tome Calculator");
        btnOpenArch.setBounds(10, 60, 115, 28);
        container.getContentPane().add(btnOpenArch);


        // Action Listeners
        btnOpenSCC.addActionListener((ActionEvent e) -> {
            SCC.main(null);
            this.container.dispose();
        });

        btnOpenArch.addActionListener((ActionEvent e) -> {
            TomeCalc.main(null);
            this.container.dispose();
        });

        // Menu Bar
        miAbout.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Made By: Ew0345\nVersion: "+version, "About", 3, null);
        });
        miExit.addActionListener((ActionEvent e) -> {
            this.container.dispose();
});
    }
}
