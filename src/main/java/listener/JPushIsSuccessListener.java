package listener;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.device.TagAliasResult;

public interface JPushIsSuccessListener {

    interface PushIsSuccessListener{
        /**
         * 推送成功
         *
         * @param statusCode 状态码
         */
        void pushSuccess(int statusCode);

        /**
         * 推送，连接失败
         *
         * @param e
         */
        void connectionFailed(APIConnectionException e);

        /**
         * 推送失败
         *
         * @param e
         */
        void pushFailed(APIRequestException e);
    }

    interface GetTagAliasIsSuccessListener{
        /**
         * 获取Tag、Alias成功
         * @param result
         */
        void getTagAliasSuccess(TagAliasResult result);

        /**
         * 获取Tag、Alias，连接失败
         *
         * @param e
         */
        void connectionFailed(APIConnectionException e);

        /**
         * 获取Tag、Alias失败
         *
         * @param e
         */
        void getTagAliasFailed(APIRequestException e);
    }
}
