package listener;

import listener.JPushIsSuccessListener.PushIsSuccessListener;
import listener.JPushIsSuccessListener.GetTagAliasIsSuccessListener;

public interface JPushListener {
    /**
     * 向所有Android用户推送
     *
     * @param msgContent 推送消息内容
     * @param listener   监听是否成功的listener
     */
    void sendMessageAll(String msgContent, PushIsSuccessListener listener);

    /**
     * 向Android设备推送消息,可以自定义Tag、Alias
     *
     * @param msgContent 推送消息内容
     * @param tag        tag
     * @param alia       alia
     * @param listener   监听是否成功的listener
     */

    void sendMessageByTagsAlias(String msgContent, String[] tag, String[] alia, PushIsSuccessListener listener);

    /**
     * 向Android设备，通过registrationId推送消息
     *
     * @param msgContent
     * @param registrationId
     * @param listener
     */
    void sendMessageByRegistrationId(String msgContent, String[] registrationId, PushIsSuccessListener listener);

    /**
     * 根据registrationId获取用户所设置的Tags、Alias
     *
     * @param registrationId registrationId
     * @param listener       监听是否成功的listener
     */
    void getTagAliasResult(String registrationId, GetTagAliasIsSuccessListener listener);

    /**
     * 关闭JPushClient进程
     */
    void closeJPushClient();
}
