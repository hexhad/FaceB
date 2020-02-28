package com.hexhad.faceb;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentTwo extends Fragment {

    DatabaseHelper myDB;

    public static  FragmentTwo fragmenttwo(){
        FragmentTwo fragmenttwo = new FragmentTwo();
        return fragmenttwo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragmenttwo,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myDB = new DatabaseHelper(getContext());
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTextView);
        ListView listView = (ListView) view.findViewById(R.id.listV);


        ArrayList<String> arrayList1 = new ArrayList<>();
        Cursor data = myDB.getListContent();
        //ArrayAdapter<String> arrayList = new ArrayAdapter<> (getContext(),android.R.layout.simple_list_item_1,arrayList1);
        //ListAdapter listAdapter = new ArrayAdapter<> (getContext(),android.R.layout.simple_list_item_1,);

        while(data.moveToNext()){
            arrayList1.add(data.getString(1));
        }
        ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrayList1);
        autoCompleteTextView.setAdapter(adapter);
        //arrayList1.add(data.getString(1));

        while(data.moveToNext()){
            arrayList1.add(data.getString(1));
        }
        ListAdapter listAdapter = new ArrayAdapter<> (getContext(),android.R.layout.simple_list_item_1,arrayList1);
        listView.setAdapter(listAdapter);


        }
    }


