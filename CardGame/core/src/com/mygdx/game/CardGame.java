package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Helper.AssetLoader;
import screens.GameScreen;
import screens.ResultScreen;
import screens.GameScreen;
import screens.BattleScreen;
import screens.DeckScreen;

public class CardGame extends Game {
	public SpriteBatch batch;
	public GameScreen Start;
	public BattleScreen Battle;
	public DeckScreen Deck;
	public ResultScreen Result;
	
	@Override
	public void create () {
	
		AssetLoader.load();
		batch = new SpriteBatch();
		Start = new GameScreen(this);
		Deck = new DeckScreen(this);
		Result = new ResultScreen(this);
		Battle = new BattleScreen(this);

		this.setScreen(Start);
	}
	
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
}
