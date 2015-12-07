package it2107.dit.nyp.com.calculator_142868j;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnBackspace;
    Button btnEqual;
    Button btnSubtract;
    Button btnAdd;
    Button btnDivide;
    Button btnMultiply;

    TextView tvDisplay;
    String total = "";
    double v1, v2;
    String sign = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnBackspace = (Button)findViewById(R.id.btnBackspace);
        btnEqual = (Button)findViewById(R.id.btnEqual);
        btnSubtract = (Button)findViewById(R.id.btnSubtract);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDivide = (Button)findViewById(R.id.btnDivide);
        btnMultiply = (Button)findViewById(R.id.btnMultiply);
        tvDisplay = (TextView)findViewById(R.id.tvDisplay);

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
    public void onClick(View v)
    {
        Button button = (Button)v;
        String str = button.getText().toString();
        total += str;
        EditText edit = (EditText)findViewById(R.id.et1);
        edit.setText(total);
    }
    public void onAdd(View v)
    {
        v1 = Double.parseDouble(total);
        total = "";
        Button button = (Button)v;
        String str = button.getText().toString();
        sign = str;
        EditText edit = (EditText)findViewById(R.id.et1);
        edit.setText("");
    }
    public void onCalculate(View v)
    {
        EditText edit = (EditText)findViewById(R.id.et1);
        String str2 = edit.getText().toString();
        v2 = Double.parseDouble(str2);
        double grand_total = 0;
        if(sign.equals("+"))
        {
            grand_total = v1+v2;
        }
        else if(sign.equals("-"))
        {
            grand_total = v1-v2;
        }
        else if(sign.equals("*"))
        {
            grand_total = v1*v2;
        }
        else if(sign.equals("/"))
        {
            grand_total = v1/v2;
        }
        edit.setText(grand_total+"");
    }
    public void onClear(View v)
    {
        EditText edit = (EditText)findViewById(R.id.et1);
        String textInBox = edit.getText().toString();
        if(textInBox.length() > 0)
        {
            //Remove last character//
            String newText = textInBox.substring(0, textInBox.length()-1);
            // Update edit text
            edit.setText(newText);
           total = newText;
        }
    }

}
