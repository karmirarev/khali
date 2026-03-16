package com.your.mom.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.your.mom.utils.Signal;

public class InputManager extends InputAdapter
{
    public Signal onSpaceClick;
    public Signal onEscapeClick;
    public Signal onEnterClick;

    public InputManager()
    {
        onSpaceClick = new Signal();
        onEscapeClick = new Signal();
        onEnterClick = new Signal();

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(final int keycode)
    {
        if(keycode == Input.Keys.SPACE)
        {
            onSpaceClick.publish();
            return true;
        }

        if(keycode == Input.Keys.ESCAPE)
        {
            onEscapeClick.publish();
            return true;
        }

        if(keycode == Input.Keys.ENTER)
        {
            onEnterClick.publish();
            return true;
        }

        return false;
    }
}
