package com.example.pc.testeg.main;

/**
 * Created by PC on 5/5/2017.
 */import java.util.ArrayList;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Vocabulary {

    ArrayList<String> Vocabulary = new ArrayList<String>();

    public  ArrayList<String> Distict(ArrayList<String> listInts) {
        ArrayList<String> listDistinctInts = new ArrayList<String>(listInts.size());
        for( String i : listInts)
        {
            if( !listDistinctInts.contains(i) ) { listDistinctInts.add(i); }
        }
        return listDistinctInts;
    }



    public void RemoveDuplicate() {

        Vocabulary = Distict(Vocabulary);

    }




    public void Input(String word)
    {
        Vocabulary.add(word);
    }


    public String GetItem(int index)
    {
        return Vocabulary.get(index).toString();
    }
    public int GetSize()
    {
        return Vocabulary.size();

    }
    public boolean IsContain(String s)
    {
        return Vocabulary.contains(s);
    }

    public boolean Remove(String s)
    {

        if ( Vocabulary.contains(s) )
        {
            Vocabulary.remove(s);
            return true;

        }else
        {
            return false;
        }



    }

}

