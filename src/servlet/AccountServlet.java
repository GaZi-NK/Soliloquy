package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Account;
import model.AccountLogic;

//アカウント登録に関するリクエストに関するコントローラ
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//アカウント登録画面に遷移させる処理
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountRegister.jsp");
		dispatcher.forward(request, response);
	}

	//アカウント登録をしてアカウント登録完了画面へ遷移させる処理
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8"); //リクエストパラメータをUTF-8に設定
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		//アカウント登録処理を実行
		Account account = new Account(userId, pass, mail, name, age);	//アカウントEntityのインスタンスを作成
		AccountLogic acLogic = new AccountLogic();						//アカウントBOのインスタンスを作成
		boolean result = acLogic.execute(account);						//アカウント登録実行。登録できた場合trueを返ってくる

		//アカウント登録処理の結果によって処理を分岐
		if(result) {//ログイン成功時
			//リクエストスコープにユーザーID、メールアドレスを保存
			request.setAttribute("userId", userId );
			request.setAttribute("mail", mail);

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountOK.jsp");
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("errorMsg", "アカウント登録に失敗しました。");
		}




	}

}
