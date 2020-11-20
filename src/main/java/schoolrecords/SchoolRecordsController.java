package schoolrecords;

import java.util.*;

public class SchoolRecordsController {
    private ClassRecords classRecords;
    private List<Subject> subjectList;
    private List<Tutor> tutorList;
    Scanner scanner = new Scanner(System.in);

    private void initSchool() {
        classRecords = new ClassRecords("9. osztály", new Random(666));
        classRecords.addStudent(new Student("Cody Coder"));
        classRecords.addStudent(new Student("Mickey Mouse"));
        classRecords.addStudent(new Student("John James Rambo"));

        subjectList = new ArrayList<>();
        subjectList.add(new Subject("Magyar nyelv és irodalom"));
        subjectList.add(new Subject("Idegen nyelv"));
        subjectList.add(new Subject("Matematika"));
        subjectList.add(new Subject("Erkölcstan/hittan"));
        subjectList.add(new Subject("Környezetismeret"));
        subjectList.add(new Subject("Ének-zene"));
        subjectList.add(new Subject("Vizuális kultúra"));
        subjectList.add(new Subject("Technika, életvitel és gyakorlat"));
        subjectList.add(new Subject("Testnevelés és sport"));

        tutorList = new ArrayList<>();
        tutorList.add(new Tutor("Menyhárt Zoltán", Arrays.asList(subjectList.get(1), subjectList.get(3))));
        tutorList.add(new Tutor("Barna János", Arrays.asList(subjectList.get(2))));
        tutorList.add(new Tutor("Tóth Judit", Arrays.asList(subjectList.get(4), subjectList.get(5))));
        tutorList.add(new Tutor("Számadó Ágnes", Arrays.asList(subjectList.get(0), subjectList.get(2))));
        tutorList.add(new Tutor("Herczeg Györgyi", Arrays.asList(subjectList.get(6), subjectList.get(7), subjectList.get(8))));
    }

    private void menu() {
        StringBuilder menu = new StringBuilder();
        menu.append("1. Diákok nevének listázása\n");
        menu.append("2. Diák név alapján keresése\n");
        menu.append("3. Diák létrehozása\n");
        menu.append("4. Diák név alapján törlése\n");
        menu.append("5. Diák feleltetése\n");
        menu.append("6. Osztályátlag kiszámolása\n");
        menu.append("7. Tantárgyi átlag kiszámolása\n");
        menu.append("8. Diákok átlagának megjelenítése\n");
        menu.append("9. Diák átlagának kiírása\n");
        menu.append("10. Diák tantárgyhoz tartozó átlagának kiírása\n");
        menu.append("11. Kilépés");
        menu.append("\n");

        System.out.println(menu.toString());
    }

    private void printStudentNames() {
        StringBuilder output = new StringBuilder();

        if (classRecords.getStudents().size() == 0) {
            output.append("Nincs tanuló rögzítve!");
        } else {
            output.append("Az osztály tanulói: ");
            output.append(classRecords.listStudentNames());
        }

        output.append("\n");
        System.out.println(output.toString());
    }

    private void createNewStudent() {
        StringBuilder output = new StringBuilder();

        output.append("Adja meg az új tanuló nevét: ");
        System.out.print(output.toString());

        if (classRecords.addStudent(new Student(scanner.nextLine()))) {
            output.replace(0, output.length(), "A tanuló rögzítése megtörtént!");
        } else {
            output.replace(0, output.length(), "A tanuló rögzítése nem sikerült, már szerepel a névsorban!");
        }

        output.append("\n");
        System.out.println(output.toString());
    }

    private void searchStudentByName() {
        StringBuilder output = new StringBuilder();

        output.append("Adja meg a keresendő tanuló nevét: ");
        System.out.print(output.toString());

        try {
            Student student = classRecords.findStudentByName(scanner.nextLine());
            output.replace(0, output.length(), "A találat: ");
            output.append(student.toString());
        } catch (Exception e) {
            if (e.getMessage().contains("Student by this name cannot be found!")) {
                output.replace(0, output.length(), e.getMessage());
            } else {
                throw e;
            }
        }

        output.append("\n");
        System.out.println(output.toString());
    }

