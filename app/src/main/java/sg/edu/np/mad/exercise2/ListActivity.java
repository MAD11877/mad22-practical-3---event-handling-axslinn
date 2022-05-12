package sg.edu.np.mad.exercise2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ImageView clickImage = findViewById(R.id.image);
        clickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertdialog();
            }
        });
    }
    private void alertdialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness").setCancelable(false); //force user to select option
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Integer number = (int)Math.random();
                Bundle extras = new Bundle();
                extras.putInt("UserID", number);
                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();
    }
}