package com.logorigm;

import static com.badlogic.gdx.math.MathUtils.random;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    float x = (float) Constants.SCR_WIDTH /2;
    float y = (float) Constants.SCR_HEIGHT /2;
    float xspeed = 300f;
    float yspeed = 300f;
    public float vtime = 0;
    public int score1 = 0;
    public int score2 = 0;
    public void update(float delta, Player player1, Player player2) {
        if(y >= Constants.SCR_HEIGHT-1 || y <= 1) {
            yspeed *= -1;
        }
        if(y >= Constants.SCR_HEIGHT-1){
            y -= 5;
        }
        else if(y <= 1){
            y += 5;
        }
        if((y <= player1.y + 128 && y >= player1.y && x<16) || (y >= player2.y && y <= player2.y+128 && x> Constants.SCR_WIDTH-16)){
            xspeed *=-1;
            if(y <= player1.y + 128 && y >= player1.y && x<16){
                yspeed += player1.pos * 200f;
            }
            else if(y >= player2.y && y <= player2.y+128 && x > Constants.SCR_WIDTH-16){
                yspeed += player2.pos * 200f;
            }
            vtime = 0.15f;
        }
        else if(x <= 2 || x >= Constants.SCR_WIDTH-2){
            if(x <= 2){
                score2++;
            }
            else if(x >= Constants.SCR_WIDTH-2){
                score1++;
            }
            brand();
        }
        x += xspeed * delta;
        y += yspeed * delta;
        speedup(delta);
    }
    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.circle(x, y, 16);
    }
    // Запуск шарика по рандомному направлению
    private void brand(){
        x = (float) Constants.SCR_WIDTH /2;
        y = (float) Constants.SCR_HEIGHT /2;
        float ran1 = random.nextFloat(2);
        float ran2 = random.nextFloat(2);
        if(ran1 < 1.25 && ran1>=1){
            ran1 += 0.5f;
        }
        if(ran2 < 1.25 && ran2>=1){
            ran2 += 0.5f;
        }
        if(ran1 < 1 && ran1 >= 0.75){
            ran1 -= 0.5f;
        }
        if(ran1 < 1 && ran1 >= 0.75){
            ran1 -= 0.5f;
        }
        xspeed = 300f * (ran1 - 1);
        yspeed = 300f * (ran2 - 1);
        if(yspeed < 0){
            yspeed -= 100f;
        }
        else if(yspeed > 0){
            yspeed += 100f;
        }
        if(xspeed < 0){
            xspeed -= 100f;
        }
        else if(xspeed > 0){
            xspeed += 100f;
        }
    }
    private void speedup(float delta){
        if(xspeed<0) {
            xspeed-= 100*delta;
        }
        else{
            xspeed+= 100*delta;
        }
        if(yspeed<0) {
            yspeed-= 25*delta;
        }
        else{
            yspeed+= 25*delta;
        }
    }
}
