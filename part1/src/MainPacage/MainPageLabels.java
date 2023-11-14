package MainPacage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import static MainPacage.MainPage.leftPanel;

public class MainPageLabels extends JLabel {
    private final String imagepath = "../image/button.png";
    Font MainPageLabelfont = utility.yeongdeok_haeparang(45);

    public MainPageLabels(String text){
        super(text);
        try {
            Image imageFile = ImageIO.read(MainPage.class.getResource(imagepath));
            Image imgButton = imageFile.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            ImageIcon image_button = new ImageIcon(imgButton);
            setIcon(image_button);
            setHorizontalAlignment(SwingConstants.CENTER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setFont(MainPageLabelfont);
    }
}
class LabelStartEvent extends MainPageLabels {
    static UnselectedMessage message;
    public LabelStartEvent(String text) {
        super(text);
        addEventListenersUnselectedMessage();
    }

    public void addEventListenersUnselectedMessage() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //leftPanel에 있는 모든 컴포넌트 리스트로 묶음
                Component[] components = leftPanel.getComponents();
                boolean containsMessage = false;

                for (Component component : components) {
                    if (component == message) {
                        containsMessage = true;
                        break;
                    }
                }
                // 라디오 버튼이 선택되지 않거나 message가 leftPanel에 있지 않는 경우 아래에 메시지 생성
                if (!MainPage.level1.isSelected() && !MainPage.level2.isSelected() && !MainPage.level3.isSelected() && !containsMessage) {
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 2; // label_gameStart 아래에 위치하도록 함
                    gbc.anchor = GridBagConstraints.WEST;
                    gbc.insets = new Insets(-13, 80, 10, 0);
                    message = new UnselectedMessage("난이도를 선택해주세요.");
                    leftPanel.add(message, gbc);
                    leftPanel.revalidate();
                    leftPanel.repaint();
                }
            }
        });
    }
}
class LabelSettingEvent extends MainPageLabels {
    public LabelSettingEvent(String text) {
        super(text);
        addEventListeners();
    }

    public void addEventListeners() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (MainPage.bgm_on.getParent() == null) {
                    GridBagConstraints gbc3 = new GridBagConstraints();
                    gbc3.gridx = 0;
                    gbc3.gridy = 4;
                    gbc3.anchor = GridBagConstraints.NORTH;
                    gbc3.insets = new Insets(0, 100, 0, 0);
                    leftPanel.add(MainPage.bgm_label, gbc3);

                    // bgm_on, bgm_off 버튼 추가
                    gbc3.anchor = GridBagConstraints.SOUTH;
                    gbc3.insets = new Insets(0, 105, 15, 0);
                    leftPanel.add(MainPage.bgm_on, gbc3);

                    gbc3.insets = new Insets(0, 190, 15, 0);
                    leftPanel.add(MainPage.bgm_off, gbc3);
                    leftPanel.revalidate();
                    leftPanel.repaint();
                }else{
                    leftPanel.remove(MainPage.bgm_on);
                    leftPanel.remove(MainPage.bgm_off);
                    leftPanel.remove(MainPage.bgm_label);
                    leftPanel.revalidate();
                    leftPanel.repaint();
                }
            }
        });
    }
}