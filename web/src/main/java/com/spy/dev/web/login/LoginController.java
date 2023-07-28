package com.spy.dev.web.login;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Textbox;

public class LoginController extends GenericForwardComposer<Component> {
	private static final long serialVersionUID = -5871525210789778113L;
	private Textbox username;
	private Textbox password;

	public void onClick$login() {
		String inputUsername = username.getValue();
		String inputPassword = password.getValue();

		if ("admin".equals(inputUsername) && "admin".equals(inputPassword)) {
			alert("Login successful!");
		} else {
			alert("Invalid username or password!");
		}
	}
}
