package com.lsk.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import view.SoftInputJustLayout;

public class MainActivity extends Activity implements SoftInputJustLayout.OnSizeChangedListener {
    private LinearLayout ll_bg;
    private EditText edt1, edt2, edt3;
    SoftInputJustLayout sl;
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContentView(R.layout.activity_main);
        initView();
        sl.setOnSizeChangedListener(this);

    }

    private void initView() {
        ll_bg = (LinearLayout) findViewById(R.id.ll_main_login);
        edt2 = (EditText) findViewById(R.id.edt2);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt3 = (EditText) findViewById(R.id.edt3);
        sl = (SoftInputJustLayout) findViewById(R.id.softinputlyout_main);
        btn= (Button) findViewById(R.id.btn);
    }


    @Override
    public void onSizeChange(boolean isChanged) {
        if (isChanged) {
sl.setPadding(0,-btn.getMeasuredHeight()*2,0,0);//最好的做法是用scrollview将字 view包起来，然后当isChanged=true时滑动到底部
        }else{
            sl.setPadding(0,0,0,0);

        }
    }
}
