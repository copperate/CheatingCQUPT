package tk.dropr.cheatingcqupt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.nio.file.Watchable;


public class MainActivity extends AppCompatActivity {
    SharedPreferences UserConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences userconfig = this.getSharedPreferences( "UserConfig", Context.MODE_PRIVATE );
        String firstrun = userconfig.getString("firstrun", "0");
        if(firstrun=="1")
        {
            MenuItem tips_menu=findViewById(R.id.action_warning);
            tips_menu.setVisible(false);
        }

        }
    public void go_out(View view)
    {
        Intent getout = new Intent(this, ScannedResult.class);
        int exifcode=1;
        getout.putExtra("exifcode",exifcode);
        startActivity(getout);
    }


    public void go_in(View view)
    {
        Intent getin = new Intent(this, ScannedResult.class);
        int exifcode=2;
        getin.putExtra("exifcode",exifcode);
        startActivity(getin);
    }
    public void pre_scan(View view)
    {
        Intent prescan=new Intent(this,PrescanActivity.class);
        startActivity(prescan);
    }
    public void menu_tips()
    {
        //UserConfig = this.getSharedPreferences( "UserConfig", Context.MODE_PRIVATE );
        //SharedPreferences.Editor editor = UserConfig.edit();
        //editor.putString( "firstrun","1");
        Intent tips = new Intent(this,WarningActivity.class);
        startActivity(tips);
        //MenuItem tips_menu=findViewById(R.id.action_warning);
        //tips_menu.setVisible(false);
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
        if (id == R.id.action_warning) {
            menu_tips();
            return true;
        }

        if (id == R.id.action_userportal) {
            Intent userportal = new Intent(this, UserPortal.class);
            startActivity(userportal);
            return true;
        }
        if(id==R.id.action_update){
            Context context = getApplicationContext();
            CharSequence text = "无法连接到DropR服务器。请检查连接后重试。";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return true;
        }
        if(id==R.id.action_about){
            Intent aboutus = new Intent(this,AboutUs.class);
            startActivity(aboutus);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}