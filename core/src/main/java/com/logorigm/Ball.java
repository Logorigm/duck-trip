package com.logorigm;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    float x = (float) Constants.SCR_WIDTH /2;
    float y = (float) Constants.SCR_HEIGHT /2;
    float xspeed = 300f;
    float yspeed = 400f;
    public void update(float delta) {
        if(y >= Constants.SCR_HEIGHT-1 || y <= 1){
            yspeed *= -1;
        }
        if(x >= Constants.SCR_WIDTH-1 || x <= 1){
            xspeed *= -1;
        }
        x += xspeed * delta;
        y += yspeed * delta;
        xspeed++;
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(x, y, 16, 16);
    }
}
