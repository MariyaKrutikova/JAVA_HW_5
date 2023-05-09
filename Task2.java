/*Пусть дан список сотрудников:... .Написать программу, 
которая найдёт и выведет повторяющиеся имена с количеством повторений. 
Отсортировать по убыванию популярности. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        String [] list = {"Иван Иванов",
        "Светлана Петрова",
        "Кристина Белова",
        "Анна Мусина",
        "Анна Крутова",
        "Иван Юрин",
        "Петр Лыков",
        "Павел Чернов",
        "Петр Чернышов",
        "Мария Федорова",
        "Марина Светлова",
        "Мария Савина",
        "Мария Рыкова",
        "Марина Лугова", 
        "Анна Владимирова",
        "Иван Мечников",
        "Петр Петин",
        "Иван Ежов"};
        Map <String, Integer> one  = repeatOfNames(list);
        SortByCount(one);
    }

    private static Map <String, Integer> repeatOfNames (String [] list) {
        Map <String, Integer> repeatOfNames = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            String [] employee= list[i].split(" ");
            if (repeatOfNames.containsKey(employee[0])) {
                int countOfName = repeatOfNames.get(employee[0]) + 1;
                repeatOfNames.remove(employee[0]);
                repeatOfNames.put(employee[0], countOfName);
            }
            else repeatOfNames.put(employee[0], 1);
        }
        System.out.println(repeatOfNames);
        return repeatOfNames;
    }

    public static List <Map.Entry <String, Integer>> SortByCount (Map<String, Integer> repeatOfNames) {
        List <Map.Entry <String, Integer>> countList = new ArrayList<>(repeatOfNames.entrySet()); /*Список перевели в List */
        Collections.sort(countList, Comparator.comparing(Map.Entry::getValue));
        System.out.println(repeatOfNames);
        System.out.println(countList);
        return countList;
    }
}
