package sg.edu.rp.c346.id21025446.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;
    String bankClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.textViewDBS);
        ocbc = findViewById(R.id.textViewOCBC);
        uob = findViewById(R.id.textViewUOB);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu, menu);

        if (v == dbs){
            bankClicked = "DBS";
        }
        else if (v == ocbc){
            bankClicked = "OCBC";
        }
        else if (v == uob){
            bankClicked = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(bankClicked.equalsIgnoreCase("DBS")){
            if(item.getItemId()==R.id.WebSelection) {
                Intent intentdbs = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentdbs);
                return true;
            }else if (item.getItemId() == R.id.ContSelection){
                Intent intentCont = new Intent(Intent.ACTION_DIAL, Uri.parse("tell:" + getResources().getString(R.string.dbsContact)));
                startActivity(intentCont);
            }
        }else if (bankClicked.equalsIgnoreCase("OCBC")){
            if(item.getItemId()==R.id.WebSelection) {
                Intent intentocbc = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentocbc);
                return true;
            }else if (item.getItemId() == R.id.ContSelection){
                Intent intentCont = new Intent(Intent.ACTION_DIAL, Uri.parse("tell:" + getResources().getString(R.string.ocbcContact)));
                startActivity(intentCont);
            }
        }else if (bankClicked.equalsIgnoreCase("UOB")){
            if(item.getItemId()==R.id.WebSelection) {
                Intent intentuob = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentuob);
                return true;
            }else if (item.getItemId() == R.id.ContSelection){
                Intent intentCont = new Intent(Intent.ACTION_DIAL, Uri.parse("tell:" + getResources().getString(R.string.uobContact)));
                startActivity(intentCont);
            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_lang, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EngSelection) {
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;
        } else if (id == R.id.ChiSelection) {
            dbs.setText("星展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}