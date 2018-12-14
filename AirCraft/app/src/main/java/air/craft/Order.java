package air.craft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Order extends AppCompatActivity {

    private JsonArrayRequest rqpesawat;
    private RequestQueue requestQueue;
    private List<modelpesawat> modelpesawatList;
    private RecyclerView recyclerView;
    private PesawatAdapter pesawatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        recyclerView = findViewById(R.id.listmodel);
        modelpesawatList = new ArrayList<>();
        getSupportActionBar().setTitle("Order Pesawat");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pesawatrequest();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void pesawatrequest() {
        String url = "http://192.168.43.243:1337/modelpesawats";
        rqpesawat = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                final int length = response.length();
                for (int i = 0; i < length; i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        modelpesawat pesawat = new modelpesawat();
                        pesawat.setNamapesawat(jsonObject.getString("namapesawat"));
                        pesawat.setHarga(jsonObject.getString("harga"));
                        pesawat.setDeskripsi(jsonObject.getString("deskripsi"));
                        pesawat.setDesigner(jsonObject.getString("designer"));
                        pesawat.setKodepesawat(jsonObject.getString("kodepesawat"));
                        String gmbr = jsonObject.getJSONObject("gambar").getString("url");
                        pesawat.setGambar("http://192.168.43.243:1337"+gmbr);
                        modelpesawatList.add(pesawat);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setupview(modelpesawatList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(rqpesawat);
    }
    private void setupview(List<modelpesawat> modelpesawatList){
        pesawatAdapter = new PesawatAdapter(this,modelpesawatList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(pesawatAdapter);
    }
}
