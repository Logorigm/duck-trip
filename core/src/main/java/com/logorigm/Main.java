package com.logorigm;

import static com.badlogic.gdx.math.MathUtils.random;

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
    float x_rand = random.nextFloat(0.9f)+0.1f;
    float y_rand = random.nextFloat(0.9f)+0.1f;
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
        shapeRenderer.identity();
        update();

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);


        spriteBatch.begin();
        font.getData().setScale(1.5f);
        font.setColor(Color.WHITE);
        font.draw(spriteBatch, "Score " + ball.score1 +  " : " + ball.score2 , Constants.SCR_WIDTH/2f-65, Constants.SCR_HEIGHT/2f+20);
        spriteBatch.end();

        vibro_rend();

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
        vibro();
    }
    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
    private void vibro_rend() {
        if(ball.vtime > 0) {
            spriteBatch.begin();
            font.getData().setScale(5f);
            font.setColor(Color.RED);
            font.draw(spriteBatch, Constants.hit, Constants.SCR_WIDTH / 2f - 100, Constants.SCR_HEIGHT - 80);
            font.draw(spriteBatch, Constants.hit, Constants.SCR_WIDTH / 2f - 100, Constants.SCR_HEIGHT/ 2f - 80);
            spriteBatch.end();
        }
    }
    private void vibro() {
        // TODO: длительность сейчас зависит от FPS, надо опираться на deltaTime
        if(ball.vtime > 0){
            if((ball.vtime / 4)%2==0) {
                shapeRenderer.translate(Constants.power * x_rand, Constants.power*y_rand, 0);
            }
            else{
                x_rand = random.nextFloat(1f)+0.1f;
                y_rand = random.nextFloat(1f)+0.1f;
            }
            ball.vtime--;
        }
    }
}
