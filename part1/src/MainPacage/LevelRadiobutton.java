package MainPacage;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

//레벨버튼 클래스
class LevelRadiobutton extends JRadioButton {
    Font radioButtonFont = utility.yeongdeok_sea(18);
    Font radioButtonScalFont = utility.yeongdeok_sea(22);
    //난이도 버튼 그룹 생성
    static ButtonGroup levelGroup = new ButtonGroup();
    public LevelRadiobutton(String text) {
        super(text);
        // 라디오 버튼 글꼴
        setFont(radioButtonFont);
        setFocusPainted(false);
        //난이도 버튼 배경색
        setBackground(Color.WHITE);
        //난이도 그룹에 라디오 버튼 추가
        levelGroup.add(this);

        addEventListeners();

    }
    //라디오 버튼 관련 이벤트들
    private void addEventListeners() {
        // 마우스 이벤트 처리
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // 마우스를 올렸을 때 bold체로 설정
                setFont(radioButtonScalFont);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                // 마우스가 벗어났을 때 원래대로 설정
                ButtonModel model = getModel();
                if (!model.isSelected()) {
                    setFont(radioButtonFont);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                setFont(radioButtonScalFont);
            }
        });

        // 이벤트 리스너 추가
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 클릭 시 글꼴을 bold체로 설정
                setFont(radioButtonScalFont);
                //난이도 선택시 문구 사라짐
                Component[] components = MainPage.leftPanel.getComponents();
                for (Component component : components) {
                    if (component == LabelStartEvent.message) {
                        MainPage.leftPanel.remove(LabelStartEvent.message);
                        MainPage.leftPanel.revalidate();
                        MainPage.leftPanel.repaint();
                        break;
                    }
                }

                // 다른 라디오 버튼을 선택하면 현재 라디오 버튼의 글꼴을 원래대로 설정
                ButtonModel model = getModel();
                if (!model.isSelected()) {
                    setFont(radioButtonFont);
                }
            }
        });

        // 라디오버튼 다른거 선택 시 글꼴을 원래대로 설정
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (!getModel().isSelected()) {
                    setFont(radioButtonFont);
                }
            }
        });
    }
}
