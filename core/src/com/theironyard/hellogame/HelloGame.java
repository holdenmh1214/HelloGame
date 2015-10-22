package com.theironyard.hellogame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;


	float x = 0;
    float y = 0;
    float xV = 0; //velocity
    float yV = 0; //velocity

    final float MAX_VELOCITY = 10;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("cloud.png");
	}

	@Override
	public void render () {

        move();


		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}

    void move() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            yV = MAX_VELOCITY;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            yV = MAX_VELOCITY*-1;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            xV = MAX_VELOCITY*-1;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            xV = MAX_VELOCITY;
        }

        x += xV + Gdx.graphics.getDeltaTime();
        y += yV + Gdx.graphics.getDeltaTime();

        xV *=0.9;
        yV *=0.9;

    }
}
