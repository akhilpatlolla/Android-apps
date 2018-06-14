package edu.cs.niu.z1803493.json;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Akhil on 5/4/2017.
 */

public class StateArrayAdapter extends ArrayAdapter<State> {
    public StateArrayAdapter(Context context, List<State> objects) {
        super(context, -1, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        State state = getItem(position);
        ViewHolder viewHolder ;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_items,parent,false);
            viewHolder.stateTV = (TextView)convertView.findViewById(R.id.stateTextView);
            viewHolder.numberTV = (TextView)convertView.findViewById(R.id.numberTextView);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.stateTV.setText("State : "+ state.stateAbbr);
        viewHolder.numberTV.setText("Number : "+ state.stateNumber);

        return super.getView(position, convertView, parent);
    }
    private static class ViewHolder{
        TextView stateTV,numberTV;
    }


}
