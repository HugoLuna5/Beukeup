package lunainc.org.beukeup.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.sdsmdg.tastytoast.TastyToast;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import lunainc.org.beukeup.ui.ResultActivity;
import lunainc.org.beukeup.R;

/**
 * Created by HugoLuna on 17/12/17.
 */

public class HomeFragment extends Fragment {

    public HomeFragment(){}

    private  NiceSpinner skin;
    private  NiceSpinner nodeOrVar;
    private  NiceSpinner style;
    private BootstrapButton btnAction;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

         skin = (NiceSpinner) v.findViewById(R.id.type_skin);
         nodeOrVar = (NiceSpinner) v.findViewById(R.id.type_2);
         style = (NiceSpinner) v.findViewById(R.id.type_style);
        btnAction = (BootstrapButton) v.findViewById(R.id.action) ;

        /**
         * Data for skin
         */
        List<String> datasetSkin = new LinkedList<>(Arrays.asList("Tipo de piel","Blanca", "Media", "Oscura"));
        skin.attachDataSource(datasetSkin);

        /**
         * Data for nodeOrVar
         */
        List<String> datasetNodeOrVar = new LinkedList<>(Arrays.asList("Color","Variado", "Nudes"));
        nodeOrVar.attachDataSource(datasetNodeOrVar);


        /**
         * Data for style
         */
        List<String> datasetStyle = new LinkedList<>(Arrays.asList("Evento","Formal", "Casual"));
        style.attachDataSource(datasetStyle);



        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data1 = skin.getText().toString();
                String data2 = nodeOrVar.getText().toString();
                String data3 = style.getText().toString();

                if (!data1.equalsIgnoreCase("tipo de piel") && !data2.equalsIgnoreCase("color")
                        && !data3.equalsIgnoreCase("evento")){


                Intent Style = new Intent(getActivity(), ResultActivity.class);
                Style.putExtra("skin",data1);
                Style.putExtra("nodeorvar",data2);
                Style.putExtra("style",data3);
                startActivity(Style);
                }else {
                    TastyToast.makeText(getActivity(),"Elige una opcón correcta",TastyToast.DEFAULT,TastyToast.WARNING);
                }
            }
        });

        return v;
    }



}
