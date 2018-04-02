package v.com.apidemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import v.com.apidemo.Adapter.DataAdapter;
import v.com.apidemo.DataModel.Data;
import v.com.apidemo.Retrofit.ApiClient;
import v.com.apidemo.Retrofit.ApiInterface;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ApiInterface apiInterface;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    public void getData(){
        showProgress("Loading...");

        apiInterface.getPosts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Data>>() {
                    @Override
                    public void accept(List<Data> data) throws Exception {
                        recyclerView.setAdapter(new DataAdapter(data));
                        hideProgress();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        hideProgress();
                        throwable.printStackTrace();
                        Log.e("Error",throwable.getMessage());
                    }
                });

    }

    public void showProgress(String message){
        progressDialog = ProgressDialog.show(this,message,"Please Wait",true);
    }

    public void hideProgress(){
        if (progressDialog!=null&&progressDialog.isShowing())
            progressDialog.dismiss();
    }

}
