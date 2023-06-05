package swing;

import DB.*;
import swing.TeamInfo.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import static DB.DB.conn;

public class MainPage extends JFrame implements ActionListener, KeyListener {

    private ImageIcon[] icons = {
            new ImageIcon("src/images/인테르.png"),
            new ImageIcon("src/images/맨시티.png"),
            new ImageIcon("src/images/AC밀란.png"),
            new ImageIcon("src/images/레알마드리드.png"),
            new ImageIcon("src/images/뮌헨.png"),
            new ImageIcon("src/images/벤피카.png"),
            new ImageIcon("src/images/첼시.png"),
            new ImageIcon("src/images/나폴리.png")
    };
    private ImageIcon[] icons2 = {
            new ImageIcon("src/images/브뤼헤.png"),
            new ImageIcon("src/images/도르트문트.png"),
            new ImageIcon("src/images/프랑크.png"),
            new ImageIcon("src/images/라히프치히.png"),
            new ImageIcon("src/images/리버풀.png"),
            new ImageIcon("src/images/파생.png"),
            new ImageIcon("src/images/포르투.png"),
            new ImageIcon("src/images/토트넘.png")
    };
    JButton[] btnIcon = new JButton[icons.length];
    JButton[] btnIcon2 = new JButton[icons2.length];
    private JLabel lab1, lab2, lab3, lab4, lab5, lab6, lab7, lab8, lab9, lab10, lab11, lab12, lab13, lab14, lab15, lab16;
    private Color b;
    private JPanel c, panIcon;
    private JLabel lblId, lblPw;
    private JTextField tfId;
    private JPasswordField tfPw;
    private JButton btnJoin, btnLogin;
    private MainGoal statGoal;
    private MainAssist statAssist;
    private MainYellow statYellow;
    private MainRed statRed;
    private MainRate statRate;
    private MainClean statClean;
    private JTable tableGoal, tableAssist, tableYellow, tableRed, tableRate, tableClean;
    private JLabel lblNick;
    private JLabel lblcong;
    private JTextField Nickn;
    private JButton btnLogout;
    private String userID, userid;

    public MainPage(String userid) {
        this.userid = userid;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("메인");
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        addKeyListener(this);
        Color sb = new Color(1, 0, 44);


        c = new JPanel();
        c.setLayout(null);
        c.setBackground(sb);
        c.setPreferredSize(new Dimension(1600, 1000));
        //스텟 프리뷰 패널
        add(c);
        setPanIcon(b);
        setAppbar(userid);
        setPanStat();
        setVisible(true);
    }

