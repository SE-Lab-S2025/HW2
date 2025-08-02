package edu.sharif.selab.services;



public class MessageServiceFactory {
    public static MessageService getService(int type) {
        switch (type) {
            case 1:
                return new SmsMessageService();
            case 2:
                return new EmailMessageService();
            case 3:
                return new TelegramMessageService();
            default:
                throw new IllegalArgumentException("Unknown service type");
        }
    }
}
