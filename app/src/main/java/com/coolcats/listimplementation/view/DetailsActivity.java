package com.coolcats.listimplementation.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.coolcats.listimplementation.R;
import com.coolcats.listimplementation.databinding.ActivityDetailsBinding;
import com.coolcats.listimplementation.model.Fruit;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Fruit fruit = getIntent().getParcelableExtra("fruit");

        if(fruit != null){
            Glide.with(this)
                    .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
                    .load(fruit.getImage())
                    .into(binding.imageView);
            binding.fruitDetailsTextview.setText(fruit.getName());

        }
    }
}