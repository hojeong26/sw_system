package MainPacage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class MainPageLabels extends JLabel {
    public MainPageLabels(String text, String imagepath){
        super(text);
        try {
            Image imageFile = ImageIO.read(MainPage.class.getResource(imagepath));
            Image imgTriangle = imageFile.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon image_triangle = new ImageIcon(imgTriangle);
            setIcon(image_triangle);
            setHorizontalAlignment(SwingConstants.CENTER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public MainPageLabels getLabelStart(){
        return this;
    }
}
class LabelStartEvent extends MainPageLabels {
    static UnselectedMessage message;
    public LabelStartEvent(String text, String imagepath) {
        super(text, imagepath);
        addEventListenersUnselectedMessage();
    }

    public void addEventListenersUnselectedMessage() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component[] components = MainPage.leftPanel.getComponents();
                boolean containsMessage = false;

                for (Component component : components) {
                    if (component == message) {
                        containsMessage = true;
                        break;
                    }
                }

                if (!MainPage.level1.isSelected() && !MainPage.level2.isSelected() && !MainPage.level3.isSelected() && !containsMessage) {
                    // 라디오 버튼이 선택되지 않은 경우 라벨 아래에 메시지 업데이트
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridy = 2; // label_gameStart 아래에 위치하도록 함
                    gbc.gridwidth = 3;
                    gbc.insets = new Insets(0, 50, 10, 0);
                    message = new UnselectedMessage("난이도를 선택해주세요.");
                    MainPage.leftPanel.add(message, gbc);
                    MainPage.leftPanel.revalidate();
                    MainPage.leftPanel.repaint();
                }
            }
        });
    }
}