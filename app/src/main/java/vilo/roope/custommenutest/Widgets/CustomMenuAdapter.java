package vilo.roope.custommenutest.Widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vilo.roope.custommenutest.R;

public class CustomMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> menuItems;
    private LayoutInflater inflater;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private ItemClickListener clickListener;

    public CustomMenuAdapter(Context context, List<Object> menuItems) {
        this.inflater = LayoutInflater.from(context);
        this.menuItems = menuItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {
            View layoutView = inflater.inflate(R.layout.menu_header, parent, false);
            return new HeaderViewHolder(layoutView);
        }
        else if (viewType == TYPE_ITEM) {
            View layoutView = inflater.inflate(R.layout.menu_card, parent, false);
            return new ItemViewHolder(layoutView);
        }

        throw new RuntimeException("No match for " + viewType + ".");

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {

            case TYPE_HEADER:
                HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
                configureHeaderViewHolder(headerHolder, position);
                break;
            case TYPE_ITEM:
                ItemViewHolder itemHolder = (ItemViewHolder) holder;
                configureItemViewHolder(itemHolder, position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (menuItems.get(position) instanceof String) {
            return TYPE_HEADER;
        } else if (menuItems.get(position) instanceof MenuItem) {
            return TYPE_ITEM;
        }

        return -1;
    }

    private void configureHeaderViewHolder(HeaderViewHolder holder, int position) {

        holder.headerText.setText(menuItems.get(position).toString());
    }

    private void configureItemViewHolder(ItemViewHolder holder, int position) {

        MenuItem menuItem = (MenuItem) menuItems.get(position);
        if (menuItem != null) {
            holder.title.setText(menuItem.getName());
            holder.description.setText(menuItem.getDescription());
        }
    }


    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        public TextView headerText;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            headerText = (TextView) itemView.findViewById(R.id.category_header);
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title;
        public TextView description;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            if (clickListener != null) {
                clickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setClickListener(ItemClickListener listener){
        this.clickListener = listener;
    }
}
