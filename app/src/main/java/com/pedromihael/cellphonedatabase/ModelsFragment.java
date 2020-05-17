package com.pedromihael.cellphonedatabase;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ModelsFragment extends Fragment {

    View mView;
    private RecyclerView mRecyclerView;
    private List<Model> mModelsList;

    public ModelsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mModelsList = new ArrayList<>();
        mModelsList.add(new Model("Galaxy S10", "Samsung"));
        mModelsList.add(new Model("7T", "Oneplus"));
        mModelsList.add(new Model("Mi 9", "Xiaomi"));
        mModelsList.add(new Model("Z3", "Motorola"));
        mModelsList.add(new Model("iPhone Xr", "Apple"));
        mModelsList.add(new Model("Galaxy S10", "Samsung"));
        mModelsList.add(new Model("7T", "Oneplus"));
        mModelsList.add(new Model("Mi 9", "Xiaomi"));
        mModelsList.add(new Model("Z3", "Motorola"));
        mModelsList.add(new Model("iPhone Xr", "Apple"));
        mModelsList.add(new Model("Galaxy S10", "Samsung"));
        mModelsList.add(new Model("7T", "Oneplus"));
        mModelsList.add(new Model("Mi 9", "Xiaomi"));
        mModelsList.add(new Model("Z3", "Motorola"));
        mModelsList.add(new Model("iPhone Xr", "Apple"));
        mModelsList.add(new Model("Galaxy S10", "Samsung"));
        mModelsList.add(new Model("7T", "Oneplus"));
        mModelsList.add(new Model("Mi 9", "Xiaomi"));
        mModelsList.add(new Model("Z3", "Motorola"));
        mModelsList.add(new Model("iPhone Xr", "Apple"));
        mModelsList.add(new Model("Galaxy S10", "Samsung"));
        mModelsList.add(new Model("7T", "Oneplus"));
        mModelsList.add(new Model("Mi 9", "Xiaomi"));
        mModelsList.add(new Model("Z3", "Motorola"));
        mModelsList.add(new Model("iPhone Xr", "Apple"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_models, container, false);

        mRecyclerView = mView.findViewById(R.id.models_recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), mModelsList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);

        return mView;
    }
}
