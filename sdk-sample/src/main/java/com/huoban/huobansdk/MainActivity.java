package com.huoban.huobansdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.huoban.sdk.openapi.HBApiImpl;

public class MainActivity extends AppCompatActivity {

    HBApiImpl hbApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        hbApi = HBApiImpl.getInstance(this);
    }

    /**
     * 打开表格详情
     *
     * @param v
     */
    public void OpenItem(View v) {
        hbApi.openItemWithId("");
    }

    /**
     * 打开工作区
     *
     * @param v
     */
    public void OpenSpace(View v) {
        hbApi.openSpaceWithId("");
    }

    /**
     * 打开表格
     *
     * @param v
     */
    public void OpenTable(View v) {
        hbApi.openTableWithId("");
    }

    /**
     * 打开app
     *
     * @param v
     */
    public void Open_app_with_table_message(View v) {
        hbApi.openAppWithHBTableMessage("");
    }


}
