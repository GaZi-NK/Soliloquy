package model;

import dao.AccountDAO;

//アカウントの登録を行うクラスDAOには直接アクセスさせない役割を持つ
public class AccountLogic {
	public boolean execute(Account account) {
		AccountDAO dao = new AccountDAO();
		boolean result;
		result = dao.createAccount(account);
		return result;

	}

}
