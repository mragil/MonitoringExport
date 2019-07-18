package com.example.monitoringexport.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monitoringexport.Model.User;
import com.example.monitoringexport.R;

import java.util.List;


public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.ViewHolder> {
    private List<User> mUserList;

    public AdapterUsers(List <User> UserList) {
        mUserList = UserList;
    }

    @NonNull
    @Override
    public AdapterUsers.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_list,viewGroup,false);
        return new ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mTextViewid.setText("Id User : " + mUserList.get(i).getId_user());
        viewHolder.mTextViewNama.setText("Nama : "+mUserList.get(i).getNama());
        viewHolder.mTextViewEmail.setText("Nomor : "+mUserList.get(i).getEmail());
        viewHolder.mTextViewPw.setText("Password : "+mUserList.get(i).getPassword());
        viewHolder.mTextViewlevel.setText("Level : Super Admin");
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewNama, mTextViewEmail, mTextViewPw, mTextViewlevel, mTextViewid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewNama = itemView.findViewById(R.id.tvNama);
            mTextViewEmail = itemView.findViewById(R.id.tvEmail);
            mTextViewPw = itemView.findViewById(R.id.tvPw);
            mTextViewlevel = itemView.findViewById(R.id.tvTgl_PEB);
            mTextViewid = itemView.findViewById(R.id.tvId);
        }

    }
}



