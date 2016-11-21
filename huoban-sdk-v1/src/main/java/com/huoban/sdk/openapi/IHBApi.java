package com.huoban.sdk.openapi;

/**
 * Created by Tata on 2016/11/18.
 */
public interface IHBApi {

    void openSpaceWithId(String spaceId);
    void openTableWithId(String tableId);
    void openItemWithId(String itemId);
    boolean openAppWithHBTableMessage(String message);
    boolean isHBTableAppInstalled();

}
