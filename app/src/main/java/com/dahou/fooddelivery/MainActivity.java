package com.dahou.fooddelivery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
    ImageView food;
    TextView filterBtn ;

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
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("data","Passed data from the main activity");
                startActivity(i);
            }
        });

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

        ConstraintLayout firstDish = findViewById(R.id.firstDish);
        firstDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);

            }
        });



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
         food=findViewById(R.id.foodImage);

         filterBtn=findViewById(R.id.filterBtn);

    }


}