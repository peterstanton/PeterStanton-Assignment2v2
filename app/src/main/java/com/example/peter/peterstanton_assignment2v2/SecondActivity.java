package com.example.peter.peterstanton_assignment2v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public final static String KEY = "blah";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent i = getIntent();
        String fromFirst = i.getStringExtra(FirstActivity.KEY);
        TextView displayInput = (TextView)findViewById (R.id.secondTextField);
        displayInput.setText(fromFirst);
    }

    public void cancel (View view)
    {
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }

    public void sendHome (View view)
    {
        int i = 1;
        EditText mText;
        mText = (EditText)findViewById (R.id.secondTextField);
        String input = mText.getText().toString();
        Intent intent = new Intent(this, FirstActivity.class);
        intent.putExtra(KEY,input);
        setResult(1011, intent);
        finish();
    }

}
