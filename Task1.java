/*Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Map <String, List <String>> myPhoneBook = new HashMap<>();

    //    Заполнение телефонной книги начальными контактами.
        List <String> telephon1 = new LinkedList<>();
        List <String> telephon2 = new LinkedList<>();
        List <String> telephon3 = new LinkedList<>();
        telephon1.add("11111");
        telephon2.add("22222");
        telephon3.add("33333");
        telephon3.add("333111");
        myPhoneBook.put("Ivanov", telephon1);
        myPhoneBook.put("Petrov", telephon2);
        myPhoneBook.put("Semenov", telephon3);
        System.out.println(myPhoneBook);

        // Выбор опции для работы с телефонной книгой. Выполнение выбранной опции.
        Scanner sc = new Scanner(System.in);
        System.out.println("Укажите, что нужно сделать: 1 - add contact, 2 - delete contact, 3 - find contact,4 - change contact");
        String chooseOption = sc.nextLine();
        switch (chooseOption) {
            case "1":
                myPhoneBook = addContact(myPhoneBook);                            
                break;
            case "2":
                deliteContact(myPhoneBook);
                break;
            case "3":
                findContact(myPhoneBook);
                break;
            case "4":
                changeContact(myPhoneBook);
                break;
        }        
        sc.close();
    }

    // Метод, реализующий добавление новного контакта в телефонную книгу.
    private static Map <String, List <String>> addContact (Map <String, List <String>> phoneBook) {
        Scanner scanner = new Scanner(System.in, "cp866");

        System.out.println("Введите ФИО человека: ");
        String lastName = scanner.nextLine();

        List <String> telephons = new LinkedList<>(); /*В LinkedList telephons буду хранится все телефоны абонента*/

        System.out.println("Введите номер(а) телефона: ");
        
        boolean flag = true;
        while(flag) { /*Добавление телефонных номеров, пока не будет нажат Enter*/
            String number = scanner.nextLine();
            if (number.isEmpty()) flag = false;
            else telephons.add(number);
        }             

        phoneBook.put(lastName, telephons);
        System.out.println(phoneBook);
        scanner.close();
        return phoneBook;
              
    }

    // Метод, реализующий возможность изменить данные абонента.
    private static Map <String, List <String>> changeContact (Map <String, List <String>> phoneBook) {
        // Поиск абонента, чью данные нужно изменить.
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.println("Укажите фамилию абонента: ");
        String contact = scanner.nextLine();

        if (!phoneBook.containsKey(contact)) {
            System.out.println("Контакт не найден.");
            }
        else {        
            List <String> newTelephons = new LinkedList<>();       
            System.out.println("1 - изменить фамилию, 2 - изменить телефон."); /*Выбор опции по изменению данных*/
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println("Укажите фамилию: ");
                    String lastName = scanner.nextLine();
                    newTelephons = phoneBook.get(contact);
                    phoneBook.remove(contact);
                    phoneBook.put(lastName, newTelephons);
                    break;

                case "2":
                    boolean flag = true;
                    System.out.println("Введите новые номер(а) телефона: ");
                    while(flag) {
                        String number = scanner.nextLine();
                        if (number.isEmpty()) flag = false;
                        else newTelephons.add(number);
                    } 
                    phoneBook.remove(contact);
                    phoneBook.put(contact, newTelephons);
                    break;     
            }
        }
        System.out.println(phoneBook);
        scanner.close();
        return phoneBook;
    }

    // Метод поиска абонента.
    private static String findContact (Map <String, List <String>> phoneBook) {
        Scanner scanner = new Scanner(System.in, "cp866");
        System.out.println("Укажите фамилию абонента: ");
        String contact = scanner.nextLine();
        // System.out.println(contact);
        String toPrint = "";
        if (phoneBook.containsKey(contact)) {
                toPrint = contact + ": " + phoneBook.get(contact);
                System.out.println("_______");
                System.out.println(toPrint);
            }
            else System.out.println("Контакт не найден.");
            scanner.close();
        return contact;
        }

    //    Метод удаления абонента
        private static Map <String, List <String>> deliteContact (Map <String, List <String>> phoneBook) {
            Scanner scanner = new Scanner(System.in, "cp866");
            System.out.println("Укажите фамилию абонента: ");
            String contact = scanner.nextLine();
            if (phoneBook.containsKey(contact)) phoneBook.remove(contact);
            System.out.println(phoneBook);
            scanner.close();
            return phoneBook;
        }
        
    }
