package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class MyWindow extends JFrame{
    static Sound backMusic;
    private static int SIZE = 4;
    private static int count = 0;
    private JPanel panel = new JPanel(new GridLayout(SIZE, SIZE, 3, 3));
    private int[][] numbers = new int[SIZE][SIZE];

    public static int getSIZE() {
        return SIZE;
    }

    public static void setSIZE(int SIZE) {
        MyWindow.SIZE = SIZE;
    }

    public MyWindow() {
        setBounds(700 - (30 * SIZE), 400 - (30 * SIZE), 75 * SIZE, 75 * SIZE);
        setTitle("Пятнашки");
        ImageIcon img = new ImageIcon("src/15_2.png");
        setIconImage(img.getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        panel.setDoubleBuffered(true);
        getContentPane().add(panel);
        File backMusicFile = new File("src/BackMusic.Wav");
        backMusic = new Sound(backMusicFile);
        backMusic.setVolume(0.7f);
        backMusic.play();
        generate();
        repaintMap();
        createMenu();
        setVisible(true);
    }

    public void generate() {
        count = 0;
        Random random = new Random();
        int[] invariants = new int[SIZE * SIZE];
        do {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    numbers[i][j] = 0;
                    invariants[i * SIZE + j] = 0;
                }
            }
            for (int i = 0; i < SIZE * SIZE; i++) {
                int k, l;
                do {
                    k = random.nextInt(SIZE);
                    l = random.nextInt(SIZE);
                } while (numbers[k][l] != 0);
                numbers[k][l] = i;
                invariants[k * SIZE + l] = i;
            }
        } while (!canBeginGame(invariants));
    }

    private boolean canBeginGame(int[] invariants) {
        int sum = 0;
        for (int i = 0; i < SIZE * SIZE; i++) {
            if (invariants[i] == 0) {
                sum += i / 4;
                continue;
            }
            for (int j = 0; j < SIZE * SIZE; j++) {
                if (invariants[j] < invariants[i])
                    sum++;
            }
        }
//        System.out.println(sum % 2 == 0);
        return sum % 2 == 0;
    }

    public void repaintMap() {
        if (!backMusic.isPlaying())
            backMusic.play();
        panel.removeAll();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton button = new JButton(Integer.toString(numbers[i][j]));
                button.setFocusable(false);
                panel.add(button);
                if (numbers[i][j] == 0) {
                    button.setVisible(false);
                } else
                    button.addActionListener(e -> {
                        JButton jButton = (JButton) e.getSource();
                        jButton.setVisible(false);
                        String name = jButton.getText();
                        change(Integer.parseInt(name));
                    });
            }
        }
        panel.validate();
        panel.repaint();
    }

    public boolean checkWin() {
        boolean status = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE - 1 && j > SIZE / 2)
                    break;
                if (numbers[i][j] != i * SIZE + j + 1) {
                    status = false;
                }
            }
        }
        return status;
    }

    public void change(int num) {
        int i = 0, j = 0;
        for (int k = 0; k < SIZE; k++) {
            for (int l = 0; l < SIZE; l++) {
                if (numbers[k][l] == num) {
                    i = k;
                    j = l;
                }
            }
        }
        if (i > 0&&numbers[i - 1][j] == 0 || i < SIZE - 1&&numbers[i + 1][j] == 0 || j > 0&&numbers[i][j - 1] == 0 || j < SIZE - 1&&numbers[i][j + 1] == 0)
            Sound.playSound("src/click.Wav").play();
        else
            Sound.playSound("src/errClick.Wav").play();
        if (i > 0) {
            if (numbers[i - 1][j] == 0) {
                numbers[i - 1][j] = num;
                numbers[i][j] = 0;
                count++;
            }
        }
        if (i < SIZE - 1) {
            if (numbers[i + 1][j] == 0) {
                numbers[i + 1][j] = num;
                numbers[i][j] = 0;
                count++;
            }
        }
        if (j > 0) {
            if (numbers[i][j - 1] == 0) {
                numbers[i][j - 1] = num;
                numbers[i][j] = 0;
                count++;
            }
        }
        if (j < SIZE - 1) {
            if (numbers[i][j + 1] == 0) {
                numbers[i][j + 1] = num;
                numbers[i][j] = 0;
                count++;
            }
        }
        repaintMap();
        if (checkWin()) {
            Sound.playSound("src/Win.wav").play();
            JOptionPane.showMessageDialog(null, "Победа! Количество ходов " + count, "Поздравляем!", JOptionPane.INFORMATION_MESSAGE);
            generate();
            repaintMap();
        }
    }

    public void createMenu() {
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        JMenu jFile = new JMenu("Файл");
        JMenu jHelp = new JMenu("Помощь");
        menu.add(jFile);
        menu.add(jHelp);
        JMenuItem jFileNewGame = new JMenuItem("Новая игра");
        jFile.add(jFileNewGame);
        JMenuItem jFileMusic = new JMenuItem("Вкл/Выкл музыку");
        jFile.add(jFileMusic);
        JMenuItem jFileStatist = new JMenuItem("Статистика");
        jFile.add(jFileStatist);
        JMenuItem jFileSettings = new JMenuItem("Параметры");
        jFile.add(jFileSettings);
        JMenuItem jFileExit = new JMenuItem("Выход");
        jFile.add(jFileExit);
        JMenuItem jHelpRules = new JMenuItem("Правила");
        jHelp.add(jHelpRules);
        JMenuItem jHelpAbout = new JMenuItem("О программе...");
        jHelp.add(jHelpAbout);
        jFileNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generate();
                repaintMap();
            }
        });
        jFileMusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (backMusic.isPlaying()){
//                    backMusic.stop();
//                }else backMusic.play();
                if (backMusic.getVolume()!=0.0f)
                    backMusic.setVolume(0.0f);
                else
                    backMusic.setVolume(0.7f);
            }
        });
        jFileStatist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Раздел в разработке...Или вообще не буду его делать, пока еще не понял.", "Информация", JOptionPane.INFORMATION_MESSAGE);
//                try {
//                    String[] a = readFile("DataStat.txt",2);
//                    for (int i = 0; i < 2; i++) {
//                        System.out.println(a[i]);
//                    }
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
            }
        });
        jFileSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Settings();
                setVisible(false);
            }
        });
        jFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jHelpRules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Цель игры — перемещая фишки по полю, \nдобиться упорядочивания их по номерам, \nжелательно сделав как можно меньше \nперемещений за как можно меньший \nпериод времени", "Правила игры", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        jHelpAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Данная программа написана после прохождения \nкурса Java на портале GeekBrains. \nАвтор: Вострухин Илья", "О программе...", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
