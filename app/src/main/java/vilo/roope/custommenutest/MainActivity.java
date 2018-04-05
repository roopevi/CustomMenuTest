package vilo.roope.custommenutest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import vilo.roope.custommenutest.Widgets.MenuItem;
import vilo.roope.custommenutest.Widgets.CustomMenuAdapter;

public class MainActivity extends AppCompatActivity implements CustomMenuAdapter.ItemClickListener {

    RecyclerView recyclerView;
    List<Object> items;
    CustomMenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();

        items.add("Section One");
        items.add(new MenuItem("First", "this is activity one", "ONE", FirstActivity.class));
        items.add(new MenuItem("Second", "this is activity two", "ONE", SecondActivity.class));
        items.add("Section Two");
        items.add(new MenuItem("Third", "this is activity three", "TWO", ThirdActivity.class));

        recyclerView = (RecyclerView) findViewById(R.id.menu_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter = new CustomMenuAdapter(this, items);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {

        MenuItem menuItem = (MenuItem) items.get(position);
        if (menuItem instanceof MenuItem) {
            Intent intent = new Intent(getApplicationContext(), menuItem.getActivity());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
