package com.practice.quizappconsumer.model;

public class DataDTO {
	private String lang;
	private int num;
	@Override
	public String toString() {
		return "DataDTO [lang=" + lang + ", num=" + num + "]";
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
