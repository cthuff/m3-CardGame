package cards;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.CardGame;

public class Deck extends ArrayList<Card> {
	
	public CardGame game;
	public String Name;
	private int DeckWidth;
	private int DeckHeight;
	public Texture Back;
	public ArrayList<Card> Deck; 
    
	public Deck(CardGame game) 
	{ 
		this.game = game;
		Deck = new ArrayList<Card>();
		DeckWidth = 30;
		DeckHeight = 70;
		Back = new Texture("CardBack.png");
		 
		}
	public void DrawDeck(int DeckX,int DeckY)
	{
		for(int i = 0; i< Deck.size();i++)
		{
			game.batch.draw(new Texture("CardBack.png"),DeckX+i,DeckY,DeckWidth,DeckHeight);
		
		}
	}
    public Deck(Card... cards) 
    {
    	Deck = new ArrayList<Card>();
        for (Card card : cards)
            if (card != null)
                Deck.add(card);
    }
    public ArrayList<Card> getDeck()
    {
    	return Deck;
    }

    public Card draw() {
        if (isEmpty())
            return null;
        return remove((int) (Math.random() * size()));
    }
    public Card drawL0Monster() {
        if (isEmpty())
            return null;
        ArrayList<MonsterCard> monsters = new ArrayList<MonsterCard>();
        for (Card c : this)
            if (c instanceof MonsterCard)
                monsters.add((MonsterCard) c);
        return get((int) (Math.random() * monsters.size()));
    }
    public void add(MonsterCard monster)
    {
    	Deck.add(monster);
    }
    public void add(ModifierCard modifier)
    {
    	Deck.add(modifier);
    }
    public void add(MagicCard magic)
    {
    	Deck.add(magic);
    }


}
