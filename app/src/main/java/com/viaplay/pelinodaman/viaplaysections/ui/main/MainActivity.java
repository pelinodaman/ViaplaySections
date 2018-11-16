package com.viaplay.pelinodaman.viaplaysections.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.viaplay.pelinodaman.viaplaysections.R;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySection;
import com.viaplay.pelinodaman.viaplaysections.ui.detail.SectionDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.LinearLayout.VERTICAL;

public class MainActivity extends AppCompatActivity implements MainMVPView {

    @BindView(R.id.recyclerViewSections)
    RecyclerView recyclerViewSections;
    private MainPresenter presenter;
    private MainSectionsAdapter adapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerViewSections.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerViewSections.setLayoutManager(mLayoutManager);

        DividerItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), VERTICAL);
        recyclerViewSections.addItemDecoration(decoration);

        presenter = new MainPresenter(this, this);
        presenter.fetchData();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void setSectionsList(List<ViaplaySection> viaplaySections) {
        if(viaplaySections != null) {
            adapter = new MainSectionsAdapter(viaplaySections, item -> {
                openDetails(item);
            });
            recyclerViewSections.setAdapter(adapter);
        } else {
            Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_LONG).show();
        }

    }

    private void openDetails(ViaplaySection item) {
        Intent intent = new Intent(this, SectionDetailActivity.class);
        intent.putExtra("ViaplaySection", item);
        startActivity(intent);
    }

}
