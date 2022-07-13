package org.sample;

public class Sample1 extends BaseClass{
	
	
	public static void faceBook(String name,String pass) 
	{
		browserConfigChrome();
		maximizeWindow();
		openUrl("https://www.facebook.com");
		
		Login l = new Login();
		
	    textInput(l.getTxtUser(), name);
		
		textInput(l.getTxtPass(), pass);
		
		Click(l.getBtnLogin());
	}
	
	public static void main(String[] args) {
		
		faceBook("sabari","sabari11998");
		
		
	}
	

}
