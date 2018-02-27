package manager;

import factory.JPushFactory;
import listener.JPushListener;
import listener.JPushIsSuccessListener.PushIsSuccessListener;
import listener.JPushIsSuccessListener.GetTagAliasIsSuccessListener;

public class JPushManager {
    private JPushListener mListener;

    private JPushManager() {

    }

    private static class Holder {
        private static final JPushManager mManager = new JPushManager();
    }

    public static JPushManager getInstance() {
        return Holder.mManager;
    }

    /**
     * 初始化JPushListener
     */
    public void initJPushListener() {
        this.mListener = JPushFactory.getInstance();
    }

    public void sendMessageAll(String msgContent, PushIsSuccessListener listener) {
        if (mListener != null) {
            mListener.sendMessageAll(msgContent, listener);
        }
    }

    /**
     * 向Android设备推送消息,可以自定义Tag、Alias
     * tag/alia 均可设置为null，当都为null时，默认向所有Android用户推送
     *
     * @param msgContent 推送消息内容
     * @param tag        tag
     * @param alia       alia
     * @param listener   监听是否成功的listener
     */
    public void sendMessageByTagsAlias(String msgContent, String[] tag, String[] alia, PushIsSuccessListener listener) {
        if (mListener != null) {
            mListener.sendMessageByTagsAlias(msgContent, tag, alia, listener);
        }
    }

    /**
     * 向Android设备，通过registrationId推送消息
     * registrationId 可设置为null，当为null时，默认向所有Android用户推送
     *
     * @param msgContent 推送消息内容
     * @param registrationId 用户的registrationId
     * @param listener 监听是否成功的listener
     */
    public void sendMessageByRegistrationId(String msgContent, String[] registrationId, PushIsSuccessListener listener) {
        if (mListener != null) {
            mListener.sendMessageByRegistrationId(msgContent, registrationId, listener);
        }
    }

    /**
     * 根据registrationId获取用户所设置的Tags、Alias
     *
     * @param registrationId 用户的registrationId
     * @param listener       监听是否成功的listener
     */
    public void getTagAliasResult(String registrationId, GetTagAliasIsSuccessListener listener) {
        if (mListener != null) {
            mListener.getTagAliasResult(registrationId, listener);
        }
    }

    /**
     * 关闭JPushClient进程
     */
    public void closeJPushClient() {
        if (mListener != null) {
            mListener.closeJPushClient();
        }
    }
}
