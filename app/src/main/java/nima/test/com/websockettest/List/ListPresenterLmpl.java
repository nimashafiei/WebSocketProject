package nima.test.com.websockettest.List;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import Tools.ListItems;

public class ListPresenterLmpl implements ListPresenter, ListIntractor.ListStateListiner {

    private static final String TAG = "Presenter";
    private ListIntractor mIntractor;
    private ListView view;

    public ListPresenterLmpl( ListView listView, ListIntractor intractor){
        this.mIntractor = intractor;
        this.view = listView;
    }


    @Override
    public void onSuccess(ArrayList<ListItems> listItems) {
        ListAdapter adp = new ListAdapter(listItems);
        view.fillList(adp);
    }

    @Override
    public void onError() {
        Log.e("Error", "Error");
    }

    @Override
    public void getData(Context context) {
        Log.e(TAG,"Callit");
        mIntractor.getData(context, this);
    }
}
