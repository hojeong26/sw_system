package MainPacage;

import javax.swing.*;
import java.awt.*;

class UnselectedMessage extends JLabel {
    Font unselectedMessageFont = utility.yeongdeok_sea(18);
    public UnselectedMessage(String unselectedmessage){
        super(unselectedmessage);
//        Font unselectedMessageFont = utility.yeongdeok_sea(18);
        setFont(unselectedMessageFont);
    }
}
