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

public class History extends JFrame implements ActionListener {
    private Color b;
    private JPanel c;
    private JLabel lblNick;
    private JLabel lblcong;
    private JTextField Nickn;
    private JButton btnLogout;
    private String userID, userid;
    private Color sb = new Color(1, 0, 44);

    public History(String userid) {
        this.userid = userid;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("역대 우승팀");
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        b = new Color(4, 27, 158);

        c = new JPanel(); // 인덱스 배경화면 패널
        c.setBackground(b);
        add(c);
        setAppbar(userid);
        setTeamIcon();
        setVisible(true);
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

    private void setTeamIcon() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setPreferredSize(new Dimension(1600, 160));
        panel1.setBackground(new Color(232, 246, 246));

        ImageIcon imgTrophy = new ImageIcon("src/iconimg/챔스로고.jpg");
        JLabel labTrophy = new JLabel(imgTrophy);
        labTrophy.setBounds(720, 0, 160, 160);
        panel1.add(labTrophy);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(sb);

        //배열로 라벨생성, 라벨에 이미지 넣기
        int startValue = 1992;
        int labelWidth = 180; // 각 라벨의 가로 크기
        int labelHeight = 160; // 각 라벨의 세로 크기
        int x = 100; // 첫 번째 라벨의 x 좌표
        int y = 20; // 첫 번째 라벨의 y 좌표
        int totalRows = 4;
        int totalCols = 8;

        JLabel[][] labels = new JLabel[totalRows][totalCols];

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                labels[row][col] = new JLabel(String.valueOf(startValue));
                labels[row][col].setBounds(x + col * (labelWidth + 5), y + row * (labelHeight + 5), labelWidth, labelHeight);
                labels[row][col].setFont(new Font("맑은 고딕", Font.BOLD, 20));
                labels[row][col].setForeground(Color.WHITE);
                labels[row][col].setHorizontalTextPosition(JLabel.CENTER);
                labels[row][col].setVerticalTextPosition(JLabel.BOTTOM);

                String imagePath = getImagePath(startValue);
                ImageIcon icon = new ImageIcon(imagePath);
                labels[row][col].setIcon(icon);

                panel2.add(labels[row][col]);
                startValue++;
            }
        }
        labels[3][7].setLocation(1416, 560);

        panel.add(panel1, BorderLayout.NORTH);
        panel.add(panel2, BorderLayout.CENTER);
        add(panel);

    }
    //이미지 경로 설정
    private static String getImagePath(int year) {
        String imagePath;
        switch (year) {
            case 1998, 2000, 2002, 2014, 2016, 2017, 2018, 2022:
                imagePath = "src/Logo90/레알마드리드.png";
                break;
            case 1992, 2006, 2009, 2011, 2015:
                imagePath = "src/Logo90/바셀.png";
                break;
            case 1994, 2003, 2007:
                imagePath = "src/Logo90/AC밀란.png";
                break;
            case 2001, 2013, 2020:
                imagePath = "src/Logo90/뮌헨.png";
                break;
            case 1999, 2008:
                imagePath = "src/Logo90/맨유.png";
                break;
            case 2012, 2021:
                imagePath = "src/Logo90/첼시.png";
                break;
            case 2005, 2019:
                imagePath = "src/Logo90/리버풀.png";
                break;
            case 1993:
                imagePath = "src/Logo90/마르세유.png";
                break;
            case 1995:
                imagePath = "src/Logo90/아약스.png";
                break;
            case 1996:
                imagePath = "src/Logo90/유벤투스.png";
                break;
            case 1997:
                imagePath = "src/Logo90/도르트문트.png";
                break;
            case 2004:
                imagePath = "src/Logo90/포르투.png";
                break;
            case 2010:
                imagePath = "src/Logo90/인테르.png";
                break;
            default:
                imagePath = "";
                break;
        }
        return imagePath;
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
    }
}
