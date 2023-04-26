package ojdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DAO (Data Access Object) : DBMS에 직접 접근해서 CRUD를 하는 클래스
public class MemoDAO {

	//전체 Select, 한 개 select, insert, update, delete
	//ArrayList 사용 => 쌓여야해서
	public List<MemoVO> getMemos() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","java");
		Statement statement = connection.createStatement();
		String sql = "select id, title, content, register_date, modify_date from memo";
		ResultSet resultSet = statement.executeQuery(sql);
		List<MemoVO> list = new ArrayList<>();
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String title = resultSet.getString("title");
			String content = resultSet.getString("content");
			Date registerDate = resultSet.getDate("register_date");
			Date modifyDate = resultSet.getDate("modify_date");
			list.add(new MemoVO(id, title, content, registerDate, modifyDate));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	//한 개 
	//select * from memo where id = ?
	public MemoVO getMemo(int searchId) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","java");
		String sql = "select id, title, content, register_date, modify_date from memo where id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, searchId); //?에 searchId 들어감 
		ResultSet resultSet = statement.executeQuery();
		MemoVO vo = null;
		if (resultSet.next()) {
			int id = resultSet.getInt("id");
			String title = resultSet.getString("title");
			String content = resultSet.getString("content");
			Date registerDate = resultSet.getDate("register_date");
			Date modifyDate = resultSet.getDate("modify_date");
			vo = new MemoVO(id, title, content, registerDate, modifyDate);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}
	//insert => insert 됐나? 안됐나?
	//insert into memo(title, content) values (?,?)
	public int insertMemo(MemoVO vo) throws Exception {
		//jdbc 연결부터 종료
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","java");
		String sql = "INSERT INTO memo(id, title, content) VALUES (memo_seq.nextval, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getTitle()); //1번 물음표 
		statement.setString(2, vo.getContent()); //2번 물음표 
		int count = statement.executeUpdate();
		statement.close();
		connection.close();
		return 0;
	}
	//update memo set title = ?, content=?
	//modify_date = sysdate where id = ?	
	public int updateMemo(MemoVO vo) {
		return 0;
	}
	//delete from memo where id = ?
	public int deleteMemo(int deleteId) {
		return 0;
	}
}
