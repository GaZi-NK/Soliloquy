package test;

import dao.MutterDAO;
import model.UpdateMutter;

public class UpdateMutterLogic_test {

	public static void main(String[] args) {
		updateMutterLogicTest();
	}

	public static void updateMutterLogicTest() {
		UpdateMutter upMutter = new UpdateMutter("naoya", "編集しました", "2020-12-31 12:55:53", "UpdateMutterLogic成功2");
		MutterDAO dao = new MutterDAO();
		if(dao.update(upMutter)) {
			System.out.println("レコードの編集に成功しました");
		}else {
			System.out.println("レコードの編集失敗しました");
		}

	}

}
