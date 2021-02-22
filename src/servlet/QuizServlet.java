package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetQuizLogic;
import model.Quiz;

/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/Quiz")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// quizを取得
		GetQuizLogic getQuizLogic = new GetQuizLogic();
		ArrayList<Quiz> quizzes =  (ArrayList<Quiz>) getQuizLogic.execute();

		request.setAttribute("quizzes", quizzes);


		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Quiz/quiz.jsp");
		dispatcher.forward(request, response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメーターを取得
		String resultAnswer = (String)request.getParameter("resultAnswer");
		String quizId = (String) request.getParameter("quizId");

		// データベースから問題の解答を取得
		GetQuizLogic getQuizLogic = new GetQuizLogic();
		ArrayList<Quiz> quizzes = (ArrayList<Quiz>) getQuizLogic.execute();
		Quiz quiz = quizzes.get(Integer.parseInt(quizId));
		boolean answer = quiz.getAnswer();

		// 正誤判定してリクエストスコープに保存
		if ((resultAnswer.equals("マル")  && answer == true) || (resultAnswer.equals("バツ") && answer == false)) {
			request.setAttribute("judge", "ヽ(。·ω·。)ﾉ  正解!!");
		} else {
			request.setAttribute("judge", "(´·ω·̥`)  不正解");
		}
		// 問題の解説をリクエストスコープに保存
		String explanation = quiz.getExplanation();
		request.setAttribute("explanation", explanation);
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Quiz/quizJudge.jsp");
		dispatcher.forward(request, response);
	}

}
