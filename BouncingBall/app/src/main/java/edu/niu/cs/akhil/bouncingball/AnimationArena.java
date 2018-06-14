package edu.niu.cs.akhil.bouncingball;

import android.graphics.Canvas;

/**
 * Created by akhil on 4/13/17.
 */

public class AnimationArena {
	private Ball myBall;

	public AnimationArena() {
		myBall = new Ball();
	}
	public void update(int width,int height){
		myBall.move(0,0,width,height);
	}
	public void draw(Canvas canvas){
		canvas.drawRGB(225,225,225);
		myBall.draw(canvas);
	}
}
