package com.jarvanmo.sona.handler


import android.os.Handler
import android.os.Looper
import com.igexin.sdk.message.GTNotificationMessage
import com.igexin.sdk.message.GTTransmitMessage
import com.jarvanmo.sona.constants.*
import io.flutter.plugin.common.MethodChannel

object ReceiverHandler {

    var methodChannel: MethodChannel? = null
    var handler: Handler = Handler(Looper.getMainLooper())

    private fun safeInvokeMethod(method: String, arguments: Any) {
        try {
            handler.post{ methodChannel?.invokeMethod(method, arguments) }
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

    fun handleReceivedMessageData(msg: GTTransmitMessage) {

        val result = hashMapOf(
                APP_ID to msg.appid,
                MESSAGE_ID to msg.messageId,
                TASK_ID to msg.taskId,
                PKG_NAME to msg.pkgName,
                CLIENT_ID to msg.clientId
        )

        val payload = msg.payload
        if (payload != null) {
            result[PAYLOAD] = String(payload)
        }
//        methodChannel?.invokeMethod("onReceiveMessageData", result)
        safeInvokeMethod("onReceiveMessageData", result)
    }

    fun onReceiveClientId(clientID: String) {
//        methodChannel?.invokeMethod("onReceiveClientId", clientID)
        safeInvokeMethod("onReceiveClientId", clientID)
    }

    fun onReceiveOnlineState(isOnline: Boolean) {
//        if (isOnline) {
//            methodChannel?.invokeMethod("onReceiveOnlineState", "STARTED")
//        } else {
//            methodChannel?.invokeMethod("onReceiveOnlineState", "OFFLINE")
//        }
        safeInvokeMethod("onReceiveOnlineState", if (isOnline) "STARTED" else "OFFLINE")
    }

    fun onNotificationMessageArrived(msg: GTNotificationMessage) {

        val result = hashMapOf(
                PLATFORM to ANDROID,
                APP_ID to msg.appid,
                MESSAGE_ID to msg.messageId,
                TASK_ID to msg.taskId,
                PKG_NAME to msg.pkgName,
                CLIENT_ID to msg.clientId,
                CONTENT to msg.content,
                TITLE to msg.title
        )

//        methodChannel?.invokeMethod("onNotificationMessageArrived", result)
        safeInvokeMethod("onNotificationMessageArrived", result)
    }

    fun onNotificationMessageClicked(msg: GTNotificationMessage) {
        val result = hashMapOf(
                PLATFORM to ANDROID,
                APP_ID to msg.appid,
                MESSAGE_ID to msg.messageId,
                TASK_ID to msg.taskId,
                PKG_NAME to msg.pkgName,
                CLIENT_ID to msg.clientId,
                CONTENT to msg.content,
                TITLE to msg.title
        )

//        methodChannel?.invokeMethod("onNotificationMessageClicked", result)
        safeInvokeMethod("onNotificationMessageClicked", result)
    }
}