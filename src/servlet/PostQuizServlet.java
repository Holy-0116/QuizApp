package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PostQuizLogic;
import model.Quiz;

/**
 * Servlet implementation class PostQuizServlet
 */
@WebServlet("/PostQuiz")
public class PostQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// フォーワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Quiz/postQuiz.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question = request.getParameter("question");
		String explanation = request.getParameter("explanation");
		boolean answer = Boolean.valueOf(request.getParameter("answer"));

		if (question == "" || explanation == "") {
			request.setAttribute("queryNG", "out");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Quiz/postQuiz.jsp");
			dispatcher.forward(request, response);
		} else {
			Quiz newQuiz = new Quiz(question, explanation, answer);
			PostQuizLogic postQuizLogic = new PostQuizLogic();
			boolean result = postQuizLogic.executeCreate(newQuiz);

			if (result != true) {
				request.setAttribute("queryNG", "out");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Quiz/postQuiz.jsp");
				dispatcher.forward(request, response);
			} else {
				// フォーワード
				request.setAttribute("queryOK", "問題を受け付けました！");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Main/index.jsp");
				dispatcher.forward(request, response);
			}
		}

	}

}
