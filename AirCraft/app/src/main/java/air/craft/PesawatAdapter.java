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

public class PesawatAdapter extends RecyclerView.Adapter<PesawatAdapter.MyViewHolder> {

    private Context context;
    private List<modelpesawat> data;
    RequestOptions option;

    public PesawatAdapter(Context context, List<modelpesawat> data) {
        this.context = context;
        this.data = data;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.blue).error(R.drawable.blue);

    }



    @NonNull
    @Override
    public PesawatAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.orderlist,viewGroup,false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.konten_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Detail.class);
                intent.putExtra("nama",data.get(viewHolder.getAdapterPosition()).getNamapesawat());
                intent.putExtra("harga",data.get(viewHolder.getAdapterPosition()).getHarga());
                intent.putExtra("designer",data.get(viewHolder.getAdapterPosition()).getDesigner());
                intent.putExtra("kode",data.get(viewHolder.getAdapterPosition()).getKodepesawat());
                intent.putExtra("gambar",data.get(viewHolder.getAdapterPosition()).getGambar());
                intent.putExtra("des",data.get(viewHolder.getAdapterPosition()).getDeskripsi());

                context.startActivity(intent);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PesawatAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.nama.setText(data.get(i).getNamapesawat());
        myViewHolder.harga.setText(data.get(i).getHarga());
        Glide.with(context).load(data.get(i).getGambar()).apply(option).into(myViewHolder.url);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nama,harga;
        ImageView url;
        ConstraintLayout konten_view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            konten_view = itemView.findViewById(R.id.konten);
            nama = itemView.findViewById(R.id.namapesawat);
            harga = itemView.findViewById(R.id.harga);
            url = itemView.findViewById(R.id.pic);
        }
    }
}
