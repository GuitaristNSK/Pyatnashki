//package com.company;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Stat extends JFrame {
//    int sizeMap = MyWindow.getSIZE();
//    String name1 = "Kolyan 100";
//
//    public Stat() {
//        setBounds(700 - (42 * sizeMap), 400 - (30 * sizeMap), 600, 200);
//        setResizable(false);
//        setTitle("Статистика игры");
//        ImageIcon img = new ImageIcon("src/15_2.png");
//        setIconImage(img.getImage());
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        JPanel mainPanel = new JPanel();
//        getContentPane().add(mainPanel);
//        JPanel upPanel = new JPanel();
//        getContentPane().add(upPanel, BorderLayout.NORTH);
//        JPanel downPanel = new JPanel();
//        getContentPane().add(downPanel, BorderLayout.SOUTH);
//        JLabel mainLbl = new JLabel("Статистика игры:");
//        upPanel.add(mainLbl, BorderLayout.CENTER);
//        JPanel statPanel = new JPanel(new GridLayout(0, 3));
//        mainPanel.add(statPanel, BorderLayout.CENTER);
//        JLabel simpleLbl = new JLabel("<html>Легкий уровень<br>1. " + name1 + "<br>2. " + name1 + "<br>3. " + name1 + "</html>");
//        simpleLbl.setPreferredSize(new Dimension(170, 100));
//        statPanel.add(simpleLbl);
//        JLabel middleLbl = new JLabel("<html>Средний уровень<br>1. " + name1 + "<br>2. " + name1 + "<br>3. " + name1 + "</html>");
//        middleLbl.setPreferredSize(new Dimension(170, 100));
//        statPanel.add(middleLbl);
//        JLabel largeLbl = new JLabel("<html>Тяжелый уровень<br>1. " + name1 + "<br>2. " + name1 + "<br>3. " + name1 + "</html>");
//        largeLbl.setPreferredSize(new Dimension(170, 100));
//        statPanel.add(largeLbl);
//        JButton okBtn = new JButton("Ok");
////        okBtn.setPreferredSize(new Dimension(100,25));
//        downPanel.add(okBtn, BorderLayout.CENTER);
//        okBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                setVisible(false);
//            }
//        });
//
//        setVisible(true);
//    }
//}
