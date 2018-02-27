package impl;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.device.TagAliasResult;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import listener.JPushListener;
import listener.JPushIsSuccessListener.PushIsSuccessListener;
import listener.JPushIsSuccessListener.GetTagAliasIsSuccessListener;

public class JPushImpl implements JPushListener {

    /**
     * 修改为申请的APP KEY
     */
    private static final String APP_KEY = "029af8d74f86111d19093583";
    /**
     * 修改为申请的MASTER SECRET
     */
    private static final String MASTER_SECRET = "191b74ca0f1a1ac468998042";

    /**
     * PushResult返回状态码，0为成功
     */
    private static final int SUCCESS = 0;

    private JPushClient mClient = null;

    private JPushImpl() {
        mClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());
    }

    public static JPushImpl getInstance() {
        return new JPushImpl();
    }

    public void sendMessageAll(String msgContent, PushIsSuccessListener listener) {
        try {
            PushPayload payload = buildPushObject_sendMessage(msgContent, null, null);
            PushResult result = mClient.sendPush(payload);
            if (result.statusCode == SUCCESS) {
                listener.pushSuccess(result.statusCode);
            }
        } catch (APIConnectionException e) {
            listener.connectionFailed(e);
        } catch (APIRequestException e) {
            listener.pushFailed(e);
        }
    }

    public void sendMessageByTagsAlias(String msgContent, String[] tag, String[] alia, PushIsSuccessListener listener) {
        try {
            PushPayload payload = buildPushObject_sendMessage(msgContent, tag, alia);
            PushResult result = mClient.sendPush(payload);
            if (result.statusCode == SUCCESS) {
                listener.pushSuccess(result.statusCode);
            }
        } catch (APIConnectionException e) {
            listener.connectionFailed(e);
        } catch (APIRequestException e) {
            listener.pushFailed(e);
        }
    }

    public void sendMessageByRegistrationId(String msgContent, String[] registrationId, PushIsSuccessListener listener) {
        try {
            PushPayload payload = buildPushObject_sendMessageByregistrationId(msgContent, registrationId);
            PushResult result = mClient.sendPush(payload);
            if (result.statusCode == SUCCESS) {
                listener.pushSuccess(result.statusCode);
            }
        } catch (APIConnectionException e) {
            listener.connectionFailed(e);
        } catch (APIRequestException e) {
            listener.pushFailed(e);
        }
    }

    public void getTagAliasResult(String registrationId, GetTagAliasIsSuccessListener listener) {
        try {
            TagAliasResult result = mClient.getDeviceTagAlias(registrationId);
            if (result.isResultOK()) {
                listener.getTagAliasSuccess(result);
            }
        } catch (APIConnectionException e) {
            listener.connectionFailed(e);
        } catch (APIRequestException e) {
            listener.getTagAliasFailed(e);
        }
    }

    public PushPayload buildPushObject_sendMessage(String msgContent, String[] tag, String[] alia) {
        if (tag == null && alia == null) {
            return PushPayload
                    .newBuilder()
                    .setPlatform(Platform.android())
                    .setAudience(Audience.all())
                    .setMessage(Message.newBuilder()
                            .setMsgContent(msgContent)
                            .build())
                    .build();
        } else if (tag == null && alia != null) {
            return PushPayload
                    .newBuilder()
                    .setPlatform(Platform.android())
                    .setAudience(Audience.newBuilder()
                            .addAudienceTarget(AudienceTarget.alias(alia))
                            .build())
                    .setMessage(Message.newBuilder()
                            .setMsgContent(msgContent)
                            .build())
                    .build();

        } else if (alia == null && tag != null) {
            return PushPayload
                    .newBuilder()
                    .setPlatform(Platform.android())
                    .setAudience(Audience.newBuilder()
                            .addAudienceTarget(AudienceTarget.alias(alia))
                            .build())
                    .setMessage(Message.newBuilder()
                            .setMsgContent(msgContent)
                            .build())
                    .build();
        } else {
            return PushPayload
                    .newBuilder()
                    .setPlatform(Platform.android())
                    .setAudience(Audience.newBuilder()
                            .addAudienceTarget(AudienceTarget.tag(tag))
                            .addAudienceTarget(AudienceTarget.alias(alia))
                            .build())
                    .setMessage(Message.newBuilder()
                            .setMsgContent(msgContent)
                            .build())
                    .build();
        }
    }

    public PushPayload buildPushObject_sendMessageByregistrationId(String msgContent, String[] registrationId) {
        if (registrationId == null) {
            return PushPayload
                    .newBuilder()
                    .setPlatform(Platform.android())
                    .setAudience(Audience.all())
                    .setMessage(Message.newBuilder()
                            .setMsgContent(msgContent)
                            .build())
                    .build();
        } else {
            return PushPayload
                    .newBuilder()
                    .setPlatform(Platform.android())
                    .setAudience(Audience.newBuilder()
                            .addAudienceTarget(AudienceTarget.registrationId(registrationId))
                            .build())
                    .setMessage(Message.newBuilder()
                            .setMsgContent(msgContent)
                            .build())
                    .build();
        }
    }

    /**
     * 关闭JPushClient进程
     */
    public void closeJPushClient() {
        if (mClient != null) {
            mClient.close();
        }
    }
}
