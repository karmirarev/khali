package com.your.mom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainMenuScreen implements Screen
{
    final Khali game;
    private Texture background;
    private Stage stage;
    private Skin skin;
    private BitmapFont font;
    TextButton.TextButtonStyle textButtonStyle;

    public MainMenuScreen(final Khali game)
    {
        this.game = game;
        background = new Texture("background.png");
    }

    public void create ()
    {
        stage = new Stage();
        skin  = new Skin();
        font = new BitmapFont();
        Gdx.input.setInputProcessor(stage);
        skin.add("default", font);

        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("white", new Texture(pixmap));

        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = skin.getFont("default");
        textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable("white", Color.GRAY);
        textButtonStyle.fontColor = Color.WHITE;

        TextButton button = new TextButton("Click Me", textButtonStyle);

        button.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new GameScreen(game));
                dispose();
            }
        });
    }

    public void render(float delta)
    {
        ScreenUtils.clear(Color.BLACK);

        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);

        game.batch.begin();
        game.batch.draw(background, 0, 0);
        game.font.draw(game.batch, "KHALI", 100, 500);
        game.font.draw(game.batch, "tap to begin", 100, 400);
        game.batch.end();

//        if (Gdx.input.isTouched())
//        {
//            game.setScreen(new GameScreen(game));
//            dispose();
//        }
    }

    public void resize(int width, int height)
    {
        game.viewport.update(width, height, true);
    }

    @Override
    public void show() {

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
    }
}
