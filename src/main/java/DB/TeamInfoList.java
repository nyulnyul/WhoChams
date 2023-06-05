package DB;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class TeamInfoList extends AbstractTableModel {

    Vector data = new Vector(); // 테이블의 데이터를 저장하기 위한 벡터
    Vector colName = new Vector(); // 테이블의 컬럼명을 저장하기 위한 벡터
    private String sql,name, nation, grade, coach, league;

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

    public void setData() {
        DB.init();

        sql = "select * from teaminfo"; //쿼리문

        ResultSet rs = DB.getResult(sql); // DB에서 데이터를 가져오는 메소드

        String list[] = { "팀명", "국가", "성적", "감독", "리그"};

        for (int i = 0; i < list.length; i++) {
            colName.addElement(list[i]); // 컬럼명을 정해주는 메소드
        }

        try {
            while (rs.next()) {

                Vector vpn = new Vector();

                name = rs.getString("name");
                nation = rs.getString("Nation");
                grade = rs.getString("Grade");
                coach = rs.getString("Coach");
                league = rs.getString("League");

                vpn.addElement(name);
                vpn.addElement(nation);
                vpn.addElement(grade);
                vpn.addElement(coach);
                vpn.addElement(league);

                //data.addElement(emblem);
                data.addElement(vpn);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
