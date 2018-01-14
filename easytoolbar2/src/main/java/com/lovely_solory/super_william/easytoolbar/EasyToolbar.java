package com.lovely_solory.super_william.easytoolbar;


import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import java.lang.reflect.Method;


/**
 * Created by Administrator on 2018/1/14.
 */

public class EasyToolbar {
    //非静态变量
    private Toolbar toolbar;
    //私有构造方法
    private EasyToolbar(Toolbar toolbar){
        this.toolbar=toolbar;

        toolbar.setFitsSystemWindows(true);
    }
    //静态方法
    //带返回值的静态方法，返回一个当前类的实例，并给非静态变量赋值
    @NonNull
    public static EasyToolbar findToolbarById(AppCompatActivity activity, int toolbarId){
        Toolbar tb= activity.findViewById(toolbarId);
        return new EasyToolbar(tb);
    }
    //setTitle
    public void setTitle(@StringRes int resId){
        toolbar.setTitle(resId);
    }
    public void setTitle(CharSequence title){
        toolbar.setTitle(title);
    }
    //setSubtitle
    public void setSubtitle(CharSequence title){
        toolbar.setSubtitle(title);
    }
    public void setSubtitle(@StringRes int resId){
        toolbar.setSubtitle(resId);
    }
    //setLogo
    public void setLogo(@DrawableRes int resId) {
        toolbar.setLogo(resId);
    }
    public void setLogo(Drawable drawable){
        toolbar.setLogo(drawable);
    }
    //inflateMenu
    public void inflateMenu(@MenuRes int resId) {
        toolbar.inflateMenu(resId);
    }
    //setNavigationIcon
    public void setNavigationIcon(@DrawableRes int resId){
        toolbar.setNavigationIcon(resId);
    }
    public void setNavigationIcon(@Nullable Drawable icon){
        toolbar.setNavigationIcon(icon);
    }
    //setTitleTextColor
    public void setTitleTextColor(@ColorInt int color) {
        toolbar.setTitleTextColor(color);
    }
    //setSubtitleTextColor
    public void setSubtitleTextColor(@ColorInt int color) {
        toolbar.setSubtitleTextColor(color);
    }
    //让菜单不会遮挡拓展按钮
    public void cancelOverlapAnchor(boolean cancel) {
        if (cancel){
            Menu menu = toolbar.getMenu();
            if (toolbar.getMenu().getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")) {
                try {
                    @SuppressLint("PrivateApi") Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //navigationListener
    public void setNavigationOnClickListener(View.OnClickListener listener){
        toolbar.setNavigationOnClickListener(listener);
    }
    //setOnMenuItemClickListener
    public void setOnMenuItemClickListener(Toolbar.OnMenuItemClickListener listener){
        toolbar.setOnMenuItemClickListener(listener);
    }
    //设置Popup风格
    public void setPopopTheme(@StyleRes int resId){
        toolbar.setPopupTheme(resId);
    }
}
