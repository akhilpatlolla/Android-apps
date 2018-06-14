package edu.niu.cs.akhil.cartoon;

import android.app.Activity;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	private LinearLayout gallery;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gallery = (LinearLayout)findViewById(R.id.characterLayout);
		fillGallery();
	}
	private void fillGallery(){
		ImageButton characterItem;
		for (int cnt =0;cnt < CharacterInformation.description.length;cnt++){
			characterItem = new ImageButton(this);
			Character character = new Character(CharacterInformation.description[cnt],CharacterInformation.id[cnt]);
			characterItem.setContentDescription(character.getCharacterDescription());
			characterItem.setImageDrawable(ResourcesCompat.getDrawable(getResources(),character.getCharacterId(),null));
			characterItem.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String description = (String)v.getContentDescription();
					Toast.makeText(v.getContext(),description,Toast.LENGTH_LONG).show();
				}
			});
			gallery.addView(characterItem);
		}
	}
}

