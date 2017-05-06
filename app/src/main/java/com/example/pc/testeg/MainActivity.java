package com.example.pc.testeg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.testeg.main.Main;
import com.example.pc.testeg.main.Vocabulary;

public class MainActivity extends AppCompatActivity {
    Button ok;
    TextView txtBoss;
    TextView txtUserOutPut;
    EditText txtUserInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControls();
        AddEvents();

    }

    private void AddEvents() {
        Main main = new Main();
        Vocabulary A = new Vocabulary();
        A.Input("aa");
        A.Input("ab");
        A.Input("ac");
        A.Input("ad");
        A.Input("ae");
        main.getTable().add(A);
        Vocabulary B = new Vocabulary();
        B.Input("ba");
        B.Input("bb");
        B.Input("bc");
        B.Input("bd");
        B.Input("be");
        main.getTable().add(B);
        Vocabulary C = new Vocabulary();
        C.Input("ca");
        C.Input("cb");
        C.Input("cc");
        C.Input("cd");
        C.Input("ce");

        main.getTable().add(C);
        Vocabulary D = new Vocabulary();
        D.Input("da");
        D.Input("db");
        D.Input("dc");
        D.Input("dd");
        D.Input("de");
        main.getTable().add(D);

        main.Boss = txtBoss;
        main.UserInput= txtUserInput;
        main.UsersOutPut= txtUserOutPut;
        main.OK = ok;
        main.Input();
}


    private void AddControls() {


        ok = (Button) findViewById(R.id.btnOK);
        txtUserInput = (EditText) findViewById(R.id.txtUsersInput);

        txtUserOutPut = (TextView) findViewById(R.id.txtUsers);
        txtBoss = (TextView) findViewById(R.id.txtBoss);

    }
}

