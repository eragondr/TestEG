package com.example.pc.testeg.main;

import android.graphics.Typeface;
import android.text.Spannable;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pc.testeg.CustomsText.CustomsText;
import com.example.pc.testeg.R;

import java.util.ArrayList;
import java.util.Random;

import static android.R.color.holo_red_dark;

public class Main {
    public TextView Boss;
    public EditText UserInput;
    public TextView UsersOutPut;
    private ArrayList<Vocabulary> table = new ArrayList<Vocabulary>();
    private ArrayList<String> hasInput = new ArrayList<String>();
    private String OutPut = "";
    private String InPut = "";

    public Main() {
    }

    public Main(ArrayList<Vocabulary> table) {
        this.table = table;
    }

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

    public String FirstRandom() {
        int index = new Random().nextInt(getTable().size() - 1);
        String item =
            getTable().get(index).GetItem(new Random().nextInt(getTable().get(index).GetSize()));
        if (getTable().get(index).Remove(item)) {
            getHasInput().add(item);
            setOutPut(item);
        }
        return item;
    }

    public void Random() {
        Spannable Item;
        Spannable CustomsLastCharOfOutPut;
        char LastCharOfInput = getInPut().charAt(getInPut().length() - 1);
        int index = words.indexOf(LastCharOfInput);
        int IndexOfFirstCharOfInput = words.indexOf(getInPut().charAt(0));
        getHasInput().add(getInPut());
        getTable().get(IndexOfFirstCharOfInput).Remove(getInPut());
        String item =
            getTable().get(index).GetItem(new Random().nextInt(getTable().get(index).GetSize()));
        if (getTable().get(index).Remove(item)) {
            getHasInput().add(item);
            setOutPut(item);
        }
        Item = CustomsText.CustomsText(Boss.getContext(), item, 0, item.length() - 1, 2f,
            R.color.colorPrimaryDark, Typeface.ITALIC);
        CustomsLastCharOfOutPut = CustomsText
            .CustomsText(Boss.getContext(), item, item.length() - 1, item.length(), 2f,
                holo_red_dark, Typeface.BOLD_ITALIC);
        Boss.setText(Item);
        char LastCharOfOutPut = getOutPut().charAt(getOutPut().length() - 1);
        int LastCharOfOutPutIndex = words.indexOf(LastCharOfOutPut);
        int size = getTable().get(LastCharOfOutPutIndex).GetSize();
        if (size == 0) {
            Boss.setText("The words starting with" + CustomsLastCharOfOutPut +
                " You can find the words starting with any other letters");
            Input2(getInPut());
        }
    }

    public void Random2() {
        Spannable Item;
        Spannable CustomsLastCharOfOutPut;
        Spannable CustomsLasLastCharOfInPut;
        int index = GetRandomArrayWord();
        // char LastCharOfInPut = getInPut().charAt(getInPut().length() - 1);
        String item =
            getTable().get(index).GetItem(new Random().nextInt(getTable().get(index).GetSize()));
        CustomsLastCharOfOutPut = CustomsText
            .CustomsText(Boss.getContext(), item, item.length() - 1, item.length(), 2f,
                holo_red_dark, Typeface.BOLD_ITALIC);
        CustomsLasLastCharOfInPut = CustomsText
            .CustomsText(Boss.getContext(), getInPut(), getInPut().length() - 1,
                getInPut().length(), 2f, holo_red_dark, Typeface.BOLD_ITALIC);
        Item = CustomsText.CustomsText(Boss.getContext(), item, 0, item.length() - 1, 2f,
            R.color.colorPrimaryDark, Typeface.ITALIC);
        if (getTable().get(index).Remove(item)) {
            getHasInput().add(item);
            setOutPut(item);
        }
        Boss.setText("The words starting with: " + CustomsLasLastCharOfInPut +
            " \n .Have been used up. I will find the words starting with any other letters. " +
            "\n That will be: " + Item);
        char LastCharOfOutPut = getOutPut().charAt(getOutPut().length() - 1);
        int LastCharOfOutPutIndex = words.indexOf(LastCharOfOutPut);
        int size = getTable().get(LastCharOfOutPutIndex).GetSize();
        if (size == 0) {
            Boss.setText("The words starting with: " + CustomsLastCharOfOutPut +
                " \n.Have been used up. You can find the words starting with any other letters");
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
        String inputText = input;
        if (getHasInput().contains(input)) {
            return inputText = "You have used this word before, let try a new one";
        }
        if (!Contains(input)) {
            return inputText = "Opps, I don't recognize this word,let check it again or try a new" +
                " ơne";
        }
        char FirstCharOfInPut = input.charAt(0);
        //   int wordsIndex = words.indexOf(FirstCharOfInPut);
        char LastCharOfOutPut = getOutPut().charAt(getOutPut().length() - 1);
        if (FirstCharOfInPut != LastCharOfOutPut) {
            return inputText="Please find the new word starts with: " + LastCharOfOutPut;
        }
        char LastCharOfInPut = input.charAt(input.length() - 1);
        int LastCharOfInPutIndex = words.indexOf(LastCharOfInPut);
        if (getTable().get(LastCharOfInPutIndex).GetSize() == 0) {
            char FirstCharOfinput = input.charAt(0);
            int IndexOfFirstCharOfinput = words.indexOf(FirstCharOfinput);
            getTable().get(IndexOfFirstCharOfinput).Remove(input);
            getHasInput().add(input);
            Random2();
            return inputText;
        } else {
            setInPut(input);
            Random();
            return inputText;
        }
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

   /* public void Input() {
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
    }*/
}







