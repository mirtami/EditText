package com.mirta.edittext;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button button_editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        button_editText = (Button) findViewById(R.id.button_editText);

        email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_NEXT){
                    Context context = getApplicationContext();
                }
                return false;
            }
        });
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    Context context = getApplicationContext();
                    Toast.makeText(context,email.getText(),Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
        button_editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmailValid()&& isPasswordValid()){
                    Toast.makeText(getApplicationContext(),email.getText(),Toast.LENGTH_SHORT).show();
            }else{
                    showMessage(R.string.login_error);
                }
        }
    });
    }



    private boolean isEmailValid(){
        return !TextUtils.isEmpty(email.getText());
    }
    private boolean isPasswordValid(){
        return !TextUtils.isEmpty(password.getText());
    }
    private void showMessage(@StringRes int string){
        Toast.makeText(this,string,Toast.LENGTH_SHORT).show();

    }
}







