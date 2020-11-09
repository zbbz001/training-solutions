package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    List<Member> members = new ArrayList<>();

    public void addMember(String name) {
        members.add(new Member(name));
    }

    public void connect (String name, String otherName) {
        Member member = findByName(name);

        if(member != null) {
            Member otherMember = findByName(otherName);
            if(otherMember != null) {
                member.connectMember(otherMember);
            }
        }
    }

    public Member findByName(String name) {
        for(Member member:members) {
            if(member.getName().equals(name)) {
                return member;
            }
        }

        return null;
    }

    public List<String> bidirectionalConnections() {
        List<String> connectedMemebers = new ArrayList<>();

        for(Member member:members) {
            for(Member subMemeber:member.getConnections()) {
                if(subMemeber.getConnections().contains(member)) {
                    connectedMemebers.add(member.getName() + " - " + subMemeber.getName());
                }
            }
        }

        return connectedMemebers;
    }

    @Override
    public String toString() {
        return members.toString();
    }
}
