package com.abim.lks_restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    Context ctx;
    TextView tv_dPrice, tv_dQty, tv_dTotal, tv_dStatus, tv_dP_status, tv_dMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv_dPrice = findViewById(R.id.tv_dPrice);
        tv_dQty = findViewById(R.id.tv_dQty);
        tv_dTotal = findViewById(R.id.tv_dTotal);
        tv_dStatus = findViewById(R.id.tv_dStatus);
        tv_dP_status = findViewById(R.id.tv_dP_status);
        tv_dMenu = findViewById(R.id.tv_dMenu);

        Intent intent = getIntent();
        tv_dPrice.setText(intent.getStringExtra("price"));
        tv_dMenu.setText(intent.getStringExtra("menu"));
        tv_dTotal.setText(intent.getStringExtra("total"));
        tv_dStatus.setText(intent.getStringExtra("status"));
        tv_dP_status.setText(intent.getStringExtra("p_status"));
        tv_dQty.setText(intent.getStringExtra("qty"));
    }
}