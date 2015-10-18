//AHMAD FAROOQ BIN EZHAR
//1226461
//ASSIGNMENT 8

package com.waghih.fragmentexample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


public class ToolbarFragment  extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private static int seekvalue = 10;
    private static EditText edittext;
    ToolbarListener activityCallback;

    public interface ToolbarListener {
        public void onButtonClick(int position, String text);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCallback = (ToolbarListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ToolbarListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.toolbar_fragment,
                container, false);

        edittext = (EditText) view.findViewById(R.id.editText1);
        final SeekBar seekbar =
                (SeekBar) view.findViewById(R.id.seekBar1);
        seekbar.setOnSeekBarChangeListener(this);
        final Button button =
                (Button) view.findViewById(R.id.button_text);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        return view;
    }

    public void buttonClicked (View view) {
        activityCallback.onButtonClick(seekvalue,
                edittext.getText().toString());
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        seekvalue = progress;
    }
    @Override
    public void onStartTrackingTouch(SeekBar arg0) {
// TODO Auto-generated method stub
    }
    @Override
    public void onStopTrackingTouch(SeekBar arg0) {
// TODO Auto-generated method stub
    }
}
