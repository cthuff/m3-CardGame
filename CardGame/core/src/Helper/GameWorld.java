package Helper;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.CardGame;

import board.Player;
import cards.Card;
import cards.Deck;
import cards.MagicCard;
import cards.ModifierCard;
import cards.MonsterCard;

public class GameWorld {

	Player human; // Refers to the player object
	private LinkedList<Card> humanHand; // Refers to the player hand
	private LinkedList<Card> AIHand; // Refers to the AI hand
	Player AI; // Refers to the AI Enemy
	public Deck AIDeck; // AI deck of cards
	public Deck humanDeck; // Player's set of cards
	public CardGame game;
	public boolean lose;
	Phase currentPhase; // Refers to the gamestate that the player is in

	public InputHandler controller;
	public int nothingCounter;
	private int counter;
	public int clickTime;
	/*
	 * Phase class This class is used to refer to the different gamestates of
	 * the game
	 */
	public enum Phase {
		NothingDone,StartPhase, DrawPhase, PlayerPhase,ModifierPhase, BattlePhase, EndPhase
	}

	public GameWorld(CardGame games) {
		this.game = games;
		currentPhase = Phase.NothingDone;
		lose = false;
		AIDeck = new Deck(game);
		humanDeck = new Deck(game);

		// List of cards in the game so far. If you want to add more, create
		// them in AssetLoader and then call them again in the battleScreen
		// class
		MonsterCard PhoenixFire = AssetLoader.PhoenixFire;
		MonsterCard Eagle = AssetLoader.Eagle;
		MonsterCard Scarecrow = AssetLoader.Scarecrow;
		MonsterCard Elf = AssetLoader.Elf;
		MonsterCard Slime = AssetLoader.Slime;
		MonsterCard ElfTeam = AssetLoader.ElfTeam;
	
		  MonsterCard NightElf = AssetLoader.NightElf;
		     MonsterCard ShadowPriesTaezyril = AssetLoader.ShadowPriesTaezyril;
		     MonsterCard BroxiderTheGreen = AssetLoader.BroxiderTheGreen;
		     MonsterCard ShadowHunter = AssetLoader.ShadowHunter;
		    MonsterCard Deathwing = AssetLoader.Deathwing ;   
		    MonsterCard Orc = AssetLoader.Orc;
		     MonsterCard Goblin = AssetLoader.Goblin;
		     MonsterCard Troll = AssetLoader.Troll;
		     MonsterCard Paladin = AssetLoader.Paladin;
		     MonsterCard GreaterPaladin = AssetLoader.GreaterPaladin;
		     MonsterCard Knight = AssetLoader.Knight;
		    MonsterCard KingArthur = AssetLoader.KingArthur;
		    
			MagicCard RelinquishFate = AssetLoader.RelinquishFate;
			MagicCard Fireball = AssetLoader.Fireball;
			MagicCard Forest = AssetLoader.Forest;
			MagicCard WindOfAl = AssetLoader.WindOfAl;
			
			ModifierCard Coin = AssetLoader.Coin;
			ModifierCard GreaterHealthPotion = AssetLoader.GreaterHealthPotion;
		  
		// Adding the cards to the humanDeck
		humanDeck.add(RelinquishFate);
		humanDeck.add(Slime);
		humanDeck.add(Elf);
		humanDeck.add(Scarecrow);
		humanDeck.add(Eagle);
		humanDeck.add(PhoenixFire);
		humanDeck.add(ElfTeam);
		humanDeck.add(KingArthur);
		humanDeck.add(GreaterPaladin);
		humanDeck.add(Deathwing);
		humanDeck.add(ShadowHunter);
		humanDeck.add(Fireball);
		humanDeck.add(GreaterHealthPotion);
		humanDeck.add(WindOfAl);

		// Adding the cards to the AIDeck
		AIDeck.add(Slime);
		AIDeck.add(Elf);
		AIDeck.add(Scarecrow);
		AIDeck.add(Eagle);
		AIDeck.add(PhoenixFire);
		AIDeck.add(ElfTeam);
		AIDeck.add(RelinquishFate);
		AIDeck.add(BroxiderTheGreen);
		AIDeck.add(GreaterPaladin);
		AIDeck.add(Troll);
		AIDeck.add(ShadowHunter);
		AIDeck.add(Fireball);
		AIDeck.add(GreaterHealthPotion);
		AIDeck.add(WindOfAl);


		human = new Player(humanDeck, game); // Creating the human object for
												// the game
		AI = new Player(AIDeck, game); // Creating the AI object for the game

		// Setting the enemies against each other
		human.setOpponent(AI);
		AI.setOpponent(human);

		// Refers to the player hands
		humanHand = new LinkedList<Card>();
		AIHand = new LinkedList<Card>();

		human.hand = new LinkedList<Card>();
		AI.hand = new LinkedList<Card>();

		// Shuffles the deck of both players
		human.shuffleDeck();
		AI.shuffleDeck();

		currentPhase = Phase.NothingDone;

		counter = 0;
		nothingCounter = 0;
		clickTime = 50;
	}

