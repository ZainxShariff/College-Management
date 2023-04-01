package com.lbas.collegestudentapp.document;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lbas.collegestudentapp.R;

import java.util.ArrayList;
import java.util.List;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocumentViewHolder> {

    private Context context;
    private List<DocumentData> list;

    public DocumentAdapter(Context context, List<DocumentData> list) {
        this.context = context;
        this.list = list;
    }

    public void FilteredList(ArrayList<DocumentData> filterlist) {
        list = filterlist;
        notifyDataSetChanged();
    }

    public class DocumentViewHolder extends RecyclerView.ViewHolder {

        private TextView documentName;
        private ImageView documentDownload;

        public DocumentViewHolder(@NonNull View itemView) {
            super(itemView);
            documentName = itemView.findViewById(R.id.documentName);
            documentDownload = itemView.findViewById(R.id.documentDownload);

        }
    }

    @NonNull
    @Override
    public DocumentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.document_item_layout,parent,false);
        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentViewHolder holder,final int position) {

        holder.documentName.setText(list.get(position).getPdfTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, list.get(position).getPdfTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.documentDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getPdfUrl()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
