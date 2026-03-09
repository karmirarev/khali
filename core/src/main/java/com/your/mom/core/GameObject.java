package com.your.mom.core;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject
{
    protected Rectangle rectangle;
    protected Texture texture;

    public GameObject()
    {
        this.rectangle = null;
        this.texture = null;
    }

    public GameObject(float x, float y, float width, float height)
    {
        this.rectangle = new Rectangle(x, y, width, height);
        this.texture = null;
    }

    public GameObject(float x, float y, float width, float height, Texture texture)
    {
        this.rectangle = new Rectangle(x, y, width, height);
        this.texture = texture;
    }

    public boolean overlaps(GameObject other)
    {
        return rectangle.overlaps(other.rectangle);
    }

    public void draw(Batch batch)
    {
        if (texture != null) {
            batch.draw(texture, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }

    public abstract void update(float delta);
}

