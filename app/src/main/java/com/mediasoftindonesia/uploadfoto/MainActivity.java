package com.mediasoftindonesia.uploadfoto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText img_title;
    private Button chooseImg, uploadImg;
    private ImageView imageView;
    private static final int IMG_REQUEST=777;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_title=(EditText)findViewById(R.id.img_title);
        chooseImg=(Button)findViewById(R.id.chooseImg);
        uploadImg=(Button)findViewById(R.id.uploadImg);
        imageView=(ImageView)findViewById(R.id.imageView);

        chooseImg.setOnClickListener(this);
        uploadImg.setOnClickListener(this);

    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.chooseImg:
                selectImg();
                break;
            case R.id.uploadImg:
                   // uploadImage();
                break;
        }
    }

/*    private void uploadImage(){
     //   String Image= imageToString();
        Toast.makeText(getApplicationContext(),Image, Toast.LENGTH_SHORT).show();

        String Title= img_title.getText().toString();
        ApiInterface apiInterface=ApiClient.getApiClient().create(ApiInterface.class);
        Call<ImageClass> call=apiInterface.uploadImage(Title,Image);
        call.enqueue(new Callback<ImageClass>() {
            @Override
            public void onResponse(Call<ImageClass> call, Response<ImageClass> response) {
                ImageClass imageClass=response.body();
                Toast.makeText(getApplicationContext(),"Server Response"+imageClass, Toast.LENGTH_SHORT).show();
                imageView.setVisibility(View.GONE);
                img_title.setVisibility(View.GONE);
                chooseImg.setEnabled(true);
                uploadImg.setEnabled(false);
                img_title.setText("");
            }

            @Override
            public void onFailure(Call<ImageClass> call, Throwable t) {

            }
        });
    }*/

    private void selectImg(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==IMG_REQUEST && resultCode==RESULT_OK && data!=null){
            Uri path=data.getData();
            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                imageView.setImageBitmap(bitmap);
                img_title.setVisibility(View.VISIBLE);
                chooseImg.setEnabled(false);
                uploadImg.setEnabled(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
