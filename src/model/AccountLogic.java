package model;

import java.util.ArrayList;
import java.util.List;

import dao.AccountDAO;

//アカウントの登録を行うクラスDAOには直接アクセスさせない役割を持つ
public class AccountLogic {
	public boolean execute(Account account) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.createAccount(account);
		return result;
	}

	//アカウント情報に不備がないかチェック⇒あればエラーメッセージとしてStringで返す。問題なければnullを返す
	public String check(Account account) {
		List<Account> acList = new ArrayList(); //ユーザーID、メールアドレス確認用のリスト(テーブル上の全レコード取り出しよう)

		//パスワードのチェック
		if (account.getPass().matches("[a-zA-Z][a-zA-Z0-9]{5,11}")) {
		} else { // 満たしていないとき
			return "パスワードの入力が正しくありません";
		}

		//ユーザーID,Mailアドレスが重複していないかチェック
		AccountDAO dao = new AccountDAO();
		acList = dao.accountList();
		for(Account ac: acList) {
			if(ac.getUserId().equals(account.getUserId())) {	//ユーザーIDが重複していた時
				return "このユーザーIDは既に登録されています";
			}else if(ac.getMail().equals(account.getMail())) {	//メールアドレスが重複していた時
				return "このメールアドレスは既に登録されています";
			}
		}

		if(account.getAge() <= 1 || account.getAge() >= 150) {
			return "正しい年齢を入力してください";
		}
	return null;
	}
}
