package github.dinosu.mock.dog.domain;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import github.dinosu.mock.dog.R;
import github.dinosu.mock.dog.view.SquaredImageView;

public class DomainAdapter extends RecyclerView.Adapter<DomainAdapter.ViewHolder> {
    final private List<String> imageUrls;
    private Context context;

    public DomainAdapter(List<String> list) {
        imageUrls = list;
    }

    @Override
    public DomainAdapter.ViewHolder onCreateViewHolder(ViewGroup container, int viewType) {
        this.context = container.getContext();

        View playlistView = LayoutInflater.from(container.getContext())
                .inflate(R.layout.item_image, container, false);

        return new ViewHolder(playlistView);
    }

    @Override
    public void onBindViewHolder(DomainAdapter.ViewHolder viewHolder, final int position) {
        String url = imageUrls.get(position);

        if (url != null) {
            Picasso.get().load(url).resize(1000, 1000).centerCrop().into(viewHolder.imgView);
        }
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SquaredImageView imgView;

        public ViewHolder(View itemView) {
            super(itemView);

            imgView = (SquaredImageView) itemView.findViewById(R.id.image);
        }
    }
}
