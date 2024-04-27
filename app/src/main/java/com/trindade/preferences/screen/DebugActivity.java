package com.trindade.preferences.screen;

//Android
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

//AndroidX
import androidx.appcompat.app.AppCompatActivity;

import com.trindade.preferences.screen.R;

//Google
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

//Java
//import com.trindade.gamide.classes.utils.CompileLogHelper;
import java.io.InputStream;

public class DebugActivity extends AppCompatActivity {
    
	String madeErrMsg;
   // GamIDELogger logger = new GamIDELogger();
	TextView error;
    
    String[] exceptionType = {
        "StringIndexOutOfBoundsException",
        "IndexOutOfBoundsException",
        "ArithmeticException",
        "NumberFormatException",
        "ActivityNotFoundException"
    };
    String[] errMessage = {
        "Invalid string operation\n",
        "Invalid list operation\n",
        "Invalid arithmetical operation\n",
        "Invalid toNumber block operation\n",
        "Invalid intent operation"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_debug);
		
		error = findViewById(R.id.error);
		
        Intent intent = getIntent();
        String errMsg = "";
         madeErrMsg = "";
        if (intent != null) {
            errMsg = intent.getStringExtra("error");
            String[] spilt = errMsg.split("\n");
            // errMsg = spilt[0];
            try {
                for (int j = 0; j < exceptionType.length; j++) {
                    if (spilt[0].contains(exceptionType[j])) {
                        madeErrMsg = errMessage[j];
                        int addIndex =
                                spilt[0].indexOf(exceptionType[j]) + exceptionType[j].length();
                        madeErrMsg += spilt[0].substring(addIndex, spilt[0].length());
                        break;
                    }
                }
                if (madeErrMsg.isEmpty()) madeErrMsg = errMsg;
            } catch (Exception e) {
            }
        }
      //  logger.add(madeErrMsg);
		setErrorText();
		error.setText(madeErrMsg);
        MaterialAlertDialogBuilder bld = new MaterialAlertDialogBuilder(this);
        bld.setTitle("An error occured");
        bld.setMessage(madeErrMsg);
        bld.setNeutralButton(
                "End Application",
                (d, w) -> {
                    finish();
                });
       // bld.show();
    }
	
	private void setErrorText() {
		//madeErrMsg = madeErrMsg.replaceAll("at", "---------- ERROR");
		error.setText(madeErrMsg);
		error.setTextIsSelectable(true);
		
	}
	
}
