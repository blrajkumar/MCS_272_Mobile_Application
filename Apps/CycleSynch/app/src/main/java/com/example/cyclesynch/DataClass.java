package com.example.cyclesynch;

public class DataClass {
    String Image_Url;

    public DataClass(String Image_Url)
    {
        this.Image_Url = Image_Url;
    }

    public String getImage_Url(){
        return Image_Url;
    }

    public void setImage_Url(String image_Url){
        Image_Url = image_Url;
    }
}
