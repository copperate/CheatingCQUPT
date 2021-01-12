package tk.dropr.cheatingcqupt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import java.util.Calendar;

public class ScannedResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_result);
        Intent intent = getIntent();
        int exifcode=intent.getIntExtra("exifcode",0);
        TextView showview=findViewById(R.id.showview);
        if (exifcode==1)
        {
            showview.setText(R.string.allow_out_text);
        }
        else
        {
            showview.setText(R.string.allow_in_text);
        }
        String date1;
        Calendar calendar = Calendar.getInstance();
        int month1=calendar.get(Calendar.MONTH)+1;
        String date2=String.format("%02d", month1);
        String date3=String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
        date1= calendar.get(Calendar.YEAR)+"-"+date2+"-"+date3;
        TextView DateView = findViewById(R.id.DateView);
        DateView.setText(date1);

        SharedPreferences userconfig = this.getSharedPreferences( "UserConfig", Context.MODE_PRIVATE );
        String number = userconfig.getString("number", "2017556821");
        String name = userconfig.getString("name", "李华");
        String college = userconfig.getString("college", "随机学院");
        TextView numView=findViewById(R.id.textView6);
        TextView nameView=findViewById(R.id.textView7);
        TextView colView=findViewById(R.id.textView8);
        numView.setText(number);
        nameView.setText(name);
        colView.setText(college);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mp_emu, menu);
        return true;
    }
}