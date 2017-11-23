package com.erfenchazhaodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int srcArray[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        binSearch(srcArray,23);

        getIndex(srcArray,32);


        Log.e("TAG",""+(srcArray.length-1)+"========="+binSearch(srcArray,23));
        Log.e("TAG",""+(srcArray.length-1)+"========="+getIndex(srcArray,32));




    }

    private int getIndex(int[] srcArray, int value) {
        int max = srcArray.length - 1;
        int min = 0;
        int mid = (max + min) / 2;
        while (srcArray[mid] != value) {
            if (srcArray[mid] > value) {
                max = mid - 1;
            } else if (srcArray[mid] < value) {
                min = mid + 1;
            }
            if (min > max) {
                return -1;
            }
            mid = (max + min) / 2;
        }
        return mid;
    }



    public static int binSearch(int srcArray[],int key){
        int mid = srcArray.length / 2;
        if (key==srcArray[mid]){
            return mid;
        }

        int start=0;
        int end=srcArray.length-1;
        while (start<=end){
            mid=(end-start)/2+start;
            if (key<srcArray[mid]){
                end=mid-1;
            }else if (key>srcArray[mid]){
                start=mid+1;
            }else {
                return mid;
            }
        }

        return -1;
    }

}
