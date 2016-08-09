package com.zawmyohtet.lothone.utility;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import com.zawmyohtet.lothone.R;

import mm.technomation.mmtext.MMTextView;

/**
 * @author zawmyohtet
 * @since 8/9/16
 */

public class ProgressDialog {

    private static final String TAG = "ProgressDialog";

    private Dialog dialog;
    private MMTextView txvMessage;

    public void show(Context context){
        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_progress);
        txvMessage = (MMTextView) dialog.findViewById(R.id.txv_loading_msg);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void setTxvMessage(String text){
        txvMessage.setMyanmarText(text);
    }

    public void dismiss(){
        dialog.dismiss();
    }

}
