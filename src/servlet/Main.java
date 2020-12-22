package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetMutterListLogic;
import model.Mutter;
import model.PostMutterLogic;
import model.User;

//独り言に関するリクエストを処理するコントローラとして動作
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//独り言を読み取りトップページを表示
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//独り言リストを取得して、main.jspにフォワード
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);

		//ログインしているか確認するため、セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if(loginUser == null) {
			//ログインしていない場合リダイレクト
			response.sendRedirect("/Soliloquy/");
		} else {
			//ログイン済みの場合フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);

		}

	}

	//独り言を投稿する処理⇒独り言の投稿が完了したら独り言リスト取得してmain.jspにフォワード
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8"); //リクエストの文字コードを指定
		String text = request.getParameter("text");

		//独り言投稿時間を保存
		LocalDateTime LocalDT = LocalDateTime.now(); //現在時刻を取得
		DateTimeFormatter dateTimeF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //時刻の表示形式を指定
		String nowDateTime = LocalDT.format(dateTimeF); //指定した表示形式で現在時刻をStringで取得

		//入力値チェック
		if(text != null && text.length() != 0) {
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");

			//独り言を独り言リストに(MUTTERテーブルに)追加
			Mutter mutter = new Mutter(loginUser.getUserId(), text, nowDateTime);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.execute(mutter);
		} else {//入力値が不正だったらエラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}

		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterlist = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterlist);


		//メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}


}
