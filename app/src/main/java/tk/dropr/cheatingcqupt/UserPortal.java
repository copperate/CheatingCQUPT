package tk.dropr.cheatingcqupt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
        TextView numView=findViewById(R.id.NumberEdit);
        TextView nameView=findViewById(R.id.NameEdit);
        TextView colView=findViewById(R.id.CollegeEdit);
        numView.setText(number);
        nameView.setText(name);
        colView.setText(college);
    }
public void saveUserConfig(View view)
{
    SharedPreferences.Editor editor = UserConfig.edit();
    EditText Namedit = (EditText) findViewById(R.id.NameEdit);
    EditText Numberdit = (EditText) findViewById(R.id.NumberEdit);
    EditText Collegedit = (EditText) findViewById(R.id.CollegeEdit);
    String number = Numberdit.getText().toString();
    String name = Namedit.getText().toString();
    String college = Collegedit.getText().toString();
    editor.putString( "number",number );
    editor.putString( "name",name );
    editor.putString( "college",college );
    editor.commit();
}
public void randomUser(View view)
{
    Context context = getApplicationContext();
    CharSequence text = "唯有保存配置之后，随机才会生效。";
    int duration = Toast.LENGTH_SHORT;
    Toast toast = Toast.makeText(context, text, duration);
    toast.show();

}
}