package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveButton = (Button) findViewById(R.id.save);

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText name = (EditText)(findViewById(R.id.userInput_Name));
                EditText email = (EditText)(findViewById(R.id.userInput_Email));
                EditText password = (EditText)(findViewById(R.id.userInput_Password));
                EditText passwordConfirm = (EditText)(findViewById(R.id.userInput_PasswordConfirm));
                if(isEmpty(name) || isEmpty(email) || isEmpty(password) || isEmpty(passwordConfirm)) {
                    Toast.makeText(FormActivity.this, "Fill in all fields", Toast.LENGTH_LONG).show();
                }else if (password.getText().toString().equals(passwordConfirm.getText().toString())){
                    String greetingName = name.getText().toString();
                    Toast.makeText(FormActivity.this, "Welcome, " + greetingName + " to the SingUpForm", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(FormActivity.this, "Password does not match, check again", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    private boolean isEmpty(EditText edText) {
        return edText.getText().toString().trim().length() == 0;
    }
}
