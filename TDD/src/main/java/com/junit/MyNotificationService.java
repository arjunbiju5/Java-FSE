package com.junit;
public class MyNotificationService {
    private final NotificationApi notificationApi;
    
    public MyNotificationService(NotificationApi notificationApi){
        this.notificationApi=notificationApi;
    }
    public void alertUser(String message){
        notificationApi.sendNotification(message);
    }
}
