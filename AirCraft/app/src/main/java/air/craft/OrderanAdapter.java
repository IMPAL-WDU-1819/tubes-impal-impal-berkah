package air.craft;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class OrderanAdapter extends RecyclerView.Adapter<OrderanAdapter.MyViewHolder>  {

    private Context context;
    private List<modelorderan> data;
    RequestOptions option;

    public OrderanAdapter(Context context, List<modelorderan> data) {
        this.context = context;
        this.data = data;

        option =new RequestOptions().centerCrop().placeholder(R.drawable.blue).error(R.drawable.blue);
    }


    @NonNull
    @Override
    public OrderanAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.orderanlist,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderanAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.nama.setText(data.get(i).getNamapesawat());
        myViewHolder.status.setText(data.get(i).getProgress());
        Glide.with(context).load(data.get(i).getGambar()).apply(option).into(myViewHolder.url);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nama,status;
        ImageView url;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.nama2);
            status = itemView.findViewById(R.id.progress);
            url = itemView.findViewById(R.id.gambar2);
        }
    }
}
