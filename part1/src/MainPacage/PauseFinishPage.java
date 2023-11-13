package MainPacage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

class PauseFinishPage extends JFrame {
    public JPanel pauseFinishPanel;
    public PauseFinishPage(String titlename) {
        super(titlename);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int laptopWidth = (int) (screenSize.getWidth() * 0.7);
        int laptopHeight = (int) (screenSize.getHeight() * 0.8);

        //타이틀 아이콘 변경
        BufferedImage backgroundImage;
        try {
            // 이미지 파일을 읽어와서 아이콘 이미지로 설정
            Image iconImage = ImageIO.read(MainPage.class.getResource("../image/logo.jpg"));
            setIconImage(iconImage);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(laptopWidth, laptopHeight);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout()); // GridBagLayout을 사용

        pauseFinishPanel = new JPanel();
        pauseFinishPanel.setBackground(new Color(255,255,255,128));
        pauseFinishPanel.setLayout(new GridBagLayout()); // GridBagLayout을 사용
        add(pauseFinishPanel, BorderLayout.CENTER);
        GridBagConstraints gbc = new GridBagConstraints();


        try {
            // 이미지 파일을 읽어와서 ImageIcon으로 설정
            ImageIcon playIcon = new ImageIcon(ImageIO.read(MainPage.class.getResource("../image/playbutton.png")));
            JButton playButton = new JButton(playIcon);
            gbc.gridy=1;
            gbc.insets = new Insets(0, 0, 10, 0);
            playButton.setPreferredSize(new Dimension(200, 50)); // 크기 조절
            playButton.setRolloverEnabled(false);
            playButton.setFocusPainted(false);
            playButton.setBackground(new Color(125,159,104));
            pauseFinishPanel.add(playButton,gbc);

            ImageIcon homeIcon = new ImageIcon(ImageIO.read(MainPage.class.getResource("../image/homebutton.png")));
            JButton homeButton = new JButton(homeIcon);
            gbc.gridy=2;
            homeButton.setPreferredSize(new Dimension(200, 50)); // 크기 조절
            homeButton.setRolloverEnabled(false);
            homeButton.setFocusPainted(false);
            homeButton.setBackground(new Color(125,159,104));
            pauseFinishPanel.add(homeButton,gbc);
        } catch (IOException e) {
            // 예외 처리
            e.printStackTrace();
        }

//        File infofile = new File("c:\\deck_game\\info.txt");
//        String scoreContent = "";
//
//        try (BufferedReader br = new BufferedReader(new FileReader(infofile))) {
//            String line;
//            int currentLine = 1;
//
//            while ((line = br.readLine()) != null) {
//                if (currentLine == 3) {
//                    // 특정 줄의 내용을 출력하거나 필요한 작업 수행
//                    scoreContent = line;
//                    break;  // 찾았으면 반복문 종료
//                }
//                currentLine++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // FinishPage에서 PauseFinishPage의 패널에 접근하여 내용 추가
//        JLabel finishscore = new JLabel(scoreContent);
//        gbc.gridy = 0;
//        Font font = new Font("맑은 고딕", Font.BOLD, 50);
//        finishscore.setFont(font);
//        pauseFinishPanel.add(finishscore,gbc);
//
//        pauseFinishPanel.revalidate();
//        pauseFinishPanel.repaint();

        setVisible(true);
    }
    public JPanel getPauseFinishPanel() {
        return pauseFinishPanel;
    }
}
class FinishPage extends PauseFinishPage{
    public FinishPage(String titlename) {
        super(titlename);

        JPanel FinishPanel = getPauseFinishPanel();

        File infofile = new File("c:\\deck_game\\info.txt");
        String scoreContent = "";

        try (BufferedReader br = new BufferedReader(new FileReader(infofile))) {
            String line;
            int currentLine = 1;

            while ((line = br.readLine()) != null) {
                if (currentLine == 3) {
                    // 특정 줄의 내용을 출력하거나 필요한 작업 수행
                    scoreContent = line;
                    break;  // 찾았으면 반복문 종료
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // FinishPage에서 PauseFinishPage의 패널에 접근하여 내용 추가
        JLabel finishscore = new JLabel(scoreContent);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        Font font = new Font("맑은 고딕", Font.BOLD, 50);
        finishscore.setForeground(new Color(125,159,104));
        finishscore.setBackground(new Color(255,255,255,128));
        finishscore.setFont(font);

        FinishPanel.add(finishscore,gbc);

        FinishPanel.revalidate();
        FinishPanel.repaint();
    }
}
