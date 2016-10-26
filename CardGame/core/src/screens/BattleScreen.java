package screens;

import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.CardGame;

import Helper.AssetLoader;
import Helper.GameRenderer;
import Helper.GameWorld;
import Helper.InputHandler;
import board.Player;
import cards.Ability;
import cards.Card;
import cards.Deck;
import cards.Element;
import cards.MagicCard;
import cards.ModifierCard;
import cards.MonsterCard;

public class BattleScreen implements Screen {

	public InputHandler controller;
	public GameWorld world;
	public GameRenderer renderer;



	
	CardGame game;																					//Refers to the CardGame class where our application is being run from


	
	


	//Everything under this is initialized on creating the Card game
	public BattleScreen(CardGame game) {


		this.game = game;
		renderer = new GameRenderer(world);
		controller = new InputHandler();

	}

	//Everything under this is initialized when the screen is called
	@Override
	public void show() {
		// TODO Auto-generated method stub
		// Starts the music
		AssetLoader.Background.play();	
		AssetLoader.Background.loop();
		world = new GameWorld(this.game);


	}

	@Override
	public void render(float delta) {


		world.update(delta);	

		renderer.render(world);

		Gdx.input.setInputProcessor(new InputHandler());

	}

	

	

	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		AssetLoader.Background.pause();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub





	}

}
