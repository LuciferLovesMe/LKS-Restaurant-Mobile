package com.abim.lks_restaurant;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Order> orders;
    Context ctx;

    public Adapter(List<Order> orders, Context ctx) {
        this.orders = orders;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_row, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.tv_menu.setText(String.valueOf(order.getMenu()));
        holder.tv_price.setText(String.valueOf(order.getPrice()));
        holder.tv_qty.setText(String.valueOf(order.getQty()));
        holder.tv_total.setText(String.valueOf(order.getTotal()));
        holder.tv_status.setText(String.valueOf(order.getStatus()));
        holder.tv_pStatus.setText(String.valueOf(order.getPaymentStatus()));
        holder.tv_tableNum.setText(String.valueOf(order.getTableNum()));
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv_menu, tv_price, tv_qty, tv_total, tv_status, tv_pStatus, tv_tableNum;
        private ConstraintLayout c_layout;
        public ViewHolder( View v) {
            super(v);

            tv_menu = v.findViewById(R.id.tv_menu);
            tv_price = v.findViewById(R.id.tv_price);
            tv_qty = v.findViewById(R.id.tv_qty);
            tv_total = v.findViewById(R.id.tv_total);
            tv_status = v.findViewById(R.id.tv_status);
            tv_pStatus = v.findViewById(R.id.tv_payment);
            tv_tableNum = v.findViewById(R.id.tv_table);
            c_layout = v.findViewById(R.id.c_layout);

            c_layout.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {
            Order order = orders.get(getAdapterPosition());
            Intent intent = new Intent(ctx, DetailActivity.class);
            intent.putExtra("menu", order.getMenu());
            intent.putExtra("price", String.valueOf(order.getPrice()));
            intent.putExtra("qty", String.valueOf(order.getQty()));
            intent.putExtra("total", String.valueOf(order.getTotal()));
            intent.putExtra("status", order.getStatus());
            intent.putExtra("p_status", order.getPaymentStatus());
            intent.putExtra("num", order.getMenu());
            ctx.startActivity(intent);
        }
    }
}
