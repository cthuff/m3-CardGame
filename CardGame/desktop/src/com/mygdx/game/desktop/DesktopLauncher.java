package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.CardGame;

public class DesktopLauncher {
	public static void main(String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// config.fullscreen = true;

		config.width = 720;
		config.height = 680;

		config.title = "M^3(MAGIC,MONSTERS AND MODIFIERS)";
		config.resizable = false;
		new LwjglApplication(new CardGame(), config);

	}
}
