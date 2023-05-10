package com.cpa.uhpocms.entity;

public class QuestionAnswer {

	private Question question;
	private Answer[] answers;

	/**
	 * 
	 */
	public QuestionAnswer() {
		super();
	}

	/**
	 * @param questions
	 * @param answers
	 */
	public QuestionAnswer(Question question, Answer[] answers) {
		super();
		this.question = question;
		this.answers = answers;
	}

	/**
	 * @return the questions
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	/**
	 * @return the answers
	 */
	public Answer[] getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(Answer[] answers) {
		this.answers = answers;
	}

}
