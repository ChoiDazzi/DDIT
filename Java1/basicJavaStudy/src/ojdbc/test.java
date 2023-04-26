package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "java");
		Statement statement = con.createStatement();
		String sql = "select mem_id from member";

		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			String memId = rs.getString("mem_id");
			System.out.println(memId);
		}
	}
}
