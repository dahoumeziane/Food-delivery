package com.dahou.fooddelivery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dahou.fooddelivery.Adapter.DishHorizontalAdapter;
import com.dahou.fooddelivery.Adapter.DishVerticalAdapter;
import com.dahou.fooddelivery.model.DishModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView notif,searchBtn;
    EditText searchField;
    Button cancel;
    TextView header;
    Boolean searchClicked = false;
    ImageView home_icon , cart_icon , add_icon;
    TextView home_text , cart_text,addTxt;
    ArrayList<BottomBarElement> Elements ;
    TextView filterBtn ;
    RecyclerView dishList,verticalDishList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializationOfFields();
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!searchClicked){
                    searchField.setVisibility(View.VISIBLE);
                    cancel.setVisibility(View.VISIBLE);
                    notif.setVisibility(View.GONE);
                    searchClicked= true;
                }else {
                    header.setText(searchField.getText().toString());
                    //Your search logic here

                }

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchField.setVisibility(View.INVISIBLE);
                cancel.setVisibility(View.GONE);
                notif.setVisibility(View.VISIBLE);
                searchField.setText("");
                header.setText("Explore our\nDelicious Offers");
                searchClicked = false;
            }
        });

        searchBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        for (int i=0 ; i<Elements.size();i++){
            int currentElement = i;
            Elements.get(i).getIcon().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Elements.get(currentElement).getIcon().setColorFilter(getColor(R.color.orange));
                    Elements.get(currentElement).getTxt().setTextColor(getColor(R.color.orange));
                    for (int j=0;j<Elements.size();j++){
                        if (j!=currentElement){
                            Elements.get(j).getIcon().setColorFilter(getColor(R.color.grey));
                            Elements.get(j).getTxt().setTextColor(getColor(R.color.grey));
                        }
                    }
                }
            });
        }


        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder filterDialog = new AlertDialog.Builder(MainActivity.this);
                filterDialog.setTitle("Choose an option");
                String [] choices = new String[]{"Price","Place","Ingredients","Sea food","Indian food","chineese food"
                ,"Korean food"};
                filterDialog.setSingleChoiceItems(choices, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        Toast.makeText(MainActivity.this,choices[position], Toast.LENGTH_SHORT).show();

                    }
                });
                filterDialog.setPositiveButton("Filter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Apply your filter logic
                        dialogInterface.dismiss();
                    }
                });
                filterDialog.show();

            }
        });

        //Recycler view binding

        //Creation of data
        ArrayList<DishModel> dishes = new ArrayList<>(6);
        dishes.add(new DishModel("Royal food court","Chinese , Indian food","100-2 south Manchester City avenue",R.drawable.food1,true));
        dishes.add(new DishModel("Tasty spot","Germaan , Indian food","1028-2 south Manchester City avenue",R.drawable.food2,false));
        dishes.add(new DishModel("Royal food court","Chinese , Indian food","100-2 south Manchester City avenue",R.drawable.food3,false));
        dishes.add(new DishModel("Sea food","Chinese , Indian food","100-2 south Manchester City avenue",R.drawable.food4,true));
        dishes.add(new DishModel("Pizza mega","Chinese , Indian food","100-2 south Manchester City avenue",R.drawable.food6,true));
        dishes.add(new DishModel("Fakhitas double","Algerian , Indian food","100-2 south Manchester City avenue",R.drawable.food7,true));

        // Adapter init
        DishHorizontalAdapter adapter = new DishHorizontalAdapter(MainActivity.this,dishes);

        dishList.setAdapter(adapter);

        //Layout manager (how the list appears)
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.HORIZONTAL);

        dishList.setLayoutManager(manager);


        //Second List binding

        DishVerticalAdapter adapter2 = new DishVerticalAdapter(MainActivity.this,dishes);
        verticalDishList.setAdapter(adapter2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);

       // GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        verticalDishList.setLayoutManager(layoutManager);





    }

    @Override
    public void onBackPressed() {

        Dialog confirmationDialog = new Dialog(MainActivity.this);
        confirmationDialog.setCanceledOnTouchOutside(false);
        confirmationDialog.setContentView(R.layout.customised_dialog);
        confirmationDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        confirmationDialog.show();
        Button confirmBtn = confirmationDialog.findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.super.onBackPressed();
            }
        });
        Button no = confirmationDialog.findViewById(R.id.cancelBtn);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmationDialog.dismiss();
            }
        });

        /*AlertDialog.Builder exitDialog = new AlertDialog.Builder(MainActivity.this);
        exitDialog.setTitle("Confirmation message");
        exitDialog.setMessage("Do you really want to exit ?");
        exitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });
        exitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        exitDialog.show();*/
    }

    public void InitializationOfFields(){
         notif = findViewById(R.id.notificationBtn);
         searchBtn = findViewById(R.id.searchBtn);
         searchField = findViewById(R.id.searchField);
         cancel = findViewById(R.id.cancelBtn);
         header = findViewById(R.id.header);
         Elements = new ArrayList<>(5);
         home_icon = findViewById(R.id.home_icon);
         cart_icon = findViewById(R.id.cart_icon);
         home_text = findViewById(R.id.home_text);
         cart_text = findViewById(R.id.cart_text);
         add_icon= findViewById(R.id.add_icon);
         addTxt=findViewById(R.id.addTxt);
         Elements.add(new BottomBarElement(home_icon,home_text));
         Elements.add(new BottomBarElement(cart_icon,cart_text));
         Elements.add(new BottomBarElement(add_icon,addTxt));
         dishList= findViewById(R.id.dish_list);
         filterBtn=findViewById(R.id.filterBtn);
         verticalDishList=findViewById(R.id.dish_list_vertical);

    }


}
