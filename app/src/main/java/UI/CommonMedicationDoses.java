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
import java.util.List;

import Classes.Medication;

public class CommonMedicationDoses extends AppCompatActivity {
    EditText enterLbs;
    int lbs;
    String medicationName;
    Medication Benadryl= new Medication("Benadryl");
    Medication Pepcid= new Medication("Pepcid");
    Medication Zyrtec= new Medication("Zyrtec");
    Medication Prilosec=new Medication("Prilosec");
    Medication medicationChosen= new Medication();
    TextView dosageResult;
    double kgs;
    double dosageZyrtec;
    double lowEndPepcid;
    double highEndPepcid;
    double dosagePrilosec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_medication_doses);

        Spinner medicationSpinner=(Spinner) findViewById(R.id.medicationSpinner);
        ArrayAdapter<CharSequence> medicationAdapter=ArrayAdapter.createFromResource(this,R.array.medications, android.R.layout.simple_spinner_item);
        medicationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        medicationSpinner.setAdapter(medicationAdapter);
        medicationSpinner.setSelection(0);

        medicationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                medicationName=medicationSpinner.getSelectedItem().toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    //calculates the dosage for the chosen medication when the calculate button is pressed
    public void calculateDosage(View view) {
        enterLbs=findViewById(R.id.enterDogLbsMeds);
        lbs= Integer.parseInt(enterLbs.getText().toString());
        dosageResult=findViewById(R.id.dosageMedicationResult);
        kgs=lbs/2.2;

        //uses the getMedication method to find the medication the user has chosen
        medicationChosen=getMedication(medicationName);

        if(lbs<=0 || enterLbs.getText().toString().equals("")){
            dosageResult.setText("This is not a valid weight. Please enter a valid weight and try again.");
        }
        //calculates the dose for Benadryl if Benadryl is chosen
        else if (medicationChosen.equals(Benadryl)) {
                dosageResult.setText("Give approximately " + lbs + " mg every 8-12 hours as needed.");
        }

        //calculates the dose for Zyrtec if Zyrtec is chosen
        else if(medicationChosen.getMedicationName()=="Zyrtec") {
                dosageZyrtec = kgs * 2;
                int intDosage = (int) dosageZyrtec;
                dosageResult.setText("Give approximately " + intDosage + " mg up to twice a day as needed.");
        }

        //calculates the dose for Pepcid if Pepcid is chosen
        else if(medicationChosen.getMedicationName()=="Pepcid") {
                lowEndPepcid = kgs * 0.5;
                int intLowEndPepcid = (int) lowEndPepcid;
                highEndPepcid = kgs * 1;
                int intHighEndPepcid = (int) highEndPepcid;
                dosageResult.setText("Give between " + intLowEndPepcid + " and " + intHighEndPepcid + " up to twice daily.");
        }

        //calculates the dose for Prilosec if Prilosec is chosen
        else if(medicationChosen.getMedicationName()=="Prilosec"){
                dosagePrilosec=lbs*0.5;
                int intDosagePrilosec= (int) dosagePrilosec;
                dosageResult.setText("Give approximately " + intDosagePrilosec + " mg once daily");
        }



    }

    //method to find which medication the user wants to calculate the dosage for given the input from the spinner
    public Medication getMedication(String medicationName2){
        Medication medicationChosen=new Medication();
        if(medicationName2.equals(Benadryl.getMedicationName())){
            medicationChosen=Benadryl;
        }
        else if(medicationName2.equals(Zyrtec.getMedicationName())){
            medicationChosen=Zyrtec;
        }
        else if(medicationName2.equals(Pepcid.getMedicationName())){
            medicationChosen=Pepcid;
        }
        else if(medicationName2.equals(Prilosec.getMedicationName())){
            medicationChosen=Prilosec;
        }
        return medicationChosen;
    }
}