package model;

import dao.LoginDAO;

//ログインに関する処理を行うモデル
/*使用方法
 * ログインIDとPassを入力するとコントローラーでUserクラスに値を保存
 * その後、このクラスでUserクラスのユーザーIDパスワードが正しいか確認する処理をする
 * パスワードが正しければTrue、正しくなければFalseを返す。
 */
public class LoginLogic {
	public boolean execute(User user) {
		LoginDAO dao = new LoginDAO();
		User resultUserInfo = dao.findView(user);

		if((resultUserInfo != null) && user.getUserId().equals(resultUserInfo.getUserId()) && user.getPass().equals(resultUserInfo.getPass())) {
			return true;
		}else {
			return false;
		}
	}
}
