package MainPacage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

/**
 * 테스트용 클래스
 * 게임화면 클래스라 생각하고 기능 재현
 * 버튼을 누르면 버튼에 맞는 Panel(일시정지 Panel,종료 Panel)이 생김
 */
class TestFrame extends JFrame{
    private JPanel existingPanel;
    public TestFrame(String text){
        super(text);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int laptopWidth = (int) (screenSize.getWidth() * 0.7);
        int laptopHeight = (int) (screenSize.getHeight() * 0.8);
        Container contentPane = getContentPane();

        //타이틀 아이콘 변경
        try {
            // 이미지 파일을 읽어와서 아이콘 이미지로 설정
            Image iconImage = ImageIO.read(MainPage.class.getResource("../image/logo.jpg"));
            setIconImage(iconImage);
        } catch (Exception e) {
            // 예외 처리
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(laptopWidth, laptopHeight);


        existingPanel = new JPanel();
        existingPanel.setBackground(utility.basecolor);
        existingPanel.setLayout(new CardLayout());
        contentPane.setLayout(new CardLayout());

        JButton pausePanelButton = new JButton("일시정지");
        pausePanelButton.addActionListener(e -> addpausePanel());
        JButton finishPanelButton = new JButton("종료");
        finishPanelButton.addActionListener(e -> addfinishPanel());

        JPanel buttonPanel = new JPanel();
        existingPanel.add(buttonPanel);
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.add(pausePanelButton);
        buttonPanel.add(finishPanelButton);

        existingPanel.add(buttonPanel, "buttonPanel");
        contentPane.add(existingPanel);

        setVisible(true);
    }
    private void addpausePanel() {
        // 새로운 패널 생성
        PausePage pausePanel = new PausePage();

        // 기존 패널에 새로운 패널 추가
        existingPanel.add(pausePanel.getPausePanel(),"pausePanel");

        CardLayout cardLayout = (CardLayout) existingPanel.getLayout();
        cardLayout.show(existingPanel, "pausePanel");
        // 기존 패널을 다시 그리기
//        revalidate();
//        repaint();
    }
    private void addfinishPanel() {
        // 새로운 패널 생성
        FinishPage finishPanel = new FinishPage();

        // 기존 패널에 새로운 패널 추가
        existingPanel.add(finishPanel.getFinishPanel(), "finishPanel");

        // 카드를 새로운 패널로 전환
        CardLayout cardLayout = (CardLayout) existingPanel.getLayout();
        cardLayout.show(existingPanel, "finishPanel");

        // 기존 패널을 다시 그리기
//        revalidate();
//        repaint();
    }
}