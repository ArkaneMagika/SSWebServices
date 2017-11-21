/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.gsubiztech.SSwebservices;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import java.util.Calendar;

import com.twilio.type.PhoneNumber;
import com.twilio.exception.ApiException;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author arkane
 */
public class SMS {

    public static final String ACCOUNT_SID = "AC788b51144dd24af8f0191d60a2070936";

    public static final String AUTH_TOKEN = "4232e2246cb9a0a912a7d5b63501edcd";

    public static void SendPassword(String pass) {

        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            String[] usernames = {"Akane Simpson", "Lala Aichac", "Kerwan Miguel Antoine", "Jarrid Richards", "Gary White"};
            String[] phonenumbers = {"3184368187", "", "", "", ""};
            String sender = "15005550006";
            String body = pass;

            Message message = Message.creator(new PhoneNumber("+"), new PhoneNumber(sender), body).create();

//        Internal Message
            System.out.println("Message has been sent:\n" + body);
            System.out.println(timeStamp);
            System.out.println(message.getSid());

            System.exit(0);
        } catch (ApiException e) {
            System.out.println("Message has not been sent:\n" + e);
            System.out.println(timeStamp);
            System.exit(0);
        }
    }

}
