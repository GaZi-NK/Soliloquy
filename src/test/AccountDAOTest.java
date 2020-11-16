package test;

import java.util.ArrayList;
import java.util.List;

import dao.AccountDAO;
import model.Account;

public class AccountDAOTest {

	public static void main(String[] args) {
		testCreateAccount(); //データベースにアカウントが登録できるか確認
		testAccountList();
	}

	public static void testCreateAccount() {
		Account account = new Account("naoy", "naoya824", "test@icloud.com", "鎌倉 直哉", 25);
		AccountDAO dao = new AccountDAO();
		boolean createResult = dao.createAccount(account);

		if(createResult) {
			System.out.println("データベースへアカウント情報の登録が完了しました");
		}else {
			System.out.println("アカウント登録に失敗しました");
		}
	}

	public static void testAccountList() {
		List<Account> accList = new ArrayList();

		AccountDAO dao = new AccountDAO();
		accList = dao.accountList();

		for(Account account: accList) {
			System.out.println(account.getUserId());
			System.out.println(account.getPass());
			System.out.println(account.getMail());
			System.out.println(account.getName());
			System.out.println(account.getAge());
			System.out.println("");

		}


	}

}
