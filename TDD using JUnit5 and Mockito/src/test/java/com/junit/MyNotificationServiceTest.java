package com.junit;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
public class MyNotificationServiceTest {
    @Test
    public void testVerifyInteraction(){
        NotificationApi mockNotificationApi = Mockito.mock(NotificationApi.class);
        MyNotificationService service = new MyNotificationService(mockNotificationApi);
        
        service.alertUser("Mock NOtification alert");

        verify(mockNotificationApi).sendNotification("Mock NOtification alert");
    }
}   