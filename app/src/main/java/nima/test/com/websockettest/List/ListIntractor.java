package nima.test.com.websockettest.List;

import android.content.Context;

import java.util.ArrayList;

import Tools.ListItems;

public interface ListIntractor {

    void getData(Context context, ListStateListiner listiner);

    public interface ListStateListiner{
        void onSuccess(ArrayList<ListItems> listItems);
        void onError();
    }
}
