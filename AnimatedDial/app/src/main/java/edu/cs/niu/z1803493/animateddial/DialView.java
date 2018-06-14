package edu.cs.niu.z1803493.animateddial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import static android.R.attr.color;
import static android.R.attr.start;
import static android.R.attr.startX;
import static android.R.attr.startY;

/**
 * Created by Akhil on 4/11/2017.
 */

public class DialView extends View {
    private float angle;
    private Paint paint;

    public DialView(Context context) {
        super(context);
        angle = 0;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(248, 234, 196);
        int canvasWidth = getMeasuredWidth(),canvasHeight = getMeasuredHeight(),radius;
        //set the radius based on orientation of the device
        if (canvasWidth>canvasHeight)
            radius = canvasHeight/2;
        else
            radius = canvasWidth/2;
        angle += 1;
        if (angle>=360)
            angle=0;
        float radians = (float)(angle* 180 /Math.PI),
        startX = canvasWidth/2,
        startY = canvasHeight/2,
                endX=(float)(startX+radius*Math.sin(radians)),
                endY=(float)(startY-radius*Math.cos(radians));
        paint.setColor(Color.rgb(68,15,168));
        canvas.drawLine(startX,startY,endX,endY,paint);
    }

    public void update(){
        invalidate();
    }

}
