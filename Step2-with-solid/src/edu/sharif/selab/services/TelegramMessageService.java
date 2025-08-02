package edu.sharif.selab.services;

import java.util.regex.Pattern;

import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.TelegramMessage;

public class TelegramMessageService implements MessageService {
    
    @Override
    public void sendMessage(Message message) {
        TelegramMessage telegramMessage = (TelegramMessage) message;
        if(validateTelegramID(telegramMessage.getSourceID()) && validateTelegramID(telegramMessage.getTargetID())){
            System.out.println("Message sent via Telegram from " + telegramMessage.getSourceID() + " to " + telegramMessage.getTargetID() + " with content : " + telegramMessage.getContent());
        }else{
            throw new IllegalArgumentException("Invalid Telegram ID/Phone Number");
        }
    }

    public boolean validateTelegramID(String ID) {
        // Telegram IDs can be alphanumeric or phone numbers
        String telegramIDRegex = "^(?:\\d{11}|@[A-Za-z0-9]+)$";
        Pattern pattern = Pattern.compile(telegramIDRegex);
        return pattern.matcher(ID).matches();
    }

}
