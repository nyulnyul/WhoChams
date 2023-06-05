package swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.DB.conn;

public class Best11 extends javax.swing.JFrame implements ActionListener, MouseMotionListener {
    private JPanel c;
    private Color b;
    private ImageIcon img, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11,
            img12, img13, img14, img15, img16, img17, img18, img19, img20, img21, img22, img23, img24,
            img25, img26, img27, img28, img29, img30, img31, img32;
    private JLabel imglbl, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10, lbl11;
    private Font font;
    private JPanel panFomation;
    private Color sb;
    private JButton btn2018, btn2019, btn2020, btn2021, btn2022;
    private JLabel lblNick;
    private JLabel lblcong;
    private JTextField Nickn;
    private JButton btnLogout;
    private String userID, userid;


    public Best11(String userid) {
        this.userid = userid;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("베스트일레븐");
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        sb = new Color(1, 0, 44);
        b = new Color(4, 27, 158);
        c = new JPanel();  // 인덱스 배경화면 패널
        c.setBackground(b);
        add(c);
        setAppbar(userid);
        setBtnSeason();
        setVisible(true);
    }

    private void setBtnSeason() {
        panFomation = new JPanel();
        panFomation.setLayout(null);
        panFomation.setBackground(b);
        panFomation.setSize(1600, 1000);
        font = new Font("monospaced", Font.BOLD | Font.ITALIC, 18);

        btn2018 = new JButton("2018");
        btn2018.setBounds(75, 10, 120, 45);
        btn2018.setFont(font);
        btn2018.addActionListener(this);

        btn2019 = new JButton("2019");
        btn2019.setBounds(195, 10, 120, 45);
        btn2019.setFont(font);
        btn2019.addActionListener(this);

        btn2020 = new JButton("2020");
        btn2020.setBounds(315, 10, 120, 45);
        btn2020.setFont(font);
        btn2020.addActionListener(this);

        btn2021 = new JButton("2021");
        btn2021.setBounds(435, 10, 120, 45);
        btn2021.setFont(font);
        btn2021.addActionListener(this);

        btn2022 = new JButton("2022");
        btn2022.setBounds(555, 10, 120, 45);
        btn2022.setFont(font);
        btn2022.addActionListener(this);

        panFomation.add(btn2018);
        panFomation.add(btn2019);
        panFomation.add(btn2020);
        panFomation.add(btn2021);
        panFomation.add(btn2022);
        //필드, 유니폼
        setPlayerIcon();
    }
    //포메이션
    private void setPlayerIcon() {
        img = new ImageIcon("src/uniform_img/ground1.png");
        img1 = new ImageIcon("src/playerFace/Courtois.png");
        img2 = new ImageIcon("src/playerFace/Cancelo.png");
        img3 = new ImageIcon("src/playerFace/Van Dijk.png");
        img4 = new ImageIcon("src/playerFace/Hakimi.png");
        img5 = new ImageIcon("src/playerFace/Casemiro.png");
        img6 = new ImageIcon("src/playerFace/De Bruyne.png");
        img7 = new ImageIcon("src/playerFace/Modrić.png");
        img8 = new ImageIcon("src/playerFace/Mbappé.png");
        img9 = new ImageIcon("src/playerFace/Haaland.png");
        img10 = new ImageIcon("src/playerFace/Benzema.png");
        img11 = new ImageIcon("src/playerFace/Messi.png");
        img12 = new ImageIcon("src/playerFace/Ronaldo.png");
        img13 = new ImageIcon("src/playerFace/Alaba.png");
        img14 = new ImageIcon("src/playerFace/Bonucci.png");
        img15 = new ImageIcon("src/playerFace/Dias.png");
        img16 = new ImageIcon("src/playerFace/Donnarumma.png");
        img17 = new ImageIcon("src/playerFace/Jorjinho.png");
        img18 = new ImageIcon("src/playerFace/Kanté.png");
        img19 = new ImageIcon("src/playerFace/Lewandowski.png");
        img20 = new ImageIcon("src/playerFace/Alisson.png");
        img21 = new ImageIcon("src/playerFace/Davies.png");
        img22 = new ImageIcon("src/playerFace/Ramos.png");
        img23 = new ImageIcon("src/playerFace/Alexander-Arnold.png");
        img24 = new ImageIcon("src/playerFace/Kimmich.png");
        img25 = new ImageIcon("src/playerFace/Alcântara.png");
        img26 = new ImageIcon("src/playerFace/Marcelo.png");
        img27 = new ImageIcon("src/playerFace/De Ligt.png");
        img28 = new ImageIcon("src/playerFace/F. de Jong.png");
        img29 = new ImageIcon("src/playerFace/E. Hazard.png");
        img30 = new ImageIcon("src/playerFace/De Gea.png");
        img31 = new ImageIcon("src/playerFace/Alves.png");
        img32 = new ImageIcon("src/playerFace/Varane.png");


        //필드
        imglbl = new JLabel(img);
        imglbl.setBounds(0, 55, 1600, 845);
        //GK
        lbl1 = new JLabel();
        lbl1.setText("Courtois");
        lbl1.setIcon(img1);
        lbl1.setHorizontalTextPosition(JLabel.CENTER);
        lbl1.setVerticalTextPosition(JLabel.BOTTOM);
        lbl1.setSize(130, 130);
        lbl1.setLocation(200, 400);
        lbl1.addMouseMotionListener(this);
        //LB
        lbl2 = new JLabel();
        lbl2.setText("Cancelo");
        lbl2.setIcon(img2);
        lbl2.setHorizontalTextPosition(JLabel.CENTER);
        lbl2.setVerticalTextPosition(JLabel.BOTTOM);
        lbl2.setSize(130, 130);
        lbl2.setLocation(390, 110);
        lbl2.addMouseMotionListener(this);
        //CB1
        lbl3 = new JLabel();
        lbl3.setText("Van Dijk");
        lbl3.setIcon(img3);
        lbl3.setHorizontalTextPosition(JLabel.CENTER);
        lbl3.setVerticalTextPosition(JLabel.BOTTOM);
        lbl3.setSize(130, 130);
        lbl3.setLocation(370, 400);
        lbl3.addMouseMotionListener(this);
        //RB
        lbl4 = new JLabel();
        lbl4.setText("Hakimi");
        lbl4.setIcon(img4);
        lbl4.setHorizontalTextPosition(JLabel.CENTER);
        lbl4.setVerticalTextPosition(JLabel.BOTTOM);
        lbl4.setSize(130, 130);
        lbl4.setLocation(380, 695);
        lbl4.addMouseMotionListener(this);
        //LM
        lbl5 = new JLabel();
        lbl5.setText("Casemiro");
        lbl5.setIcon(img5);
        lbl5.setHorizontalTextPosition(JLabel.CENTER);
        lbl5.setVerticalTextPosition(JLabel.BOTTOM);
        lbl5.setSize(130, 130);
        lbl5.setLocation(800, 205);
        lbl5.addMouseMotionListener(this);
        //CM
        lbl6 = new JLabel();
        lbl6.setText("De Bruyne");
        lbl6.setIcon(img6);
        lbl6.setHorizontalTextPosition(JLabel.CENTER);
        lbl6.setVerticalTextPosition(JLabel.BOTTOM);
        lbl6.setSize(130, 130);
        lbl6.setLocation(715, 400);
        lbl6.addMouseMotionListener(this);
        //RM
        lbl7 = new JLabel();
        lbl7.setText("Modrić");
        lbl7.setIcon(img7);
        lbl7.setHorizontalTextPosition(JLabel.CENTER);
        lbl7.setVerticalTextPosition(JLabel.BOTTOM);
        lbl7.setSize(130, 130);
        lbl7.setLocation(800, 600);
        lbl7.addMouseMotionListener(this);
        //LW
        lbl8 = new JLabel();
        lbl8.setText("Mbappé");
        lbl8.setIcon(img8);
        lbl8.setHorizontalTextPosition(JLabel.CENTER);
        lbl8.setVerticalTextPosition(JLabel.BOTTOM);
        lbl8.setSize(130, 130);
        lbl8.setLocation(1060, 125);
        lbl8.addMouseMotionListener(this);
        //ST1
        lbl9 = new JLabel();
        lbl9.setText("Haaland");
        lbl9.setIcon(img9);
        lbl9.setHorizontalTextPosition(JLabel.CENTER);
        lbl9.setVerticalTextPosition(JLabel.BOTTOM);
        lbl9.setSize(130, 130);
        lbl9.setLocation(1140, 325);
        lbl9.addMouseMotionListener(this);
        //ST2
        lbl10 = new JLabel();
        lbl10.setText("Benzema");
        lbl10.setIcon(img10);
        lbl10.setHorizontalTextPosition(JLabel.CENTER);
        lbl10.setVerticalTextPosition(JLabel.BOTTOM);
        lbl10.setSize(130, 130);
        lbl10.setLocation(1140, 515);
        lbl10.addMouseMotionListener(this);
        //RW
        lbl11 = new JLabel();
        lbl11.setText("Messi");
        lbl11.setIcon(img11);
        lbl11.setHorizontalTextPosition(JLabel.CENTER);
        lbl11.setVerticalTextPosition(JLabel.BOTTOM);
        lbl11.setSize(130, 130);
        lbl11.setLocation(1060, 690);
        lbl11.addMouseMotionListener(this);

        panFomation.add(lbl1);
        panFomation.add(lbl2);
        panFomation.add(lbl3);
        panFomation.add(lbl4);
        panFomation.add(lbl5);
        panFomation.add(lbl6);
        panFomation.add(lbl7);
        panFomation.add(lbl8);
        panFomation.add(lbl9);
        panFomation.add(lbl10);
        panFomation.add(lbl11);
        panFomation.add(imglbl);

        add(panFomation, BorderLayout.CENTER);
    }

