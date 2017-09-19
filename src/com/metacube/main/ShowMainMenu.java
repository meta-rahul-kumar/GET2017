package com.metacube.main;

public class ShowMainMenu implements Action {

	@Override
	public void performAction() {
		Home.createMenu();
	}

}
