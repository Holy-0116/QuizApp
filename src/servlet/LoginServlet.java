package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;
import model.User;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// フォーワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/User/loginForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");

		Login login = new Login(mail, pass);
		LoginLogic bo = new LoginLogic();
		User user = bo.execute(login);
		if (user == null) {
			// エラーメッセージ作成
			request.setAttribute("errMsg", "Eメールまたはパスワードが違います" );
			// ログインフォームへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/User/loginForm.jsp");
			dispatcher.forward(request, response);
		} else {
			// セッションスコープにログインユーザーを保存
			HttpSession session = request.getSession();
			session.setAttribute("logedinUser", user);
			
			// リダイレクト
			response.sendRedirect("Main");
		}
	}

}
