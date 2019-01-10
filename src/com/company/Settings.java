package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {
    int sizeMap = MyWindow.getSIZE();

    public Settings() {
        setBounds(700 - (42 * sizeMap), 400 - (30 * sizeMap), 400, 200);
        setResizable(false);
        setTitle("Параметры игры");
        ImageIcon img = new ImageIcon("src/15_2.png");
        setIconImage(img.getImage());
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        JPanel upSet = new JPanel();
        getContentPane().add(upSet, BorderLayout.NORTH);
        JPanel mainSet = new JPanel(new GridLayout(4, 1));
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(20, 0));
        getContentPane().add(leftPanel, BorderLayout.WEST);
        getContentPane().add(mainSet, BorderLayout.CENTER);
        JPanel downSet = new JPanel();
        getContentPane().add(downSet, BorderLayout.SOUTH);
        Label difficult = new Label();
        difficult.setFont(new Font("Arial", Font.BOLD, 12));
        difficult.setText("Выберите уровень сложности");
        upSet.add(difficult, BorderLayout.CENTER);
        ButtonGroup bGroup = new ButtonGroup();
        JRadioButton smallLevel = new JRadioButton("Легкий уровень. Классические пятнашки.", true);
        bGroup.add(smallLevel);
        JRadioButton mediumLevel = new JRadioButton("Срядний уровень. Количество фишек увеличено до 35.", false);
        bGroup.add(mediumLevel);
        JRadioButton largeLevel = new JRadioButton("Тяжелый уровень. Количество фишек увеличено до 63.", false);
        bGroup.add(largeLevel);
        mainSet.add(smallLevel);
        mainSet.add(mediumLevel);
        mainSet.add(largeLevel);
        JButton jSetClose = new JButton("Ок");
        downSet.add(jSetClose);
        jSetClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (smallLevel.isSelected() == true) {
                    MyWindow.setSIZE(4);
                    MyWindow.backMusic.stop();
                    new MyWindow();
                }
                if (mediumLevel.isSelected() == true) {
                    MyWindow.setSIZE(6);
                    MyWindow.backMusic.stop();
                    new MyWindow();
                }
                if (largeLevel.isSelected() == true) {
                    MyWindow.setSIZE(8);
                    MyWindow.backMusic.stop();
                    new MyWindow();
                }
                setVisible(false);
            }
        });
        setVisible(true);
    }
}
