package edu.niu.cs.akhil.bouncingball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by akhil on 4/13/17.
 */

public class Ball {
	private final int RADIUS = 15, REVERSE = -1;
	private int x,y,velocityX,velocityY;
	public Ball(){
		x=100;y=100;
		velocityX=100;
		velocityY=100;
	}
	public void move(int leftWall,int topWall,int rightWall, int bottomWall) {
		x += velocityX;	y += velocityY;
		if (y > bottomWall - RADIUS){
			y = bottomWall - RADIUS;
			velocityY*=REVERSE;
		}
		else if (y  < topWall+RADIUS){
			y = topWall + RADIUS;
			velocityY *=REVERSE;
		}
		if (x > rightWall - RADIUS){
			x = rightWall - RADIUS;
			velocityX*=REVERSE;
		}
		else if (x  < leftWall+RADIUS){
			x = leftWall + RADIUS;
			velocityX*=REVERSE;
		}
	}

	public void draw(Canvas canvas){
		Paint paint = new Paint();
		paint.setColor(Color.rgb(55,108,187));
		canvas.drawCircle(x,y,RADIUS,paint);
	}

}
