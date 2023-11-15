package MainPacage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

//폰트랑 컬러 저장

/**폰트,색깔 객체를 정의해 놓은 클래스*/
class utility {
    /**기본 색깔*/
    static Color basecolor = new Color(237,227,206);
    /**주요 색깔*/
    static Color maincolor = new Color(125,159,104);
    /**포인트 색깔*/
    static Color pointcolor = new Color(80,102,67);
    /**일시정지,종료화면에 쓰이는 색깔*/
    static Color pausefinishpagecolor = new Color(255,255,255,220);

    /**
     * @param size 폰트객체의 사이즈를 매개변수로 받음
     * @return yeongdeok haeparang 폰트 객체
     * @throws IOException          폰트 파일을 읽는 도중 I/O오류 발생시 처리
     * @throws FontFormatException   폰트 형식이 올바르지 않는 경우 처리
     */
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
    /**
     * @param size 폰트객체의 사이즈를 매개변수로 받음
     * @return yeongdeok sea 폰트 객체
     * @throws IOException          폰트 파일을 읽는 도중 I/O오류 발생시 처리
     * @throws FontFormatException   폰트 형식이 올바르지 않는 경우 처리
     */
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
