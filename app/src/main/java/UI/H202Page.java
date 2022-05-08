package UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vetnurse.R;

public class H202Page extends AppCompatActivity {
    EditText enterDogLbs;
    int dogLbs;
    TextView dosageText;
    String dosageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h202_page);
    }

    public void calculateH202(View view) {
        enterDogLbs=findViewById(R.id.enterDogLbs);
        dogLbs= Integer.parseInt(enterDogLbs.getText().toString());
        dosageText =findViewById(R.id.dosageResult);
        dosageResult=dosageText.getText().toString();


        if(dogLbs <0){
            dosageText.setText("This is not an accurate weight, please try again");

        }

        else if(dogLbs >0 && dogLbs<= 5){
            dosageText.setText("Give 1 teaspoon of 3% hydrogen peroxide. Dosage can be repeated in 15 minutes if the dog does not vomit");
        }

        else if(dogLbs >=6 && dogLbs <=10){
            dosageText.setText("Give 2 teaspoons of 3% hydrogen peroxide. Dosage can be repeated in 15 minutes if the dog does not vomit");
        }

        else if(dogLbs >=11 && dogLbs <=15){
            dosageText.setText("Give 1 tablespoon of 3% hydrogen peroxide. Dosage can be repeated in 15 minutes if the dog does not vomit");
        }

        else if (dogLbs >=16 && dogLbs <=20){
            dosageText.setText("Give 1 tablespoon and 1 teaspoon of 3% hydrogen peroxide. Dosage can be repeated in 15 minutes if the dog does not vomit");
        }

        else if(dogLbs >=21 && dogLbs <=25){
            dosageText.setText("Give 1 & 1/2 tablespoons of 3% hydrogen peroxide. Dosage can be repeated in 15 minutes if the dog does not vomit.");
        }

        else if (dogLbs >=26 && dogLbs <=30){
            dosageText.setText("Give 2 tablespoons of 3% hydrogen peroxide. Dosage can be repeated in 15 minutes if the dog does not vomit");
        }

        else if(dogLbs >=31 && dogLbs <=40){
            dosageText.setText("Give 2 & 1/2 tablespoons of 3% hydrogen peroxide. Dosage can be repeated in 15 minutes if the dog does not vomit;");
        }

        else if(dogLbs >41){
            dosageText.setText("Give 3 tablespoons of 3% hydrogen peroxide. Dosage can be repeated in 15 minutes if the dog does not vomit");
        }

    }
}