    //팀 아이콘
    private void setPanIcon(Color b) {
        panIcon = new JPanel();
        panIcon.setLayout(null);
        panIcon.setBackground(new Color(32,32,32));
        panIcon.setBounds(66, 0, 1450, 370);

        //팀 아이콘
        for (int i = 0; i < icons.length; i++) {
            btnIcon[i] = new JButton(icons[i]);
            btnIcon[i].setBackground(new Color(32,32,32));
            btnIcon[i].setBorderPainted(false);
            btnIcon[i].setBounds(180 * i + 35, 20, 120, 100);
            btnIcon[i].addActionListener(this);
            panIcon.add(btnIcon[i]);
        }
        for (int i = 0; i < icons.length; i++) {
            btnIcon2[i] = new JButton(icons2[i]);
            btnIcon2[i].setBackground(new Color(32,32,32));
            btnIcon2[i].setBorderPainted(false);
            btnIcon2[i].setBounds(180 * i + 35, 210, 120, 100);
            btnIcon2[i].addActionListener(this);
            panIcon.add(btnIcon2[i]);
        }

        lab1 = new JLabel();
        lab1.setText("<html>FC Internazionale<br>" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Milano</html>");
        lab1.setSize(120, 100);
        lab1.setLocation(47, 90);
        lab1.setForeground(Color.WHITE);

        lab2 = new JLabel();
        lab2.setText("Manchester City FC");
        lab2.setSize(120, 100);
        lab2.setLocation(222, 82);
        lab2.setForeground(Color.WHITE);

        lab3 = new JLabel();
        lab3.setText("AC Milan");
        lab3.setSize(120, 100);
        lab3.setLocation(430, 82);
        lab3.setForeground(Color.WHITE);

        lab4 = new JLabel();
        lab4.setText("Real Madrid CF");
        lab4.setSize(120, 100);
        lab4.setLocation(593, 82);
        lab4.setForeground(Color.WHITE);

        lab5 = new JLabel();
        lab5.setText("FC Bayern München");
        lab5.setSize(120, 100);
        lab5.setLocation(759, 82);
        lab5.setForeground(Color.WHITE);

        lab6 = new JLabel();
        lab6.setText("SL Benfica");
        lab6.setSize(120, 100);
        lab6.setLocation(964, 82);
        lab6.setForeground(Color.WHITE);

        lab7 = new JLabel();
        lab7.setText("Chelsea FC");
        lab7.setSize(120, 100);
        lab7.setLocation(1143, 82);
        lab7.setForeground(Color.WHITE);

        lab8 = new JLabel();
        lab8.setText("SSC Napoli");
        lab8.setSize(120, 100);
        lab8.setLocation(1323, 82);
        lab8.setForeground(Color.WHITE);

        lab9 = new JLabel();
        lab9.setText("Club Brugge");
        lab9.setSize(120, 100);
        lab9.setLocation(60, 270);
        lab9.setForeground(Color.WHITE);

        lab10 = new JLabel();
        lab10.setText("Borussia Dortmund");
        lab10.setSize(120, 100);
        lab10.setLocation(220, 270);
        lab10.setForeground(Color.WHITE);

        lab11 = new JLabel();
        lab11.setText("Eintracht Frankfurt");
        lab11.setSize(120, 100);
        lab11.setLocation(400, 270);
        lab11.setForeground(Color.WHITE);

        lab12 = new JLabel();
        lab12.setText("RB Leipzig");
        lab12.setSize(120, 100);
        lab12.setLocation(604, 270);
        lab12.setForeground(Color.WHITE);

        lab13 = new JLabel();
        lab13.setText("Liverpool FC");
        lab13.setSize(120, 100);
        lab13.setLocation(781, 270);
        lab13.setForeground(Color.WHITE);

        lab14 = new JLabel();
        lab14.setText("Paris Saint-Germain");
        lab14.setSize(120, 100);
        lab14.setLocation(937, 270);
        lab14.setForeground(Color.WHITE);

        lab15 = new JLabel();
        lab15.setText("FC Porto");
        lab15.setSize(120, 100);
        lab15.setLocation(1150, 270);
        lab15.setForeground(Color.WHITE);

        lab16 = new JLabel();
        lab16.setText("Tottenham Hotspur");
        lab16.setSize(120, 100);
        lab16.setLocation(1302, 270);
        lab16.setForeground(Color.WHITE);


        panIcon.add(lab1);
        panIcon.add(lab2);
        panIcon.add(lab3);
        panIcon.add(lab4);
        panIcon.add(lab5);
        panIcon.add(lab6);
        panIcon.add(lab7);
        panIcon.add(lab8);
        panIcon.add(lab9);
        panIcon.add(lab10);
        panIcon.add(lab11);
        panIcon.add(lab12);
        panIcon.add(lab13);
        panIcon.add(lab14);
        panIcon.add(lab15);
        panIcon.add(lab16);

        c.add(panIcon);
    }

    //앱바
    private void setAppbar(String userID) { //디폴트 메인바 세팅
        this.userID = userID;
        JPanel pN = new JPanel();
        pN.setLayout(new FlowLayout());

        JToolBar toolbar = new JToolBar();
        Color sb = new Color(1, 0, 44);

        toolbar.setBackground(sb);
        toolbar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        toolbar.setBorder(new EmptyBorder(0, 5, 0, 5));
        toolbar.setPreferredSize(new Dimension(1450, 55));

        JButton mainMenu = new JButton(" ");
        mainMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        mainMenu.setBackground(sb);
        mainMenu.setBorderPainted(false);
        mainMenu.addActionListener(this);
        toolbar.add(mainMenu);

        JButton tSMenu = new JButton("매치");
        tSMenu.setForeground(Color.WHITE);
        tSMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        tSMenu.setBackground(sb);
        tSMenu.setBorderPainted(false);
        tSMenu.setPreferredSize(new Dimension(150, 40));
        tSMenu.addActionListener(this);
        toolbar.add(tSMenu);

        JButton BEMenu = new JButton("베스트일레븐");
        BEMenu.setForeground(Color.WHITE);
        BEMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        BEMenu.setBackground(sb);
        BEMenu.setBorderPainted(false);
        BEMenu.setPreferredSize(new Dimension(150, 40));
        BEMenu.addActionListener(this);
        toolbar.add(BEMenu);

        JButton toMenu = new JButton("스텟");
        toMenu.setForeground(Color.WHITE);
        toMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        toMenu.setBackground(sb);
        toMenu.setBorderPainted(false);
        toMenu.setPreferredSize(new Dimension(150, 40));
        toMenu.addActionListener(this);
        toolbar.add(toMenu);

        JButton infoMenu = new JButton("역대 우승팀");
        infoMenu.setForeground(Color.WHITE);
        infoMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        infoMenu.setBackground(sb);
        infoMenu.setBorderPainted(false);
        infoMenu.setPreferredSize(new Dimension(150, 40));
        infoMenu.addActionListener(this);
        toolbar.add(infoMenu);


        JLabel imgLabel = new JLabel();
        ImageIcon icon = new ImageIcon("src/iconimg/mmain.png");
        Image img = icon.getImage();
        Image updateImg = img.getScaledInstance(180, 50, Image.SCALE_SMOOTH);
        ImageIcon updateIcon = new ImageIcon(updateImg);
        imgLabel.setIcon(updateIcon);
        imgLabel.setPreferredSize(new Dimension(180, 40));
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        mainMenu.add(imgLabel);


        lblNick = new JLabel("닉네임 :");
        lblNick.setForeground(Color.WHITE);
        lblNick.setPreferredSize(new Dimension(70, 30));
        lblcong = new JLabel("환영합니다!");
        lblcong.setForeground(Color.WHITE);
        lblcong.setPreferredSize(new Dimension(80, 30));

        Nickn = new JTextField(15);
        Nickn.setEditable(false);

        String user = userID;
        String nickname = "";

        try {
            String query = "SELECT nickname FROM acc WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, user);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                nickname = rs.getString("nickname");
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Nickn.setText(nickname);

        btnLogout = new JButton("로그아웃");
        btnLogout.setPreferredSize(new Dimension(70, 25));
        btnLogout.addActionListener(this);

        JPanel nickPn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nickPn.add(lblNick);
        nickPn.add(Nickn);
        nickPn.setBackground(sb);

        JPanel CongPn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        CongPn.add(lblcong);
        CongPn.setBackground(sb);

        toolbar.add(nickPn);
        toolbar.add(CongPn);
        toolbar.add(btnLogout);
        btnLogout.addActionListener(this);
        Color b = new Color(3, 2, 137);
        pN.setBackground(b);
        pN.add(toolbar, BorderLayout.NORTH);
        add(pN, BorderLayout.NORTH);
    }

    //스텟 프리뷰 패널
    private void setPanStat() {
        //득점 프리뷰
        JPanel panGoal = new JPanel();
        panGoal.setLayout(new BorderLayout());
        panGoal.setBackground(Color.GRAY);
        panGoal.setBounds(68, 390, 477, 240);

        JPanel panNorth1 = new JPanel();
        panNorth1.setPreferredSize(new Dimension(477, 35)); // 원하는 높이로 설정
        JLabel labGoal = new JLabel("득점");//라벨 제목
        labGoal.setFont(new Font("맑은 고딕", Font.BOLD, 23));//라벨 폰트
        labGoal.setForeground(Color.BLACK);
        labGoal.setHorizontalAlignment(JLabel.CENTER);//라벨 가운데 정렬

        panNorth1.add(labGoal);
        panGoal.add(panNorth1, BorderLayout.NORTH);

        JPanel panTable1 = new JPanel();
        panTable1.setLayout(new BorderLayout());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        statGoal = new MainGoal();
        statGoal.setData();
        tableGoal = new JTable(statGoal);
        tableGoal.setRowHeight(60);
        tableGoal.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        tableGoal.setBackground(new Color(57, 76, 131));
        tableGoal.setForeground(Color.WHITE);

        tableGoal.setDefaultRenderer(Object.class, centerRenderer);
        JTableHeader header = tableGoal.getTableHeader();
        header.setPreferredSize(new Dimension(477, 20));
        header.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        header.setBackground(new Color(57, 76, 131));
        header.setForeground(Color.WHITE);

        JScrollPane sp = new JScrollPane(tableGoal);
        panTable1.add(sp);
        panGoal.add(panTable1, BorderLayout.CENTER);

        //도움 프리뷰
        JPanel panAssist = new JPanel();
        panAssist.setLayout(new BorderLayout());
        panAssist.setBackground(Color.GRAY);
        panAssist.setBounds(555, 390, 477, 240);

        JPanel panNorth2 = new JPanel();
        panNorth2.setPreferredSize(new Dimension(477, 35)); // 원하는 높이로 설정
        JLabel labAssist = new JLabel("도움");
        labAssist.setFont(new Font("맑은 고딕", Font.BOLD, 23));
        labAssist.setHorizontalAlignment(JLabel.CENTER);

        panNorth2.add(labAssist);
        panAssist.add(panNorth2, BorderLayout.NORTH);

        JPanel panTable2 = new JPanel();
        panTable2.setLayout(new BorderLayout());
//
        statAssist = new MainAssist();
        statAssist.setData();
        tableAssist = new JTable(statAssist);
        tableAssist.setRowHeight(60);
        tableAssist.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        tableAssist.setBackground(new Color(57, 76, 131));
        tableAssist.setForeground(Color.WHITE);
//
        tableAssist.setDefaultRenderer(Object.class, centerRenderer);
        JTableHeader header2 = tableAssist.getTableHeader();
        header2.setPreferredSize(new Dimension(477, 20));
        header2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        header2.setBackground(new Color(57, 76, 131));
        header2.setForeground(Color.WHITE);
//
        JScrollPane sp2 = new JScrollPane(tableAssist);
        panTable2.add(sp2);
        panAssist.add(panTable2, BorderLayout.CENTER);

        //평점 프리뷰
        JPanel panRate = new JPanel();
        panRate.setLayout(new BorderLayout());
        panRate.setBackground(Color.GRAY);
        panRate.setBounds(1042, 390, 477, 240);

        JPanel panNorth3 = new JPanel();
        panNorth3.setPreferredSize(new Dimension(477, 35)); // 원하는 높이로 설정
        JLabel labRate = new JLabel("평점");
        labRate.setFont(new Font("맑은 고딕", Font.BOLD, 23));
        labRate.setHorizontalAlignment(JLabel.CENTER);

        panNorth3.add(labRate);
        panRate.add(panNorth3, BorderLayout.NORTH);
        //테이블
        JPanel panTable3 = new JPanel();
        panTable3.setLayout(new BorderLayout());
//
        statRate = new MainRate();
        statRate.setData();
        tableRate = new JTable(statRate);
        tableRate.setRowHeight(60);
        tableRate.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        tableRate.setBackground(new Color(57, 76, 131));
        tableRate.setForeground(Color.WHITE);
//
        tableRate.setDefaultRenderer(Object.class, centerRenderer);
        JTableHeader header3 = tableRate.getTableHeader();
        header3.setPreferredSize(new Dimension(477, 20));
        header3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        header3.setBackground(new Color(57, 76, 131));
        header3.setForeground(Color.WHITE);
//
        JScrollPane sp3 = new JScrollPane(tableRate);
        panTable3.add(sp3);
        panRate.add(panTable3, BorderLayout.CENTER);

        //경고 프리뷰
        JPanel panYellow = new JPanel();
        panYellow.setLayout(new BorderLayout());
        panYellow.setBackground(Color.GRAY);
        panYellow.setBounds(68, 640, 477, 238);

        JPanel panNorth4 = new JPanel();
        panNorth4.setPreferredSize(new Dimension(477, 35)); // 원하는 높이로 설정
        JLabel labYellow = new JLabel("경고");
        labYellow.setFont(new Font("맑은 고딕", Font.BOLD, 23));
        labYellow.setHorizontalAlignment(JLabel.CENTER);

        panNorth4.add(labYellow);
        panYellow.add(panNorth4, BorderLayout.NORTH);
        //테이블
        JPanel panTable4 = new JPanel();
        panTable4.setLayout(new BorderLayout());
//
        statYellow = new MainYellow();
        statYellow.setData();
        tableYellow = new JTable(statYellow);
        tableYellow.setRowHeight(60);
        tableYellow.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        tableYellow.setBackground(new Color(57, 76, 131));
        tableYellow.setForeground(Color.WHITE);
//
        tableYellow.setDefaultRenderer(Object.class, centerRenderer);
        JTableHeader header4 = tableYellow.getTableHeader();
        header4.setPreferredSize(new Dimension(477, 20));
        header4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        header4.setBackground(new Color(57, 76, 131));
        header4.setForeground(Color.WHITE);
//
        JScrollPane sp4 = new JScrollPane(tableYellow);
        panTable4.add(sp4);
        panYellow.add(panTable4, BorderLayout.CENTER);

        //퇴장 프리뷰
        JPanel panRed = new JPanel();
        panRed.setLayout(new BorderLayout());
        panRed.setBackground(Color.GRAY);
        panRed.setBounds(555, 640, 477, 238);

        JPanel panNorth5 = new JPanel();
        panNorth5.setPreferredSize(new Dimension(477, 35)); // 원하는 높이로 설정
        JLabel labRed = new JLabel("퇴장");
        labRed.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        labRed.setHorizontalAlignment(JLabel.CENTER);

        panNorth5.add(labRed);
        panRed.add(panNorth5, BorderLayout.NORTH);
        //테이블
        JPanel panTable5 = new JPanel();
        panTable5.setLayout(new BorderLayout());
//
        statRed = new MainRed();
        statRed.setData();
        tableRed = new JTable(statRed);
        tableRed.setRowHeight(60);
        tableRed.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        tableRed.setBackground(new Color(57, 76, 131));
        tableRed.setForeground(Color.WHITE);
//
        tableRed.setDefaultRenderer(Object.class, centerRenderer);
        JTableHeader header5 = tableRed.getTableHeader();
        header5.setPreferredSize(new Dimension(477, 20));
        header5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        header5.setBackground(new Color(57, 76, 131));
        header5.setForeground(Color.WHITE);
//
        JScrollPane sp5 = new JScrollPane(tableRed);
        panTable5.add(sp5);
        panRed.add(panTable5, BorderLayout.CENTER);

        //클린시트 프리뷰
        JPanel panClean = new JPanel();
        panClean.setLayout(new BorderLayout());
        panClean.setBackground(Color.GRAY);
        panClean.setBounds(1042, 640, 477, 238);

        JPanel panNorth6 = new JPanel();
        panNorth6.setPreferredSize(new Dimension(477, 35)); // 원하는 높이로 설정
        JLabel labClean = new JLabel("클린시트");
        labClean.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        labClean.setHorizontalAlignment(JLabel.CENTER);

        panNorth6.add(labClean);
        panClean.add(panNorth6, BorderLayout.NORTH);
        //테이블
        JPanel panTable6 = new JPanel();
        panTable6.setLayout(new BorderLayout());
//
        statClean = new MainClean();
        statClean.setData();
        tableClean = new JTable(statClean);
        tableClean.setRowHeight(60);
        tableClean.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        tableClean.setBackground(new Color(57, 76, 131));
        tableClean.setForeground(Color.WHITE);
//
        tableClean.setDefaultRenderer(Object.class, centerRenderer);
        JTableHeader header6 = tableClean.getTableHeader();
        header6.setPreferredSize(new Dimension(477, 20));
        header6.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        header6.setBackground(new Color(57, 76, 131));
        header6.setForeground(Color.WHITE);
//
        JScrollPane sp6 = new JScrollPane(tableClean);
        panTable6.add(sp6);
        panClean.add(panTable6, BorderLayout.CENTER);

        c.add(panGoal);
        c.add(panAssist);
        c.add(panRate);
        c.add(panYellow);
        c.add(panRed);
        c.add(panClean);
    }


    //데베 연동 스텟프리뷰 패널

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        //앱바 버튼 클릭 시
        if (e.getActionCommand().equals("매치")) {
            new Match(userid);
            this.dispose();
        } else if (e.getActionCommand().equals("베스트일레븐")) {
            new Best11(userid);
            this.dispose();
        } else if (e.getActionCommand().equals("스텟")) {
            new LeagueTable(userid);
            this.dispose();
        } else if (e.getActionCommand().equals("역대 우승팀")) {
            new History(userid);
            this.dispose();
        } else if (e.getActionCommand().equals(" ")) {
            new MainPage(userid);
            this.dispose();
        } else if (e.getActionCommand().equals("로그아웃")) {
            new LoginForm();
            this.dispose();
        }
        //팀명단 아이콘 클릭 시
        if (obj == btnIcon[0])
            new Inter();
        else if (obj == btnIcon[1])
            new ManCity();
        else if (obj == btnIcon[2])
            new Milan();
        else if (obj == btnIcon[3])
            new Real();
        else if (obj == btnIcon[4])
            new Munchen();
        else if (obj == btnIcon[5])
            new Benfica();
        else if (obj == btnIcon[6])
            new Chelsea();
        else if (obj == btnIcon[7])
            new Napoli();
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        else if (obj == btnIcon2[0])
            new Brugge();
        else if (obj == btnIcon2[1])
            new Dortmund();
        else if (obj == btnIcon2[2])
            new Frankfurt();
        else if (obj == btnIcon2[3])
            new Leipzig();
        else if (obj == btnIcon2[4])
            new Liverpool();
        else if (obj == btnIcon2[5])
            new Paris();
        else if (obj == btnIcon2[6])
            new Porto();
        else if (obj == btnIcon2[7])
            new Tottenhem();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
