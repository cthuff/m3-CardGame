package Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;

import board.Player;
import cards.Card;

public class InputHandler implements InputProcessor {
private int cardWidth;
private int cardHeight;
	
	public InputHandler()
	{
	cardWidth = 36;
	cardHeight = 84;
	}
	
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
	
		return false;
		
	}
	
	public boolean cardPosition(int x, int y, boolean faceUp)
	{

		if(Gdx.input.getX()> x  && Gdx.input.getX()< x + this.cardWidth && Gdx.input.getY()> Gdx.graphics.getHeight() - (y + this.cardHeight)  && Gdx.input.getY()<Gdx.graphics.getHeight() - y)
		{
	//		if(Gdx.input.isTouched())
		//	{
				return true;
		//	}
			
		}
		return false;
		
	}

	
	public boolean touchUp() {
		// TODO Auto-generated method stub
		return false;
		}
	
	
	public boolean touchDown() {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean onPhaseChanger() {
		
		if (Gdx.input.getX() < Gdx.graphics.getWidth() / 2 + 75 + 150
				&& Gdx.input.getX() > Gdx.graphics.getWidth() / 2 + 75
				&& Gdx.input.getY() < Gdx.graphics.getHeight() / 2 + 100
				&& Gdx.input.getY() > Gdx.graphics.getWidth() / 2 + 25 ) {
		if(Gdx.input.isTouched())
		{
			return true;
		}
		}
		return false;

	}

}
