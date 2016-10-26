package board;

import java.awt.geom.Point2D;
import java.util.ArrayList;	
import java.util.LinkedList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.CardGame;

import Helper.InputHandler;
import cards.Attackable;
import cards.Card;
import cards.Deck;
import cards.MagicCard;
import cards.ModifierCard;
import cards.MonsterCard;

public class Player implements PlayerInterface {

	public Player opponent;

    public Deck playerDeck;
   
    public int cardWidth;
    public int cardHeight;
    
    public BitmapFont cardInfo;
    public LinkedList<Card> hand;
    public LinkedList<MonsterCard> monsterField;         // refers to the monsters on the playing field
    public Point2D[] MonsterCardPoints;
    public LinkedList<ModifierCard> modifierField;		// refers to the modifiers on the playing field
    public CardGame game;
    public int mana, maxMana, manaRegen, health, maxHealth;
    public final int startXoffset = 50;

    public LinkedList<Card> graveyard;
    public InputHandler controller;

    	
    	/*
    	public Player(Deck deck,CardGame game, Point2D position1, Point2D position2, Point2D position3, Point2D position4, Point2D position5) {

        MonsterCardPoints = new Point2D[5];
        MonsterCardPoints[0] = position1;
        MonsterCardPoints[1] = position2;
        MonsterCardPoints[2] = position3;
        MonsterCardPoints[3] = position4;
        MonsterCardPoints[4] = position5;
        */
        public Player(Deck deck,CardGame game) {

        this.game = game;
    	mana = 30;
        maxMana = 100;
        manaRegen = 10;
        health = maxHealth = 50;
        cardWidth = 36;
        cardHeight = 84;
        this.playerDeck = deck;
        
        hand = new LinkedList<Card>();
        
        monsterField = new LinkedList<MonsterCard>(); // 0 index is main monster
        modifierField = new LinkedList<ModifierCard>();
        graveyard = new LinkedList<Card>();
    	cardInfo = new BitmapFont();
    	
    	controller = new InputHandler();
        
    }
    
    public void drawCard()
    {
    	hand.add(playerDeck.Deck.remove(0));
    	
    	
    }
    
    
    //Still implementing this
    /*
    public void MonsterFieldDraw(){
      	
    	Card ActiveCard = monsterField.get(0);
    	Card Passive1 = monsterField.get(1);
    	Card Passive2 = monsterField.get(2);
    	Card Passive3 = monsterField.get(3);
    	Card Passive4 = monsterField.get(4);
    	
    	ActiveCard.isFaceUp = true;
    	game.batch.draw(ActiveCard.front,(int)MonsterCardPoints[0].getX(),(int)MonsterCardPoints[0].getY(),cardWidth,cardHeight);
    	
    		if(Passive1.isFaceUp())
    		{
    	game.batch.draw(Passive1.front,(int)MonsterCardPoints[1].getX(),(int)MonsterCardPoints[1].getY(),cardWidth,cardHeight);
    	
        	
    		}
    		else
    		{
    	    	game.batch.draw(Passive1.back,(int)MonsterCardPoints[1].getX(),(int)MonsterCardPoints[1].getY(),cardWidth,cardHeight);
    		}
    
    		if(Passive2.isFaceUp())
    		{
    	game.batch.draw(touchedCard.front,(int)MonsterCardPoints[2].getX(),(int)MonsterCardPoints[2].getY(),cardWidth,cardHeight);
    	
    
    	if(controller.cardPosition(leftSideofCard, handY,true))
    	{
    	playCard(i);
    
    	}
    	else
    	{
        	Gdx.app.log("CardPosition", "false");
    	}
    	
    		}
    		else
    		{
    	    	game.batch.draw(touchedCard.back,((handX+(this.startXoffset*this.hand.size()/2)) - (this.startXoffset * (this.hand.size() - i))),handY,this.cardWidth,this.cardHeight);
    		}
    		
    		
    		
    		if(Passive3.isFaceUp())
    		{
    	game.batch.draw(touchedCard.front,(int)MonsterCardPoints[3].getX(),(int)MonsterCardPoints[3].getY(),cardWidth,cardHeight);
    	
    
    	if(controller.cardPosition(leftSideofCard, handY,true))
    	{
    	playCard(i);
    
    	}
    	else
    	{
        	Gdx.app.log("CardPosition", "false");
    	}
    	
    		}
    		else
    		{
    	    	game.batch.draw(touchedCard.back,((handX+(this.startXoffset*this.hand.size()/2)) - (this.startXoffset * (this.hand.size() - i))),handY,this.cardWidth,this.cardHeight);
    		}
    		
    		
    		
    		if(Passive4.isFaceUp())
    		{
    	game.batch.draw(touchedCard.front,(int)MonsterCardPoints[4].getX(),(int)MonsterCardPoints[4].getY(),cardWidth,cardHeight);
    	
    
    	if(controller.cardPosition(leftSideofCard, handY,true))
    	{
    	playCard(i);
    
    	}
    	else
    	{
        	Gdx.app.log("CardPosition", "false");
    	}
    	
    		}
    		else
    		{
    	    	game.batch.draw(touchedCard.back,((handX+(this.startXoffset*this.hand.size()/2)) - (this.startXoffset * (this.hand.size() - i))),handY,this.cardWidth,this.cardHeight);
    		}
    		
    	
    	
    }
    */
    public void playCard(int theCard)
    {
    	if(theCard<hand.size())
    	{
    		Card remove = hand.remove(theCard);
    		if(remove instanceof MonsterCard)
    		{
    				if(monsterField.size()<5)
    				{
    					monsterField.add((MonsterCard)remove);
    				}
    				else
    				{
    					hand.add(theCard, remove);
    				}
    			
    		}
    		else if(remove instanceof MagicCard)
    		{
    			graveyard.add(remove);
    		}
    		else if(remove instanceof ModifierCard)
    		{
    			if(modifierField.size()<3)
				{
					modifierField.add((ModifierCard) remove);
				}
				else
				{
					hand.add(theCard, remove);
				}
    			
    		}
    	}
    }
  
    
    public void handDraw(int handX,int handY, boolean isEnemy)
    {
    	for (int i = 0; i < hand.size(); i++)
    	{

    		int leftSideofCard = ((handX+(this.startXoffset*this.hand.size()/2)) - (this.startXoffset * (this.hand.size() - i)));
  
    	
    		Card touchedCard = hand.get(i);
    		if(!isEnemy)
    		{
    	game.batch.draw(touchedCard.front,leftSideofCard,handY,cardWidth,cardHeight);
    
    	if(controller.cardPosition(leftSideofCard, handY,true))
    	{
    		if(Gdx.input.isTouched())
    		{
    	playCard(i);
    		}
    	}
    	else
    	{
        	Gdx.app.log("CardPosition", "false");
    	}
    	
    		}
    		else
    		{
    	    	game.batch.draw(touchedCard.back,((handX+(this.startXoffset*this.hand.size()/2)) - (this.startXoffset * (this.hand.size() - i))),handY,this.cardWidth,this.cardHeight);
    		}
     	       
    	}
    	
    	
    }
    
