package week02;

import java.util.ArrayList;
import java.util.List;

public class Office {
    List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.print(meetingRoom.getName() + ";");
        }
        System.out.println();
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size() - 1; i >= 0; i--) {
            System.out.print(meetingRooms.get(i).getName() + ";");
        }
        System.out.println();
    }

    public void printEventNames() {
        for (int i = 1; meetingRooms.size() > i; i += 2){
            System.out.print(meetingRooms.get(i).getName() + ";");
        }
        System.out.println();
    }

    public void printAreas() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            printMeetingRoom(meetingRoom);
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if(meetingRoom.getName().equals(name)) {
                printMeetingRoom(meetingRoom);
            }
        }
    }

    public void printMeetingRoomsContains(String name) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if(meetingRoom.getName().contains(name)) {
                printMeetingRoom(meetingRoom);
            }
        }
    }

    public void printAreasLargerThan(int area) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if(meetingRoom.getArea() > area) {
                printMeetingRoom(meetingRoom);
            }
        }
    }

    private void printMeetingRoom(MeetingRoom meetingRoom) {
        System.out.println(meetingRoom.getName() + " nevü iroda adatai:");
        System.out.println("  szélessége: " + meetingRoom.getWidth());
        System.out.println("  hosszúsága: " + meetingRoom.getLength());
        System.out.println("  területe: " + meetingRoom.getArea());
        System.out.println();
    }
}
