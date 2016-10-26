package screens;


import java.util.Random;

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

public class GameScreen implements Screen {
	float screenHeight = Gdx.graphics.getHeight();
	float screenWidth = Gdx.graphics.getWidth();

	private GameWorld world;
	private GameRenderer renderer;
	
	private final CardGame game;

	Texture ButtonActive;
	Texture ButtonInactive;
	Texture bg;
	BitmapFont DECK;
	BitmapFont NEWGAME;
	BitmapFont GAMETITLE;
	BitmapFont versionNumber;
	BitmapFont font;

	public GameScreen(CardGame game)
	{
		font = new BitmapFont();
		bg = new Texture("Openning page.jpg");
		this.game = game;
		ButtonActive = new Texture("Deck2.png");
		ButtonInactive = new Texture("Deck1.png");
		DECK = new BitmapFont();
		NEWGAME = new BitmapFont();
		renderer = new GameRenderer(world);
		GAMETITLE = new BitmapFont();
		versionNumber = new BitmapFont();
	}

	@Override
	public void show() {

		AssetLoader.frontScreen.play();
		AssetLoader.frontScreen.loop();

	}

	@Override
	public void render(float delta) {
	//	world.update(delta);	
	//	renderer.render(world);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(bg,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		float DeckX = screenWidth/2-50;
		float DeckY = screenHeight/2 - 50;
	
		if(Gdx.input.getX()<DeckX+100 && Gdx.input.getX()>DeckX && Gdx.input.getY()<DeckY - 50 && Gdx.input.getY()>DeckY - 150)
		{
		game.batch.draw(ButtonActive, (screenWidth/2) - 50,(screenHeight/2)+100, 100, 100);
		DECK.setColor(Color.RED);
		DECK.draw(game.batch, "DECK", (screenWidth/2) - 20 , (screenHeight/2)+160);
		
		if(Gdx.input.justTouched())
		{
			game.setScreen(game.Deck);
			
		
		}
		}
		else
		{
			

			game.batch.draw(ButtonInactive, (screenWidth/2) - 50,(screenHeight/2)+100, 100, 100);
			DECK.draw(game.batch, "DECK", (screenWidth/2) - 20 , (screenHeight/2)+160);
			DECK.setColor(Color.WHITE);
			
		}
		
		
		
		if(Gdx.input.getX()<DeckX+100 && Gdx.input.getX()>DeckX && Gdx.input.getY()<DeckY + 150 && Gdx.input.getY()>DeckY + 50)
		{
			NEWGAME.setColor(Color.RED);
			game.batch.draw(ButtonActive, (screenWidth/2) - 50, (screenHeight/2)-100, 100, 100);
			NEWGAME.draw(game.batch, "NEW GAME", (screenWidth/2) - 40 , (screenHeight/2)-50);
			if(Gdx.input.justTouched())
			{
				game.setScreen(game.Battle);
		
				
			}
		}
		else
		{
			game.batch.draw(ButtonInactive, (screenWidth/2) - 50, (screenHeight/2)-100, 100, 100);
			NEWGAME.draw(game.batch, "NEW GAME", (screenWidth/2) - 40 , (screenHeight/2)-50);
			NEWGAME.setColor(Color.WHITE);
		}
		
		
		Random colorDecider = new Random();
		int colorDecided = colorDecider.nextInt(5);
		Color chosenColor = new Color();
		int red = 0;
		int blue = 1;
		int green = 2;
		int purple = 3;
		int black = 4;
		int white = 5;
		if(colorDecided == red)
		{
			chosenColor = Color.RED;
		}
		if(colorDecided == blue)
		{
			chosenColor = Color.BLUE;
		}
		if(colorDecided == green)
		{
			chosenColor = Color.GREEN;
		}
		if(colorDecided == purple)
		{
			chosenColor = Color.PURPLE;
		}
		if(colorDecided == black)
		{
			chosenColor = Color.BLACK;
		}
		if(colorDecided == white)
		{
			chosenColor = Color.WHITE;
		}

		
		if(game.Start.equals(game.getScreen()))
		{
			GAMETITLE.setColor(chosenColor);
			GAMETITLE.getData().setScale(2, 2);
			GAMETITLE.draw(game.batch, "MAGIC MONSTERS AND MODIFIERS THE GAME", Gdx.graphics.getWidth()/2 - 335,Gdx.graphics.getHeight() - 50);
			versionNumber.draw(game.batch, "ver 1.0",  Gdx.graphics.getWidth()/2 + 300, Gdx.graphics.getHeight() - 100);
		}
		game.batch.end();
	}

	

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {

		AssetLoader.frontScreen.pause();
		
	}

	@Override
	public void dispose() {
		
		
	}

}
