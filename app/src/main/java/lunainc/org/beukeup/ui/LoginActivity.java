package lunainc.org.beukeup.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.TextAlignment;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;

import com.facebook.FacebookSdk;
import com.facebook.login.Login;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sdsmdg.tastytoast.TastyToast;


import java.util.Arrays;

import cn.refactor.library.SmoothCheckBox;
import lunainc.org.beukeup.R;

/**
 * Created by HugoLuna on 15/12/17.
 */

public class LoginActivity extends AppCompatActivity{


    CallbackManager callbackManager;

    private static final String TAG = "Error";
    private FirebaseAuth mAuth;
    private ProgressDialog Progress;
    private Button loginBtn;
    private Handler handler;
    private SmoothCheckBox terms;
    private TextView termsText;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        Progress = new ProgressDialog(this);

        loginBtn = (Button) findViewById(R.id.log_fb);
        terms = (SmoothCheckBox) findViewById(R.id.terms);
        termsText = (TextView) findViewById(R.id.termsText);

        FacebookSdk.sdkInitialize(getApplicationContext());
        handler = new Handler();
        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d("Success", "Login");
                        handleFacebookAccesToken(loginResult.getAccessToken());

                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(LoginActivity.this, "Inicio Cancelado", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(LoginActivity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


       
        
        
        //login
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (terms.isChecked()){
                    LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("email","public_profile", "user_friends","user_status"));

                }else{

                    //Toast.makeText(LoginActivity.this, "Debes aceptar los terminos y condiciones", Toast.LENGTH_SHORT).show();

                    TastyToast.makeText(getApplicationContext(), "Debes aceptar los terminos y condiciones", TastyToast.DEFAULT, TastyToast.ERROR);

                }
            }
        });


        termsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MaterialDialog dialog =
                        new MaterialDialog.Builder(LoginActivity.this)
                                .title("Terminos y Condiciones")
                                .customView(R.layout.dialog_terms, true)
                                .positiveText("Ok")
                                .build();



                LinearLayout cont = dialog.getCustomView().findViewById(R.id.content);

                DocumentView documentView = new DocumentView(cont.getContext(), DocumentView.PLAIN_TEXT);  // Support plain text
                documentView.getDocumentLayoutParams().setTextAlignment(TextAlignment.JUSTIFIED);
                documentView.getDocumentLayoutParams().setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                documentView.getDocumentLayoutParams().setInsetPaddingLeft(0f);
                documentView.getDocumentLayoutParams().setInsetPaddingRight(0f);
                documentView.getDocumentLayoutParams().setTextTypeface(Typeface.SANS_SERIF);
                documentView.setText(getResources().getString(R.string.terms));

                LinearLayout linearLayout = new LinearLayout(cont.getContext());
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.setLayoutParams(
                        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.MATCH_PARENT));
                linearLayout.addView(documentView);

                cont.addView(linearLayout);

                dialog.show();

            }
        });
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode, resultCode, data);





    }


    private void handleFacebookAccesToken(AccessToken accessToken) {
        Progress.setMessage("Espere un momento...");
        Progress.setCanceledOnTouchOutside(false);
        Progress.show();
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        mAuth.signInWithCredential(credential).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (!task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Upss ocurrio un error", Toast.LENGTH_SHORT).show();
                    Log.e("Error",task.getResult().toString());

                    Progress.dismiss();
                }else {

                    FirebaseUser user = mAuth.getCurrentUser();
                    handler.postDelayed(new Runnable() {
                        public void run() {

                            // acciones que se ejecutan tras los milisegundos
                            Intent intent = new Intent(LoginActivity.this, Navigation.class);
                            startActivity(intent);
                            finish();
                            Progress.dismiss();

                        }
                    }, 10);
                }
            }
        });
    }

    private void updateUI() {

        //Toast.makeText(this, "You're logged in", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();


        if (currentUser != null){

            updateUI();
            if (mAuth.getCurrentUser() != null) {
                startActivity(new Intent(LoginActivity.this, Navigation.class));
                finish();
            }

        }


    }


}
