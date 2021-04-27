package com.coolcats.listimplementation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.coolcats.listimplementation.R;
import com.coolcats.listimplementation.databinding.ActivityMainBinding;
import com.coolcats.listimplementation.model.Fruit;
import com.coolcats.listimplementation.view.adapter.FruitAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FruitAdapter.FruitDelegate {

    private List<Fruit> fruit = new ArrayList<>(
            Arrays.asList(
                    new Fruit("Watermelon", "https://images2.alphacoders.com/210/thumb-1920-210152.jpg", 50),
                    new Fruit("Banana","https://wallpapercave.com/wp/wp2145487.jpg", 7),
                    new Fruit("Apple", "https://images.unsplash.com/photo-1560806887-1e4cd0b6cbd6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHx8&w=1000&q=80", 12),
                    new Fruit("Mango","https://ak.picdn.net/shutterstock/videos/2866627/thumb/1.jpg", 30)
            )
    );

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //With ArrayAdapter
//        ArrayAdapter<Fruit> adapter = new ArrayAdapter<>(
//                this,
//                R.layout.fruit_item_layout,
//                R.id.fruitname_textview,
//                fruit
//        );
        //Base Adapter
        FruitAdapter adapter = new FruitAdapter(fruit, this);
        binding.mainListview.setAdapter(adapter);
    }

    @Override
    public void selectFruit(Fruit fruit) {
//        Toast.makeText(this, fruit.toString(), Toast.LENGTH_SHORT).show();
        Intent fruitIntent = new Intent(this, DetailsActivity.class);
        fruitIntent.putExtra("fruit", fruit);
        startActivity(fruitIntent);
    }
}