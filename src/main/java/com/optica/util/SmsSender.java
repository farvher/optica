package com.optica.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {

    public static final String ACCOUNT_SID =
            "";
    public static final String AUTH_TOKEN =
            "";

    


    public static void sendSms(String sms,String toNumber, String fromNumber) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(toNumber), // to
                        new PhoneNumber(fromNumber), // from
                        sms)
                .create();

        System.out.println(message.getSid());
    }
}
