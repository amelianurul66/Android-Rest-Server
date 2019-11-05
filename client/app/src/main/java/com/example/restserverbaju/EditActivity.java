package com.example.restserverbaju;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restserverbaju.Model.PostPutDeleteBaju;
import com.example.restserverbaju.Rest.ApiClient;
import com.example.restserverbaju.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {

    EditText edtId, edtMerk, edtUkuran;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtId = (EditText) findViewById(R.id.edtId);
        edtMerk = (EditText) findViewById(R.id.edtMerk);
        edtUkuran = (EditText) findViewById(R.id.edtUkuran);
        Intent mIntent = getIntent();
        edtId.setText(mIntent.getStringExtra("Id"));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtMerk.setText(mIntent.getStringExtra("Merk"));
        edtUkuran.setText(mIntent.getStringExtra("Ukuran"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDeleteBaju> updateBajuCall = mApiInterface.putBaju(
                        edtId.getText().toString(),
                        edtMerk.getText().toString(),
                        edtUkuran.getText().toString());
                updateBajuCall.enqueue(new Callback<PostPutDeleteBaju>() {
                    @Override
                    public void onResponse(Call<PostPutDeleteBaju> call, Response<PostPutDeleteBaju> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDeleteBaju> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btDelete = (Button) findViewById(R.id.btDelete2);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDeleteBaju> deleteBaju = mApiInterface.deleteBaju(edtId.getText().toString());
                    deleteBaju.enqueue(new Callback<PostPutDeleteBaju>() {
                        @Override
                        public void onResponse(Call<PostPutDeleteBaju> call, Response<PostPutDeleteBaju> response) {
                            MainActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDeleteBaju> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ma.refresh();
                finish();
            }
        });
    }
}