	public void update(float delta) {

		if(human.health>0 && AI.health>0)
		{
		if(currentPhase == Phase.NothingDone)
		{
			NothingDone();
		}
		if (currentPhase == Phase.StartPhase) {
			StartPhase();
		}
		else if (currentPhase.equals(Phase.DrawPhase)) {
			drawPhase();
		}else if (currentPhase == Phase.PlayerPhase) {
			playerPhase();
		} else if(currentPhase == Phase.ModifierPhase){
			modifierPhase();
		} else if (currentPhase == Phase.BattlePhase) {
			battlePhase();
		} else if (currentPhase == Phase.EndPhase) {
			endPhase();
		}

	}
		else
		{
			lose = true;
		}
		
		if (lose) {
			dispose();
			game.setScreen(game.Result);

		}

		// Gdx.app.log("GameWorld", "update");
	}

	

	private void NothingDone() {
		// TODO Auto-generated method stub
		
		nothingCounter++;
		if(nothingCounter == 10)
		{
			try {
			    Thread.sleep(clickTime);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			currentPhase = Phase.StartPhase;
			
		}
				
		
	}

	private void dispose() {
		// TODO Auto-generated method stub

		humanHand.clear();
		AIHand.clear();
		AIDeck.clear();
		humanDeck.clear();
		lose = false;

	}

	// Draws the first 5 cards from the deck
	private void StartPhase() {
		counter++;
		
			AI.drawCard();
			human.drawCard();
			try {
			    Thread.sleep(clickTime);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		if(counter == 4)
		{
		currentPhase = Phase.DrawPhase;
		}
	}

	private void drawPhase() {
		// TODO Auto-generated method stub

			try {
	    Thread.sleep(clickTime);                 //1000 milliseconds is one second.
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	
		try {
			human.drawCard();
			AI.drawCard();
		} catch (Exception e) {
			lose = true;
		}
		currentPhase = Phase.PlayerPhase;

	}
	
	private void playerPhase() {
		// TODO Auto-generated method stub

		if (game.Battle.controller.onPhaseChanger()) {

			currentPhase = Phase.ModifierPhase;
			try {
			    Thread.sleep(clickTime);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}

		}

	}

	private void modifierPhase() {
		// TODO Auto-generated method stub
		if (game.Battle.controller.onPhaseChanger()) {
			currentPhase = Phase.BattlePhase;
			try {
			    Thread.sleep(clickTime);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}	
	}
	
	private void battlePhase() {
		// TODO Auto-generated method stub

		if (game.Battle.controller.onPhaseChanger()) {
			currentPhase = Phase.EndPhase;
			try {
			    Thread.sleep(clickTime);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			// System.out.println("Shift from " + currentPhase.toString() + " to
			// EndPhase");
		}

	}

	private void endPhase() {
		// TODO Auto-generated method stub
		if (game.Battle.controller.onPhaseChanger()) {
			currentPhase = Phase.DrawPhase;
			try {
			    Thread.sleep(clickTime);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}

	}
}
