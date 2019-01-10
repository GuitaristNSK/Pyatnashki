//package com.company;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Statistics extends JFrame {
//    int sizeMap = MyWindow.getSIZE();
//
//    public Statistics() {
//        setBounds(700 - (42 * sizeMap), 400 - (30 * sizeMap), 600, 200);
//        setResizable(false);
//        setTitle("Статистика игры");
//        ImageIcon img = new ImageIcon("src/15_2.png");
//        setIconImage(img.getImage());
//        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//        JPanel upSet = new JPanel();
//        getContentPane().add(upSet, BorderLayout.NORTH);
//        JPanel mainSet = new JPanel();
//        JPanel leftPanel = new JPanel();
//        JPanel rightPanel = new JPanel();
//        leftPanel.setPreferredSize(new Dimension(20, 0));
//        rightPanel.setPreferredSize(new Dimension(20,0));
//        getContentPane().add(leftPanel, BorderLayout.WEST);
//        getContentPane().add(rightPanel, BorderLayout.EAST);
//        getContentPane().add(mainSet, BorderLayout.CENTER);
//        JPanel downSet = new JPanel();
//        getContentPane().add(downSet, BorderLayout.SOUTH);
//        Label difficult = new Label();
//        difficult.setFont(new Font("Arial", Font.BOLD, 12));
//        difficult.setText("Статистика игры" + sizeMap);
//        upSet.add(difficult, BorderLayout.CENTER);
//        JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
//        JPanel panelSimple = new JPanel();
//        jTabbedPane.add("Легкий уровень", panelSimple);
//        JPanel panelMid = new JPanel();
//        jTabbedPane.add("Средний уровень", panelMid);
//        JPanel panelHard = new JPanel();
//        jTabbedPane.add("Тяжелый уровень", panelHard);
//        JLabel simpleLabel = new JLabel();
//        simpleLabel.setFont(new Font("Arial", Font.BOLD, 12));
//        simpleLabel.setText("1. Колян\t\t999\n2. Илюха\t\t888");
//        panelSimple.add(simpleLabel, BorderLayout.CENTER);
//        mainSet.add(jTabbedPane);
//
//        JButton jSetClose = new JButton("Ок");
//        downSet.add(jSetClose);
//        jSetClose.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//            }
//        });
//
//        setVisible(true);
//    }
//}
