package model;

import java.util.ArrayList;
import java.util.List;

import dao.QuizDAO;

public class GetQuizLogic {
	public List<Quiz> execute(){
		QuizDAO dao = new QuizDAO();
		ArrayList<Quiz> quizzes =  (ArrayList<Quiz>) dao.findAll();
		return quizzes;
	}



}
