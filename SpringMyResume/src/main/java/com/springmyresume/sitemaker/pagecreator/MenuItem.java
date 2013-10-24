package com.springmyresume.sitemaker.pagecreator;

public class MenuItem {

	private String url;
	private String name;
	public MenuItem(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	@Override
	public String toString() {
		return "MenuItem [url=" + url + ", name=" + name + "]";
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
