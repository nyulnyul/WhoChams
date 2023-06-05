package swing;

import DB.TeamStatList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.DB.conn;

public class LeagueTable extends JFrame implements KeyListener, ActionListener, MouseListener {

    private final String userid;
    private TeamStatList TeamStats;
    private JTextField search;
    private JTable TeamTable;
    private JTable icontable;
    private String teamName;

    public LeagueTable(String userid) {
        this.userid = userid;
        initComponents();
    }


    private JPanel c;
    private Color b;
    private JLabel lblNick;
    private JLabel lblcong;
    private JTextField Nickn;
    private JButton btnLogout;
    private String userID;

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("팀스텟");
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        b = new Color(4, 27, 158);

        c = new JPanel();  // 인덱스 배경화면 색 패널
        c.setBackground(b);
        add(c);
        setAppbar(userid);
        setLeagueTable();
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

    private void setLeagueTable() {
        JPanel jp = new JPanel();
        jp.setLayout(null);


        TeamStats = new TeamStatList(); //팀 스텟 리스트 생성
        TeamStats.setData();
        TeamTable = new JTable(TeamStats); //팀 스텟 리스트를 테이블에 삽입 및 테이블 설정
        TeamTable.setRowHeight(43);
        TeamTable.setFont(new Font("고딕", Font.BOLD, 15));
        TeamTable.setAlignmentX(0);
        TeamTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TeamTable.setBackground(new Color(44, 47, 51));
        TeamTable.setForeground(Color.WHITE);


        String[] columns = {" "};
        Object[][] data = { //이미지 테이블에 들어갈 데이터
                {new ImageIcon("src/iconimg/mc.png")},
                {new ImageIcon("src/iconimg/inter.png")},
                {new ImageIcon("src/iconimg/rm.png")},
                {new ImageIcon("src/iconimg/ac.png")},
                {new ImageIcon("src/iconimg/bm.png")},
                {new ImageIcon("src/iconimg/np.png")},
                {new ImageIcon("src/iconimg/ch.png")},
                {new ImageIcon("src/iconimg/bf.png")},
                {new ImageIcon("src/iconimg/rp.png")},
                {new ImageIcon("src/iconimg/psg.png")},
                {new ImageIcon("src/iconimg/pt.png")},
                {new ImageIcon("src/iconimg/rc.png")},
                {new ImageIcon("src/iconimg/dm.png")},
                {new ImageIcon("src/iconimg/tt.png")},
                {new ImageIcon("src/iconimg/cb.png")},
                {new ImageIcon("src/iconimg/ir.png")},

        };
        DefaultTableModel model = new DefaultTableModel(data, columns); //모델에 담기

        icontable = new JTable(model) { //이미지 테이블 설정
            public Class getColumnClass(int column) {
                return (column == 0) ? Icon.class : Object.class;
            } //삼항연산자를 이용 컬럼값이 0이면 아이콘 값을 가져오고 아니면 오브젝트 값을 가져옴
        };
        JScrollPane sp = new JScrollPane(icontable);
        icontable.setRowHeight(43); //이미지 테이블 설정
        icontable.setFont(new Font("고딕", Font.BOLD, 15));
        icontable.setAlignmentX(0);
        icontable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        icontable.setBackground(new Color(44, 47, 51));
        icontable.setForeground(Color.WHITE);
        icontable.addMouseListener(this);
        sp.setBounds(90, 120, 190, 723);
        jp.add(sp);

        JScrollPane Mainsp = new JScrollPane(TeamTable);
        Mainsp.setBounds(280, 120, 1200, 723);
        jp.add(Mainsp);

        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        //테이블 헤더 설정 - 이미지
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        JTableHeader header = icontable.getTableHeader();
        header.setPreferredSize(new Dimension(200, 30));
        header.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        //테이블 헤더 - 리스트
        JTableHeader header2 = TeamTable.getTableHeader();
        header2.setPreferredSize(new Dimension(200, 30));
        header2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        search = new JTextField(); //검색창 생성
        search.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        search.setBounds(210, 62, 673, 26);
        jp.add(search);
        search.setColumns(10);

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
    public void keyTyped(KeyEvent e) {
        String val = search.getText();
        //현재 행이 데이터를 갖고 있지 않으면 정리가 되도록함
        TableRowSorter<TableModel> trs = new TableRowSorter<>(TeamTable.getModel());
        TeamTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(val)); //테이블에 입력한 값을 필터링함
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) { // 해당 아이콘을 클릭한 경우
            int row = icontable.getSelectedRow(); // 선택한 아이콘의 행 번호를 가져옴
             teamName = ""; // 선택한 아이콘에 대한 정보를 저장할 변수

            switch (row) { // 선택한 아이콘에 대한 정보를 teamName 변수에 저장
                case 0:
                    teamName = "Manchester city";
                    break;
                case 1:
                    teamName = "Inter";
                    break;
                case 2:
                    teamName = "Real madrid";
                    break;
                case 3:
                    teamName = "AC milan";
                    break;
                case 4:
                    teamName = " Bayern Munich";
                    break;
                case 5:
                    teamName = "Napoli";
                    break;
                case 6:
                    teamName = "Chelsea";
                    break;
                case 7:
                    teamName = "Benfica";
                    break;
                case 8:
                    teamName = "Liverpool FC";
                    break;
                case 9:
                    teamName = "Paris Saint-Germain";
                    break;
                case 10:
                    teamName = "FC Porto";
                    break;
                case 11:
                    teamName = "RB Leipzig";
                    break;
                case 12:
                    teamName = "Borussia Dortmund";
                    break;
                case 13:
                    teamName = "Tottenham Hotspur";
                    break;
                case 14:
                    teamName = "Club Bruges";
                    break;
                case 15:
                    teamName = "Eintracht Frankfurt";
                    break;

            }

            // 저장한 정보를 stats() 클래스로 전달하는 코드 작성
            new Stats(userid, teamName); // stats() 클래스에서 teamName 변수를 활용
            this.dispose(); // 현재 창 닫기
        }

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
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
