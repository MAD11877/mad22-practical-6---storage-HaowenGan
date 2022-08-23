package sg.edu.mad.madpractical3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    static ArrayList<User> userArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Random rd = new Random();

        


        userArrayList = new ArrayList<>();
        for (int i=0; i<20;i++)
        {
            User user = new User();
            user.setName("Name"+randomNum());
            user.setDescription("Description"+randomNum());
            user.setFollow(rd.nextBoolean());
            userArrayList.add(user);
        }

        
        

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ItemAdapter itemAdapter =
                new ItemAdapter(userArrayList);

        LinearLayoutManager mLayoutManager =
                new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(itemAdapter);
    }

    private int randomNum()
    {
        Random ran = new Random();
        return ran.nextInt(1000000000);
    }


}

