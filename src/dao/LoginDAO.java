package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class LoginDAO {
	//データベースに接続する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public User findView(User user) {
			User userResultInfo = null;

			try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS) ){
				//SELECT文を準備
				String sql = "SELECT USER_ID, PASS FROM ACCOUNT WHERE USER_ID=? AND PASS=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, user.getUserId());
				pStmt.setString(2, user.getPass());

				//SELECT文を実行し結果を取得
				ResultSet rs = pStmt.executeQuery();

				if(rs.next()){
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				userResultInfo = new User(userId, pass);
				}else {
					System.out.println("データが取得できていません");
					return null;
				}


			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}

			return userResultInfo;
		}
}
