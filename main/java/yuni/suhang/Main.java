package yuni.suhang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main extends AppCompatActivity {
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
    }


    public void tv1Click(View v){
        Intent intent = new Intent(this,Explain1.class);
        startActivity(intent);
    }

    public void tv2Click(View v){
        Intent intent = new Intent(this,Explain2.class);
        startActivity(intent);

    }

    public void tv3Click(View v){
        Intent intent = new Intent(this,Explain3.class);
        startActivity(intent);
    }


    public void QuizClick(View v){
        Intent intent = new Intent(this,Quiz.class);
        startActivity(intent);
    }
}
