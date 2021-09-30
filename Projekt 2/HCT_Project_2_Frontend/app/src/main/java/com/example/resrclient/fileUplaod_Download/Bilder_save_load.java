package com.example.resrclient.fileUplaod_Download;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bilder_save_load {
    /*
    * Es gibt 4 Metoden saveImage und load ImageBitmap gehören zusammen heißt wenn ihr saveImage verwendet zum speichern müsst ihr mit loadImageBitmap das Bild wieder laden
    * die erste lösung (saveImage/LoadImageBitmap) ist recht simpel ihr übergebt den Context der Activity(Fragemnt?) sowie die Bitmap hier der Code zum erstllen einer Bitmap.
    *               try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImageUri));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
    * Wenn ihr nur ein Bild aufrufen wollt könnt ihr das mit loadImageBitmap machen dafür den Context übergeben und den Namen des Bildes daher einfacher.
    *
    * */
    //erste Lösung
    public void saveImage(Context context, Bitmap b, String imageName) {
        FileOutputStream foStream;
        try {
            foStream = context.openFileOutput(imageName, Context.MODE_PRIVATE);
            b.compress(Bitmap.CompressFormat.PNG, 100, foStream);
            foStream.close();
        } catch (Exception e) {
            Log.d("saveImage", "Exception 2, Something went wrong!");
            e.printStackTrace();
        }
    }

    public Bitmap loadImageBitmap(Context context, String imageName) {
        Bitmap bitmap = null;
        FileInputStream fiStream;
        try {
            fiStream    = context.openFileInput(imageName);
            bitmap      = BitmapFactory.decodeStream(fiStream);
            fiStream.close();
        } catch (Exception e) {
            Log.d("saveImage", "Exception 3, Something went wrong!");
            e.printStackTrace();
        }
        return bitmap;
    }

    //zweite Lösung
    private String saveToInternalStorage(Context context,Bitmap bitmapImage) throws FileNotFoundException {
        ContextWrapper cw = new ContextWrapper(context);
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        // Create imageDir
        File mypath=new File(directory,"profile.jpg");
        Log.v("SuCC", "File Absolut Path " + mypath);
        FileOutputStream fos = new FileOutputStream(mypath.getAbsolutePath());
        try {


            Log.v("SuCC", "File Output Stream" + fos.toString());
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return directory.getAbsolutePath();
    }

    private Bitmap loadImageFromStorage(String path)
    {

        Log.v("SuCC", "load Image From Storage Path 1 " + path);
        try {
            File f=new File(path, "profile.jpg");

            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            Log.v("SuCC", "load Image From Storage Path 2" + path);

            return b;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            Log.v("SuCC", "Fail");
        }
        return null;
    }

}
