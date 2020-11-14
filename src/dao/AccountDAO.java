package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Account;

public class AccountDAO {

	//データベースに接続する情報
	private final String JDBC_URL ="jdbc:h2:tcp://localhost/~/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";


	//アカウント情報をデータベースへ追加
	public boolean createAccount(Account account) {
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS) ){

			//SELECT文を準備
			String sql = "INSERT INTO ACCOUNT (USER_ID, PASS, MAIL, NAME, AGE) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getUserId());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getMail());
			pStmt.setString(4, account.getName());
			pStmt.setInt(5, account.getAge());

			//SELECT文を実行
			int rs = pStmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("登録できませんでした");
			return false;
		}
		return true;
	}

	//データベースに登録されているすべてのアカウント情報を取得
	public List<Account> accountList() {
		List<Account> accList = new ArrayList();

		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS) ){

			//SELECT文を準備
			String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECT文を実行し結果を取得
			ResultSet rs = pStmt.executeQuery();

			//取得した結果をに格納されたレコードの内容をAccountに設定時、ArrayListインスタンスに追加
			while(rs.next()) {
				String id = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				Account account = new Account(id, pass, mail, name, age);
				accList.add(account);
			}

		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("登録情報を取得できませんでした");
			return null;
		}
		return accList;
	}
}
