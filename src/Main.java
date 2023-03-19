import controllers.EmailController;
import dtos.request.CreateMailBoxRequest;
import dtos.request.CreateMailRequest;
import dtos.request.CreateUserRequest;
import dtos.response.MailResponse;

import javax.swing.*;




public class Main {

    private static EmailController emailController = new EmailController();

    public static void main(String[] args) {
        startApp(); }

    private static void startApp() {
        String message = """
                 1 -> Sign Up.
                 2 -> Login.
                 3 -> Exit.
                """;
        String input = input(message);
        switch (input.charAt(0)) {
            case '1' -> signUp();
            case '2' -> login();
            case '3' ->exit();
            default -> {
                display("Invalid input try again");
                startApp();
            }
        }

    }



    private static void login() {
        String userName = input("Enter UserName: ");
        String password = input("Enter password: ");
        var result = emailController.login(userName,password);
        display(result.toString());
         if(result.equals(null)){
             startApp();

        }else{
             mailMenu();

         }
    }

    private static void mailMenu() {
        String message = """
                 1 -> Send Mails.
                 2 -> Inbox.
                 3 -> Outbox
                 4 -> login
                 5 -> Exit.
                """;
        String input = input(message);
        switch (input.charAt(0)) {
            case '1' -> sendMails();
            case '2' -> inbox();
            case '3' -> outbox();
            case '4' -> login();
            case '5' ->exit();
            default -> {
                display("Invalid input try again");
                startApp();
            }
        }
    }

    private static void outbox() {
        String message = """
                 1 -> View Mails.
                 2 -> View by Recipient.
                 3 -> Delete by Recipient.
                 4 -> mainMenu
                 5 -> Exit.
                """;
        String input = input(message);
        switch (input.charAt(0)) {
            case '1' -> viewAllOutboxMails();
            case '2' -> viewMailsFromRecipient();
            case '3' -> deleteMailsFromRecipient();
            case '4' -> mailMenu();
            case '5' ->exit();
            default -> {
                display("Invalid input try again");
                inbox();
            }
        }

    }

    private static void deleteMailsFromRecipient() {
        String userName = input("Enter userName:");
        String recipient = input("Enter Recipient: ");
        var result = emailController.deleteByRecipient(userName,recipient);
        display(result.toString());
        outbox();
    }

    private static void viewMailsFromRecipient() {
        String userName = input("Enter userName:");
        String recipient = input("Enter Recipient: ");
        MailResponse mailResponse = new MailResponse();
        var result = emailController.viewByRecipient(userName,recipient,mailResponse);
        display(result.toString());
        outbox();
    }

    private static void viewAllOutboxMails() {
        String userName = input("Enter userName:");
        String recipient = input("Enter recipient: ");
        MailResponse mailResponse = new MailResponse();
        var result = emailController.viewByRecipient(userName,recipient,mailResponse);
        display(result.toString());
        outbox();
    }




    private static void inbox() {
        String message = """
                 1 -> View Mails.
                 2 -> View by Sender.
                 3 -> Delete by Sender.
                 4. -> mainMenu
                 4 -> Exit.
                """;
        String input = input(message);
        switch (input.charAt(0)) {
            case '1' -> viewAllInboxMails();
            case '2' -> viewMailsFromSender();
            case '3' -> deleteMailsFromSender();
            case '4' -> mailMenu();
            case '5' ->exit();
            default -> {
                display("Invalid input try again");
                inbox();
            }
        }
    }

    private static void deleteMailsFromSender() {
        String userName = input("Enter userName:");
        String sender = input("Enter Sender: ");
        var result = emailController.deleteBySender(userName,sender);
        display(result.toString());
        inbox();
    }

    private static void viewMailsFromSender() {
        String userName = input("Enter userName:");
        String sender = input("Enter Sender: ");
        MailResponse mailResponse = new MailResponse();
        var result = emailController.viewBySender(userName,sender,mailResponse);
        display(result.toString());
        inbox();

    }

    private static void viewAllInboxMails() {
        String userName = input("Enter userName:");
        MailResponse mailResponse = new MailResponse();
        var result = emailController.inbox(userName,mailResponse);
        display(result.toString());
        inbox();

    }


    private static void sendMails() {
        CreateMailRequest mailRequest = new CreateMailRequest();
        mailRequest.setSender(input("Enter Sender Address: "));
        mailRequest.setRecipient(input("Enter Recipient Address: "));
        mailRequest.setTitle(input("Enter title: "));
        mailRequest.setBody(input("Enter Body: "));
        var result = emailController.sendMail(mailRequest);
        display(result.toString());
        mailMenu();
    }




    private static void signUp() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        CreateMailBoxRequest createMailBoxRequest = new CreateMailBoxRequest();
        createUserRequest.setFirstName(input("Enter first Name: "));
        createUserRequest.setLastName(input("Enter last Name: "));
        createUserRequest.setUserName(input("Enter userName: "));
        createUserRequest.setPassword(input("Enter password: "));
        createMailBoxRequest.setUserName(createUserRequest.getUserName());
        var user = emailController.createAccount(createUserRequest);
        //var mailbox = emailController.createMailBox(createMailBoxRequest);
        display(user.toString());

        startApp();

    }

    private static String input(String message) {
        return JOptionPane.showInputDialog(message);
    }
    private static void display(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private static void exit() {
        display("Thank you for using our application ");
        System.exit(1);
        }
}