    //툴바
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

    //상단 메뉴 클릭시
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
        //버튼 클릭 시 이벤트
        Object obj = e.getSource();
        if (obj == btn2022) {
            //GK
            lbl1.setText("Courtois");
            lbl1.setIcon(img1);
            lbl1.setLocation(200, 400);
            //LB
            lbl2.setText("Cancelo");
            lbl2.setIcon(img2);
            lbl2.setSize(130, 130);
            lbl2.setLocation(390, 110);
            //CB1
            lbl3.setText("Van Dijk");
            lbl3.setIcon(img3);
            lbl3.setSize(130, 130);
            lbl3.setLocation(370, 400);
            //RB
            lbl4.setText("Hakimi");
            lbl4.setIcon(img4);
            lbl4.setSize(130, 130);
            lbl4.setLocation(380, 695);
            //LM
            lbl5.setText("Casemiro");
            lbl5.setIcon(img5);
            lbl5.setSize(130, 130);
            lbl5.setLocation(800, 205);
            //CM
            lbl6.setText("De Bruyne");
            lbl6.setIcon(img6);
            lbl6.setSize(130, 130);
            lbl6.setLocation(715, 400);
            //RM
            lbl7.setText("Modrić");
            lbl7.setIcon(img7);
            lbl7.setSize(130, 130);
            lbl7.setLocation(800, 600);
            //LW
            lbl8.setText("Mbappé");
            lbl8.setIcon(img8);
            lbl8.setSize(130, 130);
            lbl8.setLocation(1060, 125);
            //ST1
            lbl9.setText("Haaland");
            lbl9.setIcon(img9);
            lbl9.setSize(130, 130);
            lbl9.setLocation(1140, 325);
            //ST2
            lbl10.setText("Benzema");
            lbl10.setIcon(img10);
            lbl10.setSize(130, 130);
            lbl10.setLocation(1140, 515);
            //RW
            lbl11.setText("Messi");
            lbl11.setIcon(img11);
            lbl11.setLocation(1060, 690);
        }
        else if (obj == btn2021) {
            //GK
            lbl1.setText("Donnarumma");
            lbl1.setIcon(img16);
            lbl1.setLocation(200, 400);
            //LB
            lbl2.setText("Alaba");
            lbl2.setIcon(img13);
            lbl2.setSize(130, 130);
            lbl2.setLocation(390, 110);
            //CB1
            lbl3.setText("Bonucci");
            lbl3.setIcon(img14);
            lbl3.setSize(130, 130);
            lbl3.setLocation(370, 400);
            //RB
            lbl4.setText("Dias");
            lbl4.setIcon(img15);
            lbl4.setSize(130, 130);
            lbl4.setLocation(380, 695);
            //LM
            lbl5.setText("Kanté");
            lbl5.setIcon(img18);
            lbl5.setSize(130, 130);
            lbl5.setLocation(800, 205);
            //CM
            lbl6.setText("Jorjinho");
            lbl6.setIcon(img17);
            lbl6.setSize(130, 130);
            lbl6.setLocation(715, 400);
            //RM
            lbl7.setText("De Bruyne");
            lbl7.setIcon(img6);
            lbl7.setSize(130, 130);
            lbl7.setLocation(800, 600);
            //LW
            lbl8.setText("Ronaldo");
            lbl8.setIcon(img12);
            lbl8.setSize(130, 130);
            lbl8.setLocation(1060, 125);
            //ST1
            lbl9.setText("Haaland");
            lbl9.setIcon(img9);
            lbl9.setSize(130, 130);
            lbl9.setLocation(1140, 325);
            //ST2
            lbl10.setText("Lewandowski");
            lbl10.setIcon(img19);
            lbl10.setSize(130, 130);
            lbl10.setLocation(1140, 515);
            //RW
            lbl11.setText("Messi");
            lbl11.setIcon(img11);
            lbl11.setLocation(1060, 690);
        }
        else if (obj == btn2020) {
            //GK
            lbl1.setText("Alisson");
            lbl1.setIcon(img20);
            lbl1.setLocation(200, 400);
            //LB
            lbl2.setText("Davies");
            lbl2.setIcon(img21);
            lbl2.setLocation(390, 110);
            //CB1
            lbl3.setText("Van Dijk");
            lbl3.setIcon(img3);
            lbl3.setLocation(360, 300);
            //CB2
            lbl4.setText("Ramos");
            lbl4.setIcon(img22);
            lbl4.setLocation(360, 490);
            //RB
            lbl5.setText("Alexander-Arnold");
            lbl5.setIcon(img23);
            lbl5.setLocation(380, 695);
            //LM
            lbl6.setText("Kimmich");
            lbl6.setIcon(img24);
            lbl6.setLocation(800, 205);
            //CM
            lbl7.setText("De Bruyne");
            lbl7.setIcon(img6);
            lbl7.setLocation(715, 400);
            //RM
            lbl8.setText("Alcântara");
            lbl8.setIcon(img25);
            lbl8.setLocation(800, 600);
            //LW
            lbl9.setText("Messi");
            lbl9.setIcon(img11);
            lbl9.setLocation(1060, 125);
            //ST
            lbl10.setText("Lewandowski");
            lbl10.setIcon(img19);
            lbl10.setLocation(1220, 400);
            //RW
            lbl11.setText("Ronaldo");
            lbl11.setIcon(img12);
            lbl11.setLocation(1060, 690);
        }
        else if (obj == btn2019) {
            //GK
            lbl1.setText("Alisson");
            lbl1.setIcon(img20);
            lbl1.setLocation(200, 400);
            //LB
            lbl2.setText("Marcelo");
            lbl2.setIcon(img26);
            lbl2.setLocation(390, 110);
            //CB1
            lbl3.setText("Van Dijk");
            lbl3.setIcon(img3);
            lbl3.setLocation(360, 300);
            //CB2
            lbl4.setText("De Ligt");
            lbl4.setIcon(img27);
            lbl4.setLocation(360, 490);
            //RB
            lbl5.setText("Ramos");
            lbl5.setIcon(img22);
            lbl5.setLocation(380, 695);
            //LM
            lbl6.setText("F. de Jong");
            lbl6.setIcon(img28);
            lbl6.setLocation(800, 205);
            //CM
            lbl7.setText("Modrić");
            lbl7.setIcon(img7);
            lbl7.setLocation(715, 400);
            //RM
            lbl8.setText("E. Hazard");
            lbl8.setIcon(img29);
            lbl8.setLocation(800, 600);
            //LW
            lbl9.setText("Mbaappé");
            lbl9.setIcon(img8);
            lbl9.setLocation(1060, 125);
            //ST
            lbl10.setText("Ronaldo");
            lbl10.setIcon(img12);
            lbl10.setLocation(1220, 400);
            //RW
            lbl11.setText("Messi");
            lbl11.setIcon(img11);
            lbl11.setLocation(1060, 690);
        }
        else if (obj == btn2018) {
            //GK
            lbl1.setText("De Gea");
            lbl1.setIcon(img30);
            lbl1.setLocation(200, 400);
            //LB
            lbl2.setText("Marcelo");
            lbl2.setIcon(img26);
            lbl2.setLocation(390, 110);
            //CB1
            lbl3.setText("Ramos");
            lbl3.setIcon(img22);
            lbl3.setLocation(360, 300);
            //CB2
            lbl4.setText("Varane");
            lbl4.setIcon(img32);
            lbl4.setLocation(360, 490);
            //RB
            lbl5.setText("Alves");
            lbl5.setIcon(img31);
            lbl5.setLocation(380, 695);
            //LM
            lbl6.setText("E. Hazard");
            lbl6.setIcon(img29);
            lbl6.setLocation(800, 205);
            //CM
            lbl7.setText("Kanté");
            lbl7.setIcon(img18);
            lbl7.setLocation(715, 400);
            //RM
            lbl8.setText("Modrić");
            lbl8.setIcon(img7);
            lbl8.setLocation(800, 600);
            //LW
            lbl9.setText("Ronaldo");
            lbl9.setIcon(img12);
            lbl9.setLocation(1060, 125);
            //ST
            lbl10.setText("Messi");
            lbl10.setIcon(img11);
            lbl10.setLocation(1220, 400);
            //RW
            lbl11.setText("Mbaappé");
            lbl11.setIcon(img8);
            lbl11.setLocation(1060, 690);
        }
    }
    //선수 아이콘 드래그
    @Override
    public void mouseDragged(MouseEvent e) {
        Object obj = e.getSource();
        int x = e.getX();
        int y = e.getY();
        if (obj == lbl1) {
            lbl1.setLocation(lbl1.getX() + x - 50, lbl1.getY() + y - 55);
        } else if (obj == lbl2) {
            lbl2.setLocation(lbl2.getX() + x - 50, lbl2.getY() + y - 55);
        } else if (obj == lbl3) {
            lbl3.setLocation(lbl3.getX() + x - 50, lbl3.getY() + y - 55);
        } else if (obj == lbl4) {
            lbl4.setLocation(lbl4.getX() + x - 50, lbl4.getY() + y - 55);
        } else if (obj == lbl5) {
            lbl5.setLocation(lbl5.getX() + x - 50, lbl5.getY() + y - 55);
        } else if (obj == lbl6) {
            lbl6.setLocation(lbl6.getX() + x - 50, lbl6.getY() + y - 55);
        } else if (obj == lbl7) {
            lbl7.setLocation(lbl7.getX() + x - 50, lbl7.getY() + y - 55);
        } else if (obj == lbl8) {
            lbl8.setLocation(lbl8.getX() + x - 50, lbl8.getY() + y - 55);
        } else if (obj == lbl9) {
            lbl9.setLocation(lbl9.getX() + x - 50, lbl9.getY() + y - 55);
        } else if (obj == lbl10) {
            lbl10.setLocation(lbl10.getX() + x - 50, lbl10.getY() + y - 55);
        } else if (obj == lbl11) {
            lbl11.setLocation(lbl11.getX() + x - 50, lbl11.getY() + y - 55);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}


