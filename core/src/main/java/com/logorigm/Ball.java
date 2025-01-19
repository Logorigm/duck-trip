package com.logorigm;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    float x = (float) Constants.SCR_WIDTH /2;
    float y = (float) Constants.SCR_HEIGHT /2;
    float xspeed = 300f;
    float yspeed = 400f;
    public void update(float delta, Player player1, Player player2) {
        if(y >= Constants.SCR_HEIGHT-1 || y <= 1){
            yspeed *= -1;
        }
        if((y <= player1.y + 128 && y >= player1.y && x<=16) ||(y >= player2.y && y <= player2.y+128 && x>= Constants.SCR_WIDTH-16)){
            xspeed *= -1;
        }
        else if(x <= 8 || x >= Constants.SCR_WIDTH-8){
            x = (float) Constants.SCR_WIDTH /2;
            y = (float) Constants.SCR_HEIGHT /2;
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
