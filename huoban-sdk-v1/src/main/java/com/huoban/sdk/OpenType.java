package com.huoban.sdk;

/**
 * Created by Tata on 2016/11/18.
 */

public enum OpenType
{
    OPEN_SPACE("open_space"),
    OPEN_ITEM("open_item"),
    OPEN_TABLE("open_table"),
    OPEN_APP_WITH_TABLE_MESSAGE("open_app_with_table_message");

    public final String type;

    OpenType(String type) {
        this.type = type;
    }

}
