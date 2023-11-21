package MainPacage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timers extends JFrame {
    private static final int BAR_WIDTH = 300;
    private static final int BAR_HEIGHT = 30;

    private int timerValue = 100; // 초기 타이머 값 (초)
    private Timer timer;

    private JProgressBar progressBar;
    private JLabel timerLabel;

    public Timers() {
        setTitle("Timer Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 프로그레스 바 초기화
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(100);
        progressBar.setStringPainted(true);

        // 타이머 라벨 초기화
        timerLabel = new JLabel("Time: " + timerValue + " seconds");

        // 타이머 설정
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerValue--;
                progressBar.setValue(timerValue);

                if (timerValue <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(Timers.this, "Game Over!");
                } else {
                    timerLabel.setText("Time: " + timerValue + " seconds");
                }
            }
        });

        // 시작 버튼 초기화
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        // 레이아웃 설정
        setLayout(new FlowLayout());
        add(progressBar);
        add(timerLabel);
        add(startButton);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Timers().setVisible(true);
//            }
//        });
//    }

}
