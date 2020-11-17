package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dao.MutterDAO;
import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;

public class MutterDAOTest {

	public static void main(String[] args) {
		//ceateTest();
		//findAllTest();
		postMutterLogicTest();

	}

	public static void ceateTest() {
		LocalDateTime LocalDT = LocalDateTime.now(); //現在時刻を取得
		DateTimeFormatter dateTimeF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //時刻の表示形式を指定
		String nowDateTime = LocalDT.format(dateTimeF); //指定した表示形式で現在時刻をStringで取得

		Mutter m = new Mutter("MutterDAOTest", "テストです", nowDateTime);
		MutterDAO mutterDAO = new MutterDAO();
		if(mutterDAO.create(m)) {
			System.out.println("レコードの挿入に成功しました");
		}else {
			System.out.println("レコードの挿入に失敗しました");
		}
	}

	public static void findAllTest() {
		MutterDAO mutterDAO = new MutterDAO();
		List<Mutter> mutterList = mutterDAO.findAll();
		if(mutterList != null) {
			System.out.println("レコードの取得に成功しました");
			for(Mutter m: mutterList) {
				System.out.println("ユーザーID：" + m.getUserId());
				System.out.println("投稿内容" + m.getText());
				System.out.println("投稿時間" + m.getDateTime());
			}
		}else {
			System.out.println("レコードの取得に失敗しました");
		}
	}
	public static void postMutterLogicTest() {
		PostMutterLogic pml = new PostMutterLogic();
		LocalDateTime LocalDT = LocalDateTime.now(); //現在時刻を取得
		DateTimeFormatter dateTimeF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //時刻の表示形式を指定
		String nowDateTime = LocalDT.format(dateTimeF); //指定した表示形式で現在時刻をStringで取得

		Mutter m = new Mutter("Post&GetMutterLogic", "テストです", nowDateTime);
		pml.execute(m);

		GetMutterListLogic gmll = new GetMutterListLogic();
		List<Mutter> mutterList = gmll.execute();
		for(Mutter mList: mutterList) {
			System.out.println("ユーザーID：" + mList.getUserId());
			System.out.println("投稿内容：" + mList.getText());
			System.out.println("投稿時間：" + mList.getDateTime());
			System.out.println("");
		}
	}

}
