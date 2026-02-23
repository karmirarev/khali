package com.your.mom;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Khali extends Game
{

    public SpriteBatch batch;
    public BitmapFont font;
    public FitViewport viewport;

    @Override
    public void create()
    {
        batch = new SpriteBatch();
        font = new BitmapFont();
        viewport = new FitViewport(1280, 800);

        font.setUseIntegerPositions(false);
        font.getData().setScale(viewport.getWorldHeight() / Gdx.graphics.getHeight());

        this.setScreen(new MainMenuScreen(this));
    }

    public void render()
    {
        super.render();
    }

    public void dispose()
    {
        batch.dispose();
        font.dispose();
    }
}
