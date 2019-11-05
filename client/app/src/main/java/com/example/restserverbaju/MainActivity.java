package com.example.restserverbaju;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.restserverbaju.Adapter.BajuAdapter;
import com.example.restserverbaju.Model.Baju;
import com.example.restserverbaju.Model.GetBaju;
import com.example.restserverbaju.Rest.ApiClient;
import com.example.restserverbaju.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btIns = (Button) findViewById(R.id.btIns);
        btIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }

    public void refresh() {
        Call<GetBaju> BajuCall = mApiInterface.getBaju();
        BajuCall.enqueue(new Callback<GetBaju>() {
            @Override
            public void onResponse(Call<GetBaju> call, Response<GetBaju>
                    response) {
                List<Baju> BajuList = response.body().getListDataBaju();
                Log.d("Retrofit Get", "Jumlah data Baju: " +
                        String.valueOf(BajuList.size()));
                mAdapter = new BajuAdapter(BajuList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetBaju> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
