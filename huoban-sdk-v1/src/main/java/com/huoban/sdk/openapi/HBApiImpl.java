package com.huoban.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.huoban.sdk.ApiConstants;
import com.huoban.sdk.OpenType;

/**
 * 调用伙伴云表格的工具类
 */
public class HBApiImpl implements IHBApi {

    public static final String HB_SCHEMA = "openapp.huobanandroid://yunbiaoge";
    private Context context;
    static HBApiImpl instance;

    public HBApiImpl(Context context) {
        this.context = context;
    }

    public static HBApiImpl getInstance(Context context) {
        if (instance == null) {
            instance = new HBApiImpl(context);
        }
        return instance;
    }

    @Override
    public void openSpaceWithId(String spaceId) {
        Intent intent = getIntent();
        intent.putExtra(ApiConstants.PARAM_KEY_SPACE_ID,spaceId);
        intent.putExtra(ApiConstants.PARAM_KEY_OPEN_TYPE, OpenType.OPEN_SPACE.type);
        context.startActivity(intent);
    }

    @NonNull
    private Intent getIntent() {
        return new Intent(Intent.ACTION_VIEW, getUri());
    }

    private Uri getUri() {
        return Uri.parse(HB_SCHEMA);
    }

    @Override
    public void openTableWithId(String tableId) {
        Intent intent = getIntent();
        intent.putExtra(ApiConstants.PARAM_KEY_TABLE_ID,tableId);
        intent.putExtra(ApiConstants.PARAM_KEY_OPEN_TYPE, OpenType.OPEN_TABLE.type);
        context.startActivity(intent);
    }

    @Override
    public void openItemWithId(String itemId) {
        Intent intent = getIntent();
        intent.putExtra(ApiConstants.PARAM_KEY_ITEM_ID,itemId);
        intent.putExtra(ApiConstants.PARAM_KEY_OPEN_TYPE, OpenType.OPEN_ITEM.type);
        context.startActivity(intent);
    }

    @Override
    public boolean openAppWithHBTableMessage(String message) {
        Intent intent = getIntent();
        intent.putExtra(ApiConstants.PARAM_KEY_TABLE_WITH_MESSAGE_ID,message);
        intent.putExtra(ApiConstants.PARAM_KEY_OPEN_TYPE, OpenType.OPEN_APP_WITH_TABLE_MESSAGE.type);
        context.startActivity(intent);
        return false;
    }

    @Override
    public boolean isHBTableAppInstalled() {
        if (context == null) {
            throw new IllegalStateException("HBApiImpl has been detached.");
        }
        try {
            context.getPackageManager().getPackageInfo("com.huoban", PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }

    }
}
