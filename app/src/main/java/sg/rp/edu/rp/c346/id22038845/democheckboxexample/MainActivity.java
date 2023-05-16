package sg.rp.edu.rp.c346.id22038845.democheckboxexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbEnabled;
    Button btnCheck;
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link var to id
        cbEnabled =findViewById(R.id.checkBoxDiscount);
        btnCheck =findViewById(R.id.buttonCheck);
        tvShow =findViewById(R.id.textView2);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyActivity", "Inside onClick()");
                Toast.makeText(MainActivity.this, "Button clicked...", Toast.LENGTH_LONG).show();
                if(cbEnabled.isChecked()==true){
                    double pay= calcPay(100,20);
                    tvShow.setText("The discount is given. You need to pay $" +String.format("%.2f",pay));
                }else{
                    double pay=calcPay(100,0);
                    tvShow.setText("The discount is not given. You need to pay $" + String.format("%.2f",pay));
                }
            }
        });

    }

    private double calcPay(double price, double discount){
        double pay=price*(1-discount/100);
        return pay;
    }
}