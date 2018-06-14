/*
 * Z-Id : Z1803493
 * Name : Patlolla, Akhil Reddy
 * Quadratic Equation Application
 * Implementation of the calculation of the quadratic equations
 * In a quadratic equation there is no way that A can be zero as that does not satisfy the
 * case of quadratic equation and if B or C is zero that's a valid case.
 * Also handle all the cases where delta is negative, positive and zero
 * where positive is unique and real values
 * negative is imaginary numbers
 * zero is equal and real roots
 *
**/
package edu.niu.cs.akhil.quadraticcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	double sol1,sol2,c1,c2,c3;
	EditText eta,etb,etc;
	TextView solution,fr,sr;
	Button solve;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Taking reference to the content on screen
		eta = (EditText)findViewById(R.id.coefficientA);
		etb = (EditText)findViewById(R.id.coefficientB);
		etc = (EditText)findViewById(R.id.coefficientC);
		//Button Reference
		solve = (Button)findViewById(R.id.solve);
		//Text view Reference
		solution = (TextView)findViewById(R.id.solution);
		fr = (TextView)findViewById(R.id.x1);
		sr = (TextView)findViewById(R.id.x2);

		//implementing on click listener
		solve.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				//This is a case for verifying for empty values of A
				if( eta.getText().toString().matches("") ){
					//Display message
					solution.setText("Co Efficient Value of A can't be empty ");
					//Toast message to the conditon
					Toast.makeText(v.getContext(),"Co Efficient Value of A can't be empty ", Toast.LENGTH_LONG).show();
					fr.setText("");
					sr.setText("");
					return;
				}
				//setting B default value of zero
				if( etb.getText().toString().matches("") ){
					etb.setText("0");
				}
				//setting C default value of zero
				if( etc.getText().toString().matches("") ){
					etc.setText("0");
				}
				//converting the text to double for perofrming mathematical operations
				c1 = Double.parseDouble(eta.getText().toString());
				c2 = Double.parseDouble(etb.getText().toString());
				c3 = Double.parseDouble(etc.getText().toString());
				//if there is a condition where coefficient of x^2 can't be zero as that dosent satisfy
				//quadratic equation condition
				if ( c1 == 0){

					solution.setText("Co Efficient Value of A can't be 0, Then it's not a Quadratic Equation");
					fr.setText("");
					sr.setText("");
					//Toast message to the conditon
					Toast.makeText(v.getContext(),"Co Efficient Value of A can't be 0, Then it's not a Quadratic Equation", Toast.LENGTH_LONG).show();
					return;
				}
				//A variable to hold the value of discriminant and can be used for any purpose
				double discriminant = c2 * c2 - 4 * c1 * c3;
				//conidition where the discriminant value is negative and roots are immaginary
				if(discriminant < 0 ){
					solution.setText("Disctiminant Value is Negative. So, both roots are immaginary");
					//Toast message to the conditon
					Toast.makeText(v.getContext(),"Disctiminant Value is Negative. So, both roots are immaginary", Toast.LENGTH_LONG).show();
					return;
				}
				//discriminant to evaluate the roots and to push results on to screen using set text method
				else {
					//caluclation of the solutions
					sol1 = ((- c2 + Math.sqrt(discriminant))/2*c1);
					sol2 = ((- c2 - Math.sqrt(discriminant))/2*c1);
					//converting the double values to string and set text will push solution on screen
					fr.setText(String.format( "Value of a: %.3f", sol1 ));sr.setText(String.format( "Value of b: %.3f", sol2 ));
				}
				//this show a text message of the content regarding the real roots and state of the roots
				if (discriminant == 0 )
					//if discriminant value is zero and the roots are equal condition
					solution.setText("Disctiminant Value is Zero. So, both roots are Equal");
				else
					//if discriminant value is positive and the roots are unique condition
					solution.setText("Disctiminant Value is Positive. So, both roots are Unique");
			}
		});//end of on click listener class
	}//end of on-create activity
}//end of main actvity
