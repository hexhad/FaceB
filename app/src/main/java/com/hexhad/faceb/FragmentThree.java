package com.hexhad.faceb;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentThree extends Fragment {

    DatabaseHelper myDB;

    public static  FragmentThree fragmentthree(){
        FragmentThree fragmentthree = new FragmentThree();
        return fragmentthree;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragmentthree,container,false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView listView = (ListView) view.findViewById(R.id.list);
        myDB = new DatabaseHelper(getContext());

        ArrayList<String> arrayList = new ArrayList<>();
        Cursor data = myDB.getListContent();

        if (data.getCount() == 0){
            Toast.makeText(getContext(), "Empty List", Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                arrayList.add(data.getString(0)+"\n"+data.getString(1)+"\n"+data.getString(2)+"\n"+data.getString(3));
                ListAdapter listAdapter = new ArrayAdapter<> (getContext(),android.R.layout.simple_list_item_1,arrayList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
