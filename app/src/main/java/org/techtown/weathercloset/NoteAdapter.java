package org.techtown.weathercloset;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>

    {ArrayList<Note> items = new ArrayList<Note>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {      //각 아이템 레이아웃을 이용해 뷰 객체 생성
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.note_item, viewGroup, false);

        //return new ViewHolder(itemView, this);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {    //뷰 객체는 기존 것 그대로 사용하고 데이터만 바꿔줌
        Note item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() { return items.size(); }   //어댑터에서 관리하는 아이템의 개수 반환

    public void addItem(Note item) { items.add(item); }      //Note 객체를 넣거나 가져갈 수 있도록 하는 메소드

    public void setItems(ArrayList<Note> items) { this.items = items; }

    public Note getItem(int position) { return items.get(position); }

    public void setItem(int position, Note item) { items.set(position, item); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout1;
        ImageView pictureExistsImageView;
        TextView contentsTextView;
        TextView dateTextView;
        TextView temperTextView;


        public ViewHolder(View itemView){
            super(itemView);

            layout1 = itemView.findViewById(R.id.layout1);
            pictureExistsImageView = itemView.findViewById(R.id.pictureExistsImageView);
            contentsTextView = itemView.findViewById(R.id.contentsTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            temperTextView = itemView.findViewById(R.id.temperTextView);

            Bitmap bitmap = BitmapFactory.decodeResource(itemView.getResources(), R.drawable.ootd2);
            pictureExistsImageView.setImageBitmap(bitmap);
            }


        public void setItem(Note item) {
            contentsTextView.setText(item.getContents());
            dateTextView.setText(item.getCreateDateStr());
            temperTextView.setText(item.getTemperature());

            String picturePath = item.getPicture();
            Log.d("NoteAdapter", "picturePath -> " + picturePath);
            if (picturePath != null && !picturePath.equals("")) {
                pictureExistsImageView.setVisibility(View.VISIBLE);
            } else {
            pictureExistsImageView.setVisibility(View.GONE);
            }
            //pictureExistsImageView.setVisibility(View.VISIBLE);
        }
    }
}