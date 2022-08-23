package sg.edu.mad.madpractical3;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView itemTitle;
    TextView itemDesc;
    ImageView profileImg;

    public ItemViewHolder(View itemView)
    {
        super(itemView);
        itemTitle = itemView.findViewById(R.id.itemTitle);
        itemDesc = itemView.findViewById(R.id.itemDesc);
        profileImg = itemView.findViewById(R.id.profileImg);
    }
}
