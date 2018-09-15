package com.example.student.sharedpreferancetext4;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    //now that's new ^o^
    int img1= R.drawable.desert;
    int img2=R.drawable.hydrangeas;
    int img3=R.drawable.lighthouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.parentLayoutId);
        loadImage();


    }

    private void loadImage() {
        SharedPreferences sharedPreferences= getSharedPreferences("db", Context.MODE_PRIVATE);

        int img= sharedPreferences.getInt("image",img1);//this will load the committed image,by getting it from put method
        linearLayout.setBackgroundResource(img);

    }

    public void click(View view) {

        if(view.getId() == R.id.img1){
            linearLayout.setBackgroundResource(img1);
            saveImage(img1);

        }
        else if(view.getId() == R.id.img2){
            linearLayout.setBackgroundResource(img2);
            saveImage(img2);
        }
        else if(view.getId() == R.id.img3){
            linearLayout.setBackgroundResource(img3);
            saveImage(img3);
        }
    }

    private void saveImage(int img) {
        //so, now even after closing the app the selected background will be saved because if SharedPreferances class
        SharedPreferences sharedPreferences= getSharedPreferences("db", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();//giving permission to edit
        editor.putInt("image",img);//putting image for performing act(commit) on it
        editor.commit();//setting the background image

    }
}
