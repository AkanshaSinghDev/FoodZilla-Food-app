package com.example.dell.loginandsignup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Menu_Actitivity extends AppCompatActivity  implements  Callback{
    int counter = 0;


    Callback callback;
    RecyclerView recyclerView;
    Product product;
    adapter adapter;
    ArrayList<Product> productsList = new ArrayList<>();
    ArrayList<Product>  selectedList = null;
    private int total_price;

    Button button;
    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__actitivity);
        textView1 = (TextView) findViewById(R.id.count);
        textView2 = (TextView) findViewById(R.id.totalcost);
        button = (Button) findViewById(R.id.confirm);

        recyclerView = findViewById(R.id.rview);

        setItems();
        adapterCall();
        //getcount();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    yes();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void adapterCall(){
        adapter = new adapter(Menu_Actitivity.this, productsList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Menu_Actitivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void yes(/*View view*/) {
        //String price=String.valueOf(finalPrice);//
        //String count=String.valueOf(counter);//
        //textView1.setText("Total price is"+price);//
        // textView2.setText("Total count is"+count);//

        textView1.setText(String.valueOf(counter));
        textView2.setText(String.valueOf(total_price));

    }
    //int counter=0;//
    //int price=0;//

    private void getcount() {
        int price=0;
        for (int i = 0; i < selectedList.size(); i++) {
            Product product = selectedList.get(i);
           if(product.getSelection())
           {
               counter=i+1;
               price=price+Integer.parseInt(product.getPrice());
           }
        }
        total_price=price;
    }
    private void setItems() {
        product = new Product(R.drawable.pizza, "Pizza", "Veg Stuffed Pan", "300", false);
        productsList.add(product);

        product = new Product(R.drawable.burger, "Burger", "Veg Cheese Burger", "180", false);
        productsList.add(product);

        product = new Product(R.drawable.virginmojito, "Mojito", "Virgin Mint Mojito", "160", false);
        productsList.add(product);

        product = new Product(R.drawable.spaghetti, "Spaghetti", "Spaghetti With Penne Pasta", "320", false);
        productsList.add(product);

        product = new Product(R.drawable.sandwich, "Sandwich", "Paneer Sandwich", "140", false);
        productsList.add(product);

        product = new Product(R.drawable.frenchfries, "French Fries", "French Fries", "100", false);
        productsList.add(product);

        product = new Product(R.drawable.soup, "Soup", "Veg Sweet Corn Soup", "170", false);
        productsList.add(product);

        product = new Product(R.drawable.rice, "Rice Bowl", "Schezwan Rice Bowl", "220", false);
        productsList.add(product);

        product = new Product(R.drawable.muffin, "Muffin", "Blueberry Muffin", "100", false);
        productsList.add(product);

        product = new Product(R.drawable.salad, "Salad", "Vegetable Salad With Italian Seasoning", "120", false);
        productsList.add(product);

        product = new Product(R.drawable.doughnut, "Doughnut", "Strawberry-Frosted Doughnut", "300", false);
        productsList.add(product);




    }


    @Override
    public void onCallBack(ArrayList<Product> arrayList) {
        selectedList=new ArrayList<>();
        selectedList=arrayList;
        getcount();

    }
}
