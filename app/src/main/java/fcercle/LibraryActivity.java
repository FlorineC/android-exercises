package fcercle;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class LibraryActivity extends AppCompatActivity implements ListFragment.OnBookClickedListener {

    private Book book = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerFrameLayout, new ListFragment(), ListFragment.class.getSimpleName())
                .commit();

        if(savedInstanceState != null && !isPortrait(getApplicationContext())){
            this.book = savedInstanceState.getParcelable("BOOK");
            findBookInformations();
        }
    }

    @Override
    public void onNext(Book book) {
        this.book = book;
        findBookInformations();
    }

    void findBookInformations() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("BOOK", this.book);
        DetailsFragment fragmentDetails = new DetailsFragment();
        fragmentDetails.setArguments(bundle);

        if (isPortrait(getApplicationContext())) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.containerFrameLayout, fragmentDetails, DetailsFragment.class.getSimpleName())
                    .addToBackStack("details")
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detailsFrameLayout, fragmentDetails, DetailsFragment.class.getSimpleName())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_library, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Check if device is in portrait mode
    public static boolean isPortrait(Context context) {
        return context.getResources().getBoolean(R.bool.is_portrait);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("BOOK", this.book);
    }


}
