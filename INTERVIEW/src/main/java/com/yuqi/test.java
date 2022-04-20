package com.yuqi;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

public class test {
    public static void main(String[] args) {
        File file = new File("test.txt");
        File backup = new File ("test.txt.bak");
        backup.delete ();
        file.renameTo(backup);//Location 1
    }
}
