package MainPacage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

class PauseFinishPage extends JFrame {
    private JPanel pausePanel;
    private PauseFinishButton topButton;
    private PauseFinishButton homeButton;
    public PauseFinishPage(String titlename, String buttonpath) {
        setBackground(Color.BLACK);
        setTitle(titlename);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int laptopWidth = (int) (screenSize.getWidth() * 0.7);
        int laptopHeight = (int) (screenSize.getHeight() * 0.8);

        //타이틀 아이콘 변경
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

        pausePanel = new JPanel();
        pausePanel.setBackground(utility.pausefinishpagecolor);
        pausePanel.setLayout(new GridBagLayout()); // GridBagLayout을 사용
        add(pausePanel, BorderLayout.CENTER);
        GridBagConstraints gbc = new GridBagConstraints();

        //윗 버튼을 인자로 준 경로의 이미지를 이용하여 생성
        topButton = new PauseFinishButton(buttonpath);
        gbc.gridy=1;
        gbc.insets = new Insets(0, 0, 10, 0);
        pausePanel.add(topButton,gbc);

        homeButton = new PauseFinishButton("../image/homebutton.png");
        gbc.gridy=2;
        pausePanel.add(homeButton,gbc);

        setVisible(true);
    }
//    public JPanel getPauseFinishPanel() {
//        return this.pauseFinishPanel;
//    }
}
class FinishPage extends PauseFinishPage{
    private JPanel finishPanel;
    public FinishPage(String titlename, String buttonpath) {
        super(titlename,buttonpath);
        finishPanel = new JPanel();
//        JPanel FinishPanel = getPauseFinishPanel();

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
        Font scorefont = utility.yeongdeok_haeparang(70);
        finishscore.setForeground(utility.maincolor);
        finishscore.setBackground(utility.pausefinishpagecolor);
        finishscore.setFont(scorefont);

        finishPanel.add(finishscore,gbc);

        finishPanel.revalidate();
        finishPanel.repaint();
    }
}
