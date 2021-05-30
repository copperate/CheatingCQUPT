package tk.dropr.cheatingcqupt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class ConfirmActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent intent = getIntent();
        int exifcode=intent.getIntExtra("exifcode",0);
        String ymd;
        Calendar calendar = Calendar.getInstance();
        int month1=calendar.get(Calendar.MONTH)+1;
        String date1=String.format("%02d", calendar.get(Calendar.YEAR));
        String date2=String.format("%02d", month1);
        String date3=String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
        ymd= date1+"-"+date2+"-"+date3;
        String hms,hms2,hms3;
        int time1=calendar.get(Calendar.HOUR_OF_DAY);
        int time2=calendar.get(Calendar.MINUTE);
        //int time3=calendar.get(Calendar.SECOND);
        hms=String.format("%02d", time1)+":"+String.format("%02d", time2)+":17";
        int time1x=time1;
        int time2x=time2;
        time2x=time2x-20;
        if((time2x)<0)
        {
            time2x=time2x+60-10;
            time1x = time1x-1;
        }
        hms2=String.format("%02d", time1x)+":"+String.format("%02d", time2x)+":02";
        time2x=time2x+1;
        if((time2x)>60)
        {
            time2x=time2x+1-60;
            time1x = time1x+1;
        }
        hms3=String.format("%02d", time1x)+":"+String.format("%02d", time2x)+":32";
        SharedPreferences UserConfig = this.getSharedPreferences( "UserConfig", Context.MODE_PRIVATE);
        String number = UserConfig.getString("number", "2017556821");
        String name = UserConfig.getString("name", "李华");
        String type=UserConfig.getString("type","市内当日离返校");
        String wentplace=UserConfig.getString("wentplace","重庆市,重庆市,南岸区");
        String scanplace=UserConfig.getString("scanplace","崇文门");
        String reason=UserConfig.getString("reason","出校");
        ImageView imageView13=findViewById(R.id.imageView13);
        ImageView imageView10=findViewById(R.id.imageView10);
        TextView textView44=findViewById(R.id.textView44);
        TextView textView46=findViewById(R.id.textView46);
        TextView textView48=findViewById(R.id.textView48);
        TextView textView50=findViewById(R.id.textView50);
        TextView textView52=findViewById(R.id.textView52);
        TextView textView54=findViewById(R.id.textView54);
        TextView textView56=findViewById(R.id.textView56);
        TextView textView58=findViewById(R.id.textView58);
        TextView textView61=findViewById(R.id.textView61);
        TextView textView63=findViewById(R.id.textView63);
        TextView textView65=findViewById(R.id.textView65);
        TextView textView67=findViewById(R.id.textView67);
        TextView textView69=findViewById(R.id.textView69);
        TextView textView71=findViewById(R.id.textView71);
        TextView textView73=findViewById(R.id.textView73);
        View line1=findViewById(R.id.line1);
        View line2=findViewById(R.id.line2);
        switch (exifcode)
        {
            case 0:
                imageView10.setImageDrawable(getDrawable(R.drawable.purpledot));
                imageView13.setImageDrawable(getDrawable(R.drawable.purpledot));
                textView46.setText(ymd+" "+hms2);
                textView50.setText(scanplace);
                textView52.setText(ymd+" "+hms3);
                textView56.setText(scanplace);
                textView58.setText(ymd+" "+hms);
                textView48.setTextColor(getColor(R.color.grey_tint));
                line1.setBackground(getDrawable(R.color.grey_tint));
                textView54.setTextColor(getColor(R.color.grey_tint));
                line2.setBackground(getDrawable(R.color.grey_tint));//All done
            break;
            case 1:
                imageView10.setImageDrawable(getDrawable(R.drawable.yellowdot));
                imageView13.setImageDrawable(getDrawable(R.drawable.greydot));
                textView46.setText(ymd+" "+hms);
                textView50.setText(" ");
                textView52.setText(" ");
                textView56.setText(" ");
                textView58.setText(" ");
                textView48.setTextColor(getColor(R.color.purple));
                line1.setBackground(getDrawable(R.color.purple));
                textView54.setTextColor(getColor(R.color.grey_tint));
                line2.setBackground(getDrawable(R.color.grey_tint));//Wait For Out
            break;
            case 2:
                imageView10.setImageDrawable(getDrawable(R.drawable.purpledot));
                imageView13.setImageDrawable(getDrawable(R.drawable.yellowdot));
                textView46.setText(ymd+" "+hms2);
                textView50.setText(scanplace);
                textView52.setText(ymd+" "+hms3);
                textView56.setText(" ");
                textView58.setText(" ");
                textView48.setTextColor(getColor(R.color.grey_tint));
                line1.setBackground(getDrawable(R.color.grey_tint));
                textView54.setTextColor(getColor(R.color.purple));
                line2.setBackground(getDrawable(R.color.purple));//Wait For In
            break;
            default:
                imageView10.setImageDrawable(getDrawable(R.drawable.purpledot));
                imageView13.setImageDrawable(getDrawable(R.drawable.purpledot));
                textView46.setText(ymd+" "+hms2);
                textView50.setText(scanplace);
                textView52.setText(ymd+" "+hms3);
                textView56.setText(scanplace);
                textView58.setText(ymd+" "+hms);
                textView48.setTextColor(getColor(R.color.grey_tint));
                textView54.setTextColor(getColor(R.color.grey_tint));
            break;
        }
        textView44.setText(name);
        textView63.setText(name);
        textView61.setText(number);
        textView65.setText(type);
        textView67.setText(ymd);
        textView69.setText(ymd);
        textView71.setText(wentplace);
        textView73.setText(reason);
    }

    public void RunScanner(View view)
    {
        Intent scanner=new Intent(this,ScannerActivity.class);
        startActivity(scanner);
    }
    public void goOut(View view)
    {
        Intent getout = new Intent(this, ScannedResult.class);
        int exifcode=1;
        getout.putExtra("exifcode",exifcode);
        startActivity(getout);
    }
    public void goIn(View view)
    {
        Intent getin = new Intent(this, ScannedResult.class);
        int exifcode=2;
        getin.putExtra("exifcode",exifcode);
        startActivity(getin);
    }
}