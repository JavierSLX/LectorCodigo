package com.morpheus.lectorcodigo;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class Lector extends Activity implements ZBarScannerView.ResultHandler
{
    private ZBarScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        scannerView = new ZBarScannerView(this);
        setContentView(scannerView);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result)
    {
        String codigo = result.getContents();
        Log.i("resultado", codigo);
        Log.i("tipo", result.getBarcodeFormat().getName());

        scannerView.resumeCameraPreview(this);

        //Agrega el codigo al intent para seguir con el proceso
        Intent intent = getIntent();
        intent.putExtra("CODIGO", codigo);
        setResult(RESULT_OK, intent);
        finish();
    }
}
