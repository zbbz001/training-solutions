package exam03retake01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MailBox {
    private List<Mail> mails = new ArrayList<>();

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> findByCriteria(String criteria) {
        if (criteria.startsWith("to:")) {
            return findByCriteriaFromRecipient(criteria);
        } else if (criteria.startsWith("from:")) {
            return findByCriteriaFromSender(criteria);
        } else {
            return findByCriteriaFromSubjectOrMessage(criteria);
        }
    }

    private List<Mail> findByCriteriaFromSubjectOrMessage(String criteria) {
        return mails.stream()
                .filter(mail -> mail.hasSubjectContains(criteria) || mail.hasMessageContains(criteria))
                .collect(Collectors.toList());
    }

    private List<Mail> findByCriteriaFromSender(String criteria) {
        String clearCriteria = criteria.replace("from:", "");

        if (clearCriteria.contains("@")) {
            return mails.stream()
                    .filter(mail -> mail.hasSenderFromEmail(clearCriteria))
                    .collect(Collectors.toList());
        } else {
            return mails.stream()
                    .filter(mail -> mail.hasSenderFromName(clearCriteria))
                    .collect(Collectors.toList());
        }
    }

    private List<Mail> findByCriteriaFromRecipient(String criteria) {
        String clearCriteria = criteria.replace("to:", "");

        if (clearCriteria.contains("@")) {
            return mails.stream()
                    .filter(mail -> mail.hasRecipientFromEmail(clearCriteria))
                    .collect(Collectors.toList());
        } else {
            return mails.stream()
                    .filter(mail -> mail.hasRecipientFromName(clearCriteria))
                    .collect(Collectors.toList());
        }
    }

    public List<Mail> getMails() {
        return new ArrayList<>(mails);
    }
}
