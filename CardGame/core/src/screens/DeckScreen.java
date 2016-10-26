package screens;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.CardGame;

import cards.Card;
import cards.Deck;
import cards.MonsterCard;

public class DeckScreen implements Screen {

	float screenHeight = Gdx.graphics.getHeight();
	float screenWidth = Gdx.graphics.getWidth();
	
	private final CardGame game;
	private Texture ReturnActive;
	private Texture ReturnInactive;
	
	public Deck playerDeck;
	public Deck AIDeck;
	public BitmapFont forButton;
	
	
	public DeckScreen(CardGame gameScreen) {
	

		game = gameScreen;
		
		ReturnActive = new Texture("Deck2.png");
		ReturnInactive = new Texture("Deck1.png");
		forButton = new BitmapFont();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		float DeckX = screenWidth/2-50;
		float DeckY = screenHeight/2 - 50;
		
		game.batch.draw(new Texture("DeckPage.jpg"), 0, 0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

		if(Gdx.input.getX()<150 && Gdx.input.getX()>50 && Gdx.input.getY()<DeckY - 50 && Gdx.input.getY()>DeckY - 150)
		{
			game.batch.draw(ReturnActive, 50, (screenHeight/2)+100, 100, 100);
			forButton.setColor(Color.RED);
			forButton.draw(game.batch, "RETURN", 70, (screenHeight/2)+160);
			if(Gdx.input.justTouched())
			{
				game.setScreen(game.Start);
				
			}
		}
		else
		{
			game.batch.draw(ReturnInactive,  50, (screenHeight/2)+100, 100, 100);
			forButton.setColor(Color.WHITE);
			forButton.draw(game.batch, "RETURN", 70, (screenHeight/2)+160);
		}

		
		game.batch.end();
		
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
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Card> CardDeck() {
		// TODO Auto-generated method stub
		return null;
	}

}
