package Helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Helper.GameWorld.Phase;

public class GameRenderer {
	private GameWorld myWorld;
	BitmapFont font = new BitmapFont(); // Used to print the various words on
										// the screen
	BitmapFont Phases = new BitmapFont();
	Texture bg; // The background image
	Texture GameField; // The image of the playing field

	public GameRenderer(GameWorld world) {
		myWorld = world;
		bg = AssetLoader.bg;
		GameField = AssetLoader.GameField;

	}

	public void render(GameWorld world) {

		world.game.batch.begin();
		
		// background
		world.game.batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 

		// playing field
		world.game.batch.draw(GameField, 50, 50, Gdx.graphics.getWidth() - 100, Gdx.graphics.getHeight() - 100); 

		// GUI related
		font.setColor(Color.RED);
		font.draw(world.game.batch, "Player HP: " + world.human.health, Gdx.graphics.getWidth() - 125,
				Gdx.graphics.getHeight() / 2 - 20);
		font.draw(world.game.batch, "Enemy HP: " + world.AI.health, 40, Gdx.graphics.getHeight() / 2 + 50);
		font.setColor(Color.BLUE);
		font.draw(world.game.batch, "Player MP: " + world.human.mana, Gdx.graphics.getWidth() - 125,
				Gdx.graphics.getHeight() / 2 - 40);
		font.draw(world.game.batch, "Enemy MP: " + world.AI.mana, 40, Gdx.graphics.getHeight() / 2 + 30);

		// Draws the deck of the players
		world.human.playerDeck.DrawDeck(Gdx.graphics.getWidth() - 92, 90);
		world.AI.playerDeck.DrawDeck(60, Gdx.graphics.getHeight() - 160);

		// Draws the hands of the players
		world.AI.handDraw(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() - 100, true);
		world.human.handDraw(Gdx.graphics.getWidth() / 2, 25, false);

		//Draws the phases
		world.game.batch.draw(new Texture("Deck1.png"), Gdx.graphics.getWidth() / 2 - 175, Gdx.graphics.getHeight() / 2,
 				50, 50);
		world.game.batch.draw(new Texture("Deck1.png"), Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2,
				50, 50);
		world.game.batch.draw(new Texture("Deck1.png"), Gdx.graphics.getWidth() / 2 + 100, Gdx.graphics.getHeight() / 2,
				50, 50);
		world.game.batch.draw(new Texture("Deck1.png"), Gdx.graphics.getWidth() / 2 + 175, Gdx.graphics.getHeight() / 2,
				50, 50);
		
		world.game.batch.draw(new Texture("Deck1.png"), Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 50,
				50, 50);
		
		
		//Draws the inactive next phase button
		world.game.batch.draw(new Texture("Deck1.png"), Gdx.graphics.getWidth() / 2 + 75,
				Gdx.graphics.getHeight() / 2 - 100, 150, 50);

		//lights up the different phases
		
		if (world.currentPhase == Phase.DrawPhase) {
			
			world.game.batch.draw(new Texture("Deck2.png"), Gdx.graphics.getWidth() / 2 - 175, Gdx.graphics.getHeight() / 2,
					50, 50);
		}
		
		
		if (world.currentPhase == Phase.BattlePhase) {
			world.game.batch.draw(new Texture("Deck2.png"), Gdx.graphics.getWidth() / 2 + 100,
					Gdx.graphics.getHeight() / 2, 50, 50);

		}

		if (world.currentPhase == Phase.PlayerPhase) {
			world.game.batch.draw(new Texture("Deck2.png"), Gdx.graphics.getWidth() / 2 - 100,
					Gdx.graphics.getHeight() / 2, 50, 50);

		}
		
		if(world.currentPhase == Phase.ModifierPhase)
		{
			world.game.batch.draw(new Texture("Deck2.png"), Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 50,
					50, 50);
		}

		if (world.currentPhase == Phase.EndPhase) {
			world.game.batch.draw(new Texture("Deck2.png"), Gdx.graphics.getWidth() / 2 + 175,
					Gdx.graphics.getHeight() / 2, 50, 50);

		}

		if (Gdx.input.getX() < Gdx.graphics.getWidth() / 2 + 75 + 150
				&& Gdx.input.getX() > Gdx.graphics.getWidth() / 2 + 75
				&& Gdx.input.getY() < Gdx.graphics.getHeight() / 2 + 100
				&& Gdx.input.getY() > Gdx.graphics.getWidth() / 2 + 25 && !Gdx.input.justTouched()) {
			
			world.game.batch.draw(new Texture("Deck2.png"), Gdx.graphics.getWidth() / 2 + 75,
					Gdx.graphics.getHeight() / 2 - 100, 150, 50);
		}

		//Writes the words on top of the phases
		Phases.draw(world.game.batch, "DP", Gdx.graphics.getWidth() / 2 - 150, (Gdx.graphics.getHeight() / 2) + 35);
		Phases.draw(world.game.batch, "PP", Gdx.graphics.getWidth() / 2 - 80, (Gdx.graphics.getHeight() / 2) + 35);
		Phases.draw(world.game.batch, "MP", Gdx.graphics.getWidth() / 2 - 80, (Gdx.graphics.getHeight() / 2) - 20);
		Phases.draw(world.game.batch, "BP", Gdx.graphics.getWidth() / 2 + 125, (Gdx.graphics.getHeight() / 2) + 35);
		Phases.draw(world.game.batch, "EP", Gdx.graphics.getWidth() / 2 + 200, (Gdx.graphics.getHeight() / 2) + 35);
		Phases.draw(world.game.batch, "NEXT PHASE", Gdx.graphics.getWidth() / 2 + 110,
				Gdx.graphics.getHeight() / 2 - 75);

		world.game.batch.end();
	}
}
