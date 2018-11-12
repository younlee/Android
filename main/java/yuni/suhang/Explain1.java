package yuni.suhang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Explain1 extends AppCompatActivity {
    ImageView hanok,hanok2,hanok3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain1);

        hanok = (ImageView)findViewById(R.id.hanok);
        hanok2 = (ImageView)findViewById(R.id.hanok2);
        hanok3 = (ImageView)findViewById(R.id.hanok3);
        hanok.setImageResource(R.drawable.koreanstylehouse);
        hanok2.setImageResource(R.drawable.koreanstylehouse2);
        hanok3.setImageResource(R.drawable.koreanstylehouse3);
    }
}
