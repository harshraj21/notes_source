package com.hax.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hax.notes.R;

import java.util.List;

public class NotesAdapter extends BaseAdapter {

    private List<Integer> images;
    private List<String> names;
    private Context applicationContext;
    private LayoutInflater inflater;

    public NotesAdapter(Context applicationContext, List<Integer> imageIds, List<String> names){
        this.applicationContext = applicationContext;
        this.images = imageIds;
        this.names = names;
        inflater = LayoutInflater.from(applicationContext);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.layoutgrid,null);

        ImageView img  = view.findViewById(R.id.imageView2);
        img.setImageResource(images.get(position));

        TextView name = view.findViewById(R.id.textView3);
        name.setText(names.get(position));

        return view;
    }
}