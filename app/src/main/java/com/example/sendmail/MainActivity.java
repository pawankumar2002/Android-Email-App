package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText emailid,subject,content;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMail(View view){
        emailid=findViewById(R.id.emailid);
        subject=findViewById(R.id.subject);
        content=findViewById(R.id.content);
        String s1=emailid.getText().toString();
        String s2=subject.getText().toString();
        String s3=content.getText().toString();

        String [] addresses={s1};
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, s2);
        intent.putExtra(Intent.EXTRA_TEXT, s3);
        if (intent.resolveActivity(getPackageManager()) != null) {
            Toast.makeText(this, "email sent successfully", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Failed to send", Toast.LENGTH_SHORT).show();
        }
    }
}