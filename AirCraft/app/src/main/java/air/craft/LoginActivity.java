package air.craft;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText mail,pass;
    private Button login;
    private RequestQueue requestUser;
    private JsonObjectRequest rqUser;
    private ProgressDialog dialog;
    private user user1 = user.getInstance();
    String email,password,err;
    String url = "http://192.168.43.243:1337/auth/local";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail =(EditText) findViewById(R.id.mail);
        pass =(EditText) findViewById(R.id.pass);

        login =(Button) findViewById(R.id.login);

        dialog = new ProgressDialog(LoginActivity.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mail.getText().toString().trim();
                password = pass.getText().toString().trim();
                dialog.setMessage("Please Wait ....");
                if (email.isEmpty()||password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Input Field Cannot Be Empty",Toast.LENGTH_SHORT).show();
                }else {
                    dialog.show();
                    addUser();
                }
            }
        });
    }

    public void addUser(){
        JSONObject params = new JSONObject();
        try {
            params.put("identifier",email);
            params.put("password",password);
        } catch (JSONException e){
            e.printStackTrace();
        }
        rqUser = new JsonObjectRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                user1.setEmail(email);
                startActivity(intent);
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                err = error.toString();
                new CountDownTimer(2000,1000){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(),err,Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
        requestUser = Volley.newRequestQueue(this);
        requestUser.add(rqUser);
    }
}
