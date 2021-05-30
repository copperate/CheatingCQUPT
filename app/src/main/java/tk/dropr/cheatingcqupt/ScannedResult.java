package tk.dropr.cheatingcqupt;

import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class ScannedResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_result);
        Toolbar toolbar_scanresu = findViewById(R.id.toolbar_scanneresult);
        setSupportActionBar(toolbar_scanresu);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Intent intent = getIntent();
        int exifcode=intent.getIntExtra("exifcode",0);
        SharedPreferences UserConfig;
        UserConfig = this.getSharedPreferences( "UserConfig", Context.MODE_PRIVATE );
        String number = UserConfig.getString("number", "2017556821");
        String name = UserConfig.getString("name", "李华");
        String college = UserConfig.getString("college", "随机学院");
        String scanplace=UserConfig.getString("scanplace","崇文门");
        String ymd;
        Calendar calendar = Calendar.getInstance();
        int month1=calendar.get(Calendar.MONTH)+1;
        String date1=String.format("%02d", calendar.get(Calendar.YEAR));
        String date2=String.format("%02d", month1);
        String date3=String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
        ymd= date1+"-"+date2+"-"+date3;
        TextView DateView=findViewById(R.id.textView_date);
        TextView NameView=findViewById(R.id.textView_name);
        TextView NumView=findViewById(R.id.textView_peoplenum);
        TextView PlaceView=findViewById(R.id.textView_wherego);
        TextView status=findViewById(R.id.textView_status);
        TextView StuView=findViewById(R.id.textView_stunum);
        TextView ColView=findViewById(R.id.textView_stufrom);
        DateView.setText(ymd);
        NameView.setText(name);
        StuView.setText(number);
        ColView.setText(college);
        int time1=calendar.get(Calendar.HOUR_OF_DAY);
        int time2=calendar.get(Calendar.MINUTE);
        int absmin=time1*60+time2;
        int numpri;
        if (exifcode==1)
        {
            PlaceView.setText("从"+scanplace+"扫码出校的同学");
            status.setText(R.string.allow_out_text);
            if(scanplace.equals("崇文门"))
            {
                numpri=(int)Math.round(72.526*Math.exp(0.0042*absmin));
            }
            else {
                numpri=(int)Math.round(72.526*Math.exp(0.0042*absmin)/4);
            }
            NumView.setText(String.format("%d",numpri));
        }
        else
        {
            PlaceView.setText("从"+scanplace+"扫码入校的同学");
            status.setText(R.string.allow_in_text);
            if(scanplace.equals("崇文门")) {
                numpri = (int) Math.round(346.57 * Math.exp(0.0025 * absmin));
            }
            else numpri = (int) Math.round(346.57 * Math.exp(0.0025 * absmin)/4);
            NumView.setText(String.format("%d",numpri));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mp_emu, menu);
        return true;
    }
}