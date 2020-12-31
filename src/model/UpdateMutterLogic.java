package model;

import dao.MutterDAO;

public class UpdateMutterLogic {
	public void execute(UpdateMutter upMutter) {
		MutterDAO dao = new MutterDAO();
		dao.update(upMutter);
	}
}
