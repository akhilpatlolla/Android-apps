package edu.niu.cs.akhil.scenetransitions;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity {

    ViewGroup painting;
    Transition transition;

    Scene activeScene,passiveScene1, passiveScene2, passiveScene3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        painting = (ViewGroup)findViewById(R.id.paintingContainer);

        transition = TransitionInflater.from(this).inflateTransition(R.transition.transition);

        activeScene = Scene.getSceneForLayout(painting,R.layout.scene1,this);
        passiveScene1 = Scene.getSceneForLayout(painting,R.layout.scene2,this);
        passiveScene2 = Scene.getSceneForLayout(painting,R.layout.scene3,this);
        passiveScene3 = Scene.getSceneForLayout(painting,R.layout.scene4,this);

        activeScene.enter();
    }

    public void changeScenes(View view){
        Scene temp = activeScene;
        activeScene = passiveScene1;
        passiveScene1 = passiveScene2;
        passiveScene2 = passiveScene3;
        passiveScene3 = temp;
        TransitionManager.go(activeScene,transition);
    }

}
