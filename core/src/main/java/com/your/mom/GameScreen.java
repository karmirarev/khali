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
        draw();
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
        // PlaceDoors();
        game.batch.end();
    }

    public void PlaceDoors()
    {
        float midWidth = (background.getWidth() - floor.getWidth()) / 2;
        float midHeight = (background.getHeight() - floor.getHeight()) / 2;
        float midFloorWidth = floor.getWidth() / 2;
        float midFloorHeight = floor.getHeight() / 2;

        Sprite doorSprite = new Sprite(door);
        doorSprite.setSize(door.getWidth(), door.getHeight());
        doorSprite.setOriginCenter();

        // top door
        doorSprite.setX(midWidth + midFloorWidth - door.getWidth() / 2f);
        doorSprite.setY(midHeight + floor.getHeight() - door.getHeight() / 2f);
        doorSprite.setRotation(0);
        doorSprite.draw(game.batch);

        // bottom door
        doorSprite.setX(midWidth + midFloorWidth - door.getWidth() / 2f);
        doorSprite.setY(midHeight - door.getHeight() / 2f);
        doorSprite.setRotation(180);
        doorSprite.draw(game.batch);

        // left door
        doorSprite.setX(midWidth - door.getWidth() / 2f);
        doorSprite.setY(midHeight + midFloorHeight - door.getHeight() / 2f);
        doorSprite.setRotation(90);
        doorSprite.draw(game.batch);

        // right door
        doorSprite.setX(midWidth + floor.getWidth() - door.getWidth() / 2f);
        doorSprite.setY(midHeight + midFloorHeight - door.getHeight() / 2f);
        doorSprite.setRotation(270);
        doorSprite.draw(game.batch);
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
