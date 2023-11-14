package MainPacage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class PauseFinishButton extends JButton {
    private int buttonwidth = 200;
    private int buttonheight = 50;
    private ImageIcon buttonIcon;
    public PauseFinishButton(String imagepath){
//        decorate();
        setPreferredSize(new Dimension(buttonwidth,buttonheight)); // 크기 조절
        setRolloverEnabled(false);
        setFocusPainted(false);
//        setBackground(utility.maincolor);

        // 이미지 파일을 읽어와서 ImageIcon으로 설정
        try {
            buttonIcon = new ImageIcon(ImageIO.read(MainPage.class.getResource(imagepath)));
            setIcon(buttonIcon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g;

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        setBackground(utility.maincolor);

        //버튼 눌러진 상태
        if (getModel().isArmed()) {
            graphics.setColor(utility.pointcolor);
        }
        //버튼 올려진 상태
        else if (getModel().isRollover()) {
            graphics.setColor(utility.maincolor);
        } else {
            graphics.setColor(getBackground());
        }

        //가로세로 길이만큼 20의 둥글기 가지는 배경
        graphics.fillRoundRect(0, 0, width, height, 20, 20);

        Icon icon = getIcon();
        if (icon != null) {
            int iconX = (width - icon.getIconWidth()) / 2;
            int iconY = (height - icon.getIconHeight()) / 2;
            icon.paintIcon(this, graphics, iconX, iconY);
        }

        graphics.dispose();

        super.paintComponent(g);
    }
}
