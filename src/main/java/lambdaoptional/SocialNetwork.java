package lambdaoptional;


import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SocialNetwork {
    private List<Member> memberList;

    public SocialNetwork(List<Member> memberList) {
        this.memberList = memberList;
    }

    public Optional<Member> findFirst(Predicate<Member> predicate) {
        for (Member member : memberList) {
            if (predicate.test(member)) {
                return Optional.of(member);
            }
        }

        return Optional.empty();
    }

    public Optional averageNumberOfSkills() {
        if (memberList.isEmpty()) {
            return Optional.empty();
        }
        int sum = 0;
        for (Member member : memberList) {
            sum += member.getSkills().size();
        }

        return Optional.of((double) sum / memberList.size());
    }

}
