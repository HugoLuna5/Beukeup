package lunainc.org.beukeup.ui;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import lunainc.org.beukeup.R;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);


        TextView app = (TextView) findViewById(R.id.app);
        TextView version = (TextView) findViewById(R.id.vesion);



        String versionName = "";
        int versionCode = -1;
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            versionName = packageInfo.versionName;
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        version.setText(String.format("Nombre de Vesrión = %s \nVersion de codigo = %d", versionName, versionCode));
        app.setTypeface(EasyFonts.robotoBold(this));
    }
}
