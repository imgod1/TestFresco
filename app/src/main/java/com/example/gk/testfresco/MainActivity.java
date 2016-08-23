package com.example.gk.testfresco;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView simple_img;
    private SimpleDraweeView img_test;
    private SimpleDraweeView img_test1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        //最简单
        simple_img = (SimpleDraweeView) findViewById(R.id.simple_img);
        simple_img.setImageURI(Uri.parse("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1209/17/c1/13902609_1347861942068.jpg"));
        //DraweeController
        img_test = (SimpleDraweeView) findViewById(R.id.img_test);
        DraweeController draweeController = Fresco.newDraweeControllerBuilder().setUri("http://a.hiphotos.baidu.com/zhidao/pic/item/5366d0160924ab18fffea7dd31fae6cd7a890b6b.jpg").build();
        img_test.setController(draweeController);
        //DraweeController 加 监听
        img_test1 = (SimpleDraweeView) findViewById(R.id.img_test1);
        DraweeController draweeController1 = Fresco.newDraweeControllerBuilder().setUri("http://a.hiphotos.baidu.com/zhidao/pic/item/5366d0160924ab18fffea7dd31fae6cd7a890b6b.jpg").setControllerListener(new ControllerListener<ImageInfo>() {
            @Override
            public void onSubmit(String id, Object callerContext) {

            }

            //加载完成
            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                Log.e("test", "onFinalImageSet");
            }

            //渐进
            @Override
            public void onIntermediateImageSet(String id, ImageInfo imageInfo) {
                Log.e("test", "onIntermediateImageSet");
            }

            @Override
            public void onIntermediateImageFailed(String id, Throwable throwable) {

            }

            //加载失败
            @Override
            public void onFailure(String id, Throwable throwable) {
                Log.e("test", "onFailure");
            }

            @Override
            public void onRelease(String id) {

            }
        }).build();
        img_test1.setController(draweeController1);
    }
}
