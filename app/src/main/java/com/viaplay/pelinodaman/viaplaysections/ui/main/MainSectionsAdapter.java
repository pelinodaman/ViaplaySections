package com.viaplay.pelinodaman.viaplaysections.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.viaplay.pelinodaman.viaplaysections.R;
import com.viaplay.pelinodaman.viaplaysections.data.model.ViaplaySection;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainSectionsAdapter extends RecyclerView.Adapter<MainSectionsAdapter.ViewHolder> {

    private List<ViaplaySection> sections;
    private final OnItemClickListener listener;

    public MainSectionsAdapter(List<ViaplaySection> sections, OnItemClickListener listener) {
        this.sections = sections;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_item, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(sections.get(i), listener);
    }

    @Override
    public int getItemCount() {
        return sections.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View rootView;
        @BindView(R.id.textViewTitle)
        TextView textViewTitle;

        public ViewHolder(LinearLayout v) {
            super(v);
            ButterKnife.bind(this, v);
            rootView = v;
        }

        public void bind(ViaplaySection viaplaySection, OnItemClickListener listener) {
            textViewTitle.setText(viaplaySection.getTitle() + " (" + viaplaySection.getType() + ")");
            rootView.setOnClickListener(v -> listener.onItemClick(viaplaySection));

        }
    }

    public interface OnItemClickListener {
        void onItemClick(ViaplaySection item);
    }
}
