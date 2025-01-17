package com.logorigm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;

    Player player1 = new Player(PlayerControls.p1);
    Player player2 = new Player(PlayerControls.p2);
    Ball ball = new Ball();

    @Override
    public void create() {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render() {
        update();

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        ball.draw(shapeRenderer);
        player1.draw(shapeRenderer,1);
        player2.draw(shapeRenderer,2);
        shapeRenderer.end();
    }

    private void update() {
        float delta = Gdx.graphics.getDeltaTime();
        ball.update(delta);
        player1.update(delta);
        player2.update(delta);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}
