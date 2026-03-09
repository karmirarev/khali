package com.your.mom.meta;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.your.mom.managers.InputManager;
import com.your.mom.utils.Event;

public class MenuScreen extends ScreenAdapter
{
    private InputManager inputManager;
    private SpriteBatch batch;
    private BitmapFont font;
    private Viewport viewport;
    private GlyphLayout glyphLayout;

    public Event onEnterGame;

    public MenuScreen(InputManager inputManager, SpriteBatch batch, BitmapFont font, Viewport viewport)
    {
        this.inputManager = inputManager;
        this.batch = batch;
        this.font = font;
        this.viewport = viewport;

        this.glyphLayout = new GlyphLayout();
        this.onEnterGame = new Event();
    }

    @Override
    public void show()
    {
        inputManager.onSpaceClick.subscribe(this, onEnterGame::invoke);
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

        glyphLayout.setText(font, "KHALI");
        font.setColor(Color.WHITE);
        font.draw(
            batch,
            glyphLayout,
            (viewport.getWorldWidth() - glyphLayout.width) / 2f,
            (viewport.getWorldHeight() + glyphLayout.height) / 2f
        );

        batch.end();
    }
}
