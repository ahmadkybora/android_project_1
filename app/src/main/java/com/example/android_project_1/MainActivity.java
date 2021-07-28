package com.example.android_project_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.hardware.Camera.Area;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String tag = "LifeCycle";
    CharSequence[] items = {"Google", "Apple", "Microsoft"};
    boolean[] itemsChecked = new boolean[items.length];
    ProgressDialog progressDialog;

    /**
     * Called when the activity is first created.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "In the onCreate() event");
    }

    public void onClick(View v) {
        showDialog(0);
    }

    public void onClick2(View v) {
        final ProgressDialog pdilog = ProgressDialog.show(this,
                "Title Ra inja Vared Mikonid",
                "pigham ra inja vared mikonid",
                true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    pdilog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void onClick3(View v) {
        showDialog(1);
        progressDialog.setProgress(0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    try {
                        Thread.sleep(1000);
                        progressDialog.incrementProgressBy((int) (100 / 15));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                progressDialog.dismiss();
            }
        }).start();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new AlertDialog.Builder(this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("En ghesamt Title Ra Vared Mikonid")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        Toast.makeText(getBaseContext(), "Ok Ra Click Kardid", Toast.LENGTH_SHORT)
                                                .show();
                                    }
                                }
                        ).setNegativeButton("Cancel", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        Toast.makeText(getBaseContext(), "Cancel Ra Click Kardid", Toast.LENGTH_SHORT)
                                                .show();
                                    }
                                })
                        .setMultiChoiceItems(items, itemsChecked, new
                                DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1,
                                                        boolean arg2) {
                                        Toast.makeText(getBaseContext(), items[arg1] + " Ra Entekhab Kardid", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .create();
            case 1:
                progressDialog = new ProgressDialog(this);
                progressDialog.setIcon(R.drawable.ic_launcher_foreground);
                progressDialog.setTitle("Download Files...");

                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int whichButton) {
                        Toast.makeText(getBaseContext(),
                                "ok clicked",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
                        "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface
                                                        dialog,
                                                int whichButton) {
                                Toast.makeText(getBaseContext(),
                                        "Cancel clicked!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                return progressDialog;
        }
        return null;
    }

    public void onStart() {
        super.onStart();
        Log.d(tag, "In the onStart() event");
    }

    public void onRestart() {
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
    }

    public void onResume() {
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }

    public void onPause() {
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }

    public void onStop() {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }
}