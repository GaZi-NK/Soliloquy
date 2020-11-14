package dao;

import model.LoginLogic;
import model.User;

public class LoginDAO_LoginLogic_test {

	public static void main(String[] args) {
		loginLogictest();
	}


	public static void loginDAOtest() {
		User user = new User("naoya", "naoya824");
		LoginDAO dao = new LoginDAO();
		User resultUserInfo = dao.findView(user);
	}

	public static void loginLogictest() {
		User user = new User("naoya", "naoya824");
		LoginLogic bo = new LoginLogic();
		if(bo.execute(user)){
			System.out.println("LoginDAOのログイン成功のテスト完了");
		}else {
			System.out.println("LoginDAOのログイン失敗のテスト失敗");
		}
	}
}