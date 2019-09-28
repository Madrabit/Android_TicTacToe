package ru.madrabit.tictactoe;

import android.annotation.SuppressLint;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {


    private Logic memory = new Logic(
            Arrays.asList(R.id.button, R.id.button2, R.id.button3,
                    R.id.button4, R.id.button5, R.id.button6,
                    R.id.button7, R.id.button8,  R.id.button9)
    );

    public Executor pool = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startEvent(View view) {
        pool.execute(animation(memory.rnd()));
    }

    @SuppressLint("ResourceAsColor")
    private Runnable animation(List<Integer> ids) {
        return () -> {
            for (Integer id : ids) {
                try {
                    Button btn = findViewById(id);
//                    Pair<Integer, Integer> color = colors.get(btn.getId());
//                    runOnUiThread(() -> btn.setBackgroundColor(color.second));
//                    Thread.sleep(500);
                    runOnUiThread(() -> btn.setBackgroundColor(android.R.color.black));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void answer(View view) {
        memory.addAnswer(view.getId());
        pool.execute(animation(Collections.singletonList(view.getId())));
        if (memory.check() && memory.isFinish()) {
            memory.cleanAnswers();
            msg("Level " + memory.level() + ". Good, Go next?");
        } else if (!memory.check()) {
            memory.cleanAnswers();
            memory.cleanSeq();
            msg("Level " + memory.level() + ". Wrong, Again?");
        }
    }

    private void msg(String text) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Memory Result");
        alertDialogBuilder
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("Ok", (dialog, id) -> pool.execute(animation(memory.rnd())));
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
