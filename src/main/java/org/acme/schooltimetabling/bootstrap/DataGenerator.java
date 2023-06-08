package org.acme.schooltimetabling.bootstrap;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.acme.schooltimetabling.domain.Lesson;
import org.acme.schooltimetabling.domain.Room;
import org.acme.schooltimetabling.domain.Timeslot;
import org.acme.schooltimetabling.persistence.LessonRepository;
import org.acme.schooltimetabling.persistence.RoomRepository;
import org.acme.schooltimetabling.persistence.TimeslotRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class DataGenerator {

    @ConfigProperty(name = "timeTable.demoData", defaultValue = "SMALL")
    DemoData demoData;

    @Inject
    TimeslotRepository timeslotRepository;
    @Inject
    RoomRepository roomRepository;
    @Inject
    LessonRepository lessonRepository;

    @Transactional
    public void generateDemoData(@Observes StartupEvent startupEvent) {
        if (demoData == DemoData.NONE) {
            return;
        }

        List<Timeslot> timeslotList = new ArrayList<>(10);
        timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));

        timeslotList.add(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
        if (demoData == DemoData.LARGE) {
            timeslotList.add(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
            timeslotList.add(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
        }
        timeslotRepository.persist(timeslotList);

        List<Room> roomList = new ArrayList<>(3);
        roomList.add(new Room("Room A"));
        roomList.add(new Room("Room B"));
        roomList.add(new Room("Room C"));
        if (demoData == DemoData.LARGE) {
            roomList.add(new Room("Room D"));
            roomList.add(new Room("Room E"));
            roomList.add(new Room("Room F"));
        }
        roomRepository.persist(roomList);

        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(new Lesson("Chemistry", "J.J.Sireesha", "10th B grade"));
        lessonList.add(new Lesson("Mathmatics", "Gond Surjyakant", "10th C grade"));
        lessonList.add(new Lesson("Physics", "Kiratkudave Snehal", "10th C grade"));
        lessonList.add(new Lesson("Physics", "Kiratkudave Snehal", "9th C grade"));
        lessonList.add(new Lesson("", "Shailkh Sana", "10th C grade"));
        lessonList.add(new Lesson("", "Shailkh Sana", "10th A grade"));
        lessonList.add(new Lesson("", "Shailkh Sana", "8th C grade"));
        lessonList.add(new Lesson("Drawing", "Swati Miss", "10th C grade"));
        lessonList.add(new Lesson("Drawing", "Swati Miss", "10th A grade"));
        lessonList.add(new Lesson("Drawing", "Swati Miss", "7th A grade"));
        lessonList.add(new Lesson("Drawing", "Swati Miss", "8th A grade"));
        lessonList.add(new Lesson("Drawing", "Swati Miss", "9th C grade"));
        lessonList.add(new Lesson("Drawing", "Swati Miss", "6th B grade"));
        lessonList.add(new Lesson("Drawing", "Swati Miss", "6th D grade"));
        lessonList.add(new Lesson("Drawing", "Ganesh Jagtap", "6th C grade"));
        lessonList.add(new Lesson("Drawing", "Swati Miss", "6th A grade"));
        lessonList.add(new Lesson("Drawing", "Swati Miss", "7th D grade"));
        lessonList.add(new Lesson("Drawing", "Swati Miss", "7th B grade"));
        lessonList.add(new Lesson("Drawing", "Swati Miss", "8th D grade"));
        lessonList.add(new Lesson("", "Phatare Komal", "10th C grade"));
        lessonList.add(new Lesson("Marathi", "New tr", "6th A grade"));
        lessonList.add(new Lesson("PE", "Chitra Rajwade", "6th B grade"));
        lessonList.add(new Lesson("", "Madhuri Miss", "6th B grade"));
        lessonList.add(new Lesson("Computer", "Rameshwari", "10th C grade"));
        lessonList.add(new Lesson("Computer", "Rameshwari", "8th D grade"));
        lessonList.add(new Lesson("PE", "Kirti", "9th B grade"));
        lessonList.add(new Lesson("PE", "Kirti", "8th B grade"));
        
    
        Lesson lesson = lessonList.get(0);
        lesson.setTimeslot(timeslotList.get(0));
        lesson.setRoom(roomList.get(0));

        lessonRepository.persist(lessonList);
    }

    public enum DemoData {
        NONE,
        SMALL,
        LARGE
    }

}
