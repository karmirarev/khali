package com.your.mom.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.your.mom.utils.Event;

public class InputManager extends InputAdapter
{
    public Event onSpaceClick;
    public Event onEscapeClick;
    public Event onEnterClick;

    public InputManager()
    {
        onSpaceClick = new Event();
        onEscapeClick = new Event();
        onEnterClick = new Event();

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(final int keycode)
    {
        if(keycode == Input.Keys.SPACE)
        {
            onSpaceClick.invoke();
            return true;
        }

        if(keycode == Input.Keys.ESCAPE)
        {
            onEscapeClick.invoke();
            return true;
        }

        if(keycode == Input.Keys.ENTER)
        {
            onEnterClick.invoke();
            return true;
        }

        return false;
    }
}
