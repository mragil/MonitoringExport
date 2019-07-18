package com.example.monitoringexport.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monitoringexport.Model.Proforma;
import com.example.monitoringexport.R;

import java.util.List;

public class AdapterProforma extends RecyclerView.Adapter<AdapterProforma.ViewHolder> {

    private List<Proforma> mProformaList ;

    public AdapterProforma(List <Proforma> ProformaList) {
        mProformaList = ProformaList;
    }

    @NonNull
    @Override
    public AdapterProforma.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.proforma_list,viewGroup,false);
        return new AdapterProforma.ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProforma.ViewHolder viewHolder, int i) {
        String tanggal;
        viewHolder.mTextViewIdData.setText("ID Data : "+ mProformaList.get(i).getIdData());
        viewHolder.mTextViewNamaProduk.setText("Nama Produk : "+ mProformaList.get(i).getNamaProduk());
        viewHolder.mTextViewTgl_PEB.setText("Tanggal PEB : "+ mProformaList.get(i).getTanggalPeb());
        viewHolder.mTextViewPembuat.setText("Pembuat : "+ mProformaList.get(i).getPembuat());
    }

    @Override
    public int getItemCount() {
        return mProformaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdData, mTextViewNamaProduk, mTextViewTgl_PEB, mTextViewPembuat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewIdData = itemView.findViewById(R.id.tvId_data);
            mTextViewNamaProduk = itemView.findViewById(R.id.tvNama_produk);
            mTextViewTgl_PEB = itemView.findViewById(R.id.tvTgl_PEB);
            mTextViewPembuat = itemView.findViewById(R.id.tvPembuat);
        }

    }


}

