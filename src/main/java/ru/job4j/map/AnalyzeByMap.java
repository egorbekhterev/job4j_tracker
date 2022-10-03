package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sum = 0;
        int score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum++;
                score += subject.score();
            }
        }
        return (double) score / sum;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                sum++;
            }
            Label label = new Label(pupil.name(),  (double) score / sum);
            labelList.add(label);
        }
        return labelList;
    }

//    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
//        Map<String, Integer> map = new LinkedHashMap<>();
//        List<Label> labelList = new ArrayList<>();
//        for (Pupil pupil : pupils) {
//            for (Subject subject : pupil.subjects()) {
//                    map.put(subject.name(), subject.score());
//            }
//        }
//        for (String key : map.keySet()) {
//            int value = map.get(key);
//            Label label = new Label(key, value / pupils.size());
//            labelList.add(label);
//        }
//        return labelList;
//    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            Label label = new Label(pupil.name(), score);
            labelList.add(label);
            labelList.sort(Comparator.naturalOrder());
        }
        return labelList.get(pupils.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}
