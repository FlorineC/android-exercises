package fcercle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private final List<Book> books;
    private final LayoutInflater inflater;
    private ListFragment.OnBookClickedListener listener;

    BookAdapter(LayoutInflater from, List<Book> books, ListFragment.OnBookClickedListener listener) {
        this.books = books;
        this.inflater = from;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(this.inflater.inflate(R.layout.book_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Book book = books.get(position);
        BookItemView itemView = (BookItemView) holder.itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNext(book);

            }
        });
        itemView.bindView(book);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        MyViewHolder(View itemView) {
            super(itemView);
        }
    }


}