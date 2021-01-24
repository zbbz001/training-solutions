package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SocialNetwork {
    private List<Member> memberList = new ArrayList<Member>();

    public SocialNetwork(List<Member> memberList) {
        this.memberList = memberList;
    }

    public List<Member> findMembersBy(Predicate<Member> predicate) {
        List<Member> results = new ArrayList<>();
        for (Member member : memberList) {
            if (predicate.test(member)) {
                results.add(member);
            }
        }

        return results;
    }

    public void applyToSelectedMembers(Predicate<Member> predicate, Consumer<Member> consumer) {
        for (Member member : memberList) {
            if (predicate.test(member)) {
                consumer.accept(member);
            }
        }
    }

    public <T> List<T> transformMembers(Function<Member, T> function) {
        List<T> results = new ArrayList<>();
        for (Member member : memberList) {
            results.add(function.apply(member));
        }

        return results;
    }
}
