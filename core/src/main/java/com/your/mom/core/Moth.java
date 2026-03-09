package com.your.mom.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Moth extends GameObject
{
    private float scale;
    private Viewport viewport;

    public Moth(float x, float y, Viewport viewport)
    {
        this.texture = new Texture(Gdx.files.internal("moth.png"));
        this.scale = 0.25f;
        this.rectangle = new Rectangle(x, y, texture.getWidth() * scale, texture.getHeight() * scale);
        this.viewport = viewport;
    }

    @Override
    public void update(float delta) {

    }
}
