package nima.test.com.websockettest.List;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nima.test.com.websockettest.List.ListAdapter;
import nima.test.com.websockettest.List.ListIntractorLmpl;
import nima.test.com.websockettest.List.ListPresenter;
import nima.test.com.websockettest.List.ListPresenterLmpl;
import nima.test.com.websockettest.List.ListView;
import nima.test.com.websockettest.Main.FirstFragment;
import nima.test.com.websockettest.R;

public class FragmentList extends Fragment implements ListView{

    private ListPresenter presenter;

    private OnFragmentInteractionListener mListener;

    private RecyclerView mRecyclerView;

    private View view;

    public FragmentList() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        presenter = new ListPresenterLmpl(this, new ListIntractorLmpl());
        presenter.getData(getContext());




        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void displayProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void fillList(ListAdapter items) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerView.setAdapter(items);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
