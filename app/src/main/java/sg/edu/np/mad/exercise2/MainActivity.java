package sg.edu.np.mad.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.BoringLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Main Activity";
    User user = new User();

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG, "on Resume...");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TAG, "on Destroy...");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "on Create!");
        setContentView(R.layout.activity_main);
        TextView helloWorld = findViewById(R.id.helloworld);

        Intent receivingEnd = getIntent();
        Integer id = receivingEnd.getIntExtra("UserID", 100);

        helloWorld.setText("MAD " + id);
        TextView content = findViewById(R.id.content);
        content.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do aiusmod tempor incididunt ut labore et dolore magna aliqua");
        Button following = findViewById(R.id.follow);
        Log.v(TAG, "before buttons");
        user.setFollowed(false);
        following.setText("Follow");
        user.setFollowed(true);
        following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.followed == false){
                    following.setText("Follow");
                    user.setFollowed(true);
                }
                else {
                    following.setText("Unfollow");
                    user.setFollowed(false);
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}