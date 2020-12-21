package model;

import dao.MutterDAO;

public class DeletetMutterLogic {
	public void execute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		dao.delete(mutter);
	}
}
