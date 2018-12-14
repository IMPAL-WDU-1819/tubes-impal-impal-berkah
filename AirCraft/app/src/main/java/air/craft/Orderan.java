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

public class Orderan extends AppCompatActivity {

    private JsonArrayRequest rqpesawat;
    private RequestQueue requestQueue;
    private List<modelorderan> modelorderanslist;
    private RecyclerView recyclerView;
    private OrderanAdapter orderanAdapter;
    private user user1 = user.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderan);

        recyclerView = findViewById(R.id.orderanlist);

        modelorderanslist = new ArrayList<>();
        getSupportActionBar().setTitle("Lihat Orderan");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        orderanreq();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void orderanreq() {
        String url = "http://192.168.43.243:1337/orderans";
        rqpesawat = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                final int length = response.length();
                for (int i = 0; i < length; i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        modelorderan modelorderan1 = new modelorderan();
                        modelorderan1.setNamapesawat(jsonObject.getString("namapesawat"));
                        modelorderan1.setGambar(jsonObject.getString("gambar"));
                        modelorderan1.setProgress(jsonObject.getString("Progress"));
                        if (user1.getEmail().equalsIgnoreCase(jsonObject.getString("Pembeli"))){
                            modelorderanslist.add(modelorderan1);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setupview(modelorderanslist);
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
    private void setupview(List<modelorderan> modelorderanslist){
        orderanAdapter = new OrderanAdapter(this,modelorderanslist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(orderanAdapter);
    }
}
