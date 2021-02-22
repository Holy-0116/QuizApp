package model;

import dao.QuizDAO;

public class PostQuizLogic {
	public boolean executeCreate(Quiz newQuiz) {
		QuizDAO dao = new QuizDAO();
		boolean result = dao.create(newQuiz);
		return result;
	}
}
