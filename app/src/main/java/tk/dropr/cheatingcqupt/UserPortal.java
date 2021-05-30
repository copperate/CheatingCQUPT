package tk.dropr.cheatingcqupt;

import android.content.Intent;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserPortal extends AppCompatActivity {
    SharedPreferences UserConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_portal);
        UserConfig = this.getSharedPreferences( "UserConfig", Context.MODE_PRIVATE );
        String number = UserConfig.getString("number", "2017556821");
        String name = UserConfig.getString("name", "李华");
        String college = UserConfig.getString("college", "随机学院");
        String type=UserConfig.getString("type","市内当日离返校");
        String wentplace=UserConfig.getString("wentplace","重庆市,重庆市,南岸区");
        String scanplace=UserConfig.getString("scanplace","崇文门");
        String reason=UserConfig.getString("reason","出校");
        TextView numView=findViewById(R.id.NumberEdit);
        TextView nameView=findViewById(R.id.NameEdit);
        TextView colView=findViewById(R.id.CollegeEdit);
        Spinner typeView=findViewById(R.id.TypeSpinner);
        TextView WentPlaceView=findViewById(R.id.WentPlaceEdit);
        Spinner ScanPlaceView=findViewById(R.id.ScanPlaceSpinner);
        TextView ReasonView=findViewById(R.id.ReasonEdit);
        numView.setText(number);
        nameView.setText(name);
        colView.setText(college);
        typeView.setPrompt(type);
        WentPlaceView.setText(wentplace);
        ScanPlaceView.setPrompt(scanplace);
        ReasonView.setText(reason);
    }
    public void saveUserConfig(View view)
{
    SharedPreferences.Editor editor = UserConfig.edit();
    EditText Namedit = (EditText) findViewById(R.id.NameEdit);
    EditText Numberdit = (EditText) findViewById(R.id.NumberEdit);
    EditText Collegedit = (EditText) findViewById(R.id.CollegeEdit);
    Spinner typedit=findViewById(R.id.TypeSpinner);
    EditText WentPlacedit=findViewById(R.id.WentPlaceEdit);
    Spinner ScanPlacedit=findViewById(R.id.ScanPlaceSpinner);
    EditText Reasondit=findViewById(R.id.ReasonEdit);
    String number = Numberdit.getText().toString();
    String name = Namedit.getText().toString();
    String college = Collegedit.getText().toString();
    String type=typedit.getSelectedItem().toString();
    String wentplace=WentPlacedit.getText().toString();
    String scanplace=ScanPlacedit.getSelectedItem().toString();
    String reason=Reasondit.getText().toString();
    editor.putString( "number",number );
    editor.putString( "name",name );
    editor.putString( "college",college );
    editor.putString("type",type);
    editor.putString("wentplace",wentplace);
    editor.putString("scanplace",scanplace);
    editor.putString("reason",reason);
    editor.commit();

    Context context = getApplicationContext();
    CharSequence text = "已保存。但...由于构建问题，主页的姓名需要重启应用后才能正确显示。";
    int duration = Toast.LENGTH_SHORT;
    Toast toast = Toast.makeText(context, text, duration);
    toast.show();
}
    public void saveAndJump(View view)
    {
        SharedPreferences.Editor editor = UserConfig.edit();
        EditText Namedit = (EditText) findViewById(R.id.NameEdit);
        EditText Numberdit = (EditText) findViewById(R.id.NumberEdit);
        EditText Collegedit = (EditText) findViewById(R.id.CollegeEdit);
        Spinner typedit=findViewById(R.id.TypeSpinner);
        EditText WentPlacedit=findViewById(R.id.WentPlaceEdit);
        Spinner ScanPlacedit=findViewById(R.id.ScanPlaceSpinner);
        EditText Reasondit=findViewById(R.id.ReasonEdit);
        String number = Numberdit.getText().toString();
        String name = Namedit.getText().toString();
        String college = Collegedit.getText().toString();
        String type=typedit.getSelectedItem().toString();
        String wentplace=WentPlacedit.getText().toString();
        String scanplace=ScanPlacedit.getSelectedItem().toString();
        String reason=Reasondit.getText().toString();
        editor.putString( "number",number );
        editor.putString( "name",name );
        editor.putString( "college",college );
        editor.putString("type",type);
        editor.putString("wentplace",wentplace);
        editor.putString("scanplace",scanplace);
        editor.putString("reason",reason);
        editor.commit();

        Context context = getApplicationContext();
        CharSequence text = "已保存。正在切换页面。";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent alldonebanner=new Intent(this,ConfirmActivity.class);
        int exifcode=0;
        alldonebanner.putExtra("exifcode",exifcode);
        startActivity(alldonebanner);

        finish();
    }
}