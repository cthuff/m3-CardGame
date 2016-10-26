package cards;

import com.badlogic.gdx.graphics.Texture;

public abstract class Card implements Comparable<Card>, CardInterface {
    
	private int manaCost; // refers to mana required
    public Texture front;// front of card
    public Texture back = new Texture("CardBack.png");; // back of card
    private boolean faceUp;// boolean weather card is faceup or facedown

    private String name, info;
    public String cardType; // refers to if it is a monster, magic or modifier
	public boolean isFaceUp;

    public Card(String name, String description, int manaCost) 
    { 
    	isFaceUp = false;
    	this.name = name;
    	this.info = description;
    	this.manaCost = manaCost; 
    	back = new Texture("CardBack.png"); 
    }
    
    public boolean isMonster()
    {
    	if(this.cardType.equals("Monster"))
    	{
    		return true;
    	}
		return false;
    }
    
    public boolean isModifier()
    {
    	if(this.cardType.equals("Modifier"))
    	{
    		return true;
    	}
		return false;
    }
    
    public boolean isMagic()
    {
    	if(this.cardType.equals("Magic"))
    	{
    		return true;
    	}
		return false;
    }

    
    @Override
    public int getManaCost()         { return manaCost; }
    @Override
    public String getName()          { return name; }
    @Override
    public String getDescription()   { return info; }
    @Override
    public String getType()          { return getClass().getSimpleName(); }
    @Override
    public Texture getFront()          {return front; }
    @Override
    public Texture getBack()           {return back; }
    @Override
    public int compareTo(Card other) { return name.compareTo(other.getName()); }
    @Override
    public boolean isFaceUp()        { return faceUp; }
    @Override
    public boolean flip() {
        faceUp = !faceUp;
        return faceUp;
    }
    
    @Override
    public void setManaCost(int manaCost)         { this.manaCost = manaCost; }
    @Override
    public void setName(String name)          { this.name =  name; }
    @Override
    public void setDescription(String description)   { this.info =  description; }
    @Override
    public void setFront(Texture front)          {this.front =  front; }
    @Override
    public void getBack(Texture back)           {this.back = back; }


    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+name+" ("+ manaCost+"): "+info;
    }
    
    
    
    public static void delay(double seconds)
    {
    	seconds = seconds*1000;
    	int delayTime = (int) seconds;
    	try
    	{
    		Thread.sleep(delayTime);
    	
    	}
    	catch(Exception e)
    	{
    		
    	}
    }
}
