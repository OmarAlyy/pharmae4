package com.ekadsoft.pharmae4.Images.imagePicker;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Base64;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ekadsoft.pharmae4.Images.ImageSelectActivity;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class Camera {

    public static Uri fileUri;
    public static final int CAMERA_REQUEST = 1888;
    public static final int GALLERY_REQUEST = 100;




    public static void showGallery(final Activity activity) {



        Intent intent = new Intent (activity, ImageSelectActivity.class);
        intent.putExtra (ImageSelectActivity.FLAG_COMPRESS, true);//default is true
        intent.putExtra (ImageSelectActivity.FLAG_CAMERA, true);//default is true
        intent.putExtra (ImageSelectActivity.FLAG_GALLERY, true);//default is true
        intent.putExtra (ImageSelectActivity.FLAG_CROP, false);//default is false
        activity.startActivityForResult (intent, GALLERY_REQUEST);
    }


    public static void showGalleryFromFragment(final Fragment activity) {

        Intent intent = new Intent (activity.getContext (), ImageSelectActivity.class);
        intent.putExtra (ImageSelectActivity.FLAG_COMPRESS, true);//default is true
        intent.putExtra (ImageSelectActivity.FLAG_CAMERA, true);//default is true
        intent.putExtra (ImageSelectActivity.FLAG_GALLERY, true);//default is true
        intent.putExtra (ImageSelectActivity.FLAG_CROP, false);//default is false
        activity.startActivityForResult (intent, GALLERY_REQUEST);
    }

    public static void captureImageFromFragment(Fragment activity) {
        Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity (activity.getActivity ().getPackageManager ()) != null) {
            ContentValues values = new ContentValues (1);
            values.put (MediaStore.Images.Media.MIME_TYPE, "image/jpg");
            fileUri = activity.getActivity ().getContentResolver ().insert (MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

            intent.putExtra (MediaStore.EXTRA_OUTPUT, fileUri);
            intent.addFlags (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            activity.startActivityForResult (intent, CAMERA_REQUEST);

        } else {
            Toast.makeText (activity.getActivity (), "error_no_camera", Toast.LENGTH_LONG).show ();
        }
    }


    public static String convertUrlToBase64(final String image_url) {
        String path = "";
        try {
            Bitmap bitmap = new AsyncTask<Void, Void, Bitmap> () {
                @Override
                protected Bitmap doInBackground(Void... params) {
                    try {
                        return Picasso.get ().load (image_url)
                                .get ();
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                    return null;
                }
            }.execute ().get ();

            bitmap = Bitmap.createScaledBitmap (bitmap, 350, 350, true);
            path = Camera.convert (bitmap);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } catch (ExecutionException e) {
            e.printStackTrace ();
        }
        return path;
    }


    public static String convert(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream ();
        bitmap.compress (Bitmap.CompressFormat.PNG, 100, outputStream);
        return Base64.encodeToString (outputStream.toByteArray (), Base64.NO_WRAP).replace ("\n\t", "");
    }

    @SuppressWarnings("deprecation")
    public static String getPath(Activity activity, Uri selectedImaeUri) {
        String[] projection = {MediaStore.Images.Media.DATA};

        Cursor cursor = activity.managedQuery (selectedImaeUri, projection, null, null,
                null);

        if (cursor != null) {
            cursor.moveToFirst ();

            int columnIndex = cursor.getColumnIndexOrThrow (MediaStore.Images.Media.DATA);

            return cursor.getString (columnIndex);
        }

        return selectedImaeUri.getPath ();
    }

    public static void captureImage(Activity activity) {
        Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity (activity.getPackageManager ()) != null) {
            ContentValues values = new ContentValues (1);
            values.put (MediaStore.Images.Media.MIME_TYPE, "image/jpg");
            fileUri = activity.getContentResolver ().insert (MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

            intent.putExtra (MediaStore.EXTRA_OUTPUT, fileUri);
            intent.addFlags (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            activity.startActivityForResult (intent, CAMERA_REQUEST);

        } else {
            Toast.makeText (activity, "error_no_camera", Toast.LENGTH_LONG).show ();
        }
    }


    public static Bitmap decodeUri(Activity activity, Uri selectedImage) throws FileNotFoundException {
        BitmapFactory.Options o = new BitmapFactory.Options ();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream (activity.getContentResolver ()
                .openInputStream (selectedImage), null, o);
        final int REQUIRED_SIZE = 72;
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options ();
        o2.inSampleSize = scale;
        Bitmap bitmap = BitmapFactory.decodeStream (activity.getContentResolver ()
                .openInputStream (selectedImage), null, o2);
        return bitmap;
    }


    public static File getFilePic(Bitmap bitmap, Activity activity) {
        String photo = MediaStore.Images.Media.insertImage (activity.getContentResolver (), bitmap, "Title", null);
        Uri tempUri = Uri.parse (photo);
        File finalFile = new File (getRealPathFromURI (tempUri, activity));
        return finalFile;
    }


    public static String getRealPathFromURI(Uri uri, Activity activity) {
        String path = "";
        if (activity.getContentResolver () != null) {
            Cursor cursor = activity.getContentResolver ().query (uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst ();
                int idx = cursor.getColumnIndex (MediaStore.Images.ImageColumns.DATA);
                path = cursor.getString (idx);
                cursor.close ();
            }
        }
        return path;
    }

}
