package com.example.joel.studyaid;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.SharedPreferences;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.util.Log;




public class MainActivity extends Activity implements View.OnClickListener{
 private ImageButton  imageButton;
 private SharedPreferences sp;
 private String username;
 private final String SP_KEY="USERNAME";
 private int nOfPage=1;
 private Start start;
 private  RelativeLayout relativeLayout;
    private ImageButton frontButton;
    private ImageButton backButton;
    private EditText buttonhint;
    private EditText passwordhint;
    private Button loginbutton;
    private Button register;
    private final String MONITOR="monitor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(MONITOR,"ONCREATE.....");

        start = new Start();

         buttonhint = (EditText) findViewById(R.id.Loginhint);
         passwordhint = (EditText) findViewById(R.id.passwordhint);
         loginbutton = (Button) findViewById(R.id.login);
         register = (Button) findViewById(R.id.Register);
         frontButton = (ImageButton) findViewById(R.id.front);
        frontButton.setOnClickListener(this);
        backButton = (ImageButton) findViewById(R.id.back);
        backButton.setOnClickListener(this);

       relativeLayout = (RelativeLayout) findViewById(R.id.mylayout);
        sp = getPreferences(MODE_PRIVATE);
        username = sp.getString(SP_KEY, "empty");
        if (username == "empty") {
            Log.d(MONITOR,"......is empty.....");
            start.tutorials_page();

        } else {
            start.login(username);
            Log.d(MONITOR,"......is not empty.....");

        }

        sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor spe = sp.edit();
        spe.putString(SP_KEY, "empty");
        spe.commit();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class Start {
        private int nOfPage=1;

        //////////////////////////defines set of text based images to offer a short tutorial for first time users//////////////////////////////
        public void tutorials_page()
        {

            switch (nOfPage)
            {
                case 1:{ Log.d(MONITOR,"......tutorials_page() case 1.....");
                nOfPage++;     break;         }
                case 2:{Log.d(MONITOR,"......tutorials_page() case 2....."); nOfPage++;            break; }
                case 3:{ nOfPage++;     break;}
                case 4:{  Log.d(MONITOR,"......tutorials_page() case 4....."); loginbutton.setVisibility(View.VISIBLE);
                    register.setVisibility(View.VISIBLE);
                    passwordhint.setVisibility(View.VISIBLE);
                    buttonhint.setVisibility(View.VISIBLE);
                    frontButton.setVisibility(View.INVISIBLE);
                    backButton.setVisibility(View.INVISIBLE);

                    break;}

            }



        }
        public void login(String username)
        {


        }
        public void logOut()
        {


        }





    }
   //////////////////Responds to click events as it happens//////////////////////////////////////
    public  void onClick (View v)
    {

        Log.d(MONITOR,"......onClick .....");
      if(v == frontButton)
      {
          Log.d(MONITOR,"......onClick frontButton.....");
        nOfPage++;
          start.tutorials_page();

      }
      else if(v== backButton)
      {   Log.d(MONITOR,"......onClick backButton.....");
          nOfPage--;
          start.tutorials_page();

      }


    }

}
