package com.your.mom.meta;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.your.mom.managers.InputManager;
import com.your.mom.utils.Event;
import com.your.mom.utils.Signal;

public class GameScreen extends ScreenAdapter
{
    private InputManager inputManager;

    private SpriteBatch batch;
    private Stage stage;
    private Skin skin;
    private BitmapFont font;
    private Viewport viewport;

    private Texture background;

    public Signal onEnterMenu;
    public Signal onEnterGame;

    TextButton.TextButtonStyle textButtonStyle;

    public GameScreen(InputManager inputManager, SpriteBatch batch, BitmapFont font, Viewport viewport)
    {
        this.inputManager = inputManager;
        this.batch = batch;
        this.font = font;
        this.viewport = viewport;

        this.background = new Texture("background.png");
        this.background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        this.onEnterMenu = new Signal();
        this.onEnterGame = new Signal();
    }

    @Override
    public void show()
    {
        inputManager.onSpaceClick.subscribe(this, onEnterMenu::publish);

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

        TextButton button = new TextButton("BACK", textButtonStyle);
        button.setPosition(100, 400);

        button.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                onEnterMenu.publish();
            }
        });

        stage = new Stage(new ScreenViewport());
        stage.addActor(button);

        Gdx.input.setInputProcessor(stage);
        inputManager.onSpaceClick.subscribe(this, onEnterMenu::publish);
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
        batch.draw(background, 0, 0);
        batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();
    }
}
