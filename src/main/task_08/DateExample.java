package main.task_08;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateExample {

    // замена на современный, потокобезопасный класс; вынесение формата в константу
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String dateString = "2024-05-13 14:30:00";
        ZoneId zoneIdSamara = ZoneId.of("Europe/Samara");
        ZoneId zoneIdUTC = ZoneId.of("UTC");

        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateString, FORMAT);
            System.out.println("Date: " + dateTime);

            // привязка таймзоны к дате, т.к. в дальнейшем может потребоваться вывести эту дату в другой таймзоне
            ZonedDateTime zonedDateTimeSamara =dateTime.atZone(zoneIdSamara);
            System.out.println("Date with timezone (Samara): " + zonedDateTimeSamara);

            // преобразование в другую таймзону (UTC)
            ZonedDateTime zonedDateTimeUTC = zonedDateTimeSamara.withZoneSameInstant(zoneIdUTC);
            System.out.println("Date with timezone (UTC): " + zonedDateTimeUTC);

        } catch (DateTimeParseException e) {
            // специализированное исключение и улучшенное сообщение об ошибке
            System.err.println("Error parsing date string: " + dateString + ". Error: " + e.getMessage());
        }
    }

}
