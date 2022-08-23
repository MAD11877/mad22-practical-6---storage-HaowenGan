package sg.edu.mad.madpractical3;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    ArrayList<User> data;

    public ItemAdapter(ArrayList<User> input) {
        data = input;
    }


    public ItemViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View item;
        if(viewType == 7)
        {
            item  = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_recyclerwith7,
                    parent,
                    false);
        }
        else
        {
            item  = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_recycler,
                    parent,
                    false);
        }


        return new ItemViewHolder(item);
    }

    public void onBindViewHolder(
            ItemViewHolder holder,
            int position)
    {
        User user = data.get(position);
        holder.itemTitle.setText(user.getName());
        holder.itemDesc.setText(user.getDescription());

        holder.profileImg.setOnClickListener(view ->{
                new AlertDialog.Builder(holder.profileImg.getContext())
                        .setTitle("Profile")
                        .setMessage(user.getName())
                        .setPositiveButton("VIEW", (dialogInterface, i)-> {
                                Intent myIntent = new Intent(holder.profileImg.getContext(), MainActivity.class);
                                myIntent.putExtra("id",holder.getAdapterPosition());
                                holder.profileImg.getContext().startActivity(myIntent);
                            })
                        .setNegativeButton("Close", null)
                        .show();

                        });
            }



    public int getItemCount(){
        return data.size();
    }

}
