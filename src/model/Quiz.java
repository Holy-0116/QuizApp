package model;

import java.io.Serializable;

public class Quiz implements Serializable {
	private int id;
	private String question;
	private String explanation;
	private boolean answer;

	public Quiz() {};

	public Quiz(String question, String explanation, boolean answer) {
		this.question = question;
		this.explanation = explanation;
		this.answer = answer;
	}

	public Quiz(int id, String question, String explanation, boolean answer) {
		this.id = id;
		this.question = question;
		this.explanation = explanation;
		this.answer = answer;
	}

	public int getId() {
		return this.id;
	}
	public String getQuestion() {
		return this.question;
	}
	public String getExplanation() {
		return this.explanation;
	}
	public boolean getAnswer() {
		return this.answer;
	}


}