    private void deleteStudent() {
        StringBuilder output = new StringBuilder();

        output.append("Adja meg a törlendő tanuló nevét: ");
        System.out.print(output.toString());

        try {
            Student student = classRecords.findStudentByName(scanner.nextLine());
            classRecords.removeStudent(student);
            output.replace(0, output.length(), "A tanuló törlése megtörtént!");
        } catch (Exception e) {
            if (e.getMessage().contains("Student by this name cannot be found!")) {
                output.replace(0, output.length(), e.getMessage());
            } else {
                throw e;
            }
        }

        output.append("\n");
        System.out.println(output.toString());
    }

    private void studentRepetition() {
        StringBuilder output = new StringBuilder();

        try {
            Student student = classRecords.repetition();
            output.append("Az osztályzott tanuló neve: ");
            output.append(student.getName());
            output.append("\n");
            System.out.println(output.toString());

            String gradeFromUser = getGradeFromUser();
            Subject subjectFromUser = getSubjectFromUser();
            Tutor tutorFromUser = getTutorFromUser(subjectFromUser);

            student.grading(new Mark(gradeFromUser, subjectFromUser, tutorFromUser));

            output.replace(0, output.length(), "Osztályzat rögzítve!");

        } catch (Exception e) {
            output.replace(0, output.length(), "Hiba történt! " + e.getMessage());
        }

        output.append("\n");
        System.out.println(output.toString());
    }

    private void printClassAverage() {
        StringBuilder output = new StringBuilder();

        try {
            output.append("Az osztály átlaga: ");
            output.append(classRecords.calculateClassAverage());
            output.append("\n");

            System.out.println(output.toString());
        } catch (Exception e) {
            System.out.println("Hiba történt! " + e.getMessage() + "\n");
        }
    }

    private void printClassAverageBySubject() {
        StringBuilder output = new StringBuilder();

        output.append("Az osztály átlaga tantárgyanként: ");
        output.append("\n");
        for (Subject subject : subjectList) {
            output.append(String.format("%-35s %.2f", subject.getSubjectName() + ": ", classRecords.calculateClassAverageBySubject(subject)));
            output.append("\n");
        }

        System.out.println(output.toString());
    }

    private void printListStudyResults() {
        StringBuilder output = new StringBuilder();

        List<StudyResultByName> studyResultByNames = classRecords.listStudyResults();

        output.append("Az osztály átlaga tanulónként: ");
        output.append("\n");
        for (StudyResultByName studyResultByName : studyResultByNames) {
            output.append(String.format("%-35s %.2f", studyResultByName.getStudentName() + ": ", studyResultByName.getStudyAverage()));
            output.append("\n");
        }

        System.out.println(output.toString());
    }

    private void printStudentAverage() {
        StringBuilder output = new StringBuilder();

        output.append("Adja meg a tanuló nevét: ");
        System.out.print(output.toString());

        try {
            Student student = classRecords.findStudentByName(scanner.nextLine());
            output.replace(0, output.length(), "A tanuló átlaga:");
            output.append(student.calculateAverage());
        } catch (Exception e) {
            if (e.getMessage().contains("Student by this name cannot be found!")) {
                output.replace(0, output.length(), e.getMessage());
            } else {
                throw e;
            }
        }

        output.append("\n");
        System.out.println(output.toString());
    }

    private void printStudentSubjectAverage() {
        StringBuilder output = new StringBuilder();

        output.append("Adja meg a tanuló nevét: ");
        System.out.print(output.toString());
        Student student = null;

        try {
            student = classRecords.findStudentByName(scanner.nextLine());
            output.replace(0, output.length(), "A tanuló átlaga: ");
            output.append(student.calculateAverage());
        } catch (Exception e) {
            if (e.getMessage().contains("Student by this name cannot be found!")) {
                output.replace(0, output.length(), e.getMessage());
            } else {
                throw e;
            }
        }

        Subject subjectFromUser = getSubjectFromUser();

        output.replace(0, output.length(), "A tanuló átlaga a(z) ");
        output.append(subjectFromUser.getSubjectName());
        output.append(" tantárgyból: ");
        output.append(student.calculateSubjectAverage(subjectFromUser));
        output.append("\n");

        System.out.println(output.toString());
    }

