package cards;

import java.util.LinkedList;
import java.util.ListIterator;

import com.badlogic.gdx.graphics.Texture;

public class MonsterCard extends Card {
	
    public final int sacrifices, manaCost;
    private int atk, def, hp;
    private LinkedList<MagicCard> equips;
    
    public static final Texture front = new Texture("CardBase_Monster.png"); 
    public static final Texture  back = new Texture("CardBack.png");
    
    public Texture MonsterImage;
    private Ability[] abilities;

    public MonsterCard(String name, String description, int manaCost, int atk, int def, int sacrifices) {
    	
        super(name, description, manaCost);
        this.sacrifices = sacrifices;
        this.manaCost = manaCost;
        this.hp = this.def = def;
        this.atk = atk;
        super.front = front;
        equips = new LinkedList<MagicCard>();
        
        /*
        back = new Texture("CardBack.png");
        front = new Texture("CardBase_Monster.png");
        */
    }
    

    public int attack(Attackable target) { return attack(target, atk, true); }
    public int attack(Attackable target, int damage, boolean allowCounter) {
        if (!(target instanceof Attackable))
            return 0;
        // TODO implement attack player if target == null
        return target.defend(this, damage, allowCounter);
    }
    
    
    
    public boolean equip(MagicCard equip)              { return equips.add(equip); }
    public boolean equip(LinkedList<MagicCard> equips) { return this.equips.addAll(equips); }
    public LinkedList<MagicCard> getEquips()           { return equips; }
    public MagicCard removeEquip(MagicCard equip) {
        ListIterator<MagicCard> iter = equips.listIterator();
        while (iter.hasNext()) {
            MagicCard card = iter.next();
            if (card.equals(equip)) {
                iter.remove();
                return card;
            }
        }
        return null;
    }
    public int getAtk() { return atk; }
    public int getDef() { return def; }
    public int getHP()  { return hp;  }
    public int changeAtk(int change) {
        atk = Math.min(0, atk + change);
        return atk;
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
