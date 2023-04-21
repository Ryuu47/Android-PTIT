package com.example.quanlichitieu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlichitieu.R;
import com.example.quanlichitieu.UpdateDeleteActivity;
import com.example.quanlichitieu.adapter.RecycleViewAdapter;
import com.example.quanlichitieu.dal.SQLiteHelper;
import com.example.quanlichitieu.model.Item;

import java.util.List;
// da check: OK
public class FragmentHistory extends Fragment implements RecycleViewAdapter.ItemListener {
    private RecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private SQLiteHelper db;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView= view.findViewById(R.id.recycleView);
        adapter= new RecycleViewAdapter();
        db= new SQLiteHelper(getContext());
//        db.addItem(new Item("quan ao", "Mua sam","125","04/07/2023"));
//        db.addItem(new Item("nuoc", "Tien nuoc","500","22/11/2022"));
        List<Item> list= db.getAll();
        adapter.setList(list);
        LinearLayoutManager manager= new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);

    }

    @Override
    public void onItemClick(View view, int position) {
        Item item= adapter.getItem(position);
        Intent intent= new Intent(getActivity(), UpdateDeleteActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        List<Item> list= db.getAll();
        adapter.setList(list);
    }
}
