package com.viaplay.pelinodaman.viaplaysections.ui.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.viaplay.pelinodaman.viaplaysections.R;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySection;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySectionDetail;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SectionDetailActivity extends AppCompatActivity implements SectionDetailMVPView{

    @BindView(R.id.textViewDescription)
    TextView textViewDescription;
    @BindView(R.id.textViewTitle)
    TextView textViewTitle;

    ViaplaySection item;

    SectionDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        item = getIntent().getExtras().getParcelable("ViaplaySection");
        setTitle(item.getTitle());

        presenter = new SectionDetailPresenter(this, this);
        presenter.fetchData(item);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setFields(ViaplaySectionDetail sectionDetail) {
        if(sectionDetail != null) {
            textViewTitle.setText(sectionDetail.getTitle());
            textViewDescription.setText(sectionDetail.getDescription());
        } else {
            Toast.makeText(this, R.string.no_internet_connection, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
