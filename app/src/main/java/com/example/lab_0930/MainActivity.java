package com.example.lab_0930;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed_name;
    private TextView tv_text, tv_name, tv_winner, tv_mmora, tv_cmora;
    private RadioButton btn_scissor, btn_stone, btn_paper;
    private Button btn_mora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_name = findViewById(R.id.editTextTextPersonName);
        tv_text = findViewById(R.id.textView);
        tv_name = findViewById(R.id.textView2);
        tv_winner = findViewById(R.id.textView3);
        tv_mmora = findViewById(R.id.textView4);
        tv_cmora = findViewById(R.id.textView5);
        btn_scissor = findViewById(R.id.radioButton);
        btn_stone = findViewById(R.id.radioButton2);
        btn_paper = findViewById(R.id.radioButton3);
        btn_mora = findViewById(R.id.button);
        btn_mora.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                //判斷字串是否是空白來要求輸入姓名
                if (ed_name.length() < 1)
                    tv_text.setText("請輸入玩家姓名");
                else {
                    tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()));

                    if (btn_scissor.isChecked())
                        tv_mmora.setText("我方出拳\n剪刀");

                    else if (btn_stone.isChecked())
                        tv_mmora.setText("我方出拳\n石頭");
                    else
                        tv_mmora.setText("我方出拳\n布");
                }

//Random()產生介於0~1 間不含 1 的亂電腦數,乘3產生0~2 當作的出拳
                int computer = (int) (Math.random() * 3);
                if (computer == 0)
                    tv_cmora.setText("電腦出拳\n剪刀");
                else if (computer == 1)
                    tv_cmora.setText("電腦出拳\n石頭");
                else
                    tv_cmora.setText("電腦出拳\n 布");
//用三個判斷式判斷並顯示猜拳結果
                if ((btn_scissor.isChecked() && computer == 2) ||
                        (btn_stone.isChecked() && computer == 0) ||
                        (btn_paper.isChecked() && computer == 1)) {
                    tv_winner.setText("勝利者\n" +
                            ed_name.getText().toString());
                    tv_text.setText("恭喜你獲勝了! ! ! ");
                } else if ((btn_scissor.isChecked() && computer == 1) ||
                        (btn_stone.isChecked() && computer == 2) ||
                        (btn_paper.isChecked() && computer == 0)) {
                    tv_winner.setText("勝利者\n電腦");
                    tv_text.setText("可惜，電腦獲勝了! ");
                } else {
                    tv_winner.setText("勝利者\n電腦");
                    tv_text.setText("平局 請再試一次! ");

                }
            }
        });
    }
}