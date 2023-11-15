package MainPacage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
class PauseFinishPage extends JPanel {
//    private JPanel pauseFinishPanel;
    private PauseFinishButton topButton;
    private PauseFinishButton homeButton;
    public PauseFinishPage(String titlename, String buttonpath) {
//        setBackground(Color.BLACK);
//        setTitle(titlename);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int laptopWidth = (int) (screenSize.getWidth() * 0.7);
        int laptopHeight = (int) (screenSize.getHeight() * 0.8);

        //타이틀 아이콘 변경
//        try {
//            // 이미지 파일을 읽어와서 아이콘 이미지로 설정
//            Image iconImage = ImageIO.read(MainPage.class.getResource("../image/logo.jpg"));
//            setIconImage(iconImage);
//        } catch (Exception e) {
//            // 예외 처리
//            e.printStackTrace();
//        }
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(laptopWidth, laptopHeight);

//        Container contentPane = getContentPane();
//        contentPane.setLayout(new BorderLayout()); // GridBagLayout을 사용
        setLayout(new GridBagLayout());
//        pauseFinishPanel = new JPanel();
        setBackground(utility.pausefinishpagecolor);
//        add(pauseFinishPanel, BorderLayout.CENTER);
        GridBagConstraints gbc = new GridBagConstraints();

        //윗 버튼을 인자로 준 경로의 이미지를 이용하여 생성
        topButton = new PauseFinishButton(buttonpath);
        gbc.gridy=1;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(topButton,gbc);

        homeButton = new PauseFinishButton("../image/homebutton.png");
        gbc.gridy=2;
        //homebutton 이벤트 적용
        homeButton.addActionListener(e -> openNewFrame());
        add(homeButton,gbc);

        setVisible(true);
    }
    //객체의 Panel반환
    public JPanel getPausePanel(){
        return this;
    }
    private void openNewFrame() {
        //현재 객체의 부모요소 찾기
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        currentFrame.setVisible(false);
        // 새로운 프레임 생성
        MainPage homeFrame = new MainPage ("엎어라 뒤집어라_Main Page");

        // 현재 프레임 닫기
//        WindowEvent windowClosing = new WindowEvent((Window) SwingUtilities.getWindowAncestor(this), WindowEvent.WINDOW_CLOSING);
//        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosing);

        // 현재 프레임을 닫지 않고 숨기기만 하기 때문에 새로운 프레임을 닫을 때의 동작을 정의해줍니다.
        homeFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // 새로운 프레임이 닫힐 때 현재 프레임을 다시 보이게 합니다.
                PauseFinishPage.this.setVisible(true);
            }
        });
    }
}
class PausePage{
    private JPanel pausePanel;
    public PausePage() {
        PauseFinishPage pause = new PauseFinishPage("엎어라 뒤집어라_Pause Page","../image/play.png");
        pausePanel = pause.getPausePanel();
        pausePanel.setBackground(utility.pausefinishpagecolor);
    }
    public JPanel getPausePanel(){
        return this.pausePanel;
    }
}
class FinishPage{
    private JPanel finishPanel;
    public FinishPage() {
        PauseFinishPage finish = new PauseFinishPage("엎어라 뒤집어라_Finish Page","../image/replay.png");
        finishPanel = finish.getPausePanel();
        finishPanel.setBackground(utility.pausefinishpagecolor);

        File infofile = new File("c:\\deck_game\\info.txt");
        String scoreContent = "";

        try (BufferedReader br = new BufferedReader(new FileReader(infofile))) {
            String line;
            int currentLine = 1;

            while ((line = br.readLine()) != null) {
                if (currentLine == 3) {
                    // 특정 줄의 내용을 출력하거나 필요한 작업 수행
                    scoreContent = line;
                    System.out.println(line);
                    break;  // 찾았으면 반복문 종료
                }
                currentLine++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 패널에 내용 추가
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
    public JPanel getFinishPanel(){
        return this.finishPanel;
    }
}

//class PausePage{
//    private JPanel pausePanel;
//    public PausePage() {
//        PauseFinishPage pfp = new PauseFinishPage("엎어라 뒤집어라_Pause Page","../image/play.png");
//        pausePanel = pfp.getPausePanel();
//        pausePanel.revalidate();
//        pausePanel.repaint();
//    }
//}

//class FinishPage extends PauseFinishPage{
//    private JPanel finishPanel;
//    public FinishPage(String titlename, String buttonpath) {
//        super(titlename,buttonpath);
//        PauseFinishPage pfp = new PauseFinishPage("엎어라 뒤집어라_Finish Page","../image/replay.png");
//        finishPanel = pfp.getPausePanel();
//
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
//                    System.out.println(line);
//                    break;  // 찾았으면 반복문 종료
//                }
//                currentLine++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // FinishPage에서 PauseFinishPage의 패널에 접근하여 내용 추가
//        JLabel finishscore = new JLabel(scoreContent);
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridy = 0;
//        Font scorefont = utility.yeongdeok_haeparang(70);
//        finishscore.setForeground(utility.maincolor);
//        finishscore.setBackground(utility.pausefinishpagecolor);
//        finishscore.setFont(scorefont);
//
//        finishPanel.add(finishscore,gbc);
//
//        finishPanel.revalidate();
//        finishPanel.repaint();
//    }
//}
