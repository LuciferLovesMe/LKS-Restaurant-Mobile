package com.abim.lks_restaurant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewActivity extends AppCompatActivity {
    Context ctx;
    Session s;
    RequestQueue queue;
    RecyclerView rv;
    List<Order> orders;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        ctx = this;
        queue = Volley.newRequestQueue(ctx);
        rv = findViewById(R.id.rv);
        s = new Session(ctx);
        orders = new ArrayList<>();
        orders.clear();

        getData();
    }

    void getData(){
        StringRequest request = new StringRequest(Request.Method.POST, MyRequest.getViewURL(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++){
                        JSONObject obj = array.getJSONObject(i);
                        orders.add(new Order(obj.getInt("qty"), obj.getInt("Price"),obj.getInt("Total"), obj.getString("Menu"), obj.getString("status"), obj.getString("paymentStatus"), obj.getInt("tableNumber")));
                    }

                    adapter = new Adapter(orders, ctx);
                    rv.setLayoutManager(new LinearLayoutManager(ctx));
                    rv.setAdapter(adapter);
                }
                catch (Exception ex){
                    Toast.makeText(ctx, ""+ex, Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                AlertDialog dialog = new AlertDialog.Builder(ctx).create();
                dialog.setTitle("Error volley");
                dialog.setMessage(""+error);
                dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("memberId", String.valueOf(s.getId()));

                return  params;
            }
        };

        queue.add(request);
    }
}