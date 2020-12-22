package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DeleteMutterLogic;
import model.GetMutterListLogic;
import model.Mutter;
import model.User;

/**
 * Servlet implementation class MainDelete
 */
@WebServlet("/MainDelete")
public class MainDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//独り言を削除する処理
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deleteErrorMsg = "";

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8"); //リクエストの文字コードを指定
		String userId = request.getParameter("userId");
		String text = request.getParameter("text");
		String dateTime = request.getParameter("dateTime");

		//セッションスコープに保存されたユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		//削除する独り言とログインしているユーザーが一致しているかチェック
		if(userId.equals(loginUser.getUserId())) {
			Mutter mutter = new Mutter(userId, text, dateTime);
			DeleteMutterLogic dml = new DeleteMutterLogic();
			dml.execute(mutter);
		}else{
			deleteErrorMsg = "※自分以外の独り言は削除できません！！";
			request.setAttribute("deleteErrorMsg", deleteErrorMsg);
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
