package com.library.apple.qrcode;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    Button button1;
    EditText editText;
    ImageView imageView;
    String text1;
//    String text2="Raj";
//    String text3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.btn_qr);
        editText = (EditText)findViewById(R.id.et_qr);
        imageView = (ImageView)findViewById(R.id.img_qr);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1 = editText.getText().toString().trim();
//                text3=text1.concat(" "+text2);
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(text1, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    imageView.setImageBitmap(bitmap );
                } catch (WriterException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}
