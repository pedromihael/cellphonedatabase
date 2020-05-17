package com.pedromihael.cellphonedatabase;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class MainActivity extends AppCompatActivity implements NewCellphoneDialog.DialogListener {

    private TabLayout mTabLayout;
    private AppBarLayout mAppBarLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tabs);
        mAppBarLayout = findViewById(R.id.app_bar);
        mViewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new ModelsFragment(), "Modelos");
        viewPagerAdapter.addFragment(new BrandsFragment(), "Marcas");

        mViewPager.setAdapter(viewPagerAdapter); // sets up the adapter to the view pager
        mTabLayout.setupWithViewPager(mViewPager); // sets up the view pager (with adapter) to the corresponding tab

        FloatingActionButton fab = findViewById(R.id.fab);

        /* BOTAO FLUTUANTE */
        fab.setOnClickListener((v) -> openNewCellphoneDialog());
    }

    private void openNewCellphoneDialog() {
        NewCellphoneDialog dialog = new NewCellphoneDialog();
        dialog.show(getSupportFragmentManager(), "New Cellphone");
    }

    @Override
    public void persistNewCellphoneData(String model, String brand) {
        // TODO
    }
}