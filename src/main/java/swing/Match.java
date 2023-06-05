package swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.DB.conn;

public class Match extends JFrame implements ActionListener {
    private Color b;
    private JLabel lblNick;
    private JLabel lblcong;
    private JTextField Nickn;
    private JButton btnLogout;
    private String userID, userid;
    private JButton btn16_1;
    private JButton btn16_2;
    private JButton btn8_1;
    private JButton btn8_2;
    private JButton btn4_1;
    private JButton btn4_2;
    private JButton btnFinal;
    private JPanel borderPn;
    private JPanel pnBtn;
    private JPanel c;
    private JLabel labImg;

    public Match(String userid) {
        this.userid = userid;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("매치");
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        b = new Color(4, 27, 158);

        c = new JPanel();  // 인덱스 배경화면 색 패널
        c.setBackground(b);
        add(c);
        setAppbar(userid);
        setMatchPan();
        setVisible(true);
    } //jframe 기본 세팅

    public JPanel FixturesPn(String icon1, String icon2, String team1, String team2, String score1, String score2) {
        JPanel pn = new JPanel();
        pn.setLayout(new GridLayout(2, 3));
        pn.setPreferredSize(new Dimension(200, 200));
        pn.setBackground(new Color(255, 255, 255));
        ImageIcon img1 = new ImageIcon(icon1);
        ImageIcon img2 = new ImageIcon(icon2);
        JLabel i1 = new JLabel(img1);
        JLabel i2 = new JLabel(img2);

        JLabel t1 = new JLabel(team1);
        t1.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        JLabel t2 = new JLabel(team2);
        t2.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        JLabel s1 = new JLabel(score1);
        s1.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        JLabel s2 = new JLabel(score2);
        s2.setFont(new Font("맑은 고딕", Font.BOLD, 19));

        pn.add(i1);
        pn.add(t1);
        pn.add(s1);
        pn.add(i2);
        pn.add(t2);
        pn.add(s2);
        return pn;
    }

    private void setMatchPan() {
        borderPn = new JPanel();
        borderPn.setLayout(new BorderLayout());
        borderPn.setBackground(b);

        labImg = new JLabel();
        ImageIcon ImgBack = new ImageIcon("src/iconimg/MatchImg.jpg");
        labImg.setIcon(ImgBack);
        borderPn.add(labImg, BorderLayout.CENTER);

        pnBtn = new JPanel();
        pnBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        pnBtn.setBackground(new Color(8, 19,73));

        btn16_1 = new JButton("16강 1차전");
        btn16_1.setPreferredSize(new Dimension(100, 40));
        btn16_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        btn16_1.addActionListener(this);

        btn16_2 = new JButton("16강 2차전");
        btn16_2.setPreferredSize(new Dimension(100, 40));
        btn16_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        btn16_2.addActionListener(this);

        btn8_1 = new JButton("8강 1차전");
        btn8_1.setPreferredSize(new Dimension(100, 40));
        btn8_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        btn8_1.addActionListener(this);

        btn8_2 = new JButton("8강 2차전");
        btn8_2.setPreferredSize(new Dimension(100, 40));
        btn8_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        btn8_2.addActionListener(this);

        btn4_1 = new JButton("4강 1차전");
        btn4_1.setPreferredSize(new Dimension(100, 40));
        btn4_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        btn4_1.addActionListener(this);

        btn4_2 = new JButton("4강 2차전");
        btn4_2.setPreferredSize(new Dimension(100, 40));
        btn4_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        btn4_2.addActionListener(this);

        btnFinal = new JButton("결승전");
        btnFinal.setPreferredSize(new Dimension(100, 40));
        btnFinal.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        btnFinal.addActionListener(this);

        pnBtn.add(btn16_1);
        pnBtn.add(btn16_2);
        pnBtn.add(btn8_1);
        pnBtn.add(btn8_2);
        pnBtn.add(btn4_1);
        pnBtn.add(btn4_2);
        pnBtn.add(btnFinal);

        borderPn.add(pnBtn, BorderLayout.NORTH);
        add(borderPn, BorderLayout.CENTER);
    }

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


