package MainPacage;

import javax.swing.*;
import java.awt.*;

class OnOffButton extends JButton {
    private Font onOffFont = utility.yeongdeok_sea(12);
    private ButtonGroup bgmGroup = new ButtonGroup();
    public OnOffButton(String buttonText,Color onOffBakColor){
        super(buttonText);
        setRolloverEnabled(false);
        setFocusPainted(false);
        setBackground(onOffBakColor);
        setFont(onOffFont);

        bgmGroup.add(this);
    }
}
