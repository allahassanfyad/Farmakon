package com.application.farmakon.ScenarioFarmakon.ScenarioFAQ.Pattrens;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.application.farmakon.R;
import com.application.farmakon.ScenarioFarmakon.ScenarioFAQ.Model.FAQ_Group1_Model;
import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

public class FAQ_Group1_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int UNSELECTED = -1;

    private RecyclerView recyclerView;
    private int selectedItem = UNSELECTED;
    List<FAQ_Group1_Model> mMainList;

    public FAQ_Group1_Adapter(RecyclerView recyclerView, List<FAQ_Group1_Model> faqList) {
        this.recyclerView = recyclerView;
        this.mMainList = faqList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.faq_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        boolean isSelected = position == selectedItem;
        final FAQ_Group1_Model questions = mMainList.get(position);

        viewHolder.expandButton.setText(questions.getQuestion1());
        viewHolder.txtdiscription.setText(questions.getAnswer1());
        viewHolder.expandButton.setSelected(isSelected);
        viewHolder.expandableLayout.setExpanded(isSelected, false);


    }


    @Override
    public int getItemCount() {
        return mMainList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {
        private ExpandableLayout expandableLayout;
        private TextView expandButton, txtdiscription;
        ImageView imgfaq;

        public ViewHolder(View itemView) {
            super(itemView);

            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            expandableLayout.setInterpolator(new OvershootInterpolator());
            expandableLayout.setOnExpansionUpdateListener(this);
            expandButton = itemView.findViewById(R.id.expand_button);
            txtdiscription = itemView.findViewById(R.id.txtDescription);
            expandButton.setOnClickListener(this);
            imgfaq = itemView.findViewById(R.id.imgFaq);

        }


        @Override
        public void onClick(View view) {
            ViewHolder holder = (ViewHolder) recyclerView.findViewHolderForAdapterPosition(selectedItem);
            if (holder != null) {
                holder.expandButton.setSelected(false);
                holder.expandableLayout.collapse();


            }

            int position = getAdapterPosition();
            if (position == selectedItem) {
                selectedItem = UNSELECTED;


            } else {
                expandButton.setSelected(true);
                expandableLayout.toggle();
                selectedItem = position;

            }
        }

        @Override
        public void onExpansionUpdate(float expansionFraction, int state) {
            Log.d("ExpandableLayout", "State: " + state);
            if (state == ExpandableLayout.State.EXPANDING) {
                recyclerView.smoothScrollToPosition(getAdapterPosition());
//                imgfaq.setImageResource(R.drawable.minus);
            }else if (state== ExpandableLayout.State.COLLAPSED)
            {
                Log.e("collapesd","aaaaaaaaaa");
//                imgfaq.setImageResource(R.drawable.plus);
            }
        }
    }
}


