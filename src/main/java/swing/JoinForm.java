package swing;


import DB.DB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.DB.conn;
import static DB.DB.stmt;


public class JoinForm extends JDialog implements ActionListener {
    private LoginForm owner;


    private JLabel lblTitle;
    private JLabel lblId;
    private JLabel lblPw;
    private JLabel lblRe;
    private JLabel lblName;
    private JLabel lblNickName;
    private JRadioButton rbtnMale;
    private JRadioButton rbtnFemale;
    private JTextField tfId;
    private JPasswordField tfPw;
    private JPasswordField tfRe;
    private JTextField tfName;
    private JTextField tfNickName;
    private JButton btnJoin;
    private JButton btnCancel;
    private String ids;
    private String pws;
    private String namess;
    private String nicks;

    public JoinForm(LoginForm owner) {
        super(owner, "회원가입", true);
        this.owner = owner;
        init();
        setDisplay();
        showFrame();
    }

    private void init() {
        // 크기 고정
        int tfSize = 10;
        Dimension lblSize = new Dimension(80, 35);
        Dimension btnSize = new Dimension(100, 25);


        lblTitle = new JLabel("회원가입");
        lblTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        lblId = new JLabel("ID", JLabel.LEFT);
        lblId.setPreferredSize(lblSize);
        lblPw = new JLabel("Password", JLabel.LEFT);
        lblPw.setPreferredSize(lblSize);
        lblRe = new JLabel("Password 확인", JLabel.LEFT);
        lblRe.setPreferredSize(lblSize);
        lblName = new JLabel("이름", JLabel.LEFT);
        lblName.setPreferredSize(lblSize);
        lblNickName = new JLabel("닉네임", JLabel.LEFT);
        lblNickName.setPreferredSize(lblSize);

        tfId = new JTextField(tfSize);
        tfPw = new JPasswordField(tfSize);
        tfRe = new JPasswordField(tfSize);
        tfName = new JTextField(tfSize);
        tfNickName = new JTextField(tfSize);

        ButtonGroup group = new ButtonGroup();
        group.add(rbtnMale);
        group.add(rbtnFemale);
        btnJoin = new JButton("가입");
        btnJoin.setPreferredSize(btnSize);
        btnCancel = new JButton("취소");
        btnCancel.setPreferredSize(btnSize);
        DB.init();

    }

    private void setDisplay() {
        // FlowLayout 왼쪽 정렬
        FlowLayout flowLeft = new FlowLayout(FlowLayout.LEFT);

        // pnlMain(pnlMNorth / pnlMCenter / pnlMSouth)
        JPanel pnlMain = new JPanel(new BorderLayout());

        // pnlMNorth(lblTitle)
        JPanel pnlMNorth = new JPanel(flowLeft);
        pnlMNorth.add(lblTitle);

        // pnlMCenter(pnlId / pnlPw / pnlRe / pnlName / pnlNickName)
        JPanel pnlMCenter = new JPanel(new GridLayout(0, 1));
        JPanel pnlId = new JPanel(flowLeft);
        pnlId.add(lblId);
        pnlId.add(tfId);

        JPanel pnlPw = new JPanel(flowLeft);
        pnlPw.add(lblPw);
        pnlPw.add(tfPw);

        JPanel pnlRe = new JPanel(flowLeft);
        pnlRe.add(lblRe);
        pnlRe.add(tfRe);

        JPanel pnlName = new JPanel(flowLeft);
        pnlName.add(lblName);
        pnlName.add(tfName);
        JPanel pnlNickName = new JPanel(flowLeft);
        pnlNickName.add(lblNickName);
        pnlNickName.add(tfNickName);

        pnlMCenter.add(pnlId);
        pnlMCenter.add(pnlPw);
        pnlMCenter.add(pnlRe);
        pnlMCenter.add(pnlName);
        pnlMCenter.add(pnlNickName);


        // pnlMain
        pnlMain.add(pnlMNorth, BorderLayout.NORTH);
        pnlMain.add(pnlMCenter, BorderLayout.CENTER);

        // pnlSouth(btnJoin / btnCancel)
        JPanel pnlSouth = new JPanel();
        pnlSouth.add(btnJoin);
        pnlSouth.add(btnCancel);

        // 화면 테두리의 간격을 주기 위해 설정 (insets 사용 가능)
        pnlMain.setBorder(new EmptyBorder(0, 20, 0, 20));
        pnlSouth.setBorder(new EmptyBorder(0, 0, 10, 0));

        add(pnlMain, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.SOUTH);

        btnJoin.addActionListener(this);
        btnCancel.addActionListener(this);
    }


    public boolean isBlank() {
        boolean result = false;
        if (tfId.getText().isEmpty()) {
            tfId.requestFocus();
            return true;
        }
        if (String.valueOf(tfPw.getPassword()).isEmpty()) {
            tfPw.requestFocus();
            return true;
        }
        if (String.valueOf(tfRe.getPassword()).isEmpty()) {
            tfRe.requestFocus();
            return true;
        }
        if (tfName.getText().isEmpty()) {
            tfName.requestFocus();
            return true;
        }
        if (tfNickName.getText().isEmpty()) {
            tfNickName.requestFocus();
            return true;
        }
        return result;
    }


    private void showFrame() {
        pack();
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnJoin) {
            if (isBlank()) {
                JOptionPane.showMessageDialog(this, "빈칸을 채워주세요");
                return;
            }
            if (String.valueOf(tfPw.getPassword()).equals(String.valueOf(tfRe.getPassword()))) {
                try {
                    String sql = "INSERT INTO acc (id, pass, name, nickname) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, tfId.getText());
                    pstmt.setString(2, String.valueOf(tfPw.getPassword()));
                    pstmt.setString(3, tfName.getText());
                    pstmt.setString(4, tfNickName.getText());
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다.");
                    dispose();
                    new LoginForm();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
            }
        }else if(e.getSource() == btnCancel){
            dispose();
            new LoginForm();
        }
    }
}
