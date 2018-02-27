import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.device.TagAliasResult;
import listener.JPushIsSuccessListener.PushIsSuccessListener;
import listener.JPushIsSuccessListener.GetTagAliasIsSuccessListener;
import manager.JPushManager;

public class Test {

    public static void main(String[] args) {

        JPushManager.getInstance().initJPushListener();
//        JPushManager.getInstance().sendMessage("123", new PushIsSuccessListener() {
//            public void pushSuccess(int statusCode) {
//                System.out.println("sendMessage-----pushSuccess，statusCode: " + statusCode);
//            }
//
//            public void connectionFailed(APIConnectionException e) {
//                System.out.println("sendMessage-----connectionFailed,getDoneRetriedTimes: " + e.getDoneRetriedTimes()+",isReadTimeout: "+e.isReadTimedout());
//            }
//
//            public void pushFailed(APIRequestException e) {
//                System.out.println("sendMessage-----pushFailed,errorCode: " + e.getErrorCode()+",errorMessage: "+e.getErrorMessage());
//            }
//        });

//        JPushManager.getInstance().getTagAliasResult("190e35f7e04f35103ee", new GetTagAliasIsSuccessListener() {
//            public void getTagAliasSuccess(TagAliasResult result) {
//                System.out.println("getTagAliasResult-----getTagAliasSuccess，tag: " +result.tags+",alias: "+result.alias);
//            }
//
//            public void connectionFailed(APIConnectionException e) {
//                System.out.println("getTagAliasResult-----connectionFailed,getDoneRetriedTimes: " + e.getDoneRetriedTimes()+",isReadTimeout: "+e.isReadTimedout());
//            }
//
//            public void getTagAliasFailed(APIRequestException e) {
//                System.out.println("getTagAliasResult-----getTagAliasFailed,errorCode: " + e.getErrorCode()+",errorMessage: "+e.getErrorMessage());
//            }
//        });

//        JPushManager.getInstance().sendMessageByTagsAlias("广告数据", null, null, new PushIsSuccessListener() {
//            public void pushSuccess(int statusCode) {
//                System.out.println("sendMessage-----pushSuccess，statusCode: " + statusCode);
//            }
//
//            public void connectionFailed(APIConnectionException e) {
//                System.out.println("sendMessage-----connectionFailed,getDoneRetriedTimes: " + e.getDoneRetriedTimes()+",isReadTimeout: "+e.isReadTimedout());
//            }
//
//            public void pushFailed(APIRequestException e) {
//                System.out.println("sendMessage-----pushFailed,errorCode: " + e.getErrorCode()+",errorMessage: "+e.getErrorMessage());
//            }
//        });

//        JPushManager.getInstance().sendMessageByRegistrationId("广告数据", new String[]{"140fe1da9ea062933ec"}, new PushIsSuccessListener() {
//            public void pushSuccess(int statusCode) {
//                System.out.println("sendMessage-----pushSuccess，statusCode: " + statusCode);
//            }
//
//            public void connectionFailed(APIConnectionException e) {
//                System.out.println("sendMessage-----connectionFailed,getDoneRetriedTimes: " + e.getDoneRetriedTimes()+",isReadTimeout: "+e.isReadTimedout());
//            }
//
//            public void pushFailed(APIRequestException e) {
//                System.out.println("sendMessage-----pushFailed,errorCode: " + e.getErrorCode()+",errorMessage: "+e.getErrorMessage());
//            }
//        });

        JPushManager.getInstance().closeJPushClient();
    }
}
