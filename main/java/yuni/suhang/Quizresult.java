package yuni.suhang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Quizresult extends AppCompatActivity {

    TextView Pointtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizresult);

        Pointtv=(TextView)findViewById(R.id.Pointtv);

        Intent intent = getIntent();
        Pointtv.setText(""+intent.getIntExtra("point",0));


    }

    public void Again(View v)
    {
        Intent intent = new Intent(Quizresult.this,Quiz.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void Gofirst(View v)
    {
        Intent intent = new Intent(Quizresult.this,Main.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
