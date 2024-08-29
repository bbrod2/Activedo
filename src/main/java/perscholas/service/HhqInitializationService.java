package perscholas.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import perscholas.database.dao.HhqDAO;
import perscholas.database.entity.Hhq;

@Service
public class HhqInitializationService {

    @Autowired
    private HhqDAO hhqDao;

    @PostConstruct
    public void initializeHhqQuestions() {
        List<Hhq> questions = Arrays.asList(
                new Hhq("Heart Attack", "checkbox"),
                new Hhq("Heart Surgery", "checkbox"),
                new Hhq("Cardiac Catherization", "checkbox"),
                new Hhq("Cornary Angioplasty (PTCA)", "checkbox"),
                new Hhq("Pacemaker/Implantable Cardiac Defibrillator/Rhythm Disturbance", "checkbox"),
                new Hhq("Heart Valve Disease", "checkbox"),
                new Hhq("Heart Failure", "checkbox"),
                new Hhq("Heart Transplantation", "checkbox"),
                new Hhq("Congenital Heart Disease", "checkbox"),
                new Hhq("You Experience Chest Discomfort With Exertion", "checkbox"),
                new Hhq("You Experience Unreasonable Breathlesness", "checkbox"),
                new Hhq("You Experience Dizziness, Fainting, or Blackouts", "checkbox"),
                new Hhq("You Experience Ankle Swelling", "checkbox"),
                new Hhq("You Experience Unpleasant Awareness of a Forceful or Rapid Heart Rate", "checkbox"),
                new Hhq("You Take Heart Medications", "checkbox"),
                new Hhq("You Have Diabetes", "checkbox"),
                new Hhq("You Have Asthma or Other Lung Disease", "checkbox"),
                new Hhq("You Have Burning or Cramping Sensation In Your Lower Legs When Walking Short Distance", "checkbox"),
                new Hhq("You Have Musculoskeletal Problems That Limit Your Physical Activity", "checkbox"),
                new Hhq("You Have Concerns About the Safety of Exercise", "checkbox"),
                new Hhq("You Take Prescription Medications", "checkbox"),
                new Hhq("You Are Pregnant", "checkbox"),
                new Hhq("You Are a Man ≥ 45 YR", "checkbox"),
                new Hhq("You Are a Woman ≥ 55 YR", "checkbox"),
                new Hhq("You Smoke or Quit Smoking Within The Previous 6 MO", "checkbox"),
                new Hhq("Your Blood Pressure is ≥ 140/90 mm Hg", "checkbox"),
                new Hhq("You Do Not Know Your Blood Pressure", "checkbox"),
                new Hhq("You Take Blood Pressure Medications", "checkbox"),
                new Hhq("Your Blood Cholesterol Level is ≥ 200 mg • dL^-1", "checkbox"),
                new Hhq("You Do Not Know Your Cholseterol Level", "checkbox"),
                new Hhq("You Have A Close Blood Relative Who Had A Heart Attack or Heart Surgery Before Age 55 (Father or Brother) or Age 65 (Mother or Sister)", "checkbox"),
                new Hhq("You Are Physically Inactive (i.e., You Get < 30 Min Of Physical Activity on at Least 3 Days Per Week)", "checkbox"),
                new Hhq("You Have A Body Mass Index ≥ 30 Kg • m^-2", "checkbox"),
                new Hhq("You Have Prediabetes", "checkbox"),
                new Hhq("You Do Not Know If You Have Prediabetes", "checkbox"),
                new Hhq("None of the Above", "checkbox")
        );

        for (Hhq question : questions) {
            if (!hhqDao.existsByQuestion(question.getQuestion())) {
                hhqDao.save(question);
            }
        }
    }
}