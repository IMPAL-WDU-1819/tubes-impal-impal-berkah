package air.craft;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class Detail extends AppCompatActivity {
    String nama,kode,harga,designer,des,gambar;
    private user user1 = user.getInstance();
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectRequest;
    String url ="http://192.168.43.243:1337/orderans";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setTitle("Detail Pesawat");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nama = getIntent().getExtras().getString("nama");
        kode = getIntent().getExtras().getString("kode");
        harga = getIntent().getExtras().getString("harga");
        designer = getIntent().getExtras().getString("designer");
        des = getIntent().getExtras().getString("des");
        gambar = getIntent().getExtras().getString("gambar");
        Button ordernow1 = findViewById(R.id.button);

        TextView nama1 = findViewById(R.id.nama2);
        TextView kode1 = findViewById(R.id.kode);
        TextView harga1 = findViewById(R.id.harga);
        TextView des1 = findViewById(R.id.deskripsi);
        TextView design1 = findViewById(R.id.design);

        ImageView gambar1 = findViewById(R.id.gambar);

        nama1.setText(nama);
        harga1.setText(harga);
        kode1.setText("( "+kode+" )");
        design1.setText("Designed by " +designer);
        des1.setText(des);

        Glide.with(this).load(gambar).into(gambar1);

        ordernow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Detail.this);

                builder.setMessage("Are you sure want to order "+nama +" ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                orderpesawat();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       int id = item.getItemId();

      if (id == android.R.id.home){
         this.finish();
      }
      return super.onOptionsItemSelected(item);
    }

    private void orderpesawat(){
        JSONObject params = new JSONObject();
        try {
            params.put("Progress","Please pay the advance 20% of price ");
            params.put("Pembeli",user1.getEmail());
            params.put("namapesawat",nama);
            params.put("gambar",gambar);
        }catch (JSONException e){
            e.printStackTrace();
        }

        jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, params, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(),"Order Success\n Please open payment info menu for payment process", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}
