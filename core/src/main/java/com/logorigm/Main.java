package com.logorigm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * {@link ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;


    Ball ball = new Ball();
    Player player1 = new Player(PlayerControls.p1);
    Player player2 = new Player(PlayerControls.p2);
    private BitmapFont font;
    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
        spriteBatch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(1.5f);
    }

    @Override
    public void render() {
        update();

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);


        spriteBatch.begin();
        font.setColor(Color.WHITE);
        font.draw(spriteBatch, "Score " + ball.score1 +  " : " + ball.score2 , Constants.SCR_WIDTH/2f-65, Constants.SCR_HEIGHT/2f+20);
        spriteBatch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shapeRenderer);
        player1.draw(shapeRenderer,1);
        player2.draw(shapeRenderer,2);
        shapeRenderer.end();
    }

    private void update() {
        float delta = Gdx.graphics.getDeltaTime();
        ball.update(delta, player1, player2);
        player1.update(delta);
        player2.update(delta);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
