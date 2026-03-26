package com.your.mom;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.your.mom.managers.InputManager;
import com.your.mom.meta.GameScreen;
import com.your.mom.meta.MenuScreen;

public class Main extends Game
{
    private SpriteBatch batch;
    private BitmapFont font;
    private Viewport viewport;

    private InputManager inputManager;

    private MenuScreen menuScreen;
    private GameScreen gameScreen;

    @Override
    public void create()
    {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        batch = new SpriteBatch();
        font = new BitmapFont();
        viewport = new ScreenViewport();
        inputManager = new InputManager();
        menuScreen = new MenuScreen(inputManager, batch, font, viewport);
        gameScreen = new GameScreen(inputManager, batch, font, viewport);

        font.setUseIntegerPositions(false);
        // font.getData().setScale(viewport.getWorldHeight() / Gdx.graphics.getHeight());
        start();
    }

    private void start()
    {
        menuScreen.onEnterGame.subscribe(this, this::enterGame);
        gameScreen.onEnterMenu.subscribe(this, this::enterMenu);

        enterMenu();
    }

    @Override
    public void dispose()
    {
        batch.dispose();
        font.dispose();
        menuScreen.dispose();
        gameScreen.dispose();
    }

    private void enterGame()
    {
        setScreen(gameScreen);
    }

    private void enterMenu()
    {
        setScreen(menuScreen);
    }
}
