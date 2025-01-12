package com.logorigm;

import com.badlogic.gdx.Input;

public class PlayerControls {
    public static final PlayerControls p1 = new PlayerControls(
        Input.Keys.W,
        Input.Keys.S,
        Input.Keys.A,
        Input.Keys.D
    );

    public static final PlayerControls p2 = new PlayerControls(
        Input.Keys.UP,
        Input.Keys.DOWN,
        Input.Keys.LEFT,
        Input.Keys.RIGHT
    );

    final int up;
    final int down;
    final int left;
    final int right;

    public PlayerControls(int up, int down, int left, int right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
}
