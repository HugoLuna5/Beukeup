package lunainc.org.beukeup.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

import lunainc.org.beukeup.R;
import lunainc.org.beukeup.utils.ChildAnimationExample;

public class ResultActivity extends AppCompatActivity  implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{

    private ActionBar actionBar;
    private String skin;
    private String nodeOrVar;
    private String style;
    private SliderLayout mDemoSlider;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Resultado");

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        LinearLayout cont = (LinearLayout) findViewById(R.id.content);
        if (getIntent().getStringExtra("skin").toString() != null &&
                getIntent().getStringExtra("nodeorvar").toString() != null &&
                getIntent().getStringExtra("style").toString() != null) {

            skin = getIntent().getStringExtra("skin").toString();
            nodeOrVar = getIntent().getStringExtra("nodeorvar").toString();
            style = getIntent().getStringExtra("style").toString();

        } else {
            Toast.makeText(this, "Ocurrio un error, intentalo más tarde", Toast.LENGTH_SHORT).show();
            Log.d("ErrorData", "Se perdieron loas datos al cambiar de pantalla ");
            finish();
        }


        /**
         * Arreglo de imagenes
         */

        HashMap<String, String> file_maps = new HashMap<String, String>();



        /**
         * Comprobar tipo de piel
         */

        //piel
        if (skin.equalsIgnoreCase("blanca")) {//en caso de ser de piel blanca


            //tipo
            if (nodeOrVar.equalsIgnoreCase("variado")) {//en caso de piel blanca y ser variado


                //estilo
                if (style.equalsIgnoreCase("formal")) {//en caso de piel blanca, ser variado y formal
                    Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();

                    String imagen1 = "http://lunainc.com.mx/Beukeup/images/1/1.jpg";
                    String imagen2 = "http://lunainc.com.mx/Beukeup/images/1/1-1.jpg";
                    String imagen3 = "http://lunainc.com.mx/Beukeup/images/1/1-2.jpg";
                    String imagen4 = "http://lunainc.com.mx/Beukeup/images/1/1-3.jpg";
                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);
                    file_maps.put("Imagen 4", imagen4);

                } else {//en caso de piel blanca, ser variado y casual
                    Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                    String imagen1 = "http://lunainc.com.mx/Beukeup/images/2/2.jpg";
                    String imagen2 = "http://lunainc.com.mx/Beukeup/images/2/2-1.jpg";
                    String imagen3 = "http://lunainc.com.mx/Beukeup/images/2/2-3.jpg";
                    String imagen4 = "http://lunainc.com.mx/Beukeup/images/2/2-4.jpg";
                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);
                    file_maps.put("Imagen 4", imagen4);
                }


            } else {//en caso de piel blanca y ser nudes

                if (style.equalsIgnoreCase("formal")) {//en caso de piel blanca, ser nudes y formal
                    Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();

                    String imagen1="http://lunainc.com.mx/Beukeup/images/3/3.jpg";
                    String imagen2="http://lunainc.com.mx/Beukeup/images/3/3-1.jpg";
                    String imagen3="http://lunainc.com.mx/Beukeup/images/3/3-2.jpg";
                    String imagen4="http://lunainc.com.mx/Beukeup/images/3/3-3.jpg";
                    String imagen5="http://lunainc.com.mx/Beukeup/images/3/3-4.jpg";
                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);
                    file_maps.put("Imagen 4", imagen4);
                    file_maps.put("Imagen 5", imagen5);


                } else {//en caso de piel blanca, ser nudes y casual
                    Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                    String imagen1="http://lunainc.com.mx/Beukeup/images/4/4.jpg";
                    String imagen2="http://lunainc.com.mx/Beukeup/images/4/4-1.jpg";
                    String imagen3="http://lunainc.com.mx/Beukeup/images/4/4-2.jpg";
                    String imagen4="http://lunainc.com.mx/Beukeup/images/4/4-3.jpg";

                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);
                    file_maps.put("Imagen 4", imagen4);
                }


            }


        } else if (skin.equalsIgnoreCase("media")) {//en caso de ser de piel media

            //tipo
            if (nodeOrVar.equalsIgnoreCase("variado")) {//en caso de piel media y ser variado


                //estilo
                if (style.equalsIgnoreCase("formal")) {//en caso de piel media, ser variado y formal
                    Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                    String imagen1="http://lunainc.com.mx/Beukeup/images/5/5.jpg";
                    String imagen2="http://lunainc.com.mx/Beukeup/images/5/5-2.jpg";
                    String imagen3="http://lunainc.com.mx/Beukeup/images/5/5-3.jpg";
                    String imagen4="http://lunainc.com.mx/Beukeup/images/5/5-4.jpg";

                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);
                    file_maps.put("Imagen 4", imagen4);
                } else {//en caso de piel media, ser variado y casual
                    Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
                    String imagen1="http://lunainc.com.mx/Beukeup/images/6/6.jpg";
                    String imagen2="http://lunainc.com.mx/Beukeup/images/6/6-1.jpg";
                    String imagen3="http://lunainc.com.mx/Beukeup/images/6/6-2.jpg";
                    String imagen4="http://lunainc.com.mx/Beukeup/images/6/6-3.jpg";


                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);
                    file_maps.put("Imagen 4", imagen4);
                }


            } else {//en caso de piel media y ser nudes

                if (style.equalsIgnoreCase("formal")) {//en caso de piel media, ser nudes y formal
                    Toast.makeText(this, "7", Toast.LENGTH_SHORT).show();
                    String imagen1="http://lunainc.com.mx/Beukeup/images/7/7.jpg";
                    String imagen2="http://lunainc.com.mx/Beukeup/images/7/7-1.jpg";
                    String imagen3="http://lunainc.com.mx/Beukeup/images/7/7-2.jpg";
                    String imagen4="http://lunainc.com.mx/Beukeup/images/7/7-3.jpg";
                    String imagen5="http://lunainc.com.mx/Beukeup/images/7/7-4.jpg";
                    String imagen6="http://lunainc.com.mx/Beukeup/images/7/7-5.jpg";


                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);
                    file_maps.put("Imagen 4", imagen4);
                    file_maps.put("Imagen 5", imagen5);
                    file_maps.put("Imagen 6", imagen6);



                } else {//en caso de piel media, ser nudes y casual
                    Toast.makeText(this, "8", Toast.LENGTH_SHORT).show();
                    String imagen1="http://lunainc.com.mx/Beukeup/images/8/8.jpg";
                    String imagen2="http://lunainc.com.mx/Beukeup/images/8/8-1.jpg";
                    String imagen3="http://lunainc.com.mx/Beukeup/images/8/8-2.jpg";
                    String imagen4="http://lunainc.com.mx/Beukeup/images/8/8-3.jpg";

                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);
                    file_maps.put("Imagen 4", imagen4);


                }


            }


        } else {//en caso de ser de piel oscura


            //tipo
            if (nodeOrVar.equalsIgnoreCase("variado")) {//en caso de piel oscura y ser variado


                //estilo
                if (style.equalsIgnoreCase("formal")) {//en caso de piel oscura, ser variado y formal
                    Toast.makeText(this, "9", Toast.LENGTH_SHORT).show();


                    String imagen1="http://lunainc.com.mx/Beukeup/images/9/9.jpg";
                    String imagen2="http://lunainc.com.mx/Beukeup/images/9/9-1.jpg";
                    String imagen3="http://lunainc.com.mx/Beukeup/images/9/9-2.jpg";


                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);



                } else {//en caso de piel oscura, ser variado y casual
                    Toast.makeText(this, "10", Toast.LENGTH_SHORT).show();


                    String imagen1="http://lunainc.com.mx/Beukeup/images/10/10.jpg";
                    String imagen2="http://lunainc.com.mx/Beukeup/images/10/10-1.jpg";
                    String imagen3="http://lunainc.com.mx/Beukeup/images/10/10-2.jpg";


                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);



                }


            } else {//en caso de piel oscura y ser nudes

                if (style.equalsIgnoreCase("formal")) {//en caso de piel oscura, ser nudes y formal
                    Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();

                    String imagen1="http://lunainc.com.mx/Beukeup/images/11/11.jpg";
                    String imagen2="http://lunainc.com.mx/Beukeup/images/11/11-1.jpg";
                    String imagen3="http://lunainc.com.mx/Beukeup/images/11/11-2.jpg";


                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);



                } else {//en caso de piel oscura, ser nudes y casual
                    Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();

                    String imagen1="http://lunainc.com.mx/Beukeup/images/12/12.jpg";
                    String imagen2="http://lunainc.com.mx/Beukeup/images/12/12-1.jpg";
                    String imagen3="http://lunainc.com.mx/Beukeup/images/12/12-2.jpg";
                    String imagen4="http://lunainc.com.mx/Beukeup/images/12/12-2.jpg";
                    String imagen5="http://lunainc.com.mx/Beukeup/images/12/12-2.jpg";
                    String imagen6="http://lunainc.com.mx/Beukeup/images/12/12-2.jpg";


                    file_maps.put("Imagen", imagen1);
                    file_maps.put("Imagen 2", imagen2);
                    file_maps.put("Imagen 3", imagen3);
                    file_maps.put("Imagen 4", imagen4);
                    file_maps.put("Imagen 5", imagen5);
                    file_maps.put("Imagen 6", imagen6);



                }


            }


        }


        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(ResultActivity.this);
            // initialize a SliderLayout
            textSliderView
                    // .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(ResultActivity.this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);

        }


        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new ChildAnimationExample());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);

        DocumentView documentView = new DocumentView(ResultActivity.this, DocumentView.PLAIN_TEXT);  // Support plain text
        documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
        documentView.getDocumentLayoutParams().setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
        documentView.getDocumentLayoutParams().setInsetPaddingLeft(30f);
        documentView.getDocumentLayoutParams().setInsetPaddingRight(30f);
        documentView.getDocumentLayoutParams().setTextTypeface(Typeface.SANS_SERIF);
        documentView.setText(getResources().getString(R.string.description));

        LinearLayout linearLayout = new LinearLayout(ResultActivity.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.addView(documentView);

        cont.addView(linearLayout);


    }


    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}


    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
