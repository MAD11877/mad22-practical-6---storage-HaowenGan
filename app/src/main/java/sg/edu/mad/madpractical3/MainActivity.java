package sg.edu.mad.madpractical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "Main Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler db = new DBHandler(this,null,null,1);

        User user = new User();
        user.setFollow(false);
        Intent receiving = getIntent();
        String message = receiving.getStringExtra("randomNum");
        TextView mainText = findViewById(R.id.maintext);
        mainText.setText(message);


        Button followBtn = findViewById(R.id.followbtn);
        followBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (user.isFollow() == false)
                {
                    followBtn.setText("UNFOLLOW");
                    Toast toast = Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT);
                    toast.show();
                    user.setFollow(true);
                    db.updateUser(user);


                }
                else if (user.isFollow() == true)
                {
                    followBtn.setText("FOLLOW");
                    Toast toast = Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT);
                    toast.show();
                    user.setFollow(false);
                    db.updateUser(user);

                }

            }
        });


    }
}