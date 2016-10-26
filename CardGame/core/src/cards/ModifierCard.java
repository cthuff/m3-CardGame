package cards;

import com.badlogic.gdx.graphics.Texture;




/**
 * The monster is a type of card that has a mana cost, name attack, defense,
 * information that relates to the card, and the effect that it has on other
 * monsters
 * 
 * @author craig
 */
public class ModifierCard extends Card {

	private String name, info, type;
	private int modify, mana;

	public ModifierCard(String name, String info, int mana, int modify, String type) 
	{
		super(name, info, mana);
		this.name = name;
		this.info = info;
		this.modify = modify;
		this.mana = mana;
		this.type = type;
		super.front = new Texture("CardBase_Modifier.png");
	}

	public String getName() {
		return name;
	}

	public String getInfo() {
		return info;
	}

	public int getModify() {
		return modify;
	}

	public int getMana() {
		return mana;
	}

	public String getType() {
		return type;
	}

	@Override
	public boolean setAbilities(Ability... abilities) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Element getElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ability[] getAbilities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElement(Element element) {
		// TODO Auto-generated method stub
		
	}
}
