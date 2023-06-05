package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class PlayerStatList extends AbstractTableModel {

    Vector data = new Vector(); // 테이블의 데이터를 저장하기 위한 벡터
    Vector colName = new Vector(); // 테이블의 컬럼명을 저장하기 위한 벡터
    private String sql,Player, Goal, Assist, Yellow, Red,Rate,Clean,team;

    @Override
    public int getRowCount() {

        return data.size(); // 데이터의 개수를 정해주는 메소드
    }

    @Override
    public int getColumnCount() {

        return colName.size(); // 컬럼의 개수를 정해주는 메소드
    }

    @Override
    public Object getValueAt(int row, int col) {

        Vector rowData = (Vector) data.elementAt(row); // 각 셀의 데이터를 저장하는 벡터
        Object returnValue = rowData.elementAt(col); // 각 셀의 데이터를 저장하는 벡터에서 해당 데이터를 가져옴

        return returnValue; // 각 셀의 데이터를 결정하는 메소드
    }

    public String getColumnName(int col) {
        String name = (String) colName.elementAt(col); // 컬럼명을 저장하는 벡터에서 해당 데이터를 가져옴
        return name; // 컬럼명을 정해주는 메소드
    }

    public void setData(String teamname) {
        DB.init();

          sql = "SELECT * FROM Stat WHERE TEAM='" + teamname + "' ORDER BY Rate DESC";
//        sql = "select * from Stat where TEAM='" + teamname + "'order by Rate DESC' "; //쿼리문

        ResultSet rs = DB.getResult(sql); // DB에서 데이터를 가져오는 메소드

        String list[] = { "선수명", "골", "어시", "경고", "퇴장", "평점","클린시트","팀" };

        for (int i = 0; i < list.length; i++) {
            colName.addElement(list[i]); // 컬럼명을 정해주는 메소드
        }

        try {
            while (rs.next()) {

                Vector vpn = new Vector();



                Player = rs.getString("PLAYER");
                Goal = rs.getString("GOAL");
                Assist = rs.getString("ASSIST");
                Yellow = rs.getString("YELLOW");
                Red = rs.getString("RED");
                Rate = rs.getString("RATE");
                Clean = rs.getString("CLEAN");
                team = rs.getString("TEAM");

                vpn.addElement(Player);
                vpn.addElement(Goal);
                vpn.addElement(Assist);
                vpn.addElement(Yellow);
                vpn.addElement(Red);
                vpn.addElement(Rate);
                vpn.addElement(Clean);
                vpn.addElement(team);

                data.addElement(vpn);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }


}
