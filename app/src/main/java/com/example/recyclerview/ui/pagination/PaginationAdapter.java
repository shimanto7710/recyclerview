package com.example.recyclerview.ui.pagination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.recyclerview.R;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class PaginationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<PaginationModel> rootList;
    private static final int LOADING = 0;
    private static final int ITEM = 1;
    private boolean isLoadingAdded = false;


    public PaginationAdapter(Context context) {
        this.context = context;
        rootList = new LinkedList<>();

    }


    public void setMovieList(List<PaginationModel> orderList) {
        this.rootList = orderList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                View viewItem = inflater.inflate(R.layout.item_simple_vertical, parent, false);
                viewHolder = new OrderListViewHolder(viewItem);
                break;
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.item_progress, parent, false);
                viewHolder = new LoadingViewHolder(viewLoading);
                break;
        }
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        PaginationModel orderListModel = rootList.get(position);


        switch (getItemViewType(position)) {
            case ITEM:

//                OrderListViewHolder orderListViewHolder = (OrderListViewHolder) holder;
//                orderListViewHolder.txtInvoice.setText(orderListModel.getParcelCode().toString());

                break;

            case LOADING:
                LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
                loadingViewHolder.progressBar.setVisibility(View.VISIBLE);
                break;
        }

    }



    @Override
    public int getItemCount() {
        return rootList == null ? 0 : rootList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == rootList.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new PaginationModel());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = rootList.size() - 1;
        PaginationModel result = getItem(position);

        if (result != null) {
            rootList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void add(PaginationModel orderListModel) {
        rootList.add(orderListModel);
        notifyItemInserted(rootList.size() - 1);
    }

    public void addAll(List<PaginationModel> moveResults) {
        for (PaginationModel result : moveResults) {
            add(result);
        }
    }

    public void removeAll() {
        rootList.removeAll(rootList);
        notifyDataSetChanged();
    }

    public void removeItem(PaginationModel orderModel) {
        rootList.remove(orderModel);
        notifyDataSetChanged();
    }

    public PaginationModel getItem(int position) {
        return rootList.get(position);
    }


    public class OrderListViewHolder extends RecyclerView.ViewHolder {

        private TextView txtInvoice, txtInvoiceDate, txtUserName, txtUserPhone, txtShippingFrom, txtShippingCost, txtShippingTime, txtPayment, txtPrice, txtStatus;
//        private Button btnView;
        Spinner spin;

        public OrderListViewHolder(View itemView) {
            super(itemView);
//            txtInvoice = (TextView) itemView.findViewById(R.id.txtParcelCode);

        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {

        private ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.loadmore_progress);

        }
    }


}
