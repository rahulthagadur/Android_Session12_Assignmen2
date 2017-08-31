package com.example.thagadur.android_session12_assignmen2;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText,ageEditText,phNumEditText,cityEditText;
    String fullName,city,phNum,age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initializze with respective ID
        nameEditText=(EditText)findViewById(R.id.name);
        ageEditText=(EditText)findViewById(R.id.age);
        phNumEditText=(EditText)findViewById(R.id.phNum);
        cityEditText=(EditText)findViewById(R.id.city);

       }
    //save the data to sharedPrefrences
    public void save(View view) {
        //get the string from edit text view
        fullName=nameEditText.getText().toString();
        city=cityEditText.getText().toString();
        phNum=phNumEditText.getText().toString();
        age=ageEditText.getText().toString();

        SharedPreferences sharedPreferences=MainActivity.this.getSharedPreferences(getResources().getString(R.string.PREF_FILE),MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(getResources().getString(R.string.NAME),fullName);
        editor.putString(getResources().getString(R.string.AGE),age);
        editor.putString(getResources().getString(R.string.CITY),city);
        editor.putString(getResources().getString(R.string.PH_NUM),phNum);
        Toast.makeText(this, "Pushed", Toast.LENGTH_SHORT).show();
        editor.commit();

    }
    //displaying the saved data in share Prefrences to Toast
    public void display(View view) {

        String texInfo= "";
        SharedPreferences sharedPreferences= MainActivity.this.getSharedPreferences(getResources().getString(R.string.PREF_FILE),MODE_PRIVATE);
        texInfo=texInfo+"saved data is \n"+sharedPreferences.getString(getResources().getString(R.string.NAME),"no value");
        texInfo=texInfo+"\n"+sharedPreferences.getString(getResources().getString(R.string.CITY),"");
        texInfo=texInfo+"\n"+sharedPreferences.getString(getResources().getString(R.string.AGE),"");
        texInfo=texInfo+"\n"+sharedPreferences.getString(getResources().getString(R.string.PH_NUM),"");
        Toast.makeText(this,texInfo, Toast.LENGTH_SHORT).show();
    }
}
