package UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vetnurse.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToH202Page(View view) {
        Intent intent= new Intent(MainActivity.this, H202Page.class);
        startActivity(intent);
    }

    public void goToCommonDosesPage(View view) {
        Intent intent=new Intent(MainActivity.this,CommonMedicationDoses.class);
        startActivity(intent);
    }

    public void gotoChocolateToxicity(View view) {
        Intent intent=new Intent(MainActivity.this, ChocolateToxicity.class);
        startActivity(intent);
    }
}