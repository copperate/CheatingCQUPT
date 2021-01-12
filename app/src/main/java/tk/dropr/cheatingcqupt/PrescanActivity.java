package tk.dropr.cheatingcqupt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PrescanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescan);

        Context context = getApplicationContext();
        CharSequence text = "使用扫描功能，请首先前往系统设定确认已授予“拍摄相片或视频”权限，否则会闪退！";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        SharedPreferences userconfig = this.getSharedPreferences( "UserConfig", Context.MODE_PRIVATE );
        String number = userconfig.getString("number", "2017556821");
        String name = userconfig.getString("name", "李华");
        TextView numView=findViewById(R.id.textView14);
        TextView nameView=findViewById(R.id.textView16);
        numView.setText(number);
        nameView.setText(name);
    }
    public void scanner(View view)
    {
        Intent scanqrcode=new Intent(this,ScannerActivity.class);
        startActivity(scanqrcode);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mp_emu, menu);
        return true;
    }
}