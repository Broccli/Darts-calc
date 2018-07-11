package com.example.kalo0osha.dartscalc;

import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.dinuscxj.progressbar.CircleProgressBar;

import java.util.ArrayList;

public class twoplayersActivity extends AppCompatActivity {
    int score1 = 301;
    int score2 = 301;
    CircleProgressBar scoreProgressBar1, scoreProgressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twoplayers);

//        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        scoreProgressBar1 = (CircleProgressBar) findViewById(R.id.score_progress1);
        final EditText pinput1 = (EditText) findViewById(R.id.player1_in);

        final EditText pinput2 = (EditText) findViewById(R.id.player2_in);
        scoreProgressBar2 = (CircleProgressBar) findViewById(R.id.score_progress2);


        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.player1_array, android.R.layout.simple_spinner_item);

//        spinner1.setAdapter(adapter1);
//        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.player2_array, android.R.layout.simple_spinner_item);
//        spinner2.setAdapter(adapter2);

        final ListView ls1 = (ListView) findViewById(R.id.player1_list);
        final ArrayList<String> l1 = new ArrayList<String>();
        final ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, l1);

        final ListView ls2 = (ListView) findViewById(R.id.player2_list);
        final ArrayList<String> l2 = new ArrayList<String>();
        final ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, l2);


        scoreProgressBar1.setProgressFormatter(new CircleProgressBar.ProgressFormatter() {
            @Override
            public CharSequence format(int progress, int max) {
                return progress + "pt";
            }
        });


        scoreProgressBar2.setProgressFormatter(new CircleProgressBar.ProgressFormatter() {
            @Override
            public CharSequence format(int progress, int max) {
                return progress + "pt";
            }
        });
        scoreProgressBar1.setMax(301);
        simulateProgress(score1, scoreProgressBar1);

        scoreProgressBar2.setMax(301);
        simulateProgress(score2, scoreProgressBar2);


        Button player1_btn = (Button) findViewById(R.id.player1_ptn);
        player1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pinput1.getText().length() != 0) {
                    int temp = Integer.parseInt(pinput1.getText().toString());
                    if (score1 - temp >= 0) {
                        l1.add(pinput1.getText().toString());
                        // adapter3.add(pinput1.getText().toString());
                        ls1.setAdapter(adapter3);
                        // adapter3.notifyDataSetChanged();


                        try {

                            score1 = score1 - temp;
//                        pscoore1.setText(String.valueOf(scoore1));
//                        mCustomProgressBar1.setProgress(scoore1);
                            simulateProgress(score1, scoreProgressBar1);

                            pinput1.setText(null);
                            getwiner();

                        } catch (Exception e) {
                            Log.i(this.getClass().getSimpleName(), e.getMessage());
                        }
                    } else {
                        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(twoplayersActivity.this);
                        dlgAlert.setMessage(" Out of range");
                        dlgAlert.setTitle("opps");
                        dlgAlert.setPositiveButton("OK", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();
                        dlgAlert.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        //
                                    }
                                });
                        pinput1.setText(null);


                    }
                }
            }
        });
        pinput1.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            if (pinput1.getText().length() != 0) {

                                int temp = Integer.parseInt(pinput1.getText().toString());

                                if (score1 - temp >= 0) {
                                    l1.add(pinput1.getText().toString());
                                    // adapter3.add(pinput1.getText().toString());
                                    ls1.setAdapter(adapter3);
                                    // adapter3.notifyDataSetChanged();


                                    try {

                                        score1 = score1 - temp;
//                                    pscoore1.setText(String.valueOf(scoore1));
//                                    mCustomProgressBar1.setProgress(scoore1);
                                        simulateProgress(score1, scoreProgressBar1);
                                        pinput1.setText(null);
                                        getwiner();

                                    } catch (Exception e) {
                                        Log.i(this.getClass().getSimpleName(), e.getMessage());
                                    }
                                } else {
                                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(twoplayersActivity.this);
                                    dlgAlert.setMessage(" Out of range");
                                    dlgAlert.setTitle("opps");
                                    dlgAlert.setPositiveButton("OK", null);
                                    dlgAlert.setCancelable(true);
                                    dlgAlert.create().show();
                                    dlgAlert.setPositiveButton("Ok",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    //
                                                }
                                            });
                                    pinput1.setText(null);

                                }
                            }

                            break;
                    }
                }
                return false;
            }
        });
        Button player2_btn = (Button) findViewById(R.id.player2_btn);


        player2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pinput2.getText().length() != 0) {

                    int temp = Integer.parseInt(pinput2.getText().toString());
                    if (score2 - temp >= 0) {
                        l2.add(pinput2.getText().toString());
                        // adapter3.add(pinput1.getText().toString());
                        ls2.setAdapter(adapter4);
                        // adapter3.notifyDataSetChanged();


                        try {

                            score2 = score2 - temp;
//                        pscoore2.setText(String.valueOf(scoore2));
                            simulateProgress(score2, scoreProgressBar2);

                            pinput2.setText(null);
                            getwiner();

                        } catch (Exception e) {
                            Log.i(this.getClass().getSimpleName(), e.getMessage());
                        }
                    } else {
                        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(twoplayersActivity.this);
                        dlgAlert.setMessage(" Out of range");
                        dlgAlert.setTitle("opps");
                        dlgAlert.setPositiveButton("OK", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();
                        dlgAlert.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        //
                                    }
                                });
                        pinput2.setText(null);

                    }
                }
            }
        });
        pinput2.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            if (pinput2.getText().length() != 0) {

                                int temp = Integer.parseInt(pinput2.getText().toString());
                                if (score2 - temp >= 0) {
                                    l2.add(pinput2.getText().toString());
                                    // adapter3.add(pinput1.getText().toString());
                                    ls2.setAdapter(adapter4);
                                    // adapter3.notifyDataSetChanged();


                                    try {

                                        score2 = score2 - temp;
//                                    pscoore2.setText(String.valueOf(score2));
                                        simulateProgress(score2, scoreProgressBar2);

                                        pinput2.setText(null);
                                        getwiner();

                                    } catch (Exception e) {
                                        Log.i(this.getClass().getSimpleName(), e.getMessage());
                                    }
                                } else {
                                    AlertDialog.Builder dlgAlert = new AlertDialog.Builder(twoplayersActivity.this);
                                    dlgAlert.setMessage(" Out of range");
                                    dlgAlert.setTitle("opps");
                                    dlgAlert.setPositiveButton("OK", null);
                                    dlgAlert.setCancelable(true);
                                    dlgAlert.create().show();
                                    dlgAlert.setPositiveButton("Ok",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    //
                                                }
                                            });
                                    pinput2.setText(null);

                                }
                            }
                            break;
                    }
                }
                return false;
            }
        });

    }

    private void simulateProgress(final int progress, final CircleProgressBar scoreProgressBar) {
        ValueAnimator animator = ValueAnimator.ofInt(0, 100);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                int progress = (int) animation.getAnimatedValue();

                scoreProgressBar.setProgress(progress);

            }
        });
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(4000);
        animator.start();
    }

    public void getwiner() {
        if (score1 == 0) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("yellow win's");
            dlgAlert.setTitle("Winer is");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    });
        } else if (score2 == 0) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("red win's");
            dlgAlert.setTitle("Winer is");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    });
        } else
            return;
    }
}

