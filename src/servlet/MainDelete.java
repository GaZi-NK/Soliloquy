package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetMutterListLogic;
import model.Mutter;

/**
 * Servlet implementation class MainDelete
 */
@WebServlet("/MainDelete")
public class MainDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//独り言を削除する処理
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8"); //リクエストの文字コードを指定
		String userId = request.getParameter("userId");
		String text = request.getParameter("text");
		String dateTime = request.getParameter("dateTime");

		//削除する独り言がログインユーザーであるかチェック

		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterlist = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterlist);

		//メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);


	}

}
