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


public class BrandsFragment extends Fragment {

    View mView;
    private RecyclerView mRecyclerView;
    private List<Cellphone> mBrandsList;

    public BrandsFragment() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CellPhoneOpenHelper helper = new CellPhoneOpenHelper(getActivity());

        mBrandsList = new ArrayList<>();
        /*mBrandsList.add(new Cellphone("Samsung"));
        mBrandsList.add(new Cellphone("Oneplus"));
        mBrandsList.add(new Cellphone("Xiaomi"));
        mBrandsList.add(new Cellphone("Motorola"));
        mBrandsList.add(new Cellphone("Apple"));*/
        for (Cellphone item : helper.retrieveBrands()) {
            mBrandsList.add(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_brands, container, false);

        mRecyclerView = mView.findViewById(R.id.brands_recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), mBrandsList, "Marcas");
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);

        return mView;
    }
}