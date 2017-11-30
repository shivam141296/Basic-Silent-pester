package com.example.androidfirewall.callsilent.Utils;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.androidfirewall.callsilent.DBUtils.ContactDetails;
import com.example.androidfirewall.callsilent.R;

import java.util.ArrayList;

/**
 * Created by ishaandhamija on 24/06/17.
 */

public class AllContactsAdapter extends RecyclerView.Adapter<AllContactsHolder> {

    Context ctx;
    ArrayList<ContactDetails> allContactsArrayList;

    public AllContactsAdapter(Context context, ArrayList<ContactDetails> list) {
        this.ctx = context;
        this.allContactsArrayList = list;
    }

    @Override
    public AllContactsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.all_contact_sample, parent, false);

        return new AllContactsHolder(itemView, ctx);
    }

    @Override
    public void onBindViewHolder(AllContactsHolder holder, int position) {
        final ContactDetails contactDetails = allContactsArrayList.get(position);
        holder.allContactsName.setText(contactDetails.getName());
        holder.allContactsNumber.setText(contactDetails.getNumber());
        holder.allContactsLetter.setText(Character.toString(contactDetails.getName().charAt(0)));
        if (position % 6 == 0){
            holder.gd.setColor(Color.parseColor("#FF0000"));
        }
        if (position % 6 == 1) {
            holder.gd.setColor(Color.BLUE);
        }
        if (position % 6 == 2){
            holder.gd.setColor(Color.parseColor("#008000"));
        }
        if (position % 6 == 3){
            holder.gd.setColor(Color.parseColor("#FFA500"));
        }
        if (position % 6 == 4){
            holder.gd.setColor(Color.parseColor("#800000"));
        }
        if (position % 6 == 5){
            holder.gd.setColor(Color.parseColor("#191970"));
        }
    }

    @Override
    public int getItemCount() {
        return allContactsArrayList.size();
    }
}
