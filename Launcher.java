package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;

public class Launcher {
    JFrame container;
    final String version = "1.0.0";
    private static String open = "";

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
    }

    public Launcher() {
        initialize();
        container.setTitle("Launcher");
    }

    private void initialize() {
        // Setup JFrame
        container = new JFrame();
        container.setResizable(false);
        container.setBounds(100, 100, 380, 215);
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.getContentPane().setLayout(null);
        container.setLocationRelativeTo(null);

        // Setup UI Elements
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 380, 20);
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
        btnOpenSCC.setHorizontalAlignment(SwingConstants.LEFT);
        btnOpenSCC.setBounds(0, 30, 95, 28);
        container.getContentPane().add(btnOpenSCC);

        JButton btnOpenArch = new JButton("Open Tome Calc");
        btnOpenArch.setToolTipText("Open the RS3 Archaeology Tome Calculator");
        btnOpenArch.setBounds(0, 60, 115, 28);
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