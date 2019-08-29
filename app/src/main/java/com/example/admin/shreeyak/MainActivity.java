package com.example.admin.shreeyak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText fnm,lnm,phn;
    private Button btns;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference=FirebaseDatabase.getInstance().getReference("User");

        fnm=(EditText)findViewById(R.id.fnm);
        lnm=(EditText)findViewById(R.id.lnm);
        phn=(EditText)findViewById(R.id.phn);

        btns=(Button)findViewById(R.id.btns);

        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
    }

    public void addUser()
    {
        String userfnm=fnm.getText().toString();
        String userlnm=lnm.getText().toString();
        String Userphn=phn.getText().toString();
        if(!TextUtils.isEmpty(userfnm) && !TextUtils.isEmpty(userlnm) && !TextUtils.isEmpty(Userphn))
        {
            String id=databaseReference.push().getKey();
            User U=new User(id,userfnm,userlnm,Userphn);
            databaseReference.child(id).setValue(U);
            fnm.setText("");
            lnm.setText("");
            phn.setText("");
        }
        else
        {
            Toast.makeText(MainActivity.this,"fields can't be empty",Toast.LENGTH_SHORT).show();
        }

    }
}
