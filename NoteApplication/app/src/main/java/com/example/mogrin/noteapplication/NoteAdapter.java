package com.example.mogrin.noteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import java.util.ArrayList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NoteAdapter extends BaseAdapter{
    Context ctx;
    ArrayList<NoteItem> objects;
    LayoutInflater lInflater;
    NoteItem parent;

    NoteAdapter(Context ctx, ArrayList<NoteItem> objects, NoteItem parent) {
        this.ctx = ctx;
        this.objects = objects;
        this.parent = parent;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        NoteItem noteIt = (NoteItem) getItem(position);
        ((TextView) view.findViewById(R.id.tvText)).setText(noteIt.name);

        return view;
    }

}
