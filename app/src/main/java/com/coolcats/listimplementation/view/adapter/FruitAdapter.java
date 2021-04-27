package com.coolcats.listimplementation.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.coolcats.listimplementation.R;
import com.coolcats.listimplementation.databinding.FruitItemLayoutBinding;
import com.coolcats.listimplementation.model.Fruit;

import java.util.List;

public class FruitAdapter extends BaseAdapter {

    private List<Fruit> fruitList;
    private FruitDelegate fruitDelegate;

    public FruitAdapter(List<Fruit> fruitList, FruitDelegate fruitDelegate) {
        this.fruitList = fruitList;
        this.fruitDelegate = fruitDelegate;
    }

    public interface FruitDelegate{
        void selectFruit(Fruit fruit);
    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Fruit getItem(int i) {
        return fruitList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //Without view binding
//        View layout = LayoutInflater.from(view.getContext()).inflate(R.layout.fruit_item_layout, viewGroup, false);
//        TextView fruitNameTV = layout.findViewById(R.id.fruitname_textview);
//        fruitNameTV.setText(fruitList.get(position).getName());
//        return layout;

        //with view binding
        FruitItemLayoutBinding binding = FruitItemLayoutBinding.inflate(LayoutInflater.from(viewGroup.getContext()),
                viewGroup,
                false);
        binding.fruitnameTextview.setText(fruitList.get(position).getName());

        Glide.with(viewGroup)
                .applyDefaultRequestOptions(RequestOptions.circleCropTransform())
                .load(fruitList.get(position).getImage())
                .placeholder(R.drawable.ic_banana)
                .into(binding.fruitImageview);

        binding.getRoot().setOnClickListener(v -> {
            fruitDelegate.selectFruit(fruitList.get(position));
        });
        return  binding.getRoot();
    }
}
