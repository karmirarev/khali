package com.your.mom;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.your.mom.util.Event;

public class GameScreen implements Screen {
    final Khali game;
    public Event<Boolean> changeScreen;

    private Texture background;
    private Stage stage;
    private Skin skin;
    private BitmapFont font;

    TextButton.TextButtonStyle textButtonStyle;

    public GameScreen(final Khali game) {
        this.game = game;
        this.changeScreen = new Event<>();
        background = new Texture("background.png");
    }

    @Override
    public void show() {
        skin  = new Skin();
        stage = new Stage();
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

        TextButton button = new TextButton("EXIT", textButtonStyle);
        button.setPosition(100, 400);
        // button.setSize(300, 500);

        button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                changeScreen.publish(true);
            }
        });

        stage = new Stage(new ScreenViewport());
        stage.addActor(button);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.BLACK);

        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);

        game.batch.begin();
        game.batch.draw(background, 0, 0);
        // game.font.draw(game.batch, "KHALI", 100, 500);
        game.batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);
        game.batch.begin();
        game.batch.draw(background, 0, 0);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
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
        stage.dispose();
        font.dispose();
        skin.dispose();
    }
}
