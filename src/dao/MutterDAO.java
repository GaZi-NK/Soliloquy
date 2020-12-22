package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	//データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	//データベースの情報を取得
	public List<Mutter> findAll(){
		List<Mutter> mutterList = new ArrayList<>();

		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//SELECT文の準備
			String sql = "SELECT ID,USER_ID,TEXT,DT FROM MUTTER ORDER BY ID DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			//日付取得用のフォーマットを用意
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			//SELECT文の結果をArrayListに格納
			while(rs.next()) {
				int id = rs.getInt("ID");
				String userName = rs.getString("USER_ID");
				String text = rs.getString("TEXT");
				String dateTime =  sdf.format(rs.getTimestamp("DT"));
				Mutter mutter = new Mutter(id, userName, text, dateTime);
				mutterList.add(mutter);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}

	//データベースにレコードを追加
	public boolean create(Mutter mutter) {
		//データベース接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){

			//INSERT文の準備(idは自動連番なので指定しなくてよい)
			String sql = "INSERT INTO MUTTER(USER_ID, TEXT, DT) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, mutter.getUserId());
			pStmt.setString(2, mutter.getText());
			pStmt.setString(3, mutter.getDateTime());

			//INSERT文を実行(resultには追加された行数が代入される)
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}

		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//データベースのレコードを削除
	public boolean delete(Mutter mutter) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER, DB_PASS)){

			//INSERT文の準備(idは自動連番なので指定しなくてよい)
			String sql = "DELETE FROM MUTTER WHERE USER_ID=? AND TEXT=? AND DT=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, mutter.getUserId());
			pStmt.setString(2, mutter.getText());
			pStmt.setString(3, mutter.getDateTime());

			//INSERT文を実行(resultには追加された行数が代入される)
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//データベースのレコード(独り言)を編集
	public boolean update(Mutter mutter) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER, DB_PASS)){

			//UPDATE文の準備
			String sql = "UPDATE MUTTER SET TEXT = '?' WHERE USER_ID = '?' AND TEXT = '?' AND DT = '?'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文の「?」に使用する値を設定しSQLを完成
			//pstmt.setString(1. )	//編集語の独り言
			pStmt.setString(1, mutter.getUserId()); //編集する独り言のユーザー
			pStmt.setString(2, mutter.getText());	//編集する独り言
			pStmt.setString(3, mutter.getDateTime());	//編集する独り言の時間(投稿した)

			//INSERT文を実行(resultには追加された行数が代入される)
			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
