package com.your.mom.meta;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.your.mom.managers.InputManager;
import com.your.mom.utils.Event;

public class GameScreen extends ScreenAdapter
{
    private InputManager inputManager;

    private SpriteBatch batch;
    private BitmapFont font;
    private Viewport viewport;

    private Texture background;

    public Event onEnterMenu;

    public GameScreen(InputManager inputManager, SpriteBatch batch, BitmapFont font, Viewport viewport)
    {
        this.inputManager = inputManager;
        this.batch = batch;
        this.font = font;
        this.viewport = viewport;

        this.background = new Texture("background.png");
        this.background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        this.onEnterMenu = new Event();
    }

    @Override
    public void show()
    {
        inputManager.onSpaceClick.subscribe(this, onEnterMenu::invoke);
    }

    @Override
    public void hide()
    {
        inputManager.onSpaceClick.unsubscribe(this);
    }

    @Override
    public void resize(int width, int height)
    {
        viewport.update(width, height, true);
    }

    @Override
    public void render(float delta)
    {
        ScreenUtils.clear(Color.BLACK);

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        batch.end();
    }
}
