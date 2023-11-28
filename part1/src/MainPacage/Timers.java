package MainPacage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.*;

public class Timers extends JFrame {
    private static final int BAR_WIDTH = 300;
    private static final int BAR_HEIGHT = 30;

    private int timerValue; // 초기 타이머 값 (초)
    private Timer timer;

    private JProgressBar progressBar;
//    private JLabel timerLabel;

    public Timers(int timelimit) {
        //프레임 설정
        setTitle("Timer Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 프로그레스 바 초기화
        progressBar = new JProgressBar(0, timelimit);
        progressBar.setValue(timelimit);
        progressBar.setBackground(utility.basecolor);  // 타이머바 배경 색
        progressBar.setForeground(utility.pointcolor); // 진행 상태 색깔
        progressBar.setPreferredSize(new Dimension(BAR_WIDTH, BAR_HEIGHT));// 타이머 사이즈, FlowLayout()이라서 이렇게 조정해야됨
//        progressBar.setBorder(BorderFactory.createLineBorder(BLACK,3)); //실선(색,두께)
        //progressBar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));//3D
//        progressBar.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        progressBar.setBorderPainted(false);
        //progressBar.setStringPainted(true);  글자(%) 출력

        timerValue=timelimit;

        // 타이머 라벨 초기화
//        timerLabel = new JLabel("Time: " + timerValue + " seconds");

        // 타이머 설정
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerValue--;
                progressBar.setValue(timerValue);

                if (timerValue <= 0) {
                    timer.stop();
                    JOptionPane.showMessageDialog(Timers.this, "Game Over!");
                }
//                } else {
//                    timerLabel.setText("Time: " + timerValue + " seconds");
//                }
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
//        add(timerLabel);
        add(startButton);
    }
}
class Level1Timer extends Timers{
        public Level1Timer(){
            super(30);
        }
}
class Level2Timer extends Timers{
    public Level2Timer(){
        super(90);
    }
}
class Level3Timer extends Timers{
    public Level3Timer(){
        super(180);
    }
}

