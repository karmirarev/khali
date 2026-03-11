package com.your.mom;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Khali<T> extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public FitViewport viewport;

    private MainMenuScreen mainMenuScreen;
    private GameScreen gameScreen;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        viewport = new FitViewport(1280, 800);

        font.setUseIntegerPositions(false);
        font.getData().setScale(viewport.getWorldHeight() / Gdx.graphics.getHeight());

        mainMenuScreen = new MainMenuScreen(this);
        gameScreen = new GameScreen(this);

        mainMenuScreen.changeScreen.subscribe(this, this::setGameScreen);
        gameScreen.changeScreen.subscribe(this, this::setMenuScreen);

        setMenuScreen(true);
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    private void setMenuScreen(boolean gloop) {
        this.setScreen(mainMenuScreen);
    }

    private void setGameScreen(boolean bloop) {
        this.setScreen(gameScreen);
    }
}
