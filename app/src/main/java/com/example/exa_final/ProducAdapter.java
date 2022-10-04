package com.example.exa_final;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.example.exa_final.databinding.AdapaterventanaBinding;

import java.util.Objects;


public class ProducAdapter extends ListAdapter<Product,ProducAdapter.EqViewHolder> {



    public static final DiffUtil.ItemCallback<Product> DIF_CALLBACK = new DiffUtil.ItemCallback<Product>() {
        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return Objects.equals(oldItem.getId(), newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.equals(newItem);
        }
    };

    protected ProducAdapter() {
        super(DIF_CALLBACK);
    }

    private OnItemClickListener onItemClickListener;

    interface OnItemClickListener{
        void onItemClick(Product producto);

    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ProducAdapter.EqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapaterventanaBinding binding= AdapaterventanaBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new EqViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProducAdapter.EqViewHolder holder, int position) {
        Product producto = getItem(position);
        holder.bind(producto);
    }

    public class EqViewHolder extends RecyclerView.ViewHolder {
        private AdapaterventanaBinding binding;
        public EqViewHolder(@NonNull AdapaterventanaBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void bind(Product product) {
            binding.setProduct(product);
            binding.getRoot().setOnClickListener(v -> {
                onItemClickListener.onItemClick(product);
            });

            binding.executePendingBindings();
        }
    }
}
