package yuni.suhang;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {

    int time = 180;
    ProgressBar pBar;
    TextView Gametv;
    Button Startbtn;
    RadioGroup radioG;
    boolean isThread = true;

    ArrayList<Question> list = new ArrayList<>();
    int num=0;
    String check;
    int point=0;
    boolean first=true;
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        LoadQuestion();
        pBar=(ProgressBar)findViewById(R.id.time);
        Gametv=(TextView)findViewById(R.id.Gametv);
        radioG=(RadioGroup)findViewById(R.id.radioG);
        radioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId)
                {
                    case R.id.radio1:
                        check="O";
                        break;
                    case R.id.radio2:
                        check="X";
                        break;
                }
            }
        });
        Startbtn=(Button)findViewById(R.id.Startbtn);

        thread = new Thread() {
            @Override
            public void run() {
                super.run();
                while(isThread) {
                    if(time==0)
                    {
                        isThread = false;
                        Toast.makeText(Quiz.this, "시간초과", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Quiz.this,Quizresult.class);
                        intent.putExtra("point",point);
                        startActivity(intent);
                        finish();
                    }
                    pBar.setProgress(time);
                    time--;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    public void LoadQuestion(){
        list.add(new Question("'한옥'은 서양의 근대건축양식이 우리나라에 들어오기 전부터 있던 용어이다.","X"));
        list.add(new Question("'주춧돌'은 기둥이 썩지 않도록 기둥의 밑둥을 받쳐준다.","O"));
        list.add(new Question("남부지방의 한옥은 마루가 안방과 건넌방 사이에 좁게 있고 창문이 적다.","X"));
        list.add(new Question("방과 방 사이를 이어 사람이 이동할 수 있게 해주는 것은 '마루'이다.","O"));
        list.add(new Question("북부지방의 한옥은 모든 가사작업을 실내에서 할 수 있도록 설계하였다.","O"));
        list.add(new Question("'한옥'은 지역과 시대에 따른 형태적 차이가 명확하다.","O"));
        list.add(new Question("'처마'는 지붕이 기둥보다 바깥쪽으로 나와 있는 부분으로, 계절에 따라 변하는 햇빛의 각도를 이용한다.","O"));
    }

    public void GameStart(View v){


        if(first)
        {
            Gametv.setText(list.get(num).getQuestion());
            radioG.setVisibility(View.VISIBLE);
            Startbtn.setText("다음 문제");
            first=false;
            thread.start();
        }
        else
        {
            if(check.equals(list.get(num).getAnswer()))
            {
                point++;
            }
            if(num==6){
                Toast.makeText(this, " "+point, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Quiz.this,Quizresult.class);
                intent.putExtra("point",point);
                startActivity(intent);
                finish();
            }
            else{
                Gametv.setText(list.get(++num).getQuestion());
            }

        }


    }

}