    public void shuffleDeck()
    {
    	ArrayList<Card> cards =  playerDeck.Deck;
    	Random randomCardint = new Random();
    	
    	for(int i = 0; i < cards.size(); i++)
    	{
    		int randomIndex = randomCardint.nextInt(cards.size());;
    		Card presentPosition = cards.get(i);
    		Card switchingWith = cards.get(randomIndex);
    		cards.set(i, switchingWith);
    		cards.set(randomIndex, presentPosition);
    	}
    }
    


    
    @Override
    public void discardFromHand(int index) {
    
        if (hand.get(index) != null) {
            graveyard.add(hand.remove(index));
            
        }
    }

    @Override public int              getHealth()    { return health;    }
    @Override public int              getMana()      { return mana;      }
    @Override public int              getMaxHealth() { return maxHealth; }
    @Override public int              getMaxMana()   { return maxMana;   }
    @Override public int              getManaRegen() { return manaRegen; }
    @Override public Player           getOpponent()  { return opponent;  }
    @Override public Deck             getDeck()      { return playerDeck;      }
    @Override public LinkedList<Card>          getHand()      { return hand;      }
    @Override public LinkedList<MonsterCard>           getMonsters()  { return monsterField;  }
    @Override public LinkedList<ModifierCard>           getModifiers() { return modifierField; }
    @Override public LinkedList<Card> getGraveyard() { return graveyard; }

    @Override
    public int changeHealth(int change) {
        health = Math.min(health + change, maxHealth);
        return health;
    }
    @Override
    public int changeMana(int change) {
        mana = Math.min(mana + change, maxMana);
        return mana;
    }
    @Override
    public int changeMaxHealth(int change) {
        maxHealth = Math.max(1, maxHealth + change);
        if (health > maxHealth)
            health = maxHealth;
        return maxHealth;
    }
    @Override
    public int changeMaxMana(int change) {
        maxMana = Math.max(1, maxMana + change);
        if (mana > maxMana)
            mana = maxMana;
        return maxMana;
    }
    @Override
    public int changeManaRegen(int change) {
        manaRegen += change;
        return manaRegen;
    }

    @Override
    public Player setOpponent(Player opponent) {
        Player hold = this.opponent;
        this.opponent = opponent;
        return hold;
    }

	@Override
	public void play(int placeInHand, int placeToPlay, Player playTo) {
		// TODO Auto-generated method stub
		
	}
  


    
}
