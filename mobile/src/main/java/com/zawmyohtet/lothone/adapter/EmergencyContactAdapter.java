package com.zawmyohtet.lothone.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zawmyohtet.lothone.R;
import com.zawmyohtet.lothone.model.EmergencyContact;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zawmyohtet
 * @since 8/8/16
 */

public class EmergencyContactAdapter extends RecyclerView.Adapter<EmergencyContactAdapter.ViewHolder> {

    private static final String TAG = "EmergencyContactAdapter";

    private List<EmergencyContact> emergencyContactList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txv_emergency_name)
        TextView txvEmergencyName;
        @BindView(R.id.txv_emergency_number)
        TextView txvEmergencyNumber;
        @BindView(R.id.txv_emergency_address)
        TextView txvEmergencyAddress;
        @BindView(R.id.iv_call)
        ImageView ivCall;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }

    public EmergencyContactAdapter(List<EmergencyContact> emergencyContactList) {
        this.emergencyContactList = emergencyContactList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_emergercy_contact_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txvEmergencyName.setText(emergencyContactList.get(position).getName());
        holder.txvEmergencyNumber.setText(emergencyContactList.get(position).getContactNumber());
        holder.txvEmergencyAddress.setText(emergencyContactList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return emergencyContactList.size();
    }
}
