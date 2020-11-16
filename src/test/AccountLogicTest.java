package test;

import model.Account;
import model.AccountLogic;

public class AccountLogicTest {

	public static void main(String[] args) {
		testExecute();
	}

	/**
	 *
	 */
	public static void testExecute() {
		Account account = new Account("redmjjkjkd", "pass123", "red@iclou.com", "naoya", 24);
		AccountLogic acLogic = new AccountLogic();
		String errorMsg = acLogic.check(account);
		if (errorMsg == null) {
			if (acLogic.execute(account)) {
				System.out.println("アカウント登録に成功しました");
			} else {
				System.out.println("ユーザーIDは既に登録されています");
			}

		} else {
			System.out.println(errorMsg);
		}
	}

}
