package swing;

import DB.DB;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DB.DB.conn;

public class LoginForm extends JFrame implements ActionListener {
	// 전역변수 선언
	private JLabel lblId;
	private JLabel lblPw;
	private JTextField tfId;
	private JPasswordField tfPw;
	private JButton btnJoin;
	private JButton btnLogin;
	private JPanel c;
	private String s;
	private Color b;

	public LoginForm() {
		initComponents();
	} // 로그인 창을 띄움 메인페이지가 유일하게 존재함으로 이곳을 통해서만 접근 가능 -ㅅ

	private void initComponents() { // 기본세팅
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("로그인");
		setSize(1600, 1000);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		b = new Color(4, 27, 158);

		setAppbar();
		setLogininfo();

		setVisible(true);
		tfId.requestFocus();
	} // jframe 기본 세팅

	private void setAppbar() { // 모든 페이지에 들어가는 메인바 세팅 -ㅅ
		JPanel pN = new JPanel();
		pN.setLayout(new FlowLayout());

		JToolBar toolbar = new JToolBar();
		Color sb = new Color(1, 0, 44);

		toolbar.setBackground(sb);
		toolbar.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		toolbar.setBorder(new EmptyBorder(0, 5, 0, 5));
		toolbar.setPreferredSize(new Dimension(1450, 55));

		// 앱바에 들어갈 버튼들 선언
		JButton mainMenu = new JButton(" ");
		mainMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		mainMenu.setBackground(sb);
		mainMenu.setBorderPainted(false);
		mainMenu.addActionListener(this);
		toolbar.add(mainMenu);

		JButton teamMenu = new JButton("매치");
		teamMenu.setForeground(Color.WHITE);
		teamMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		teamMenu.setBackground(sb);
		teamMenu.setBorderPainted(false);
		teamMenu.setPreferredSize(new Dimension(150, 40));
		teamMenu.addActionListener(this);
		toolbar.add(teamMenu);

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

		JButton statMenu = new JButton("역대 우승팀");
		statMenu.setForeground(Color.WHITE);
		statMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		statMenu.setBackground(sb);
		statMenu.setBorderPainted(false);
		statMenu.setPreferredSize(new Dimension(150, 40));
		statMenu.addActionListener(this);
		toolbar.add(statMenu);

		// 메인페이지 이미지 라벨
		JLabel imgLabel = new JLabel();
		ImageIcon icon = new ImageIcon("src/iconimg/mmain.png");
		Image img = icon.getImage();
		Image updateImg = img.getScaledInstance(180, 50, Image.SCALE_SMOOTH);
		ImageIcon updateIcon = new ImageIcon(updateImg);
		imgLabel.setIcon(updateIcon);
		imgLabel.setPreferredSize(new Dimension(180, 40));
		imgLabel.setHorizontalAlignment(JLabel.CENTER);
		mainMenu.add(imgLabel);

		// 로그인 기능 구현
		lblId = new JLabel("ID");
		lblId.setForeground(Color.WHITE);
		lblId.setPreferredSize(new Dimension(30, 30));
		lblPw = new JLabel("Password");
		lblPw.setForeground(Color.WHITE);
		lblPw.setPreferredSize(new Dimension(80, 30));

		tfId = new JTextField(10);
		tfPw = new JPasswordField(10);

		btnJoin = new JButton("가입");
		btnJoin.setPreferredSize(new Dimension(50, 25));
		btnLogin = new JButton("로그인");
		btnLogin.setPreferredSize(new Dimension(50, 25));

		JPanel IDpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		IDpanel.add(lblId);
		IDpanel.add(tfId);
		IDpanel.setBackground(sb);

		JPanel PWpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		PWpanel.add(lblPw);
		PWpanel.add(tfPw);
		PWpanel.setBackground(sb);

		toolbar.add(IDpanel);
		toolbar.add(PWpanel);
		toolbar.add(btnLogin);
		toolbar.add(btnJoin);
		btnJoin.addActionListener(this);
		btnLogin.addActionListener(this);
		Color b = new Color(3, 2, 137);
		pN.setBackground(b);
		pN.add(toolbar, BorderLayout.NORTH);
		add(pN, BorderLayout.NORTH);
	}

	private void setLogininfo() {
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());

		JLabel labLogin = new JLabel();
		ImageIcon LoginImg = new ImageIcon("src/iconimg/loginImg.jpg");
		labLogin.setIcon(LoginImg);

		jp.add(labLogin);
		add(jp, BorderLayout.CENTER);
//        jp.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 200));
//        jp.setPreferredSize(new Dimension(300, 900));
//        jp.setBackground(b);
//        JTextArea jta = new JTextArea("2022 - 2023 챔피언스리그 프로그램. 사용을 위해서 로그인 해주세요. " +
//                "\n로그인 전에는 사용이 제한 됩니다. 계정이 존재하지 않다면 회원가입 해주세요 "+
//                "\n(made by Java d'Or :202045040 서은율, 202045052 김수현)" );
//        jta.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
//        jta.setBackground(b);
//        jta.setForeground(Color.WHITE);
//        jta.setEditable(false);
//        jp.add(jta);
//        add(jp, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new LoginForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 로그인을 하지 않으면 다른 버튼들 기능 이용하지 못하게 함
		if (e.getActionCommand().equals("검색")) {
			this.dispose();
		} else if (e.getActionCommand().equals("베스트일레븐")) {
			this.dispose();
		} else if (e.getActionCommand().equals("토너먼트")) {
			this.dispose();
		} else if (e.getActionCommand().equals("역대 우승팀")) {
			this.dispose();
		} else if (e.getActionCommand().equals(" ")) {
			this.dispose();
			// 회원가입을 누를 시 회원가입 페이지를 열고 임시로 로그인 페이지를 닫음
		} else if (e.getSource() == btnJoin) {
			setVisible(false);
			new JoinForm(LoginForm.this);
			tfId.setText("");
			tfPw.setText("");
		} else if (e.getSource() == btnLogin) {
			// 아이디칸이 비었을 경우
			if (tfId.getText().isEmpty()) {
				JOptionPane.showMessageDialog(LoginForm.this, "아이디를 입력하세요.", "로그인폼", JOptionPane.WARNING_MESSAGE);
				// 존재하는 아이디일 경우
			} else if (tfId != null && tfPw != null) {
				try {
					if (DB.conn == null) { // DB와 연동
						DB.init();
					}
					// 쿼리를 작성하여 DB에서 계정 정보를 가져옴
					String query = "SELECT * FROM acc WHERE id = ? AND pass = ?";
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setString(1, tfId.getText());
					pstmt.setString(2, String.valueOf(tfPw.getPassword()));

					s = tfId.getText();

					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) { // 데이터베이스에 접속해 로그인 정보가 존재하면 로그인 성공
						System.out.println("로그인 성공");
						JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
						dispose(); // 해당 페이지를 닫고 로그인 한 사람만 접근 가능한 메인 페이지로 이동
						new MainPage(s); // 해당 로그인의 아이디 정보를 이용해 모든 페이지에 아이디 정보를 공유하기 위함
					} else {
						// 비밀번호칸이 비었을 경우
						if (String.valueOf(tfPw.getPassword()).isEmpty()) {
							JOptionPane.showMessageDialog(LoginForm.this, "비밀번호를 입력하세요.", "로그인폼",
									JOptionPane.WARNING_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(LoginForm.this, "존재하지 않는 Id입니다."

							);
						}
					}
					pstmt.close();
					rs.close();
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}

			}

		}
	}
}
