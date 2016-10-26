package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.CardGame;

public class ResultScreen implements Screen {
	
	BitmapFont Result;
	BitmapFont Shadow;
	CardGame game;
	Boolean won;
	int started;
	
	public ResultScreen(CardGame game)
	{
		this.game = game;
		Result = new BitmapFont();
		Shadow = new BitmapFont();
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		if(!this.game.Battle.world.lose)
		{
			won = true;
		}
		else
		{
			won = false;
		}
	started = 0;
	}

	@Override
	public void render(float delta) {
	game.batch.begin();
	started++;
	
	Result.setColor(Color.WHITE);
	Result.getData().setScale(2, 2);
	Shadow.setColor(Color.LIGHT_GRAY);
	Shadow.getData().setScale(2, 2);

		if(won)
		{
		Shadow.draw(game.batch, "YOU WIN!! GOOD JOB !!", (Gdx.graphics.getWidth()/2) - 148 , (Gdx.graphics.getHeight()/2) +48);		
		Result.draw(game.batch, "YOU WIN!! GOOD JOB !!", (Gdx.graphics.getWidth()/2) - 150 , (Gdx.graphics.getHeight()/2) +50);		
		}
		else
		{
			Shadow.draw(game.batch, "YOU LOST :( TRY AGAIN", (Gdx.graphics.getWidth()/2) - 148, (Gdx.graphics.getHeight()/2)+ 48);		
			Result.draw(game.batch, "YOU LOST :( TRY AGAIN", (Gdx.graphics.getWidth()/2) - 150, (Gdx.graphics.getHeight()/2)+ 50);		
		}
	
		game.batch.end();
		if(started> 10)
		{
			if( Gdx.input.justTouched());
			{
				try {
				    Thread.sleep(2000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
				game.setScreen(game.Start);
			}
		
	}		
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

}
