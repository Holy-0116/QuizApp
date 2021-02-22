package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LogonLogic;
import model.User;

/**
 * Servlet implementation class LogonServlet
 */
@WebServlet("/Logon")
public class LogonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/User/logonForm.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメーターを取得
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String pass = request.getParameter("pass");
		if (name != "" && mail != "" && pass != "") {

			User user = new User(name, mail, pass);
			LogonLogic bo = new LogonLogic();
			boolean result = bo.execute(user);
			if (result) {
				// セッションスコープに保存
				HttpSession session = request.getSession();
				session.setAttribute("LogedinUser", user);
				// リダイレクト
				response.sendRedirect("Main");

			} else {
				// エラーメッセージ
				request.setAttribute("errMsg", "登録できませんでした");
				// フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/User/logonForm.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			// エラーメッセージ
			request.setAttribute("errMsg", "登録できませんでした");
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/User/logonForm.jsp");
			dispatcher.forward(request, response);
		}
	}

}
