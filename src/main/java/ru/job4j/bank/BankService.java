package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает начальный функционал банковской системы.
 * @author EGOR BEKHTEREV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение всех пользователей системы с привязанными к ним счетами осуществляется в коллекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему.
     * @param user Для пользователя реализована проверка на уникальность пользователя.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет для пользователя.
     * @param passport Поиск счетов пользователя по паспорту.
     * @param account Доавбление нового счета к уже существующим. Реализована проверка на уникальность счета.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по паспорту.
     * @param passport На вход метод принимает номер паспорта.
     * @return Возвращает пользователя или null, если пользователь не найден.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет пользователя по реквизитам.
     * @param passport Поиск пользователя по номеру паспорта с помощью метода findByPassport.
     *                  Реализована проверка на уникальность пользователя.
     * @param requisite Поиск счета по реквизитам в списке счетов пользователя.
     * @return Возвращает счет пользователя или null, если счет не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            for (Account account : accountList) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления средств с одного счета на другой.
     * @param srcPassport Номер паспорта отправителя средств.
     * @param srcRequisite Номер счета отправителя средств.
     * @param destPassport Номер паспорта получателя средств.
     * @param destRequisite Номер счета получетля средств.
     * @param amount Сумма перевода.
     * @return Возвращает true при успешном выполнении операции и false в противоположном случае.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {
            rsl = true;
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return rsl;
    }

    /**
     * На вход метод принимает пользователя.
     * @return Возвращает список счетов пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
