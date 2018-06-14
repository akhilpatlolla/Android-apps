package com.example.akhil.painting;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;

import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.UUID;

public class MainActivity extends Activity implements View.OnClickListener{

    private DrawingView drawingView;
    private ImageButton currentColor;
    private Button brushBtn,eraseBtn,newBtn,saveBtn;
    private float smallBrush,meduimBrush,largeBrush;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);
            }
        }
        //
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(),"NO permission yet ",Toast.LENGTH_LONG).show();
            }

        }

        drawingView = (DrawingView)findViewById(R.id.drawing);
        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.colors);
        currentColor = (ImageButton)paintLayout.getChildAt(0);
        currentColor.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.paint_selected,null));

        smallBrush = getResources().getInteger(R.integer.small_size);
        largeBrush = getResources().getInteger(R.integer.large_size);
        meduimBrush = getResources().getInteger(R.integer.medium_size);

        drawingView.setBrushSize(meduimBrush);
        drawingView.setPaintColor(currentColor.getTag().toString());

        brushBtn = (Button)findViewById(R.id.brushButon);
        brushBtn.setOnClickListener(this);
        eraseBtn = (Button)findViewById(R.id.eraserButton);
        eraseBtn.setOnClickListener(this);

        newBtn = (Button)findViewById(R.id.newButton);
        newBtn.setOnClickListener(this);

        saveBtn = (Button)findViewById(R.id.saveButton);
        saveBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.brushButon){
            //create the pop up dialogue with 3 buttons / choices
            final Dialog brushDialogue = new Dialog(this);
            brushDialogue.setTitle("Select a  Brush Size:");
            brushDialogue.setContentView(R.layout.brush_choice);

            //display dialogue
             brushDialogue.show();
            final Button smallBrushButton = (Button)brushDialogue.findViewById(R.id.smallBrushButton);
            smallBrushButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawingView.setBrushSize(smallBrush);
                    drawingView.setLastBrushSize(smallBrush);
                    drawingView.setErase(false);
                    brushDialogue.dismiss();
                }
            });

            final Button mediumBrushButton = (Button)brushDialogue.findViewById(R.id.mediumBrushButton);
            mediumBrushButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawingView.setBrushSize(meduimBrush);
                    drawingView.setLastBrushSize(meduimBrush);
                    drawingView.setErase(false);
                    brushDialogue.dismiss();
                }
            });

            final Button largeBrushButton = (Button)brushDialogue.findViewById(R.id.largeBrushButton);
            largeBrushButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawingView.setBrushSize(largeBrush);
                    drawingView.setLastBrushSize(largeBrush);
                    drawingView.setErase(false);
                    brushDialogue.dismiss();
                }
            });



        }
        else if (view.getId() == R.id.eraserButton){
            final Dialog eraseDialogue = new Dialog(this);
            eraseDialogue.setTitle("Select a  Erase Size:");
            eraseDialogue.setContentView(R.layout.eraser_choice);

            //display dialogue
            eraseDialogue.show();
            Button smallEraserButton = (Button)eraseDialogue.findViewById(R.id.smallEraserButton);
            smallEraserButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawingView.setBrushSize(smallBrush);
                    drawingView.setErase(true);
                    eraseDialogue.dismiss();
                }
            });
             Button mediumEraserButton = (Button)eraseDialogue.findViewById(R.id.mediumEraserButton);
            mediumEraserButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawingView.setBrushSize(meduimBrush);
                    drawingView.setErase(true);
                    eraseDialogue.dismiss();
                }
            });
             Button largeEraserButton = (Button)eraseDialogue.findViewById(R.id.largeEraserButton);
            largeEraserButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawingView.setBrushSize(largeBrush);
                    drawingView.setErase(true);
                    eraseDialogue.dismiss();
                }
            });


        } else if (view.getId() == R.id.newButton){

            AlertDialog.Builder newDialogue = new AlertDialog.Builder(this);
            newDialogue.setTitle("New Drawing ");
            newDialogue.setMessage("Start  a New Drawing :P and this will be gone maan :P ");
            newDialogue.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    drawingView.newDrawing();
                    dialog.dismiss();
                }
            });
            newDialogue.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            newDialogue.show();
        }else if (view.getId() == R.id.saveButton){

            AlertDialog.Builder saveDialogue = new AlertDialog.Builder(this);
            saveDialogue.setTitle("Save Drawing ");
            saveDialogue.setMessage("Save drawing to gallery ?");

            saveDialogue.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    drawingView.setDrawingCacheEnabled(true);
                    String savedImageURI = MediaStore.Images.Media.insertImage(MainActivity.this.getContentResolver(),
                            drawingView.getDrawingCache(), UUID.randomUUID().toString()+".png","drawing");
                    if (savedImageURI != null){
                        Toast.makeText(getApplicationContext(),"Drawing Saved to Gallery "+ savedImageURI,Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Drawing was not Saved ",Toast.LENGTH_LONG).show();

                    }
                }
            });
            saveDialogue.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            saveDialogue.show();
            drawingView.destroyDrawingCache();


        }
    }
    public void paintClicked(View view){
        drawingView.setErase(false);
        drawingView.setBrushSize(drawingView.getLastBrushSize());
        if (view != currentColor){
            ImageButton imageButton = (ImageButton) view;
            String color = view.getTag().toString();
            drawingView.setPaintColor(color);
            imageButton.setImageDrawable( ResourcesCompat.getDrawable(getResources(),R.drawable.paint_selected,null) );
            currentColor.setImageDrawable( ResourcesCompat.getDrawable(getResources(),R.drawable.print_color,null) );
            currentColor = imageButton;
        }
    }
}
