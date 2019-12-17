package com.example.wordplay.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordplay.R;

public class CharAdapters extends RecyclerView.Adapter<CharAdapters.CharactersHolder> {

    Context context;
    private Character[] characterList;
    EditText word;

    public CharAdapters(Context context, Character[] characterList,EditText word) {
        this.context = context;
        this.characterList = characterList;
        this.word = word;
    }


    @NonNull
    @Override
    public CharactersHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upper, parent,false);
        CharactersHolder charHolder = new CharactersHolder(view);
        return charHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CharactersHolder holder, final int position) {


        holder.txtChar.setText(String.valueOf(characterList[position]));

        holder.txtChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String setword = word.getText().toString() + characterList[position];
                word.setText(setword);
                holder.txtChar.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                holder.txtChar.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                holder.txtChar.setOnClickListener(null);
            }
        });
    }


    @Override
    public int getItemCount() {
        return characterList.length;
    }

    public class CharactersHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView txtChar;

        public CharactersHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.layout_linear);
            txtChar = itemView.findViewById(R.id.Txtview);
        }
    }
}
