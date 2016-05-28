package com.twinsunshinelauncher.twinsunshinelauncher.dialogs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.facebook.drawee.view.SimpleDraweeView;
import com.twinsunshinelauncher.twinsunshinelauncher.R;
import com.twinsunshinelauncher.twinsunshinelauncher.models.Presentation;

import java.util.HashMap;
import java.util.Map;

public class PlusOneFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static int id = 100;
    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View mPlusOneButton;
    private EditText mPresentationName;
    private SimpleDraweeView mSlide1;
    private SimpleDraweeView mSlide2;
    private SimpleDraweeView mSlide3;
    private SimpleDraweeView mSlide4;
    private SimpleDraweeView mSlide5;
    private SimpleDraweeView mSlide6;

    private Presentation mPresentation = new Presentation("" + id);

    private static final int REQUEST_CODE = 110;

    private Map<Integer, SimpleDraweeView> mImageViewMap = new HashMap<>();


    private OnFragmentInteractionListener mListener;

    public PlusOneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlusOneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlusOneFragment newInstance() {
        id = id + 1;
        PlusOneFragment fragment = new PlusOneFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);

        //Find the +1 button
        mPlusOneButton = (View) view.findViewById(R.id.plus_one_button);
        mPresentationName = (EditText) view.findViewById(R.id.presentation_name_input);

        setUpSlideButtons(view);

        return view;
    }

    private View.OnClickListener getClickListener(final int requestCodeInc) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, REQUEST_CODE + requestCodeInc);
            }
        };
    }

    private void setUpSlideButtons(View view) {
        mSlide1 = (SimpleDraweeView) view.findViewById(R.id.slide1);
        mSlide2 = (SimpleDraweeView) view.findViewById(R.id.slide2);
        mSlide3 = (SimpleDraweeView) view.findViewById(R.id.slide3);
        mSlide4 = (SimpleDraweeView) view.findViewById(R.id.slide4);
        mSlide5 = (SimpleDraweeView) view.findViewById(R.id.slide5);
        mSlide6 = (SimpleDraweeView) view.findViewById(R.id.slide6);

        mSlide1.setOnClickListener(getClickListener(1));
        mSlide2.setOnClickListener(getClickListener(2));
        mSlide3.setOnClickListener(getClickListener(3));
        mSlide4.setOnClickListener(getClickListener(4));
        mSlide5.setOnClickListener(getClickListener(5));
        mSlide6.setOnClickListener(getClickListener(6));

        mImageViewMap.put(REQUEST_CODE + 1, mSlide1);
        mImageViewMap.put(REQUEST_CODE + 2, mSlide2);
        mImageViewMap.put(REQUEST_CODE + 3, mSlide3);
        mImageViewMap.put(REQUEST_CODE + 4, mSlide4);
        mImageViewMap.put(REQUEST_CODE + 5, mSlide5);
        mImageViewMap.put(REQUEST_CODE + 6, mSlide6);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri pickedImage = data.getData();
        mPresentation.setImageUrl(requestCode - REQUEST_CODE - 1, pickedImage.toString());
        mImageViewMap.get(requestCode).setImageURI(pickedImage);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Refresh the state of the +1 button each time the activity receives focus.
        mPlusOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed();
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (mListener != null) {
            mPresentation.setName(mPresentationName.getText().toString());
            mListener.onFragmentInteraction(mPresentation);
            dismiss();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Presentation presentation);
    }

}
