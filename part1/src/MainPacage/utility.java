package MainPacage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

//폰트랑 컬러 저장
class utility {
    static Color basecolor = new Color(237,227,206);
    static Color maincolor = new Color(125,159,104);
    static Color pointcolor = new Color(80,102,67);
    static Color pausefinishpagecolor = new Color(255,255,255,220);
    public static Font yeongdeok_haeparang(float size) {
        Font yeongdeok_haeparang= null;
        try {
            File fontFile = new File("src/font/Yeongdeok Haeparang.ttf");
            yeongdeok_haeparang = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return yeongdeok_haeparang;
    }
    //바다체_일반
    public static Font yeongdeok_sea(float size) {
        Font yeongdeok_sea = null;
        try {
            File fontFile = new File("src/font/Yeongdeok Sea.ttf");
            yeongdeok_sea = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return yeongdeok_sea;
    }
}
