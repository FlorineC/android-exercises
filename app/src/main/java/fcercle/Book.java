package fcercle;

import android.os.Parcel;
import android.os.Parcelable;

class Book implements Parcelable {

    private String isbn;
    private String title;
    private String price;
    private String cover;
    private String[] synopsis;

    String getIsbn() {
        return isbn;
    }

    String getTitle() {
        return title;
    }

    String getPrice() {
        return price;
    }

    String getCover() {
        return cover;
    }

    String getSynopsisToString() {
        String res = "";
        for (String synopsisLine : synopsis) {
            res += synopsisLine + "\n";
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return isbn.equals(book.isbn);

    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }


    private Book(Parcel in) {
        title = in.readString();
        price = in.readString();
        cover = in.readString();
        isbn = in.readString();
        synopsis = in.createStringArray();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(price);
        dest.writeString(cover);
        dest.writeString(isbn);
        dest.writeStringArray(synopsis);
    }
}