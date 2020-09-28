package com.example.puzzle_m08uf2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.puzzle_m08uf2.layout.PuzzleLayout;
import com.example.puzzle_m08uf2.views.PuzzleView;

public class PuzzleActivity extends AppCompatActivity implements Runnable, View.OnTouchListener  {

    private PuzzleView mPuzzleView;
    private PuzzleLayout puzzleLayout;
    int squareRootNum = 3;
    ImageView ivTips;
    Bitmap IMG = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        Intent intent = getIntent();
        IMG = intent.getParcelableExtra("bmIMG");

        puzzleLayout = (PuzzleLayout) findViewById(R.id.activity_swipe_card);
        puzzleLayout.setImage(IMG, squareRootNum);
        puzzleLayout.setOnCompleteCallback(new PuzzleLayout.OnCompleteCallback() {
            @Override
            public void onComplete() {

                puzzleLayout.postDelayed(PuzzleActivity.this, 800);
            }
        });



    }

    @Override
    public void run() {
        squareRootNum++;
        if(squareRootNum > 2){
            showDialog();
        }else {
            ivTips.setImageBitmap(IMG);
            puzzleLayout.setImage(IMG, squareRootNum);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                ivTips.setVisibility(View.VISIBLE);
                break;
            default:
                ivTips.setVisibility(View.GONE);
        }
        return true;
    }

    private void showDialog() {
        new AlertDialog.Builder(PuzzleActivity.this)
                .setTitle(R.string.TituloGanar)
                .setMessage(R.string.DescGanar)
                .setPositiveButton(R.string.OK,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).show();
    }

}
