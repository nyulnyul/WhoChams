package swing.TeamInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paris extends JFrame implements KeyListener {

    private ImageIcon teamIcon1 = new ImageIcon("src/Logo90/파생.png");
    private Color b;
    private JLabel labIcon;
    private Font font = new Font("맑은 고딕", Font.BOLD, 20);
    private JLabel uniform;
    private Icon uniformIcon;
    private Color sb = new Color(1, 0, 44);
    private JRadioButton rdo1, rdo2, rdo3;

    public Paris() {
        initComponents();
    }

    private void initComponents() {
        setTitle("팀 정보");
        setSize(800, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(this);

        b = new Color(4, 27, 158);
        //왼쪽 패널
        setPanLeft();
        setPanRight();
        setVisible(true);
        requestFocus();
    }

    private void setPanLeft() {
        //왼쪽 패널
        JPanel panLeft = new JPanel();
        panLeft.setLayout(null);
        panLeft.setBackground(b);
        panLeft.setBounds(0, 40, 400, 560);

        //페이지 상단 구단명
        JLabel labName = new JLabel("파리 생제르맹");
        labName.setBounds(-5, 0, 800, 40);
        labName.setFont(font);
        labName.setHorizontalAlignment(JLabel.CENTER);
        labName.setBackground(Color.LIGHT_GRAY);
        labName.setForeground(Color.BLACK);
        labName.setOpaque(true);//라벨 배경 나오게
        add(labName);

        //아이콘
        labIcon = new JLabel();
        labIcon.setIcon(teamIcon1);
        labIcon.setSize(130, 130);
        labIcon.setLocation(20, 30);

        //구단, 감독, 국가, 리그
        JLabel labCoach = new JLabel("감독 : 크리스토프 갈티에");
        labCoach.setSize(250, 20);
        labCoach.setLocation(150, 25);
        labCoach.setFont(font);
        labCoach.setForeground(Color.WHITE);

        JLabel labNation = new JLabel("주장 : 마르퀴뇨스");
        labNation.setSize(250, 20);
        labNation.setLocation(150, 65);
        labNation.setFont(font);
        labNation.setForeground(Color.WHITE);

        JLabel labLeague = new JLabel("국가 : 프랑스");
        labLeague.setSize(250, 20);
        labLeague.setLocation(150, 105);
        labLeague.setFont(font);
        labLeague.setForeground(Color.WHITE);
        JLabel labCaptain = new JLabel("리그 : Ligue 1");
        labCaptain.setSize(250, 27);
        labCaptain.setLocation(150, 145);
        labCaptain.setFont(font);
        labCaptain.setForeground(Color.WHITE);

        JLabel labUniform = new JLabel("Uniform");
        labUniform.setBounds(0, 209, 400, 40);
        labUniform.setFont(font);
        labUniform.setHorizontalAlignment(JLabel.CENTER);
        labUniform.setBackground(Color.WHITE);
        labUniform.setForeground(Color.BLACK);
        labUniform.setOpaque(true);//라벨 배경 나오게

        //유니폼 이미지 아이콘
        uniform = new JLabel();
        uniform.setIcon(uniformIcon);
        uniform.setSize(250, 250);
        uniform.setLocation(125, 230);

        updateUniformIcon("src/uniform150x150/psg h.png");
        //라디오버튼
        rdo1 = new JRadioButton("Home", true);
        rdo1.setBounds(85, 460, 80, 20);
        rdo1.setBackground(b);
        rdo1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        rdo1.setForeground(Color.WHITE);
        rdo1.setFocusPainted(false);
        rdo1.addActionListener(e -> updateUniformIcon("src/uniform150x150/psg h.png"));
        rdo1.addActionListener(e -> setRdo());

        rdo2 = new JRadioButton("Away");
        rdo2.setBounds(165, 460, 80, 20);
        rdo2.setBackground(b);
        rdo2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        rdo2.setForeground(Color.WHITE);
        rdo2.setFocusPainted(false);
        rdo2.addActionListener(e -> updateUniformIcon("src/uniform150x150/psg a.png"));
        rdo2.addActionListener(e -> setRdo());

        rdo3 = new JRadioButton("Other");
        rdo3.setBounds(245, 460, 80, 20);
        rdo3.setBackground(b);
        rdo3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        rdo3.setForeground(Color.WHITE);
        rdo3.setFocusPainted(false);
        rdo3.addActionListener(e -> updateUniformIcon("src/uniform150x150/psg t.png"));
        rdo3.addActionListener(e -> setRdo());

        ButtonGroup g = new ButtonGroup();//라디오버튼 그룹화
        g.add(rdo1);
        g.add(rdo2);
        g.add(rdo3);
        panLeft.add(labIcon);
        panLeft.add(labUniform);
        panLeft.add(labCoach);
        panLeft.add(labCaptain);
        panLeft.add(labNation);
        panLeft.add(labLeague);
        panLeft.add(uniform);
        panLeft.add(rdo1);
        panLeft.add(rdo2);
        panLeft.add(rdo3);
        add(panLeft);
    }

    //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    //오른쪽 패널
    private void setPanRight() {
        JPanel panRight = new JPanel();
        panRight.setLayout(null);
        panRight.setBackground(Color.WHITE);
        panRight.setBounds(400, 40, 400, 560);
        //스타디움 라벨
        JLabel stName = new JLabel("파르크 데 프랭스");
        stName.setBounds(0, 0, 400, 30);
        stName.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 18));
        stName.setHorizontalAlignment(JLabel.CENTER);
        stName.setForeground(Color.WHITE);
        stName.setBackground(sb);
        stName.setOpaque(true);//라벨 배경 나오게
        //스타디움 이미지
        ImageIcon stIcon = new ImageIcon("src/Stadium_Img/파르크 데 프랭스_파생.jpg");
        JLabel labSt = new JLabel();
        labSt.setIcon(stIcon);
        labSt.setBounds(0, 30, 400, 220);
        //트로피
        ImageIcon Trophy1 = new ImageIcon("src/Trophy/챔스.png");
        JLabel labTrophy1 = new JLabel("챔스 : 0회");
        labTrophy1.setIcon(Trophy1);
        labTrophy1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        labTrophy1.setHorizontalTextPosition(JLabel.CENTER);
        labTrophy1.setVerticalTextPosition(JLabel.BOTTOM);
        labTrophy1.setBounds(7, 285, 120, 200);

        ImageIcon Trophy2 = new ImageIcon("src/Trophy/리그.png");
        JLabel labTrophy2 = new JLabel("리그 : 11회");
        labTrophy2.setIcon(Trophy2);
        labTrophy2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        labTrophy2.setHorizontalTextPosition(JLabel.CENTER);
        labTrophy2.setVerticalTextPosition(JLabel.BOTTOM);
        labTrophy2.setBounds(127, 285, 120, 200);

        ImageIcon Trophy3 = new ImageIcon("src/Trophy/FA.png");
        JLabel labTrophy3 = new JLabel("쿠프 드 프랑스 : 14회");
        labTrophy3.setIcon(Trophy3);
        labTrophy3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        labTrophy3.setHorizontalTextPosition(JLabel.CENTER);
        labTrophy3.setVerticalTextPosition(JLabel.BOTTOM);
        labTrophy3.setBounds(247, 285, 120, 200);

        panRight.add(labSt);
        panRight.add(stName);
        panRight.add(labTrophy1);
        panRight.add(labTrophy2);
        panRight.add(labTrophy3);
        add(panRight);
    }

    //유니폼 이미지 변경 메소드
    private void updateUniformIcon(String imagePath) {
        ImageIcon uniformIcon = new ImageIcon(imagePath);
        uniform.setIcon(uniformIcon);
    }

    private void setRdo() {
        if (rdo1.isSelected() || rdo2.isSelected() || rdo3.isSelected()) {
            requestFocus();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            dispose();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}