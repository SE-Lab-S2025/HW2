import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;
import edu.sharif.selab.services.MessageService;
import edu.sharif.selab.services.MessageServiceFactory;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello and Welcome to SE Lab Messenger.");
        int userAnswer;

        do {
            System.out.println("1. Send SMS\n2. Send Email\n3. Send Telegram\n0. Exit");
            userAnswer = scanner.nextInt();

            if (userAnswer == 0) break;

            Message message = createMessage(userAnswer);
            MessageService service = MessageServiceFactory.getService(userAnswer);
            service.sendMessage(message);

        } while (true);
    }

    private static Message createMessage(int type) {
        switch (type) {
            case 1:
                SmsMessage sms = new SmsMessage();
                System.out.print("Enter source phone: ");
                sms.setSourcePhoneNumber(scanner.next());
                System.out.print("Enter target phone: ");
                sms.setTargetPhoneNumber(scanner.next());
                System.out.print("Write Your Message: ");
                sms.setContent(scanner.next());
                return sms;
            case 2:
                EmailMessage email = new EmailMessage();
                System.out.print("Enter source email: ");
                email.setSourceEmailAddress(scanner.next());
                System.out.print("Enter target email: ");
                email.setTargetEmailAddress(scanner.next());
                System.out.print("Write Your Message: ");
                email.setContent(scanner.next());
                return email;
            case 3:
                TelegramMessage telegram = new TelegramMessage();
                System.out.print("Enter source ID: ");
                telegram.setSourceID(scanner.next());
                System.out.print("Enter target ID: ");
                telegram.setTargetID(scanner.next());
                System.out.print("Write Your Message: ");
                telegram.setContent(scanner.next());
                return telegram;
            default:
                throw new IllegalArgumentException("Invalid message type");
        }
    }
}