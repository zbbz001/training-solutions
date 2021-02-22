package exam03retake01;

import java.util.List;

public class Mail {
    private Contact from;
    private List<Contact> to;
    private String subject;
    private String message;

    public Mail(Contact from, List<Contact> to, String subject, String message) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public boolean hasRecipientFromEmail(String criteria) {
        for (Contact contact : to) {
            if (contact.getEmail().equals(criteria)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasRecipientFromName(String criteria) {
        for (Contact contact : to) {
            if (contact.getName().equals(criteria)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasSenderFromEmail(String criteria) {
        return from.getEmail().equals(criteria);
    }

    public boolean hasSenderFromName(String criteria) {
        return from.getName().equals(criteria);
    }

    public boolean hasSubjectContains(String criteria) {
        return subject.contains(criteria);
    }

    public boolean hasMessageContains(String criteria) {
        return message.contains(criteria);
    }

    public Contact getFrom() {
        return from;
    }

    public List<Contact> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}
