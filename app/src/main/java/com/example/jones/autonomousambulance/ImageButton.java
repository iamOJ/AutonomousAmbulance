package com.example.jones.autonomousambulance;

import java.util.ArrayList;

/**
 * Created by jones on 3/3/17.
 */

public class ImageButton {
    private String mSrcname;
    private String mText;

    public ImageButton(String srcname,String text) {
        mSrcname = srcname;
        mText = text;
    }

    public String getmText(){
        return mText;
    }

    public String getmSrcname(){
        return mSrcname;
    }

    public static ArrayList<ImageButton> createImageList() {
        ArrayList<ImageButton> imageButtons = new ArrayList<>();
        imageButtons.add(new ImageButton("accident","Accident"));
        imageButtons.add(new ImageButton("fire","Fire"));
        imageButtons.add(new ImageButton("earthquake","Disaster"));
        imageButtons.add(new ImageButton("stroke","Stroke"));
        imageButtons.add(new ImageButton("harassment","Harassment"));

        return imageButtons;
    }

}
