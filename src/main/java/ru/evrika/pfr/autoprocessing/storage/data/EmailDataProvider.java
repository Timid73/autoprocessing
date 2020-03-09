package ru.evrika.pfr.autoprocessing.storage.data;

/**
 * Created by Sergei Balashov on 09.03.2020.
 */
public interface EmailDataProvider {

    String findEmailByRegNum(String regNum);
}
