package br.com.gilsouza.spellfiredeckbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.gilsouza.spellfiredeckbuilder.db.Database;

public class SearchActivity extends AppCompatActivity {
    private Database mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mdb = new Database(this);
        mdb.open();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mdb.close();
    }
}
