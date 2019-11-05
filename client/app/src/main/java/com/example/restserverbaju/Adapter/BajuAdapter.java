package com.example.restserverbaju.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.restserverbaju.EditActivity;
import com.example.restserverbaju.Model.Baju;
import com.example.restserverbaju.R;

import java.util.List;

public class BajuAdapter extends RecyclerView.Adapter<BajuAdapter.MyViewHolder> {
    List<Baju> mBajuList;
    public BajuAdapter(List<Baju> BajuList) {
        mBajuList = BajuList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.baju_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, final int position){
        holder.mTextViewId.setText("Id = " + mBajuList.get(position).getId());
        holder.mTextViewNama.setText("Merk = " + mBajuList.get(position).getMerk());
        holder.mTextViewNomor.setText("Ukuran333 = " + mBajuList.get(position).getUkuran());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id", mBajuList.get(position).getId());
                mIntent.putExtra("Nama", mBajuList.get(position).getMerk());
                mIntent.putExtra("Nomor", mBajuList.get(position).getUkuran());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mBajuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama, mTextViewNomor;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvMerk);
            mTextViewNomor = (TextView) itemView.findViewById(R.id.tvUkuran);
        }
    }
}
