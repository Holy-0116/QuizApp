package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Quiz;

public class QuizDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/test";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<Quiz> quizzes = new ArrayList<>();

	public List<Quiz> findAll(){

		// データベースへ接続
		try(Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			// SQL文を準備
			String sql = "SELECT * FROM QUIZ;";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			// SQL文を実行し、結果をrsに格納
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("ID");
				String question = rs.getString("QUESTION");
				String explanation = rs.getString("EXPLANATION");
				boolean answer = rs.getBoolean("ANSWER");

				Quiz quiz = new Quiz(id, question, explanation, answer);
				quizzes.add(quiz);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return quizzes;
	}

	public boolean create(Quiz newQuiz) {

		// データベースへ接続
		try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			String sql = "INSERT INTO QUIZ(QUESTION, EXPLANATION, ANSWER) VALUES(?, ? ,?);";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			pStmt.setString(1, newQuiz.getQuestion());
			pStmt.setString(2, newQuiz.getExplanation());
			pStmt.setBoolean(3, newQuiz.getAnswer());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
