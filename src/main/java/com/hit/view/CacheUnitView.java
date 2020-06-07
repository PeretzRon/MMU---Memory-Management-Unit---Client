package com.hit.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.Map;

public class CacheUnitView {

    private PropertyChangeSupport changes;
    private String path;
    private JFrame mainFrame;
    JTextArea textArea;
    JPanel panel;

    public CacheUnitView() {
        changes = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        changes.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        changes.removePropertyChangeListener(pcl);

    }

    public <T> void updateUIData(T t) {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setText(t.toString());
        textArea.setCaretPosition(0);
        mainFrame.invalidate();
    }

    public void start() { // createUI{

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        int posX = dim.width;
        int posY = dim.height;
        mainFrame = new JFrame("CacheUnit - Ayelet & Ron");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon("src\\main\\resources\\main_frame_ico.png");
        mainFrame.setIconImage(img.getImage());
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(3, 3, 3, 3));
        mainFrame.setContentPane(panel);
        panel.setLayout(null);

        // Buttons
        JButton requestBtn = new JButton("Load a Request");
        JButton statisticBtn = new JButton("Show Statistics");
        requestBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        statisticBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        requestBtn.setBounds(50, 173, 244, 78);
        statisticBtn.setBounds(50, 270, 244, 78);
        panel.add(requestBtn);
        panel.add(statisticBtn);

        // Text
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.getVerticalScrollBar().setValue(0);
        panel.add(scroll);
        scroll.setBounds(340, 170, 570, 300);
        scroll.setVisible(true);

        // CopyWrite
        JLabel label = new JLabel("Ayelet Avraham & Ron Peretz");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        label.setBounds(300, 500, 513, 25);
        panel.add(label);

        // Main Title
        JLabel label2 = new JLabel("MMU PROJECT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
        label2.setBounds(270, 20, 600, 150);
        panel.add(label2);

        // Creating the MenuBar and adding components
        JMenuBar bar = new JMenuBar();
        JMenu helpBar = new JMenu("Help");
        bar.add(helpBar);
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        mainFrame.getContentPane().add(BorderLayout.NORTH, bar);
        helpBar.add(aboutItem);
        mainFrame.setJMenuBar(bar);

        // About Window
        aboutItem.addActionListener(new ActionListener() {

            @SuppressWarnings({"unchecked", "rawtypes"})
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aboutFrame = new JFrame("About");
                JPanel panelAbout = new JPanel();
                panelAbout.setBorder(new EmptyBorder(3, 3, 3, 3));
                aboutFrame.setContentPane(panelAbout);
                panelAbout.setLayout(null);

                ImageIcon imageIcon = new ImageIcon("src\\main\\resources\\info.png");
                Image image = imageIcon.getImage();
                Image newimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(newimg);
                JLabel image2 = new JLabel("");
                image2.setBounds(10, 20, 300, 300);
                image2.setIcon(imageIcon);
                panelAbout.add(image2);

                JLabel label3 = new JLabel("MMU PROJECT");

                Font font = new Font("David", Font.BOLD, 40);
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                label3.setFont(font.deriveFont(attributes));
                label3.setForeground(Color.cyan);
                JLabel label4 = new JLabel("Version: 1.0");
                JLabel label6 = new JLabel("Copyright (C) 2018 - Ayelet Avraham, Ron Peretz");
                JLabel label5 = new JLabel("Lecturer: Nissim Brami");
                label4.setFont(new Font("David", Font.BOLD, 18));
                label5.setFont(new Font("David", Font.BOLD, 18));
                label6.setFont(new Font("David", Font.BOLD, 18));
                label3.setBounds(220, 10, 600, 150);
                label4.setBounds(220, 80, 600, 150);
                label5.setBounds(220, 130, 600, 150);
                label6.setBounds(220, 180, 600, 150);
                label4.setForeground(Color.white);
                label5.setForeground(Color.white);
                label6.setForeground(Color.white);
                panelAbout.add(label3);
                panelAbout.add(label4);
                panelAbout.add(label5);
                panelAbout.add(label6);

                JLabel theWallpaper = new JLabel("");
                theWallpaper.setBounds(0, 0, posX, posY);
                theWallpaper.setIcon(new ImageIcon("src\\main\\resources\\windowshd.jpg"));
                panelAbout.add(theWallpaper);

                ImageIcon imgWindowAbout = new ImageIcon("src\\main\\resources\\aboutico.png");
                aboutFrame.setIconImage(imgWindowAbout.getImage());

                aboutFrame.pack();
                aboutFrame.setSize(new Dimension(posX / 3 + 50, posY / 3));
                aboutFrame.setLocationRelativeTo(null);
                Point p = aboutFrame.getLocation();
                aboutFrame.setLocation(p.x + 20, p.y + 60);
                aboutFrame.setVisible(true);

            }
        });

        // Icon
        JLabel image = new JLabel("");
        image.setBounds(100, 10, 513, 150);
        image.setIcon(new ImageIcon("src\\main\\resources\\photo.png"));
        panel.add(image);

        // BackGround
        JLabel theWallpaper = new JLabel("");
        theWallpaper.setBounds(0, 0, posX, posY);
        theWallpaper.setIcon(new ImageIcon("src\\main\\resources\\windowshd.jpg"));
        panel.add(theWallpaper);

        requestBtn.addActionListener(new ActionListener() { // loadFile_Btn

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Json Files", "json"));
                File workingDirectory = new File(System.getProperty("user.dir") + "/src" + "/main");
                fileChooser.setCurrentDirectory(workingDirectory);
                fileChooser.setDialogTitle("Open a request");
                int returnValue = fileChooser.showOpenDialog(mainFrame);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    path = selectedFile.getAbsolutePath();
                    changes.firePropertyChange("path", null, path);
                }
            }
        });

        statisticBtn.addActionListener(new ActionListener() { // statistic_Btn

            @Override
            public void actionPerformed(ActionEvent e) {
                changes.firePropertyChange("showStatistic", null, "showStatistic");
            }
        });

        mainFrame.pack();
        mainFrame.setSize(new Dimension(posX / 2 + 150, posY / 2 + 120));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

}
