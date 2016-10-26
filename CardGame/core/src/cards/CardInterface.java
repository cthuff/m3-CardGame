package cards;

import com.badlogic.gdx.graphics.Texture;

/**
 * This interface specifies all of the methods absolutely necessary for an object of class Card.
 * @author Gregory Gan
 */
public interface CardInterface {
    public int getManaCost();
    public boolean isFaceUp();
    public boolean flip();
    public boolean setAbilities(Ability... abilities);
    public Element getElement();
    public Ability[] getAbilities();
    public String getType();
    public String getName();
    public String getDescription();
	Texture getFront();
	Texture getBack();
	void setManaCost(int manaCost);
	void setElement(Element element);
	void setName(String name);
	void setDescription(String description);
	void setFront(Texture front);
	void getBack(Texture back);
}
