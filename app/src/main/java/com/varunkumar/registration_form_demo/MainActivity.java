package com.varunkumar.registration_form_demo;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


     EditText name,phn_no;

    RadioGroup gender;
    CheckBox eng,hin,nativ;
    Button submit;
    Spinner courses;
    String [] course={"java","c","c++","c#","python",".net","android","xml", "rales on rube"};
     String course_selected="";
    String gender_selected="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editText3);
        phn_no = (EditText) findViewById(R.id.editText5);
        gender = (RadioGroup) findViewById(R.id.radioGroup2);
        eng = (CheckBox) findViewById(R.id.checkBox4);
        hin = (CheckBox) findViewById(R.id.checkBox5);
        nativ = (CheckBox) findViewById(R.id.checkBox6);
        courses = (Spinner) findViewById(R.id.spinner2);
        submit = (Button) findViewById(R.id.button2);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= "Name"+name.getText().toString()+
                        "Phone"+phn_no.getText().toString()+
                        "Gendre"+gender_selected+
                        "English"+eng.isChecked()+
                        "Hindi"+hin.isChecked()+
                        "Native"+nativ.isChecked()+
                        "Course Offered"+course_selected;
                Toast.makeText(getApplicationContext(),user,Toast.LENGTH_LONG).show();

            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, course);
        courses.setAdapter(adapter);
        courses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                course_selected = course[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(i==R.id.male){
                    gender_selected="Male";
                }else {
                    gender_selected="Female";
                }
            }
        });
    }
}
