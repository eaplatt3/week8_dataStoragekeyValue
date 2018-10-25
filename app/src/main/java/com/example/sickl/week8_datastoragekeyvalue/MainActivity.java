package com.example.sickl.week8_datastoragekeyvalue;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtv) TextView mTv;
    @BindView(R.id.btn) Button mBth;
    @BindView(R.id.edt1) EditText mEt;


    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBth.setOnClickListener(this::pressMe);

        preferences = getSharedPreferences(getString(R.string.sharedpreffilename), Context.MODE_PRIVATE);
        editor =preferences.edit();

        counter = preferences.getInt("COUNTER", 1);

    }


    void pressMe(View v){

        editor.putString("KEY_" + counter++, mEt.getText().toString());
        editor.putInt("COUNTER", counter);
        editor.commit();

        for(int i = 1; i <= counter; i++)
        mTv.setText(  mTv.getText() + "\n" + preferences.getString("KEY_"+ counter, "No Course"));

    }

}
