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

		Account account = new Account(userId, pass, mail, name, age);	//アカウントEntityのインスタンスを作成
		AccountLogic acLogic = new AccountLogic();						//アカウントBOのインスタンスを作成

		//ユーザーID,メールアドレスが既に登録されているか確認
		//問題なければアカウント登録を実行
		String errorMsg = acLogic.check(account);
		if(errorMsg == null) {		//チェックに問題がなかった場合Accountテーブルに登録
			boolean resul = acLogic.execute(account);		//アカウント登録実行。登録できた場合trueを返ってくる

			//アカウント登録処理の結果によって処理を分岐(上記のIFでチェックしているので基本エラーは出ない想定)
			if(resul) {//アカウント登録成功時
				//リクエストスコープにAccountインスタンスを保存
				request.setAttribute("account", account );

				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountOK.jsp");
				dispatcher.forward(request, response);
			}else { //アカウント登録失敗時
				request.setAttribute("account", null );		//リクエストスコープにnullを保存
				request.setAttribute("errorMsg", "なんらかのエラーでアカウント情報をテーブルに追加できませんでした" );

				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountOK.jsp");
				dispatcher.forward(request, response);
			}
		}else { 	//チェックに問題があった場合の処理
			request.setAttribute("account", null );		//リクエストスコープにnullを保存
			request.setAttribute("errorMsg", errorMsg );

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/accountOK.jsp");
			dispatcher.forward(request, response);

		}
	}
}
