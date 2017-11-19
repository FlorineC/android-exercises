package fcercle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsFragment extends Fragment {

    private TextView nameTextView;
    private TextView priceTextView;
    private ImageView coverImageView;
    private TextView isbnTextView;
    private TextView synopsisTextView;
    private Book book;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);

        book = getArguments().getParcelable("BOOK");

        nameTextView = view.findViewById(R.id.nameTextView);
        priceTextView = view.findViewById(R.id.priceTextView);
        isbnTextView = view.findViewById(R.id.isbnTextView);
        synopsisTextView = view.findViewById(R.id.synopsisTextView);

        coverImageView = view.findViewById(R.id.coverImageView);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameTextView.setText(book.getTitle());
        priceTextView.setText(String.format("%s €", book.getPrice()));
        isbnTextView.setText(String.format("Isbn : %s", book.getIsbn()));
        synopsisTextView.setText(book.getSynopsisToString());

        Glide.with(view.getContext())
                .load(book.getCover())
                .into(coverImageView);
    }



}
