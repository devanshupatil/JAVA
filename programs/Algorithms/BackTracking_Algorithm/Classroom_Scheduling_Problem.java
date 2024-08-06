import java.util.ArrayList;
import java.util.List;

public class Classroom_Scheduling_Problem {

    public static void Print(List<List<List<String>>> Timeslots) {
        // Print the Schedule
        for (int i = 0; i < Timeslots.size(); i++) {
            System.out.println("Time Slot " + (i + 1) + ":");

            for (int j = 0; j < Timeslots.get(i).size(); j++) {

                if (Timeslots.get(i).get(j).size() != 0) {

                    System.out.println();
                    System.out.println("Class " + (j + 1) + ":");
                    System.out.println();
                    System.out.println("Subject : " + Timeslots.get(i).get(j).get(0));
                    System.out.println("Instructor : " + Timeslots.get(i).get(j).get(1));
                }
            }

            System.out.println();
            System.out.println("***************************");
            System.out.println();
        }

        System.exit(0); // Exit the program
    }

    public static void scheduleOfClasses(List<List<List<String>>> Timeslots,
            List<List<String>> subject_And_Instructor,
            List<List<List<String>>> remainingClasses, int classRooms, int index, int l, int classes, int dutyIdx_1,
            int dutyIdx_2) {

        for (int i = 0; i < Timeslots.size(); i++) {

            if (classes >= 10) {
                classes = 0;
            }
            if (index >= classRooms) {
                index = 0;
                l = 0;
            }

            while (index < classRooms) {

                if (classes >= 10) {
                    int idx = dutyIdx_1;

                    // IF The REMAINING CLASSES IS NOT ZERO
                    while (remainingClasses.get(idx).size() != 0) {

                        for (int h = 0; h < l || h == 0; h++) {

                            for (int j = 0; j < dutyIdx_2; j++, h++) {

                                if (index >= classRooms) {
                                    index = 0;
                                    l = 0;
                                }
                                // CHECK THE INSTRUCTOR AND SUBJECT IS SAME OR NOT
                                if (Timeslots.get(i).get(h).get(0).equals(remainingClasses.get(idx).get(j).get(0))
                                        || Timeslots.get(i).get(h).get(1)
                                                .equals(remainingClasses.get(idx).get(j).get(1))) {

                                    if (i < Timeslots.size()) {

                                        // YES, ADD CLASS IN NEXT TIME SLOT

                                        i++;
                                        // Initialize the lists of lists
                                        Timeslots.get(i).add(new ArrayList<>());
                                        l = Timeslots.get(i).size() - 1;

                                        Timeslots.get(i).get(l).addAll(remainingClasses.get(idx).get(j));
                                        remainingClasses.get(idx).remove(j);
                                        dutyIdx_2--;
                                    }

                                } else {
                                    // NO, ADD CLASS

                                    if (Timeslots.get(i).size() > 1 && Timeslots.get(i).size() <= classRooms) {

                                        if (Timeslots.get(i).get(h + 1).size() == 0) {

                                            Timeslots.get(i).get(l).addAll(remainingClasses.get(idx).get(j));
                                            index++;

                                            remainingClasses.get(idx).remove(j);
                                            dutyIdx_2--;
                                        }
                                    } else {

                                        // Initialize the lists of lists
                                        Timeslots.get(i).add(new ArrayList<>());
                                        l = Timeslots.get(i).size() - 1;
                                        Timeslots.get(i).get(l).addAll(remainingClasses.get(idx).get(j));
                                        index++;

                                        remainingClasses.get(idx).remove(j);
                                        dutyIdx_2--;
                                    }

                                }

                            }
                        }

                    }

                    Print(Timeslots);

                }

                // Initialize the lists
                if (Timeslots.size() < 5) {
                    Timeslots.add(new ArrayList<>());

                }

                // Initialize the lists of lists
                if (Timeslots.get(i).size() < classRooms) {

                    Timeslots.get(i).add(new ArrayList<>());

                    l = Timeslots.get(i).size() - 1;
                }

                for (int k = 0; k < l; k++) {

                    // Check the instructor is double-booked
                    if (Timeslots.get(i).get(k).get(0).equals(subject_And_Instructor.get(classes).get(0))
                            || Timeslots.get(i).get(k).get(1).equals(subject_And_Instructor.get(classes).get(1))) {

                        remainingClasses.add(new ArrayList<>());
                        remainingClasses.get(dutyIdx_1).add(new ArrayList<>());

                        if (dutyIdx_2 < classRooms) {

                            remainingClasses.get(dutyIdx_1).get(dutyIdx_2).addAll(subject_And_Instructor.get(classes));

                            dutyIdx_2++;
                            classes++; // If yes, go to next instructor
                        } else {

                            dutyIdx_1++;
                        }

                    }
                }
                if (classes < 10) {
                    // Assign value to available classrooms and time slot
                    Timeslots.get(i).get(l).addAll(subject_And_Instructor.get(classes));
                    index++;
                    classes++;
                }

            }

        }

    }

    public static void main(String[] args) {

        // Initialize the lists
        List<List<List<String>>> TimeSlot = new ArrayList<>(5);
        TimeSlot.add(new ArrayList<>());
        // TimeSlot.get(0).add(new ArrayList<>());

        List<List<List<String>>> inDuty = new ArrayList<>(5);
        inDuty.add(new ArrayList<>());
        // inDuty.get(0).add(new ArrayList<>());

        List<List<String>> subject_And_Instructor = new ArrayList<>(5);
        int classRooms = 3;

        subject_And_Instructor.add(new ArrayList<>());
        subject_And_Instructor.get(0).add("Math101");
        subject_And_Instructor.get(0).add("Instructor A");

        subject_And_Instructor.add(new ArrayList<>());
        subject_And_Instructor.get(1).add("History101");
        subject_And_Instructor.get(1).add("Instructor B");

        subject_And_Instructor.add(new ArrayList<>());
        subject_And_Instructor.get(2).add("Chemistry101");
        subject_And_Instructor.get(2).add("Instructor C");

        subject_And_Instructor.add(new ArrayList<>());
        subject_And_Instructor.get(3).add("Physics101");
        subject_And_Instructor.get(3).add("Instructor A");

        subject_And_Instructor.add(new ArrayList<>());
        subject_And_Instructor.get(4).add("English101");
        subject_And_Instructor.get(4).add("Instructor D"); //

        subject_And_Instructor.add(new ArrayList<>());
        subject_And_Instructor.get(5).add("English102");
        subject_And_Instructor.get(5).add("Instructor A");

        subject_And_Instructor.add(new ArrayList<>());
        subject_And_Instructor.get(6).add("History102");
        subject_And_Instructor.get(6).add("Instructor C");

        subject_And_Instructor.add(new ArrayList<>());
        subject_And_Instructor.get(7).add("Math102");
        subject_And_Instructor.get(7).add("Instructor B");

        subject_And_Instructor.add(new ArrayList<>());
        subject_And_Instructor.get(8).add("Physics102");
        subject_And_Instructor.get(8).add("Instructor D");

        subject_And_Instructor.add(new ArrayList<>());
        subject_And_Instructor.get(9).add("English103");
        subject_And_Instructor.get(9).add("Instructor D");

        scheduleOfClasses(TimeSlot, subject_And_Instructor, inDuty, classRooms, 0, 0, 0, 0, 0);

    }

}
