package id.renaldirey.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.renaldirey.mvp.R;
import id.renaldirey.mvp.model.Model;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    Context context;
    List<Model> data;

    public DataAdapter(Context context) {
        this.context = context;
        data = new ArrayList<>();
    }

    public void add(Model item) {
        data.add(item);
        notifyItemInserted(data.size() - 1);
    }

    public void addAll(List<Model> items) {
        for (Model item : items) {
            add(item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvId;
        TextView tvTitle;

        public ViewHolder(ViewGroup parent) {
            super(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_data, parent, false));
            initViews();
        }

        public void bind(Model item) {
            tvId.setText(String.valueOf(item.getId()));
            tvTitle.setText(item.getTitle());
        }

        public void initViews() {
            tvId = (TextView) itemView.findViewById(R.id.tv_id);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}