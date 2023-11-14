package MainPacage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class MainPage extends JFrame {
    static JPanel leftPanel;
    static LabelStartEvent label_gameStart;
    MainPageLabels label_infoPage;
    static LevelRadiobutton level1;
    static LevelRadiobutton level2;
    static LevelRadiobutton level3;
    static JLabel bgm_label;
    static OnOffButton bgm_on;
    static OnOffButton bgm_off;
    private int laptopWidth;
    private int laptopHeight;
    public MainPage(String titlename) {
        super(titlename);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        laptopWidth = (int) (screenSize.getWidth() * 0.7);
        laptopHeight = (int) (screenSize.getHeight() * 0.8);

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
        contentPane.setLayout(new GridBagLayout()); // GridBagLayout을 사용

        // 메인페이지 왼쪽 panel
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new GridBagLayout()); // GridBagLayout을 사용
        GridBagConstraints gbc = new GridBagConstraints();

        //난이도 선택 라디오 버튼
        level1 = new LevelRadiobutton("하");
        level2 = new LevelRadiobutton("중");
        level3 = new LevelRadiobutton("상");

        gbc.gridx = 0;
        gbc.gridy=0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 70, 0, 0);
        leftPanel.add(level1, gbc);
        gbc.insets = new Insets(0, 130, 0, 0);
        leftPanel.add(level2, gbc);
        gbc.insets = new Insets(0, 190, 0,0);
        leftPanel.add(level3, gbc);

        //게임 시작 label
        LabelStartEvent label_gameStart = new LabelStartEvent("게임 시작");
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        leftPanel.add(label_gameStart, gbc);

        //정보열람 label
        MainPageLabels label_infoPage = new MainPageLabels("정보 열람");
        gbc.gridy = 3;
        leftPanel.add(label_infoPage, gbc);

        //설정 label
        LabelSettingEvent label_setting = new LabelSettingEvent("설정");
        gbc.gridy = 4;
        leftPanel.add(label_setting, gbc);

        //bgm버튼
        bgm_label = new JLabel("bgm");
        Font font_bgmLabel = utility.yeongdeok_sea(19);
        bgm_label.setFont(font_bgmLabel);

        bgm_on = new OnOffButton("On",utility.maincolor);
        bgm_off = new OnOffButton("Off", utility.basecolor);


        bgm_on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼을 클릭했을 때 배경색을 변경합니다.
                bgm_on.setBackground(utility.maincolor); // 색 변경
                bgm_off.setBackground(utility.basecolor);
            }
        });

        bgm_off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 버튼을 클릭했을 때 배경색을 변경합니다.
                bgm_off.setBackground(utility.maincolor); // 색 변경
                bgm_on.setBackground(utility.basecolor);
            }
        });

        // 오른쪽 패널에 이미지 추가 (예제에서는 빈 레이블로 대체)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE); //배경색 흰색으로
        rightPanel.setLayout(new GridBagLayout()); // GridBagLayout을 사용

        //이미지 삽입
        try {
            Image main_page_logo = ImageIO.read(MainPage.class.getResource("../image/yongyong1.png"));
            Image img_logo_scal = main_page_logo.getScaledInstance(370, 400, Image.SCALE_SMOOTH);
            ImageIcon img_logo = new ImageIcon(img_logo_scal);
            JLabel main_logo = new JLabel(img_logo);
            rightPanel.add(main_logo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.weightx = 1.0; // 다른 컴포넌트와의 상대적인 크기 비율 조정
        gbc2.weighty = 1.0;
        gbc2.fill = GridBagConstraints.BOTH; // 두 가지 방향으로 확장
        contentPane.add(leftPanel, gbc2);
        contentPane.add(rightPanel, gbc2);

        setVisible(true);
    }
    public static void main(String[] args) {
        new MainPage("엎어라 뒤집어라_Main Page");
        new PauseFinishPage("엎어라 뒤집어라_Pause Page","../image/play.png");
        new FinishPage("엎어라 뒤집어라_Finish Page","../image/replay.png");
    }
}
