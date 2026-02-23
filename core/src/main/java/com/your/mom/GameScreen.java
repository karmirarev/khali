package com.your.mom;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen
{
    final Khali game;

    public GameScreen(final Khali game)
    {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
