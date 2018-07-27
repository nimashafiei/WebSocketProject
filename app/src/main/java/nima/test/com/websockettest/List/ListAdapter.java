package nima.test.com.websockettest.List;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import Tools.ListItems;
import nima.test.com.websockettest.R;
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private static  final  String TAG = "ListAdapter";
    private List<ListItems> items;
    private Context context;

    public ListAdapter(List<ListItems> Items){
        this.items = Items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View conteView = inflater.inflate(R.layout.row_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(conteView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItems item = items.get(position);

        holder.title.setText(item.getTitle());

        Log.e(TAG, item.getTitle());
        Log.e(TAG, item.getImgUrl());

        Picasso.get().load(context.getResources().getString(R.string.baseURL ) + item.getImgUrl())
                .placeholder(R.drawable.ic_menu_camera)
                .error(R.drawable.ic_menu_gallery)
                .resize(100 , 100)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.list_title);
            img = (ImageView) itemView.findViewById(R.id.list_img);


        }
    }
}
