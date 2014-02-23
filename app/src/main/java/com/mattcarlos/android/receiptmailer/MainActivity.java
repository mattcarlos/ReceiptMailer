package com.mattcarlos.android.receiptmailer;

import java.io.File;

import com.googlecode.leptonica.android.ReadFile;
import com.googlecode.tesseract.android.TessBaseAPI;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.R;

//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.WriterException;

public class MainActivity extends Activity {
//	String emailAddress;
//	EditText emailID;
//	DatabaseHandler dbManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		emailID = (EditText) findViewById(R.id.emailID);
//		dbManager = new DatabaseHandler(this);
//		emailID.setText(getEmailAddress());
		try {
			setupButton();
		} catch (Exception e) {
			//catch the thing
			e.printStackTrace();
		}
	}

	private void setupButton() throws Exception {
		//Button to create QRCode
		Button btnClicky = (Button) findViewById(R.id.btnClick);
		btnClicky.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					tryToOpenFile();
					
//					emailAddress = emailID.getText().toString();
//					//Get email text field
//					ImageView imgDisplay = (ImageView) findViewById(R.id.imgViewDisplay);
//					//Set ImageView to bitmap returned by encodeQRImage();
//					imgDisplay.setImageBitmap(encodeQRImage(emailAddress));
//					InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//					inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//					
//					storeEmailInDB(emailAddress);
					
				} catch (Exception e) {
					//catch the thing
					e.printStackTrace();
				}
			}

			private void tryToOpenFile() {
				TextView display = (TextView) findViewById(R.id.textDisplay);
				TessBaseAPI tesseract = new TessBaseAPI();
				File imageFile = new File("/storage/sdcard0/tesseract/tessdata/ocrtest.jpg");
				tesseract.init("/storage/sdcard0/tesseract/", null);
				tesseract.setImage(imageFile);
				display.setText(tesseract.getUTF8Text() + " this part works");
			}
		});
	}

//	private String getEmailAddress() {
//		String returnString = "";
//		try {
//			returnString = dbManager.getEmail().toString();
//		} catch (Exception e) {
//			
//		}
//		return returnString;
//	}

//	private void storeEmailInDB(String emailAddress) {
//		dbManager.updateEmail(new EmailAddress(emailAddress));
//	}

//	private Bitmap encodeQRImage(String emailAddress) throws WriterException {
//		QRCodeWriter qrwriter = new QRCodeWriter();
//		BitMatrix bitMatrixReturn;
//		BarcodeFormat formatter = BarcodeFormat.QR_CODE;
//		Bitmap image;
//        int matrixWidth;
//        //Calls zxing's QRCodeWriter.encode method, which returns zxings BitMatrix format
//		bitMatrixReturn = qrwriter.encode(emailAddress, formatter, 400, 400);
//		matrixWidth = bitMatrixReturn.getWidth();
//		image = Bitmap.createBitmap(matrixWidth, matrixWidth, Bitmap.Config.RGB_565);
//		//Draws the qr code
//	    for (int x = 0; x < matrixWidth; x++){
//	        for (int y = 0; y < matrixWidth; y++){
//	            image.setPixel(x, y, bitMatrixReturn.get(x,y) ? Color.BLACK : Color.WHITE);
//	        }
//	    }
//	    return image;
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
