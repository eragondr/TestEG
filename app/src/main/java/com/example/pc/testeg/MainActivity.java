package com.example.pc.testeg;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pc.testeg.CustomsText.CustomsText;
import com.example.pc.testeg.main.Main;
import com.example.pc.testeg.main.Vocabulary;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button ok;
    TextView txtBoss;
    TextView txtUserOutPut;
    EditText txtUserInput;
    Main mMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControls();
        AddEvents();
    }

    private void AddEvents() {
        ArrayList<Vocabulary> vocabularyList = new ArrayList<>();
        Vocabulary A = new Vocabulary();
        A.Input("aa");
        A.Input("ab");
        A.Input("ac");
        A.Input("ad");
        A.Input("ae");
        Vocabulary B = new Vocabulary();
        B.Input("ba");
        B.Input("bb");
        B.Input("bc");
        B.Input("bd");
        B.Input("be");
        Vocabulary C = new Vocabulary();
        C.Input("ca");
        C.Input("cb");
        C.Input("cc");
        C.Input("cd");
        C.Input("ce");
        Vocabulary D = new Vocabulary();
        D.Input("da");
        D.Input("db");
        D.Input("dc");
        D.Input("dd");
        D.Input("de");
        vocabularyList.add(A);
        vocabularyList.add(B);
        vocabularyList.add(C);
        vocabularyList.add(D);
        mMain = new Main(vocabularyList);
        Spannable item = CustomsText
            .CustomsText(getBaseContext(), mMain.FirstRandom(), 0, mMain.FirstRandom().length(), 2f,
                R.color.colorPrimaryDark,
                Typeface.BOLD_ITALIC);
        txtBoss.setText(item);
    }

    private void AddControls() {
        ok = (Button) findViewById(R.id.btnOK);
        ok.setOnClickListener(this);
        txtUserInput = (EditText) findViewById(R.id.txtUsersInput);
        txtUserOutPut = (TextView) findViewById(R.id.txtUsers);
        txtBoss = (TextView) findViewById(R.id.txtBoss);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOK:
                String input = txtUserInput.getText().toString();
                txtUserOutPut.setText(mMain.getInPut());
                String text = mMain.CheckInput(input);
                if (!input.equals(text)) {
                    txtUserOutPut.setText(text);
                }
                break;
        }
    }
}

