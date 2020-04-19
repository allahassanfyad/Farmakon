package com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Pattrens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentCategory.Model.Category_Model;
import com.application.farmakon.ScenarioFarmakon.ScenarioMain.Controller.UiFragments.FragmentNotification.Model.Notification_Model;
import com.application.farmakon.Utils.TinyDB;
import com.bumptech.glide.Glide;

import java.util.List;

public class RcyNotificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    TinyDB tinyDB;
    List<Notification_Model> mMainGridList;
    Context mContext;


    public RcyNotificationAdapter(List<Notification_Model> songsList, Context context) {
        this.mMainGridList = songsList;
        this.mContext = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View ads = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item,parent,false);
        MainItemHolder mainHolder = new MainItemHolder(ads) ;
        return mainHolder;
    }

    public class MainHolder extends RecyclerView.ViewHolder{
        public MainHolder(View itemview) {
            super(itemview);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        tinyDB = new TinyDB(mContext);
        int viewType = getItemViewType(position);
        final Notification_Model notification = mMainGridList.get(position);


        MainItemHolder mainHolder =(MainItemHolder) holder;


        mainHolder.texttitle.setText(notification.getTitle());
        mainHolder.textdesc.setText(notification.getDescription());
        Glide.with(mContext)
                .load(notification.getImage())
                .placeholder(R.drawable.img)
                .into(mainHolder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                tinyDB.putString("id_home",mMainGridList.get(position).getId());
//                //mContext.startActivity(new Intent(mContext, Product.class).putExtra("id_home",mMainGridList.get(position).getId()));
//                FragmentTransaction fr = ((AppCompatActivity)mContext).getSupportFragmentManager().beginTransaction();
//                fr.replace(R.id.fragment_container,new Product());
//                fr.addToBackStack(null);
//                fr.commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return mMainGridList.size();
    }


    public class MainItemHolder extends RecyclerView.ViewHolder
    {
        TextView texttitle,textdesc;
        ImageView imageView;


        public MainItemHolder(@NonNull View itemView)
        {
            super(itemView);
            texttitle = itemView.findViewById(R.id.txtNotificationTitle);
            textdesc = itemView.findViewById(R.id.txtNotificationDesc);
            imageView = itemView.findViewById(R.id.imgNotification);

        }

    }
    public interface OnItemListener {
        void onItemClick(int position);
    }


}
