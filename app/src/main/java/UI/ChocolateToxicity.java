package UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.vetnurse.R;

import java.util.ArrayList;

import Classes.Chocolate;

public class ChocolateToxicity extends AppCompatActivity {
    EditText enterLbs;
    EditText enterOz;
    int lbs;
    int oz;
   // double methylxanthines;
    double theobromineDose;
    double caffeineDose;
    double totalMethylxanthinesDose;
    double ounces;
    String chocolateName;
    TextView result;



    Chocolate milkChoc=new Chocolate("Milk Chocolate", 54,6);
    Chocolate darkChoc=new Chocolate("Dark Chocolate", 190,12);
    Chocolate bakingChoc=new Chocolate("Baking Chocolate", 450,23);
    Chocolate semiSweetChoc=new Chocolate("Semi Sweet Chocolate",150,10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocolate_toxicity);

        Spinner chocolateSpinner=(Spinner) findViewById(R.id.chocolateSpinner);
        ArrayAdapter<CharSequence> chocolateAdapter=ArrayAdapter.createFromResource(this,R.array.chocolate,android.R.layout.simple_spinner_item);
        chocolateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        chocolateSpinner.setAdapter(chocolateAdapter);
        chocolateSpinner.setSelection(0);

        chocolateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                chocolateName=chocolateSpinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public Chocolate getChocolateType(String chocolateName1){
        Chocolate chosenChocolate=new Chocolate();

        if(chocolateName1.equals(darkChoc.getName())){
            chosenChocolate=darkChoc;
        }
        else if(chocolateName1.equals(milkChoc.getName())){
            chosenChocolate=milkChoc;
        }
        else if(chocolateName1.equals(semiSweetChoc.getName())){
            chosenChocolate=semiSweetChoc;
        }
        else if(chocolateName1.equals(bakingChoc.getName())){
            chosenChocolate=bakingChoc;
        }
        return chosenChocolate;
    }



    public void calculateChoc(View view) {
        enterLbs=findViewById(R.id.enterDogLbsChoc);
        lbs=Integer.parseInt(enterLbs.getText().toString());
        result=findViewById(R.id.chocResult);
        enterOz=findViewById(R.id.enterOunces);
        oz=Integer.parseInt(enterOz.getText().toString());
        double kg=lbs/2.2;

        Chocolate chocolate=getChocolateType(chocolateName);

        theobromineDose=(chocolate.getTheobromidePerOz()*oz);
        caffeineDose=(chocolate.getCaffeinePerOz()*oz);
        totalMethylxanthinesDose=(theobromineDose+caffeineDose)/kg;

        if(totalMethylxanthinesDose < 20){
            result.setText("This is not a toxic amount of chocolate for this dog. Some effects such as GI upset may be noted.");
        }
        else if(totalMethylxanthinesDose > 19 && totalMethylxanthinesDose <= 40){
            result.setText("This amount of chocolate is not toxic for this dog. GI upset such as vomiting and diarrhea should be expected.");
        }
        else if(totalMethylxanthinesDose > 39 && totalMethylxanthinesDose <=60){
            result.setText("This amount of chocolate is considered cardiotoxic. This dog should present to an emergency vet for treatment immediately.");
        }
        else if(totalMethylxanthinesDose >59 && totalMethylxanthinesDose <= 100){
            result.setText("This amount of chocolate is considered toxic for this dog. Seizures may occur. The dog should present to an emergency vet for treatment immediately.");
        }
        else if(totalMethylxanthinesDose >100){
            result.setText("This amount of chocolate can be lethal. This dog should present to an emergency vet immediately.");
        }
        else{
            result.setText("This is not an accurate input. Please try again.");
        }

    }


}