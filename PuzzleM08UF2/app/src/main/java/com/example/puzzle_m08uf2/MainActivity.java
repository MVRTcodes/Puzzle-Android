package com.example.puzzle_m08uf2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public MediaPlayer ring;
    public MediaPlayer ring2;
    private static final int PERMIS_CAMARA = 200;
    private static final int PERMIS_CAPTURA_IMATGE = 300;
    private ImageView img;
    private Button bfoto;
    private Button bplay;
    private TextView tvplay;
    private Bitmap IMGBitmap = null;
    // Número que identifica l'activitat de l'aplicació de fotos
    private static final int APP_CAMERA = 0;
    // Identificador de la imatge que crearà l'aplicació de fotos
    private Uri identificadorImatge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ring = MediaPlayer.create(MainActivity.this, R.raw.audio);
        ring2 = MediaPlayer.create(MainActivity.this, R.raw.audio);
        bplay = (Button) findViewById(R.id.bJugar);
        tvplay = (TextView) findViewById(R.id.NameEText);

        bfoto = (Button) findViewById(R.id.bFoto);
        img = (ImageView) findViewById(R.id.imageView);

        bfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMIS_CAMARA);
                    return;
                }
                fesFoto(view);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
            if (id==R.id.opcion1 && ring.isPlaying()) {
                ring.pause();
            }else {
                ring.start();
            }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ring.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        ring.release();

    }

    @Override
    protected void onRestart() {
        ring = MediaPlayer.create(MainActivity.this, R.raw.audio);
        super.onRestart();

    }

    public void IntentGoPuzzle(View v){
        if(IMGBitmap!=null) {
            Intent intent = new Intent(this, PuzzleActivity.class);
            String n1 = tvplay.getText().toString();
            intent.putExtra("nomET",n1);

            intent.putExtra("bmIMG", IMGBitmap);

            startActivity(intent);
        }
    }

    private void fesFoto(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, PERMIS_CAPTURA_IMATGE);
        }
    }

    public static Bitmap RotateBitmap(Bitmap source, float angle)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == PERMIS_CAPTURA_IMATGE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;

                IMGBitmap = imageBitmap;

                img.setImageBitmap(IMGBitmap);

            }
        }
    }
}