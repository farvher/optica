package com.optica.util;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {

    public static final String ACCOUNT_SID =
            "AC361a6392543887cba95a9af2c58ead47";
    public static final String AUTH_TOKEN =
            "6f8394163683c540c075b3906c6bc513";

    


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
