package test;

import dao.MutterDAO;
import model.Mutter;

public class DeleteDAO_DeleteMutterLogic_Test {

	public static void main(String[] args) {
		deleteLogicTest();
	}


	public static void deleteLogicTest() {
		Mutter mutter = new Mutter("MutterDAOTest","テストです","2020-11-17 19:34:21");
		MutterDAO dao = new MutterDAO();
		if(dao.delete(mutter)) {
			System.out.println("レコードの削除に成功しました");
		}else {
			System.out.println("レコードの削除に失敗しました");
		}

	}
}
