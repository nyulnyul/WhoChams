package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class TeamStatList extends AbstractTableModel {

    Vector data = new Vector(); // 테이블의 데이터를 저장하기 위한 벡터
    Vector colName = new Vector(); // 테이블의 컬럼명을 저장하기 위한 벡터
    private String sql,name, PL, W, D, L,GD,PTS,RESULTS;

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

        sql = "select * from TeamStat"; //쿼리문

        ResultSet rs = DB.getResult(sql); // DB에서 데이터를 가져오는 메소드

        String list[] = { "팀명", "경기 수", "승", "무", "패", "골","승점","결과" };

        for (int i = 0; i < list.length; i++) {
            colName.addElement(list[i]); // 컬럼명을 정해주는 메소드
        }

        try {
            while (rs.next()) {

                Vector vpn = new Vector();



                //icon = rs.getString("icon"); // DB에서 가져온 데이터를 변수에 저장
                name = rs.getString("NAME");
                PL = rs.getString("PL");
                W = rs.getString("W");
                D = rs.getString("D");
                L = rs.getString("L");
                GD = rs.getString("GD");
                PTS = rs.getString("PTS");
                RESULTS = rs.getString("RESULTS");

                vpn.addElement(name);
                vpn.addElement(PL);
                vpn.addElement(W);
                vpn.addElement(D);
                vpn.addElement(L);
                vpn.addElement(GD);
                vpn.addElement(PTS);
                vpn.addElement(RESULTS);

                //data.addElement(emblem);
                data.addElement(vpn);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

//    public static String[][] getStat() {
//
//        try {
//            DB.init();
//            ArrayList<String[]> list = new ArrayList<String[]>();
//            ResultSet rs = DB.getResult("select * from TeamStat"); // DB에서 데이터를 가져오는 메소드
//
//            while (rs.next()) {
//                list.add(new String[] { rs.getString("name"), rs.getString("PL"), rs.getString("W"),
//                        rs.getString("D"), rs.getString("L"), rs.getString("GD")
//                        , rs.getString("PTS"), rs.getString("RESULTS")} // DB에서 가져온 데이터를 변수에 저장
//
//                );
//            }
//
//            String[][] arr = new String[list.size()][6];
//            return list.toArray(arr);
//
//        } catch (Exception e) {
//            return null;
//        }
//    }
}
