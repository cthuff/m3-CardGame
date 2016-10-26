package board;

import java.util.LinkedList;

import cards.Attackable;
import cards.Card;
import cards.Deck;
import cards.ModifierCard;
import cards.MonsterCard;

public interface PlayerInterface{
     /**
     * Draws a Level 0 (no-sacrifices-required) monster from the deck, if possible.
     * @return a Level 0 monster, or null if none is available
     */
    public LinkedList<Card> getHand();
    public LinkedList<MonsterCard> getMonsters();
    public LinkedList<ModifierCard> getModifiers();
    
    public LinkedList<Card> getGraveyard();
  
    /**
     * Plays a card.
     * @param placeInHand the desired card's index in the hand
     * @param placeToPlay the desired card's destination index in an applicable space, depending on the card's
     * type and abilities
     * @param playTo the player on whom the card should be played
     * @return the card played
     */
    public void play(int placeInHand, int placeToPlay, Player playTo);
    /**
     * Sends the card at the specified index in the hand to the graveyard.
     * @param index the index of the card to discard
     * @return the discarded card
     */

    public void discardFromHand(int index);
    /*public void monsterPhase(MonsterCard monster, int toPosition);
    public void magicPhase(MagicCard[] magics, Object[] magicTargets, MagicCard[] modifiers,
                           int[] modifierToPosition, Player[] modifierPlayTo);
    public void battlePhase(MonsterCard... useAbilityInsteadOfAttack);*/
    
    public Player getOpponent();
    /**
     * Sets this player's opponent.
     * @param opponent the new opponent
     * @return the previous opponent
     */
    public Player setOpponent(Player opponent);
    
    public int getMana();
    /**
     * Changes this player's amount of mana.
     * @param change the change in mana
     * @return the new mana value
     */
    public int changeMana(int change);
    
    public int getMaxMana();
    /**
     * Changes this player's maximum amount of mana.
     * @param change the change in maximum mana
     * @return the new maximum mana value
     */
    public int changeMaxMana(int change);
    
    public int getHealth();
    /**
     * Changes this player's amount of health.
     * @param change the change in health
     * @return the new health value
     */
    public int changeHealth(int change);
    
    public int getMaxHealth();
    /**
     * Changes this player's maximum amount of health.
     * @param change the change in maximum health
     * @return the new maximum health value
     */
    public int changeMaxHealth(int change);
    
    public int getManaRegen();
    /**
     * Changes this player's mana regen.
     * @param change the change in mana regen
     * @return the new mana regen
     */
    public int changeManaRegen(int change);
    
    public Deck getDeck();
}
