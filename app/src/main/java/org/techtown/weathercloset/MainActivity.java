package org.techtown.weathercloset;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

import lib.kingja.switchbutton.SwitchMultiButton;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NoteAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        NoteAdapter adapter = new NoteAdapter();

        adapter.addItem(new Note("오늘 너무 행복해!", "@drawable/ootd1", "5월 7일", "1"));
        adapter.addItem(new Note("오늘 너무 신나!", "@drawable/ootd2", "5월 8일", "19"));
        adapter.addItem(new Note("집에 갈래!", null, "5월 9일", "34"));

        recyclerView.setAdapter(adapter);

    }
}


