package com.your.mom;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameScreen implements Screen
{
    final Khali game;
    private Texture background;
    private Texture floor;
    private Texture door;

    public GameScreen(final Khali game)
    {
        this.game = game;

        background = new Texture("background.png");
        floor = new Texture("floor.png");
        door = new Texture("door.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v)
    {
        generateRoom();
        draw();
    }

    private void generateRoom()
    {

    }

    private void draw()
    {
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
        background.dispose();
        floor.dispose();
        door.dispose();
    }
}
