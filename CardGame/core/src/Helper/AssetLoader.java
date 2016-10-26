package Helper;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import cards.Ability;
import cards.Element;
import cards.MagicCard;
import cards.ModifierCard;
import cards.MonsterCard;

public class AssetLoader {

    public static Texture bg;
    public static Texture GameField;
  
    public static Sound frontScreen;
    public static Sound Background;
    
    public static MonsterCard PhoenixFire;
    public static MonsterCard Eagle;
    public static MonsterCard Scarecrow;
    public static MonsterCard Elf;
    public static MonsterCard Slime;
    public static MonsterCard ElfTeam; 	
    public static MonsterCard NightElf;
    public static MonsterCard ShadowPriesTaezyril;
    public static MonsterCard BroxiderTheGreen;
    public static MonsterCard ShadowHunter;
    public static MonsterCard Deathwing;   
    public static MonsterCard Orc;
    public static MonsterCard Goblin;
    public static MonsterCard Troll;
    public static MonsterCard Paladin;
    public static MonsterCard GreaterPaladin;
    public static MonsterCard Knight;
    public static MonsterCard KingArthur;
    

    public static MagicCard RelinquishFate; 
    public static MagicCard Fireball;
    public static MagicCard Forest;
    public static MagicCard WindOfAl;
    
    public static ModifierCard Coin;
    public static ModifierCard GreaterHealthPotion;
    public static void load() {

        bg = new Texture("Background.png");
        GameField = new Texture("GameField.png");
        Background = Gdx.audio.newSound(Gdx.files.internal("Background.mp3"));
        frontScreen = Gdx.audio.newSound(Gdx.files.internal("Mystic.mp3"));
        
        //Monster cards
        PhoenixFire = new MonsterCard("Phoenix Fire","If this card is destroyed, it can be revived by sacrificing 2 monsters in your bench.  If it is destroyed while it is active, destroy the enemy monster also.", 10, 18, 14, 1);
    	Eagle = new MonsterCard("Eagle","Once per turn.  Attack and defense are equal", 5, 8, 4, 0);
    	Scarecrow = new MonsterCard("Scarecrow","Scarecrows are fantastically brainless and feel no pain.", 7, 10, 15, 0);
    	Elf = new MonsterCard("Elf","Intelligent creatures with pointy ears", 1, 3, 2, 0);
    	Slime = new MonsterCard("Slime","Slimes regenerate health over time, making them a nuisance to weak opponents.", 3, 5, 10, 0);
    	ElfTeam = new MonsterCard("Elf Team","Intelligent creatures with pointy ears", 3, 6, 5, 0);
    	 NightElf = new MonsterCard( "Night Elf","Heal this minion for two HEALTH at the start of each turn",3, 2, 4, 0);
    	 ShadowPriesTaezyril = new MonsterCard( "Shadow Priest Taezyril","",15, 11, 10 , 0);
    	    BroxiderTheGreen =  new MonsterCard("Broxidor the Green","",29, 12, 30,  1);
    	    ShadowHunter =    new MonsterCard( "Shadow Hunter Jin-Vol","CHANGE attack with the opposing minion",12, 5, 7,  2);
    	    Deathwing =    	new MonsterCard( "Deathwing","DESTROY enitre board and DISCARD your hand",30, 9, 9,  0);   
    	    Orc =    		new MonsterCard( "Orc","Heal this minion for two healh after battle",3, 5, 4,  2);
    	    Goblin =     	new MonsterCard( "Goblin","Heal this minion for two healh after battle",3, 5, 4,  2);
    	    Troll =     	new MonsterCard("Troll", "Heal this minion for two healh after battle",3,  7, 8, 2);
    	    Paladin =  		new MonsterCard("Paladin","Heal this minion for two healh after battle",3,  5, 7,  2);
    	    GreaterPaladin = new MonsterCard("Greater Paladin", "Heal this minion for two healh after battle",3,  5, 6, 2);
    	    Knight =     	new MonsterCard("Knight","Heal this minion for two healh after battle",3,  4, 2,  2);
    	    KingArthur =    new MonsterCard("King Arthur","Heal this minion for two healh after battle",3,  2, 9,  2);
    	    
    	    
    	   
 

    	    
    	//Magic cards
     	RelinquishFate = new MagicCard("Relinquish Fate", "Discard all cards in your hand to destroy all cards on both sides of the field", 5, 0,"OnPlay"); 
     	Fireball =new MagicCard("Fireball","Deals DAMAGE",4, 4, "OnPlay");
		Forest =  new MagicCard("Forest", "DEFENSE",8,  4, "Continuous");
		WindOfAl = new MagicCard("Wind of Al-Akir", "DAMAGE",80,  100, "OnPlay");

		//Modifier cards
		Coin = new ModifierCard( "The coin","Add some mana!",3, 15, "MANA" );
		GreaterHealthPotion = new ModifierCard( "Greater Helth Potion","Add some HP!",10, 10,  "HEALTH");
    }

    public static void dispose() {
        // We must dispose of the texture when we are finished.
        bg.dispose();
        GameField.dispose();
    }

}