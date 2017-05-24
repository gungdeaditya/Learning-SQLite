package com.example.gungdeaditya.samplesqliteapps.view;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gungdeaditya.samplesqliteapps.R;
import com.example.gungdeaditya.samplesqliteapps.helper.UserDbHelper;

public class NewContactActivity extends AppCompatActivity {

    EditText ContactName, ContactMobile, ContactEmail;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ContactName = (EditText) findViewById(R.id.name_contact);
        ContactMobile = (EditText) findViewById(R.id.number_contact);
        ContactEmail = (EditText) findViewById(R.id.email_contact);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addContact(View view){
        String name = ContactName.getText().toString();
        String mob = ContactMobile.getText().toString();
        String email = ContactEmail.getText().toString();
        if(name.equals("") || mob.equals("")|| email.equals("")){
            Toast.makeText(NewContactActivity.this, "Please fill the blank before saving", Toast.LENGTH_SHORT).show();
            return;
        }
            userDbHelper = new UserDbHelper(context);
            sqLiteDatabase = userDbHelper.getWritableDatabase();
            userDbHelper.addInformation(name, mob, email, sqLiteDatabase);
            Clean();
            Toast.makeText(NewContactActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();

        userDbHelper.close();
    }

    public void Clean(){
        ContactName.setText(null);
        ContactMobile.setText(null);
        ContactEmail.setText(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
