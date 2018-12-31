package com.uniprogy.outquiz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.uniprogy.outquiz.activities.signin.LoginActivity;

import java.io.ByteArrayOutputStream;

public class LiveDuelSdk {

    private String username="", password="";
    private Context mContext;
    private int backgroundImageID=0;
    private int iconID=0;
    private String IPAdress="", sdk_key="";


    public  LiveDuelSdk(Context mContext){
        this.mContext=mContext;
    }


    public LiveDuelSdk(Context mContext, String username, String password){

        this.mContext=mContext;
        this.username=username;
        this.password=password;

        if(mContext!=null){
            Toast.makeText(mContext,username + " " + password, Toast.LENGTH_LONG ).show();

        }
    }


    public LiveDuelSdk(Context mContext, int backgroundImageID,int iconID, String base_url, String sdk_key){

        this.mContext=mContext;

        if(backgroundImageID==0){
            Toast.makeText(mContext, "Please Enter a valid Background Image", Toast.LENGTH_SHORT).show();
        }else {
            this.backgroundImageID=backgroundImageID;
        }

        if(iconID==0){
            Toast.makeText(mContext, "Please Enter a valid Icon Image", Toast.LENGTH_SHORT).show();
        }else {
            this.iconID=iconID;
        }

        if(base_url.equalsIgnoreCase("")){
            Toast.makeText(mContext, "Please Enter a valid Base Url", Toast.LENGTH_SHORT).show();
        }else {
            this.IPAdress=base_url;
        }

        if(sdk_key.equalsIgnoreCase("")){
            Toast.makeText(mContext, "Please Enter a valid SDK Key", Toast.LENGTH_SHORT).show();
        }else {
            this.sdk_key=sdk_key;
        }

    }

    public void openLiveDuelSdk(){

        if(mContext!=null && backgroundImageID!=0 && iconID!=0 && !IPAdress.equalsIgnoreCase("") && !sdk_key.equalsIgnoreCase("")){

           /* Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), drawable);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, baos);
            byte[] b = baos.toByteArray();*/

            Intent intent=new Intent(mContext,LoginActivity.class);
            intent.putExtra("backgroundImageID", backgroundImageID);
            intent.putExtra("iconID", iconID);
            intent.putExtra("IPAdress", IPAdress);
            mContext.startActivity(intent);

        }else if(mContext!=null){

            Intent intent=new Intent(mContext,LoginActivity.class);
            mContext.startActivity(intent);
        }else {

            Toast.makeText(mContext, "Sdk might not have been initialized properly.", Toast.LENGTH_SHORT).show();
        }


    }
}
