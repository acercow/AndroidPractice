package com.acercow.androidpractice.viewpager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.acercow.androidpractice.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PageSlideScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PageSlideScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageSlideScreenFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "[LifeCycle]" + "[Fragment]";

    // TODO: Rename and change types of parameters
    public String mParam1;
    public String mParam2;

    public String mParamBySet;

    private OnFragmentInteractionListener mListener;
    private Context mContext;
    private boolean isFirstIn = true;

    public PageSlideScreenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PageSlideScreenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PageSlideScreenFragment newInstance(String param1, String param2) {
        PageSlideScreenFragment fragment = new PageSlideScreenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        Log.d(TAG, "onAttach :: ");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.d(TAG, "onCreate :: " + savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView :: " + savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_page_slide_screen, container, false);
        TextView tvTitle = (TextView) rootView.findViewById(R.id.tv_title);
        tvTitle.setText(mParamBySet);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onViewCreated :: " + savedInstanceState);
    }
    

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }



    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }



    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        Log.d(TAG, "onDetach");

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState :: " + outState);

    }

//    @Override
//    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
//        super.onViewStateRestored(savedInstanceState);
//        Log.d(TAG, "onViewStateRestored :: " + savedInstanceState);
//
//    }

   /* @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            Log.d(TAG, "Parent Fragment # lazyLoad()");
            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
//                    ItemFragment itemFragment = new ItemFragment();
//                    itemFragment.pos = mParam1;
                    ItemFragment itemFragment = ItemFragment.newInstance(0, mParam1);
                    itemFragment.mListener = new ItemFragment.OnListFragmentInteractionListener() {
                        @Override
                        public void onListFragmentInteraction(DummyContent.DummyItem item) {
                            Toast.makeText(mContext, "onListFragmentInteraction", Toast.LENGTH_SHORT).show();
                        }
                    };
                    if (PageSlideScreenFragment.this.isAdded()) {
                        getChildFragmentManager().beginTransaction().add(R.id.container, itemFragment).commit();
                    }
                }
            }, 1000);

        } else {

        }
    }
*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
