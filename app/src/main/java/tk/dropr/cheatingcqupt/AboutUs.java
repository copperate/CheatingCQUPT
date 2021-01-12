package tk.dropr.cheatingcqupt;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar abouttoolbar = findViewById(R.id.toolbar_about);
        setSupportActionBar(abouttoolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    public boolean hasPackage(Context context, String pkgName) {
        if (null == context || null == pkgName) {
            return false;
        }

        boolean bHas = true;
        try {
            context.getPackageManager().getPackageInfo(pkgName, PackageManager.GET_GIDS);
        } catch (PackageManager.NameNotFoundException e) {
            // 抛出找不到的异常，说明该程序已经被卸载
            bHas = false;
        }
        return bHas;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_loginjabbr:
                if(hasPackage(this,"web.jabbr")==false) {
                    Context context = getApplicationContext();
                    CharSequence text = "未检测到Jabbr。请前往DropR应用商店安装。";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return true;
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "正在启动Jabbr，请在弹出的窗口中选择“授权”。";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}