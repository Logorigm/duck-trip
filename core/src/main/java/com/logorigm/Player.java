package com.logorigm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {
    private final PlayerControls playerControls;

    public Player(PlayerControls playerControls) {
        this.playerControls = playerControls;
    }

    public float x = 0;
    public float y = 0;

    public void update(float delta) {
        float speed = 1000f;
        if (Gdx.input.isKeyPressed(playerControls.up)) {
            if(y<Constants.SCR_HEIGHT-128) {
                y += speed * delta;
            }
        }
        if (Gdx.input.isKeyPressed(playerControls.down)) {
            if(y>0) {
                y -= speed * delta;
            }
        }
    }

    public void draw(ShapeRenderer shapeRenderer, int number) {
        // shapeRenderer.begin();
        if(number == 1) {
            shapeRenderer.rect(x, y, 16, 128);
        }
        else if(number == 2){
            shapeRenderer.rect(Constants.SCR_WIDTH-16, y, 16, 128);
        }
        //shapeRenderer.end();
    }
}