    @Override
    public void actionPerformed(ActionEvent e) {
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
        if (e.getSource() == btn16_1) {
            JPanel bottomPn = new JPanel();
            bottomPn.setLayout(null);

            JPanel pn16_1 = FixturesPn("src/iconimg/psg.png", "src/iconimg/bm.png", "Paris", "Bayern", "0", "1");
            pn16_1.setBounds(100, 50, 600, 100);
            bottomPn.add(pn16_1);

            JPanel pn16_2 = FixturesPn("src/iconimg/ac.png", "src/iconimg/tt.png", "AC Milan", "Tottenham", "1", "0");
            pn16_2.setBounds(100, 200, 600, 100);
            bottomPn.add(pn16_2);

            JPanel pn16_3 = FixturesPn("src/iconimg/cb.png", "src/iconimg/bf.png", "Club Brugge", "Benfica", "0", "2");
            pn16_3.setBounds(100, 400, 600, 100);
            bottomPn.add(pn16_3);

            JPanel pn16_4 = FixturesPn("src/iconimg/dm.png", "src/iconimg/ch.png", "Dortmund", "Chelsea", "1", "0");
            pn16_4.setBounds(100, 550, 600, 100);
            bottomPn.add(pn16_4);

            JPanel pn16_5 = FixturesPn("src/iconimg/rp.png", "src/iconimg/rm.png", "Liverpool", "Real Madrid", "2", "5");
            pn16_5.setBounds(890, 50, 600, 100);
            bottomPn.add(pn16_5);

            JPanel pn16_6 = FixturesPn("src/iconimg/ir.png", "src/iconimg/np.png", "Frankfurt", "Napoli", "0", "2");
            pn16_6.setBounds(890, 200, 600, 100);
            bottomPn.add(pn16_6);

            JPanel pn16_7 = FixturesPn("src/iconimg/rc.png", "src/iconimg/mc.png", "Leipzig", "Man City", "1", "1");
            pn16_7.setBounds(890, 400, 600, 100);
            bottomPn.add(pn16_7);

            JPanel pn16_8 = FixturesPn("src/iconimg/inter.png", "src/iconimg/pt.png", "Inter", "Porto", "1", "0");
            pn16_8.setBounds(890, 550, 600, 100);
            bottomPn.add(pn16_8);

            labImg.setBounds(0,-62,1600,900);
            bottomPn.add(labImg);
            borderPn.add(bottomPn, BorderLayout.CENTER);
            borderPn.revalidate();
        } else if (e.getSource() == btn16_2) {
            JPanel bottomPn = new JPanel();
            bottomPn.setLayout(null);

            JPanel pn16_3 = FixturesPn("src/iconimg/bf.png", "src/iconimg/cb.png", "Benfica", "Club Brugge", "5", "1");
            pn16_3.setBounds(100, 50, 600, 100);
            bottomPn.add(pn16_3);

            JPanel pn16_4 = FixturesPn("src/iconimg/ch.png", "src/iconimg/dm.png", "Chelsea", "Dortmund", "2", "0");
            pn16_4.setBounds(100, 200, 600, 100);
            bottomPn.add(pn16_4);

            JPanel pn16_1 = FixturesPn("src/iconimg/bm.png", "src/iconimg/psg.png", "Bayern", "Paris", "2", "0");
            pn16_1.setBounds(100, 400, 600, 100);
            bottomPn.add(pn16_1);

            JPanel pn16_2 = FixturesPn("src/iconimg/tt.png", "src/iconimg/ac.png", "Tottenham", "AC Milan", "0", "0");
            pn16_2.setBounds(100, 550, 600, 100);
            bottomPn.add(pn16_2);


            JPanel pn16_7 = FixturesPn("src/iconimg/mc.png", "src/iconimg/rc.png", "Man City", "Leipzig", "7", "0");
            pn16_7.setBounds(890, 50, 600, 100);
            bottomPn.add(pn16_7);

            JPanel pn16_8 = FixturesPn("src/iconimg/pt.png", "src/iconimg/inter.png", "Porto", "Inter", "0", "0");
            pn16_8.setBounds(890, 200, 600, 100);
            bottomPn.add(pn16_8);

            JPanel pn16_5 = FixturesPn("src/iconimg/rm.png", "src/iconimg/rp.png", "Real Madrid", "Liverpool", "1", "0");
            pn16_5.setBounds(890, 400, 600, 100);
            bottomPn.add(pn16_5);

            JPanel pn16_6 = FixturesPn("src/iconimg/np.png", "src/iconimg/ir.png", "Napoli", "Frankfurt", "3", "0");
            pn16_6.setBounds(890, 550, 600, 100);
            bottomPn.add(pn16_6);

            labImg.setBounds(0,-62,1600,900);
            bottomPn.add(labImg);
            borderPn.add(bottomPn, BorderLayout.CENTER);
            borderPn.revalidate();

        } else if (e.getSource() == btn8_1) {
            JPanel bottomPn = new JPanel();
            bottomPn.setLayout(null);

            JPanel pn8_2 = FixturesPn("src/iconimg/bf.png", "src/iconimg/inter.png", "Benfica", "Inter", "0", "2");
            pn8_2.setBounds(100, 100, 600, 200);
            bottomPn.add(pn8_2);

            JPanel pn8_1 = FixturesPn("src/iconimg/mc.png", "src/iconimg/bm.png", "Man City", "Bayern", "3", "0");
            pn8_1.setBounds(100, 400, 600, 200);
            bottomPn.add(pn8_1);


            JPanel pn8_4 = FixturesPn("src/iconimg/rm.png", "src/iconimg/ch.png", "Real Madrid", "Chelsea", "2", "0");
            pn8_4.setBounds(890, 100, 600, 200);
            bottomPn.add(pn8_4);

            JPanel pn8_3 = FixturesPn("src/iconimg/ac.png", "src/iconimg/np.png", "Milan", "Napoli", "1", "0");
            pn8_3.setBounds(890, 400, 600, 200);
            bottomPn.add(pn8_3);

            labImg.setBounds(0,-62,1600,900);
            bottomPn.add(labImg);
            borderPn.add(bottomPn, BorderLayout.CENTER);
            borderPn.revalidate();

        } else if (e.getSource() == btn8_2) {
            JPanel bottomPn = new JPanel();
            bottomPn.setLayout(null);
            JPanel pn8_3 = FixturesPn("src/iconimg/np.png", "src/iconimg/ac.png", "Napoli", "Milan", "1", "1");
            pn8_3.setBounds(100, 400, 600, 200);
            bottomPn.add(pn8_3);

            JPanel pn8_4 = FixturesPn("src/iconimg/ch.png", "src/iconimg/rm.png", "Chelsea", "Real Madrid", "0", "2");
            pn8_4.setBounds(100, 100, 600, 200);
            bottomPn.add(pn8_4);


            JPanel pn8_1 = FixturesPn("src/iconimg/bm.png", "src/iconimg/mc.png", "Bayern", "Man City", "1", "1");
            pn8_1.setBounds(890, 100, 600, 200);
            bottomPn.add(pn8_1);


            JPanel pn8_2 = FixturesPn("src/iconimg/inter.png", "src/iconimg/bf.png", "Inter", "Benfica", "3", "3");
            pn8_2.setBounds(890, 400, 600, 200);
            bottomPn.add(pn8_2);

            labImg.setBounds(0,-62,1600,900);
            bottomPn.add(labImg);
            borderPn.add(bottomPn, BorderLayout.CENTER);
            borderPn.revalidate();


        } else if (e.getSource() == btn4_1) {
            JPanel bottomPn = new JPanel();
            bottomPn.setLayout(null);


            JPanel pn4_1 = FixturesPn("src/iconimg/rm.png", "src/iconimg/mc.png", "Real Madrid", "Man City", "1", "1");
            pn4_1.setBounds(100, 200, 600, 250);
            bottomPn.add(pn4_1);


            JPanel pn4_2 = FixturesPn("src/iconimg/ac.png", "src/iconimg/inter.png", "AC Milan", "Inter", "0", "2");
            pn4_2.setBounds(890, 200, 600, 250);
            bottomPn.add(pn4_2);

            labImg.setBounds(0,-62,1600,900);
            bottomPn.add(labImg);
            borderPn.add(bottomPn, BorderLayout.CENTER);
            borderPn.revalidate();


        } else if (e.getSource() == btn4_2) {
            JPanel bottomPn = new JPanel();
            bottomPn.setLayout(null);

            JPanel pn4_2 = FixturesPn("src/iconimg/inter.png", "src/iconimg/ac.png", "Inter", "AC Milan", "1", "0");
            pn4_2.setBounds(890, 200, 600, 250);
            bottomPn.add(pn4_2);

            JPanel pn4_1 = FixturesPn("src/iconimg/mc.png", "src/iconimg/rm.png", "Man City", "Real Madrid", "4", "0");
            pn4_1.setBounds(100, 200, 600, 250);
            bottomPn.add(pn4_1);

            labImg.setBounds(0,-62,1600,900);
            bottomPn.add(labImg);
            borderPn.add(bottomPn, BorderLayout.CENTER);
            borderPn.revalidate();


        } else if (e.getSource() == btnFinal) {
            JPanel bottomPn = new JPanel();
            bottomPn.setLayout(null);

            JPanel pnFn = FixturesPn("src/iconimg/mc.png", "src/iconimg/inter.png", "Man City", "Inter", "06.11.(일)", "04:00 FINAL");
            pnFn.setBounds(500, 200, 600, 250);
            bottomPn.add(pnFn);

            labImg.setBounds(0,-62,1600,900);
            bottomPn.add(labImg);
            borderPn.add(bottomPn, BorderLayout.CENTER);
            borderPn.revalidate();

        }

    }
}