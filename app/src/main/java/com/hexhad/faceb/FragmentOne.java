package com.hexhad.faceb;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {
    DatabaseHelper myDb;

    Button add, viewall, update, delete;
    EditText name, age, id;

    public static FragmentOne fragmentOne() {
        FragmentOne fragmentOne = new FragmentOne();
        return fragmentOne;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragmenone, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        myDb = new DatabaseHelper(getContext());

        age = view.findViewById(R.id.age);
        id = view.findViewById(R.id.id);
        name = view.findViewById(R.id.name);

        add = view.findViewById(R.id.add);
        delete = view.findViewById(R.id.delete);
        viewall = view.findViewById(R.id.viewAll);
        update = view.findViewById(R.id.update);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(name.getText().toString(), age.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(getContext(), "Data Inserted ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Data Insert ERROR ", Toast.LENGTH_LONG).show();
                }

            }
        });

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    //no data
                    showMessage("ERROR", "Nothing Found");
                    return;
                } else {
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("id:" + res.getString(0) + "\n");
                        buffer.append("name:" + res.getString(1) + "\n");
                        buffer.append("age:" + res.getString(2) + "\n\n");
                    }
                    //show all
                    showMessage("Data", buffer.toString());

                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean updated = myDb.updateData(id.getText().toString(), name.getText().toString(), age.getText().toString());
                if (updated == true) {
                    Toast.makeText(getContext(), "Data Updated ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Data Update ERROR ", Toast.LENGTH_LONG).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer delete = myDb.deleteData(id.getText().toString());
                if (delete > 0) {
                    Toast.makeText(getContext(), "Data Deleted ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Data Delete ERROR ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}