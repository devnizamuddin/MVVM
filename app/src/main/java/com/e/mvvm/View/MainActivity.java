package com.e.mvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.mvvm.Adapter.UserAdapter;
import com.e.mvvm.Model.User;
import com.e.mvvm.R;
import com.e.mvvm.ViewModel.MainActivityViewModel;
import com.e.mvvm.ViewModel.MyViewModelFactory;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    EditText one_et, two_et;
    Button plus_btn;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       MainActivityViewModel mainActivityViewModel = new ViewModelProvider(this,new MyViewModelFactory(this.getApplication())).get(MainActivityViewModel.class);

       mainActivityViewModel.getAllUserData().observe(MainActivity.this, new Observer<User[]>() {
           @Override
           public void onChanged(User[] users) {

               recyclerView.setAdapter(new UserAdapter(users));
           }
       });

    }
}