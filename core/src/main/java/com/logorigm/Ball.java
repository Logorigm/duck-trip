package com.logorigm;

import static com.badlogic.gdx.math.MathUtils.random;
import static java.lang.Math.abs;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.sun.tools.javac.Main;

public class Ball {
    float x = (float) Constants.SCR_WIDTH /2;
    float y = (float) Constants.SCR_HEIGHT /2;
    float xspeed = 300f;
    float yspeed = 300f;
    public int score1 = 0;
    public int score2 = 0;
    public void update(float delta, Player player1, Player player2) {
        if(y >= Constants.SCR_HEIGHT-1 || y <= 1){
            yspeed *= -1;
        }
        if((y <= player1.y + 128 && y >= player1.y && x<16) ||(y >= player2.y && y <= player2.y+128 && x> Constants.SCR_WIDTH-16)){
            xspeed *= -1;
            x++;
        }
        else if(x <= 2 || x >= Constants.SCR_WIDTH-2){
            if(x <= 2){
                score2++;
            }
            else if(x >= Constants.SCR_WIDTH-2){
                score1++;
            }
            x = (float) Constants.SCR_WIDTH /2;
            y = (float) Constants.SCR_HEIGHT /2;
            float ran = random.nextFloat(2);
            xspeed = 300f * (ran-1);
        }
        x += xspeed * delta;
        y += yspeed * delta;
        if(xspeed<0) {
            xspeed-= 100*delta;
        }
        else{
            xspeed+= 100*delta;
        }
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(x, y, 16);
    }
}