    private String getGradeFromUser() {
        StringBuilder output = new StringBuilder();

        List<String> markList = new ArrayList<>();
        Arrays.asList(MarkType.values()).forEach(markType -> markList.add(markType.name()));

        boolean validMark = false;

        while (!validMark) {
            output.replace(0, output.length(), "Adja meg az osztályzatot!");
            output.append(" (");
            output.append(String.join(", ", markList));
            output.append("): ");
            System.out.print(output.toString());
            String userInputMark = scanner.nextLine();

            for (String markString : markList) {
                if (markString.equals(userInputMark)) {
                    return userInputMark;
                }
            }

            output.replace(0, output.length(), "Nem megfelelő osztályzat!");
            output.append("\n");
            System.out.println(output.toString());
        }

        return null;
    }

    private Subject getSubjectFromUser() {
        StringBuilder output = new StringBuilder();
        List<String> subjectNameList = new ArrayList<>();
        subjectList.forEach(subject -> subjectNameList.add(subject.getSubjectName()));

        boolean validSubject = false;
        while (!validSubject) {
            output.replace(0, output.length(), "Válasszon tantárgyat!");
            output.append(" (");
            output.append(String.join(", ", subjectNameList));
            output.append(")");
            output.append("\n: ");
            System.out.print(output.toString());
            String userInputSubject = scanner.nextLine();

            for (Subject subject : subjectList) {
                if (subject.getSubjectName().equals(userInputSubject)) {
                    return subject;
                }
            }

            output.replace(0, output.length(), "A tárgy nem található!");
            output.append("\n");
            System.out.println(output.toString());
        }

        return null;
    }

    private Tutor getTutorFromUser(Subject subject) {
        StringBuilder output = new StringBuilder();
        List<String> tutorNameList = new ArrayList<>();

        for (Tutor tutor : tutorList) {
            if (tutor.tutorTeachingSubject(subject)) {
                tutorNameList.add(tutor.getName());
            }
        }

        boolean validTutor = false;
        while (!validTutor) {
            output.replace(0, output.length(), "Válasszon oktatót!");
            output.append(" (");
            output.append(String.join(", ", tutorNameList));
            output.append(")");
            output.append("\n: ");
            System.out.print(output.toString());
            String userInputTutor = scanner.nextLine();

            for (Tutor tutor : tutorList) {
                if (tutor.getName().equals(userInputTutor)) {
                    return tutor;
                }
            }

            output.replace(0, output.length(), "Az oktató nem található!");
            output.append("\n");
            System.out.println(output.toString());
        }

        return null;
    }

    private void run() {
        int menuElement = 0;
        boolean running = true;
        boolean userError = false;

        while (running) {
            try {
                if (!userError) {
                    menu();
                    menuElement = scanner.nextInt();
                    scanner.nextLine();
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Nem létező menüpont, válasszon másikat!");
                System.out.println("\n");
                scanner.nextLine();
                continue;
            }

            try {
                switch (menuElement) {
                    case 1:
                        printStudentNames();
                        break;
                    case 2:
                        searchStudentByName();
                        break;
                    case 3:
                        createNewStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        studentRepetition();
                        break;
                    case 6:
                        printClassAverage();
                        break;
                    case 7:
                        printClassAverageBySubject();
                        break;
                    case 8:
                        printListStudyResults();
                        break;
                    case 9:
                        printStudentAverage();
                        break;
                    case 10:
                        printStudentSubjectAverage();
                        break;
                    case 11:
                        System.out.println("Mosolygós szép napot!");
                        return;
                    default:
                        System.out.println("Nem létező menüpont, válasszon másikat!");
                        System.out.println("\n");
                }
                userError = false;
            } catch (Exception e) {
                System.out.println("Hiba történt! " + e.getMessage() + "\n");
                userError = true;
            }
        }
    }

    public static void main(String[] args) {
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();
        schoolRecordsController.initSchool();
        schoolRecordsController.run();
    }
}
