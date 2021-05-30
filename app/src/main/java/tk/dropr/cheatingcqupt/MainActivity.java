package tk.dropr.cheatingcqupt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.nio.file.Watchable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String ymd;
        Calendar calendar = Calendar.getInstance();
        int month1=calendar.get(Calendar.MONTH)+1;
        String date1=String.format("%02d", calendar.get(Calendar.YEAR));
        String date2=String.format("%02d", month1);
        String date3=String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
        ymd= date1+"-"+date2+"-"+date3;
        String hms;
        int time1=calendar.get(Calendar.HOUR_OF_DAY);
        int time2=calendar.get(Calendar.MINUTE);
        int time3=calendar.get(Calendar.SECOND);
        hms=String.format("%02d", time1)+":"+String.format("%02d", time2)+":"+String.format("%02d", time3);
        SharedPreferences userconfig = this.getSharedPreferences( "UserConfig", Context.MODE_PRIVATE );
        String name=userconfig.getString("name","李华");
        String reason=userconfig.getString("reason","校外");
        TextView textView18=findViewById(R.id.textView18);
        TextView textView22=findViewById(R.id.textView22);
        TextView textView25=findViewById(R.id.textView25);
        TextView textView27=findViewById(R.id.textView27);
        TextView textView29=findViewById(R.id.textView29);
        TextView textView30=findViewById(R.id.textView30);
        TextView textView33=findViewById(R.id.textView33);
        TextView textView35=findViewById(R.id.textView35);
        TextView textView37=findViewById(R.id.textView37);
        TextView textView39=findViewById(R.id.textView39);
        textView22.setText(ymd);
        textView27.setText(ymd);
        textView33.setText(ymd);
        textView37.setText(ymd);
        textView29.setText(ymd+" "+hms);
        textView39.setText(ymd+" "+hms);
        textView25.setText(reason);
        textView35.setText(reason);
        textView18.setText(name);
        textView30.setText(name);
    }

    public void go_out_still(View view)
    {
        Intent gooutbanner=new Intent(this,ConfirmActivity.class);
        int exifcode=1;
        gooutbanner.putExtra("exifcode",exifcode);
        startActivity(gooutbanner);
    }
    public void go_in_still(View view)
    {
        Intent goinbanner=new Intent(this,ConfirmActivity.class);
        int exifcode=2;
        goinbanner.putExtra("exifcode",exifcode);
        startActivity(goinbanner);
    }
    public void userportal(View view)
    {
        Intent userportal = new Intent(this, UserPortal.class);
        startActivity(userportal);
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
            Intent tips = new Intent(this,WarningActivity.class);
            startActivity(tips);

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