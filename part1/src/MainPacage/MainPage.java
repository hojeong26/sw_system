package MainPacage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

class CustomRadioButton extends JRadioButton {
    public CustomRadioButton(String text) {
        super(text);

        // 라디오 버튼 글꼴
        setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        setFocusPainted(false);

        // 마우스 이벤트 처리
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // 마우스를 올렸을 때 bold체로 설정
                setFont(new Font("맑은 고딕", Font.BOLD, 18));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // 마우스가 벗어났을 때 원래대로 설정
                ButtonModel model = getModel();
                if (!model.isSelected()) {
                    setFont(new Font("맑은 고딕", Font.PLAIN, 18));
                }
            }
        });

        // 이벤트 리스너 추가
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 클릭 시 글꼴을 bold체로 설정
                setFont(new Font("맑은 고딕", Font.BOLD, 18));

                // 다른 라디오 버튼을 선택하면 현재 라디오 버튼의 글꼴을 원래대로 설정
                ButtonModel model = getModel();
                if (!model.isSelected()) {
                    setFont(new Font("맑은 고딕", Font.PLAIN, 18));
                }
            }
        });

        // 아이콘 변경 시 글꼴을 원래대로 설정
        addChangeListener(e -> {
            if (!getModel().isSelected()) {
                setFont(new Font("맑은 고딕", Font.PLAIN, 18));
            }
        });
    }
}

public class MainPage extends JFrame {
    public MainPage() {
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

        setTitle("엎어라 뒤집어라_Main Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(laptopWidth, laptopHeight);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout()); // GridBagLayout을 사용

        // 메인페이지 왼쪽 panel
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new GridBagLayout()); // GridBagLayout을 사용
        GridBagConstraints gbc = new GridBagConstraints();

        //난이도 선택 라디오 버튼
        ButtonGroup levelGroup = new ButtonGroup();
        CustomRadioButton level1 = new CustomRadioButton("하");
        CustomRadioButton level2 = new CustomRadioButton("중");
        CustomRadioButton level3 = new CustomRadioButton("상");

        //font
        level1.setBackground(Color.WHITE);
        level2.setBackground(Color.WHITE);
        level3.setBackground(Color.WHITE);

        levelGroup.add(level1);
        levelGroup.add(level2);
        levelGroup.add(level3);

//        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy=0;
        gbc.insets = new Insets(0, 0, 0, 60);
        leftPanel.add(level1, gbc);
        gbc.insets = new Insets(0, 100, 0, 30);
        leftPanel.add(level2, gbc);
        gbc.insets = new Insets(0, 200, 0, 10);
        leftPanel.add(level3, gbc);

        //게임 시작 label
        JLabel label_gameStart;
        try {
            Image imageFile = ImageIO.read(MainPage.class.getResource("../image/yongyong2.png"));
            Image imgTriangle = imageFile.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon image_triangle = new ImageIcon(imgTriangle);
            label_gameStart = new JLabel("게임 시작", image_triangle, SwingConstants.CENTER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 0, 20, 0);
        label_gameStart.setFont(new Font("맑은 고딕", Font.BOLD, 45));
        leftPanel.add(label_gameStart, gbc);

        JLabel label_infoPage;
        try {
            Image imageFile = ImageIO.read(MainPage.class.getResource("../image/yongyong2.png"));
            Image imgTriangle = imageFile.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon image_triangle = new ImageIcon(imgTriangle);
            label_infoPage = new JLabel("정보 열람", image_triangle, SwingConstants.CENTER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        leftPanel.add(label_infoPage, gbc);
        label_infoPage.setFont(new Font("맑은 고딕", Font.BOLD, 45));

        JLabel label_setting;
        try {
            Image imageFile = ImageIO.read(MainPage.class.getResource("../image/yongyong2.png"));
            Image imgTriangle = imageFile.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon image_triangle = new ImageIcon(imgTriangle);
            label_setting = new JLabel("설정", image_triangle, SwingConstants.CENTER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        leftPanel.add(label_setting, gbc);
        label_setting.setFont(new Font("맑은 고딕", Font.BOLD, 45));


        // 오른쪽 패널에 이미지 추가 (예제에서는 빈 레이블로 대체)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE); //배경색 흰색으로
        rightPanel.setLayout(new GridBagLayout()); // GridBagLayout을 사용

        //이미지 삽입
        try {
            Image main_page_logo = ImageIO.read(MainPage.class.getResource("../image/yongyong1.png"));
            Image img_logo_scal = main_page_logo.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
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

        MainPage mp = new MainPage();
    }
}
