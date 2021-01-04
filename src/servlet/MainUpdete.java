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

import model.GetMutterListLogic;
import model.Mutter;
import model.UpdateMutter;
import model.UpdateMutterLogic;
import model.User;


@WebServlet("/MainUpdete")
public class MainUpdete extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String updateErrorMsg = "";

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8"); //リクエストの文字コードを指定
		String userId = request.getParameter("userId");
		String text = request.getParameter("text");
		String dateTime = request.getParameter("dateTime");
		Mutter mutter = new Mutter(userId, text, dateTime);

		//セッションスコープに保存されたユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		//編集する独り言とログインしているユーザーが一致しているかチェック
		if(userId.equals(loginUser.getUserId())) {

			//編集する独り言の情報をリクエストスコープに保存
			request.setAttribute("mutter", mutter);

			//編集画面(update.jsp)にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
		}else{
			updateErrorMsg = "※自分以外の独り言は編集できません！！";
			request.setAttribute("updateErrorMsg", updateErrorMsg);

			//つぶやきリストを取得して、リクエストスコープに保存
			GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
			List<Mutter> mutterlist = getMutterListLogic.execute();
			request.setAttribute("mutterList", mutterlist);

			//メイン画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8"); //リクエストの文字コードを指定
		String userId = request.getParameter("userId");
		String text = request.getParameter("text");
		String dateTime = request.getParameter("dateTime");
		String toText = request.getParameter("toText");

		UpdateMutter upMutter = new UpdateMutter(userId, text, dateTime, toText);
		UpdateMutterLogic upMutterLogic = new UpdateMutterLogic();
		upMutterLogic.execute(upMutter);

		//つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterlist = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterlist);

		//メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
