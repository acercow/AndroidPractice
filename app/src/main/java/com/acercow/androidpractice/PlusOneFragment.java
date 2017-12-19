package com.acercow.androidpractice;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.acercow.androidpractice.gesture.AndroidBug;
import com.google.android.gms.plus.PlusOneButton;

import static com.acercow.androidpractice.R.id.et;

/**
 * A fragment with a Google +1 button.
 */
public class PlusOneFragment extends android.app.Fragment {

    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    private PlusOneButton mPlusOneButton;
    private InputMethodManager mInputMethodManager;
    private EditText mEt;


    public PlusOneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);

        //Find the +1 button
        mPlusOneButton = (PlusOneButton) view.findViewById(R.id.plus_one_button);
        mEt = (EditText) view.findViewById(R.id.et_frag);
        new AndroidBug(getActivity(), null, mEt);
        view.findViewById(R.id.et_frag).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showKeyboard();
            }
        });


        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
        mPlusOneButton.initialize(PLUS_ONE_URL, PLUS_ONE_REQUEST_CODE);
    }
    public void showKeyboard() {
        if (mInputMethodManager == null) {
            mInputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        }
        mInputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//        mEt.requestFocus();
//        mInputMethodManager.showSoftInput(mEt, 0); // 默认chatedit隐藏的 所以传过去也获取不到焦点
    }

}
