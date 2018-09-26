package com.optica.constants;

public enum EMenuNav {

	HOME("", "") , ABOUT("","") , CONTACT("","");

	private String name;
	private String path;

	private EMenuNav(String name, String path) {
		this.name = name;
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

}
