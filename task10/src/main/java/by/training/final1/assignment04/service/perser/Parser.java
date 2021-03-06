package by.training.final1.assignment04.service.perser;

import by.training.final1.assignment04.bean.Treasure;
import by.training.final1.assignment04.service.exception.ServiceException;

public class Parser {
    public Treasure parseString(String data) throws ServiceException {
        String[] array = data.split(" ");
        int price;
        try {
            price = Integer.parseInt(array[1]);
        } catch (NumberFormatException e) {
            throw new ServiceException("Parsing error", e.getCause());
        }
        return new Treasure(array[0], price);
    }
}
