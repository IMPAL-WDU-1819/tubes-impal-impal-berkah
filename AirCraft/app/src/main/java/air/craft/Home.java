package air.craft;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;

import java.util.List;


public class Home extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);

        Button order = v.findViewById(R.id.order);
        Button lihat = v.findViewById(R.id.lihatorder);

        order.setOnClickListener((View.OnClickListener)this);
        lihat.setOnClickListener((View.OnClickListener)this);

        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order:
                Intent intent = new Intent(getContext(),Order.class);
                startActivity(intent);
                break;
            case R.id.lihatorder:
                Intent intent1 = new Intent(getContext(),Orderan.class);
                startActivity(intent1);
                break;
        }
    }

}
