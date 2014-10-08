package com.example.mogrin.noteapplication;

import java.util.ArrayList;
import android.app.DialogFragment;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

    private static final int CM_DELETE_ID = 1;

    Context contxt;
    DialogFragment crtDlg;
    ListView lvNote;
    NoteAdapter noteAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        contxt = this;
        crtDlg = new CreateItemDialog();

        noteAdapter = new NoteAdapter(this, new ArrayList<NoteItem>(), null);
        lvNote = (ListView) findViewById(R.id.lvSimple);
        lvNote.setAdapter(noteAdapter);

        lvNote.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NoteItem tmpItem = (NoteItem)parent.getItemAtPosition(position);
                NoteAdapter tmpAdapter = new NoteAdapter(contxt, new ArrayList<NoteItem>(),tmpItem);
                lvNote.setAdapter(tmpAdapter);
                /*noteAdapter.objects.remove(position);
                noteAdapter.notifyDataSetChanged();*/
            }
        });
    }

    public void onButtonClick(View v) {
        //crtDlg.show(getFragmentManager(), "crtDlg");
        switch(v.getId()) {
            case R.id.button1:
                NoteAdapter tmpNote1 = (NoteAdapter) lvNote.getAdapter();
                tmpNote1.objects.add(new NoteItem("Name", tmpNote1));
                tmpNote1.notifyDataSetChanged();
                break;
            case R.id.button2:
                NoteAdapter tmpNote2 = (NoteAdapter) lvNote.getAdapter();
                NoteItem tmpIt = tmpNote2.parent;
                if(tmpIt == null) {
                    break;
                }
                NoteAdapter tmpAdapter = tmpIt.parent;
                lvNote.setAdapter(tmpAdapter);
                break;
        }

        /*noteAdapter.objects.add(new NoteItem("Name"));
        noteAdapter.notifyDataSetChanged();*/
    }

    public void addItem(String s){
        //noteAdapter.objects.add(new NoteItem(s));
        //noteAdapter.notifyDataSetChanged();
    }



}
