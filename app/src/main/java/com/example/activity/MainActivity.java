package com.example.activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import org.jspecify.annotations.NonNull;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TextView out,name,mob,add,out1,out2,out3;
    Button btn;
    ImageButton ib;
    CheckBox ch1,ch2,ch3,ch4;
    RadioGroup rg;
    RadioButton rb;
    EditText e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),
                this::onApplyWindowInsets);
    }
    private WindowInsetsCompat onApplyWindowInsets(@NonNull View v,
                                                   @NonNull WindowInsetsCompat insets) {
        Insets systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right,
                systemBars.bottom);
        ib = findViewById(R.id.im);
        name = findViewById(R.id.name);
        mob = findViewById(R.id.mn);
        add = findViewById(R.id.add);

        btn = findViewById(R.id.btn);
        ch1 = findViewById(R.id.read);
        ch2 = findViewById(R.id.dance);
        ch3 = findViewById(R.id.sing);
        ch4 = findViewById(R.id.travel);
        out1 = findViewById(R.id.out1);
        out2 = findViewById(R.id.out2);
        out3 = findViewById(R.id.out3);
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.mn);
        e3=findViewById(R.id.add);
        rg = findViewById(R.id.rg);

        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd;
                dpd = new DatePickerDialog(MainActivity.this, new
                        DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int
                                    day) {

                                out3.setText("You Born on "+day + "/" + (month+1) + "/" + year);
                            }
                        }, year, month, day);
                dpd.show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                out1.setText("your Name is " + " "+ e1.getText().toString() +" " +"Your Mobile no. & Address is : " +" "+ e2.getText().toString() + " & " +
                e3.getText().toString());
                int selectedgender = rg.getCheckedRadioButtonId();
                if (selectedgender != -1){
                    rb = findViewById(selectedgender);
                    String deviceoutput = rb.getText().toString();
                    out2.setText("Your Gender is: "+" "+ deviceoutput);
                }
                String hobbies = " ";

                if (ch1.isChecked())
                    hobbies = hobbies + " " + ch1.getText().toString();
                if (ch2.isChecked())
                    hobbies = hobbies + " " + ch2.getText().toString();

                if (ch3.isChecked())
                    hobbies = hobbies + " " + ch3.getText().toString();
                if (ch4.isChecked())
                    hobbies = hobbies + " " + ch4.getText().toString();
                out3.setText(out3.getText().toString()+" " +" You like to: " + hobbies);
            }
        });
        return insets;
    }
}