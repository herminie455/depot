package com.example.hphilippe_di_tp3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GalerieImages extends AppCompatActivity {

    private int STORAGE_PERMISSION_CODE = 23;
    private String idVignettes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallerie_images);

        LinearLayout vignettesGalerie = findViewById(R.id.linearVignettes);
        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 1; i < 21; i++) {
            View view = inflater.inflate(R.layout.vignettes_layout, vignettesGalerie, false);

            final ImageView imageView = view.findViewById(R.id.vignettesImageView);

            imageView.setId(i);

            String stringPath = String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));

            Bitmap myBitmap = BitmapFactory.decodeFile(stringPath + String.valueOf("/tp2_image" + i + ".jpg"));
            imageView.setImageBitmap(myBitmap);
            vignettesGalerie.addView(view);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MediaPlayer mp;
                    mp = MediaPlayer.create(view.getContext(), R.raw.navigationson);
                    mp.start();

                    idVignettes = String.valueOf(view.getId());
                    String myMsg1 = "/tp2_image" + idVignettes + ".jpg";

                    Bundle bundle = new Bundle();
                    bundle.putString("message1", myMsg1);

                    createFragment(bundle);
                }
            });
        }

        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, STORAGE_PERMISSION_CODE);
    }

    /*
    public void CreateToast(Object message){
        Context context = getApplicationContext();
        Toast.makeText(context, String.valueOf(message), Toast.LENGTH_LONG).show();
    }
     */

    public void checkPermission(String permission, int requestCode) {

        if (ContextCompat.checkSelfPermission(GalerieImages.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(GalerieImages.this, new String[]{permission}, requestCode);
        }
        /*else
        {
            CreateToast("Permission déjà accordée");
        }
         */
    }

    public void createFragment(Bundle bundle){

        Fragment fragPhoto = new PhotoFragment();
        fragPhoto.setArguments(bundle);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frameVignettes, fragPhoto);
        ft.commit();
    }

    public String getMyIdVignette(){
        return idVignettes;
    }
}