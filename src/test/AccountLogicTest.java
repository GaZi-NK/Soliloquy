package test;

import model.Account;
import model.AccountLogic;

public class AccountLogicTest {

	public static void main(String[] args) {
		testExecute();
	}

	public static void testExecute() {
		Account account = new Account("red", "pass", "red@icloud.com", "naoya", 24);
		AccountLogic acLogic = new AccountLogic();
		if(acLogic.execute(account)) {
			System.out.println("アカウント登録に成功しました");
		}
	}

}
