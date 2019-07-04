package github.dinosu.mock.dog.view;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import github.dinosu.mock.dog.R;
import github.dinosu.mock.dog.domain.DomainAdapter;

class HomeView {
    final private View rootView;
    final private DomainAdapter adapter;
    final private List<String> data = new ArrayList();
    final private GridLayoutManager gridLayoutManager;
    final private RecyclerView recyclerView;

    public HomeView(LayoutInflater inflater, ViewGroup container) {
        adapter = new DomainAdapter(data);

        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // RecyclerView
        int initPosition = 0;
        gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.scrollToPosition(initPosition);
        recyclerView.setAdapter(adapter);
    }

    public View getRooView() {
        return rootView;
    }

    private Context getContext() {
        return rootView.getContext();
    }

    public void setData(List<String> imageUrls) {
        data.clear();

        Iterator<String> iterator = imageUrls.iterator();
        while (iterator.hasNext()) {
            data.add(iterator.next());
        }

        adapter.notifyDataSetChanged();
    }

    public void snackbar(String message, int duration) {
        Snackbar.make(recyclerView, message, duration).show();
    }
}
