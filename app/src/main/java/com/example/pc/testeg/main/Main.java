package com.example.pc.testeg.main;

import android.graphics.Typeface;
import android.text.Spannable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pc.testeg.CustomsText.CustomsText;
import com.example.pc.testeg.R;

import java.util.ArrayList;
import java.util.Random;

import static android.R.color.holo_red_dark;


public class Main {
    CustomsText customsText = new CustomsText();

    public   TextView Boss;
    public  EditText UserInput;
    public TextView UsersOutPut;
    public Button OK;

    public Main() {
    }

    public Main(String inPut, ArrayList<Vocabulary> table, ArrayList<String> hasInput, String outPut) {

        InPut = inPut;
        this.table = table;
        this.hasInput = hasInput;
        OutPut = outPut;
    }

    private ArrayList<Vocabulary> table = new ArrayList<Vocabulary>();

    private ArrayList<String> hasInput = new ArrayList<String>();

    private String OutPut = "";

    private String InPut = "";

    public ArrayList<Vocabulary> getTable() {
        return table;
    }

    public void setTable(ArrayList<Vocabulary> table) {
        this.table = table;
    }

    public ArrayList<String> getHasInput() {
        return hasInput;
    }

    public void setHasInput(ArrayList<String> hasInput) {
        this.hasInput = hasInput;
    }

    public String getOutPut() {
        return OutPut;
    }

    public void setOutPut(String outPut) {
        OutPut = outPut;
    }

    public String getInPut() {
        return InPut;
    }

    public void setInPut(String inPut) {
        InPut = inPut;
    }



    String words = "abcdefghijklmnopqrstuvwxyz";

    public void FirstRandom() {
        Spannable Item;

        int index = new Random().nextInt(getTable().size() - 1);
        String item = getTable().get(index).GetItem(new Random().nextInt(getTable().get(index).GetSize()));
        if (getTable().get(index).Remove(item)) {
            getHasInput().add(item);
            setOutPut(item);
        }
        Item = customsText.CustomsText(Boss.getContext(), item, 0, item.length(), 2f, R.color.colorPrimaryDark, Typeface.BOLD_ITALIC);
        Boss.setText("Let me start first:" + Item);

    }

    public void Random() {
        Spannable Item;
        Spannable CustomsLastCharOfOutPut;


        char LastCharOfInput = getInPut().charAt(getInPut().length() - 1);

        int index = words.indexOf(LastCharOfInput);

        int IndexOfFirstCharOfInput = words.indexOf(getInPut().charAt(0));

        getHasInput().add(getInPut());
        getTable().get(IndexOfFirstCharOfInput).Remove(getInPut());

        String item = getTable().get(index).GetItem(new Random().nextInt(getTable().get(index).GetSize()));
        if (getTable().get(index).Remove(item)) {
            getHasInput().add(item);
            setOutPut(item);
        }
        Item = customsText.CustomsText(Boss.getContext(), item, 0, item.length()-1, 2f, R.color.colorPrimaryDark, Typeface.ITALIC);
        CustomsLastCharOfOutPut = customsText.CustomsText(Boss.getContext(), item, item.length()-1, item.length(), 2f, holo_red_dark, Typeface.BOLD_ITALIC);
        Boss.setText(Item);
        char LastCharOfOutPut = getOutPut().charAt(getOutPut().length() - 1);
        int LastCharOfOutPutIndex = words.indexOf(LastCharOfOutPut);
        int size = getTable().get(LastCharOfOutPutIndex).GetSize();

        if (size == 0) {


            Boss.setText("The words starting with" + CustomsLastCharOfOutPut + " You can find the words starting with any other letters");
            Input2(getInPut());
        }
    }

    public void Random2() {
        Spannable Item;
        Spannable CustomsLastCharOfOutPut;
        Spannable CustomsLasLastCharOfInPut;
        int index = GetRandomArrayWord();
        // char LastCharOfInPut = getInPut().charAt(getInPut().length() - 1);
        String item = getTable().get(index).GetItem(new Random().nextInt(getTable().get(index).GetSize()));
        CustomsLastCharOfOutPut = customsText.CustomsText(Boss.getContext(), item, item.length()-1, item.length(), 2f,holo_red_dark, Typeface.BOLD_ITALIC);
        CustomsLasLastCharOfInPut =customsText.CustomsText(Boss.getContext(),getInPut(), getInPut().length()-1,getInPut().length(), 2f,holo_red_dark, Typeface.BOLD_ITALIC);
        Item = customsText.CustomsText(Boss.getContext(), item, 0, item.length()-1, 2f, R.color.colorPrimaryDark, Typeface.ITALIC);

        if (getTable().get(index).Remove(item)) {
            getHasInput().add(item);
            setOutPut(item);
        }
        Boss.setText("The words starting with: " +CustomsLasLastCharOfInPut + " \n .Have been used up. I will find the words starting with any other letters. " + "\n That will be: " + Item);
        char LastCharOfOutPut = getOutPut().charAt(getOutPut().length() - 1);
        int LastCharOfOutPutIndex = words.indexOf(LastCharOfOutPut);
        int size = getTable().get(LastCharOfOutPutIndex).GetSize();
        if (size == 0) {

            Boss.setText("The words starting with: " + CustomsLastCharOfOutPut  + " \n.Have been used up. You can find the words starting with any other letters");
            Input2(getInPut());
        }
    }

    public int GetRandomArrayWord() {

        int i = 0;
        for (Vocabulary item : getTable()) {

            if (item.GetSize() > 0) {
                return i;
            }
            i++;
        }
        return i;
    }

    public String CheckInput(String input) {

        if (getHasInput().contains(input)) {
            Boss.setText("You have used this word before, let try a new one");
            return input;

        }

        if (!Contains(input)) {
            Boss.setText("Opps, I don't recognize this word,let check it again or try a new ơne");
            return input;
        }

        char FirstCharOfInPut = input.charAt(0);
        //   int wordsIndex = words.indexOf(FirstCharOfInPut);

        char LastCharOfOutPut = getOutPut().charAt(getOutPut().length() - 1);

        if (FirstCharOfInPut != LastCharOfOutPut) {
            System.out.println("Please find the new word starts with: " + LastCharOfOutPut);

            return input;
        }

        char LastCharOfInPut = input.charAt(input.length() - 1);
        int LastCharOfInPutIndex = words.indexOf(LastCharOfInPut);

        if (getTable().get(LastCharOfInPutIndex).GetSize() == 0) {
            char FirstCharOfinput = input.charAt(0);
            int IndexOfFirstCharOfinput = words.indexOf(FirstCharOfinput);
            getTable().get(IndexOfFirstCharOfinput).Remove(input);
            getHasInput().add(input);
            Random2();
            return input;
        } else {

            setInPut(input);
            UsersOutPut.setText(input);
            Random();

        }


        return input;


    }

    public Boolean Contains(String input) {
        for (Vocabulary arr : getTable()) {
            if (arr.IsContain(input)) {
                return true;
            }
        }
        return false;
    }

    public String Input2(String Input) {

        Input = UserInput.getText().toString();

        if (!Contains(Input)) {
            System.out.println("Từ bạn nhập không có trong dữ liệu.1");
            return Input;

        }
        if (getHasInput().contains(Input)) {
            System.out.println("Tu ban nhap da duoc su dung");
            return Input;

        }
        setInPut(Input);
        UsersOutPut.setText(Input);

        Random();

        return Input;

    }

    public void Input() {

        FirstRandom();
        String Input;

        while (true) {
            Input = UserInput.getText().toString();

            final String finalInput = Input;
            OK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckInput(finalInput);
                }
            });


        }

    }

}







