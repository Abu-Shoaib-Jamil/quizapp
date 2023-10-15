package com.practice.quizappproducer.model;

public class DataDTO {
	private String lang;
	@Override
	public String toString() {
		return "DataDTO [lang=" + lang + ", num=" + num + "]";
	}
	private int num;
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
