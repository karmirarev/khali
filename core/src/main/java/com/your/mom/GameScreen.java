package com.your.mom;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);

        game.batch.begin();

        float midWidth = (background.getWidth() - floor.getWidth()) / 2;
        float midHeight = (background.getHeight() - floor.getHeight()) / 2;

        game.batch.draw(background, 0, 0);
        game.batch.draw(floor, midWidth, midHeight);
        placeDoors();

        game.batch.end();
    }

    private void placeDoors()
    {
        float midWidth = (background.getWidth() - floor.getWidth()) / 2;
        float midHeight = (background.getHeight() - floor.getHeight()) / 2;

        Sprite doorSprite = new Sprite(door);
        doorSprite.setSize(door.getWidth(), door.getHeight());
        int roomIndex = 0;

        if (roomIndex == 0)
        {
            // top door
            doorSprite.setX(floor.getWidth() / 2);
            doorSprite.setY(midHeight + floor.getHeight() / 2);
            doorSprite.setRotation(0);
            doorSprite.draw(game.batch);

            // bottom door
            doorSprite.setX(floor.getWidth() / 2);
            doorSprite.setY(floor.getHeight() / 2 - midHeight);
            doorSprite.setRotation(180);
            doorSprite.draw(game.batch);

            // left door
            doorSprite.setX(midWidth);
            doorSprite.setY(floor.getHeight() / 2);
            doorSprite.setRotation(90);
            doorSprite.draw(game.batch);

            // right door
            doorSprite.setX(midWidth +  floor.getWidth() / 2);
            doorSprite.setY(floor.getHeight() / 2);
            doorSprite.setRotation(270);
            doorSprite.draw(game.batch);
        }
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
