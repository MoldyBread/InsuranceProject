package com.company.firstproject.utils;

import com.company.firstproject.entity.obligations.Obligation;
import com.company.firstproject.exceptions.InvalidValuesException;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
    private static final Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    public static Obligation[] serializationUtil() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obligations.dat"))) {
            return (Obligation[]) ois.readObject();
        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.getMessage());
        }
        return new Obligation[0];
    }

    public static void validationUtil(int id, double payoutAmount) throws InvalidValuesException {
        if (payoutAmount < 0 || id < 0) {
            throw new InvalidValuesException("Id or payout amount value is wrong");
        }
    }
}
