package com.acryink.android_example;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.acryink.android_example.databinding.CustomListBinding;

import java.util.List;

public class CustomRecyclerView extends RecyclerView {
    Adapter adapter;

    class Holder extends RecyclerView.ViewHolder {
        CustomListBinding binding;

        public Holder(View itemView) {
            super(itemView);
            binding = CustomListBinding.bind(itemView);
        }
    }

    class Manager extends LinearLayoutManager {

        public Manager(Context context) {
            super(context, VERTICAL, false);
        }
    }

    class Adapter extends RecyclerView.Adapter<Holder> {

        ObservableField<List<String>> items = new ObservableField<>();

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list, parent, false));
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            String value = items.get() != null ? items.get().get(position) : "";
            holder.binding.textView.setText(value);
        }

        @Override
        public int getItemCount() {
            return items.get() != null ? items.get().size() : 0;
        }
    }

    public CustomRecyclerView(Context context) {
        this(context, null);
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Manager manager = new Manager(context);
        adapter = new Adapter();
        setLayoutManager(manager);
        addItemDecoration(new DividerItemDecoration(context, manager.getOrientation()));
        setAdapter(adapter);
    }

    public void setItems(List<String> values) {
        adapter.items.set(values);
        adapter.notifyDataSetChanged();
    }
}
