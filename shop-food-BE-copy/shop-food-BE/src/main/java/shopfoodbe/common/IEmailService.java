package shopfoodbe.common;

public interface IEmailService {
    boolean sendEmail(String receiptEmail, String link);
}
