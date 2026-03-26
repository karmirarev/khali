//package com.your.mom.meta;
//
//import com.badlogic.gdx.ScreenAdapter;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.GlyphLayout;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Skin;
//import com.badlogic.gdx.utils.ScreenUtils;
//import com.badlogic.gdx.utils.viewport.Viewport;
//import com.your.mom.managers.InputManager;
//import com.your.mom.utils.Signal;
//
//public class MenuScreen extends ScreenAdapter
//{
//    private InputManager inputManager;
//    private SpriteBatch batch;
//    private BitmapFont font;
//    private Viewport viewport;
//    private GlyphLayout glyphLayout;
//
//    private Stage stage;
//    private Skin skin;
//
//    public Signal onEnterGame;
//
//    public MenuScreen(InputManager inputManager, SpriteBatch batch, BitmapFont font, Viewport viewport)
//    {
//        this.inputManager = inputManager;
//        this.batch = batch;
//        this.font = font;
//        this.viewport = viewport;
//        this.glyphLayout = new GlyphLayout();
//
//        this.onEnterGame = new Signal();
//    }
//
//    @Override
//    public void show()
//    {
//        stage = new Stage();
//        skin = new Skin();
//        font = new BitmapFont();
//
//        inputManager.onSpaceClick.subscribe(this, onEnterGame::publish);
//    }
//
//    @Override
//    public void hide()
//    {
//        inputManager.onSpaceClick.unsubscribe(this);
//    }
//
//    @Override
//    public void resize(int width, int height)
//    {
//        viewport.update(width, height, true);
//    }
//
//    @Override
//    public void render(float delta)
//    {
//        ScreenUtils.clear(Color.BLACK);
//
//        viewport.apply();
//        batch.setProjectionMatrix(viewport.getCamera().combined);
//        batch.begin();
//
//        glyphLayout.setText(font, "KHALI");
//        font.setColor(Color.WHITE);
//        font.draw(
//            batch,
//            glyphLayout,
//            (viewport.getWorldWidth() - glyphLayout.width) / 2f,
//            (viewport.getWorldHeight() + glyphLayout.height) / 2f
//        );
//
//        batch.end();
//    }
//}

package com.your.mom.meta;

import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.your.mom.managers.InputManager;
import com.your.mom.utils.Signal;

public class MenuScreen extends ScreenAdapter
{
    private final InputManager inputManager;
    private final SpriteBatch batch;
    private final Viewport viewport;

    private Stage stage;
    private Skin skin;
    private BitmapFont font;
    private Texture background;

    public final Signal onEnterGame;

    public MenuScreen(InputManager inputManager, SpriteBatch batch, BitmapFont font, Viewport viewport)
    {
        this.inputManager = inputManager;
        this.batch = batch;
        this.font = font;
        this.viewport = viewport;
        this.onEnterGame = new Signal();
        this.background = new Texture("background.png");
    }

    @Override
    public void show()
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
        pixmap.dispose();

        skin.add("default", font);

        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = skin.getFont("default");
        buttonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
        buttonStyle.down = skin.newDrawable("white", Color.GRAY);
        buttonStyle.fontColor = Color.WHITE;

        TextButton startButton = new TextButton("START", buttonStyle);
        startButton.setPosition(
//            (viewport.getWorldWidth()  - startButton.getWidth())  / 2f,
//            (viewport.getWorldHeight() - startButton.getHeight()) / 2f - 40f
            100, 400
        );

        startButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                onEnterGame.publish();
            }
        });

        stage = new Stage(viewport);
        stage.addActor(startButton);

        Gdx.input.setInputProcessor(stage); // set once
        inputManager.onSpaceClick.subscribe(this, onEnterGame::publish);
    }

    @Override
    public void render(float delta)
    {
        ScreenUtils.clear(Color.BLACK);

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(background, 0, 0);
        font.draw(batch, "KHALI", 100, 500);
        batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height)
    {
        viewport.update(width, height, true);
    }

    @Override
    public void hide()
    {
        inputManager.onSpaceClick.unsubscribe(this);
    }

    @Override
    public void dispose()
    {
        stage.dispose();
        skin.dispose();
    }
}
