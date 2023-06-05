//appbar

package swing;

import DB.PlayerStatList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.DB.conn;

public class Stats extends JFrame implements ActionListener, KeyListener {
    private final String userid;
    private final String teamName;
    private JTable StatTable;
    private JTextField search;
    private PlayerStatList PlayerStats;
    private Color b;
    private JLabel lblNick;
    private JLabel lblcong;
    private JTextField Nickn;
    private JButton btnLogout;
    private String userID;

    public Stats(String userid, String teamName) {
        this.userid = userid;
        this.teamName = teamName;
        initComponents();
    }

    private JPanel c;

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("선수스텟");
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        b = new Color(4, 27, 158);

        c = new JPanel();  // 인덱스 배경화면 패널
        c.setBackground(b);
        add(c);
        setAppbar(userid);
        setStatTable(teamName);
        setVisible(true);
    } //jframe 기본 세팅

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

    private void setStatTable(String Teamname) {
        JPanel jp = new JPanel();
        jp.setLayout(null);

        PlayerStats = new PlayerStatList(); //팀 스텟 리스트 생성
        PlayerStats.setData(Teamname);
        StatTable = new JTable(PlayerStats); //팀 스텟 리스트를 테이블에 삽입 및 테이블 설정
        StatTable.setRowHeight(43);
        StatTable.setFont(new Font("고딕", Font.BOLD, 15));
        StatTable.setAlignmentX(0);
        StatTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        StatTable.setBackground(new Color(44, 47, 51));
        StatTable.setForeground(Color.WHITE);

        JScrollPane sp = new JScrollPane(StatTable);
        sp.setBounds(90, 120, 1390, 723);
        jp.add(sp);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        JTableHeader header = StatTable.getTableHeader();
        header.setPreferredSize(new Dimension(200, 30));
        header.setFont(new Font("맑은 고딕", Font.BOLD, 17));

        search = new JTextField(); //검색창 생성
        search.setFont(new Font("굴림", Font.PLAIN, 17));
        search.setBounds(210, 62, 673, 26);
        jp.add(search);
        search.setColumns(10);
        search.setText(Teamname);
        search.setEditable(false);


        JLabel searchLabel = new JLabel("팀 이름 : ");
        searchLabel.setFont(new Font("굴림", Font.BOLD, 17));
        searchLabel.setForeground(Color.WHITE);
        searchLabel.setBounds(112, 62, 117, 26);
        jp.add(searchLabel);
        search.addKeyListener(this);

        jp.setBackground(b);
        add(jp, BorderLayout.CENTER);
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

    @Override
    public void keyTyped(KeyEvent e) {
        String val = search.getText();
        //현재 행이 데이터를 갖고 있지 않으면 정리가 되도록함
        TableRowSorter<TableModel> trs = new TableRowSorter<>(StatTable.getModel());
        StatTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(val));//필터링
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}