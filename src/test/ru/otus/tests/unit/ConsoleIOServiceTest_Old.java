//package java.ru.otus.tests.unit;
//
//import ru.otus.currency_signer.services.ConsoleIOService;
//
////import java.io.ByteArrayInputStream;
////import java.io.ByteArrayOutputStream;
////import java.io.PrintStream;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.ru.otus.assertions.*;
//
//public class ConsoleIOServiceTest_Old {
//    public void testInput() {
//        String scenario = "Тест чтения строки";
//        try {
//            String expected = "45";
//            ByteArrayInputStream inputStream = new ByteArrayInputStream(expected.getBytes());
//            ConsoleIOService ioService = new ConsoleIOService();
//            String actual = ioService.readString();
//            Assertions.assertEquals(expected, actual);
//
//            System.out.printf("\"%s\" passed %n", scenario);
//        } catch (Throwable e) {
//            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
//        }
//    }
//
//    public void testOutput() {
//        String scenario = "Тест вывода строки";
//        try {
//            String expected = "output string";
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            ConsoleIOService ioService = new ConsoleIOService(new PrintStream(outputStream),new ByteArrayInputStream(new byte[0]));
//            ioService.outputString(expected);
//            String actual = outputStream.toString();
//            Assertions.assertEquals(expected + System.getProperty("line.separator"), actual);
//
//            System.out.printf("\"%s\" passed %n", scenario);
//        } catch (Throwable e) {
//            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
//        }
//    }
//
//    public void testFormattedOutput() {
//        String scenario = "Тест форматированного вывода строки";
//        try {
//            String template = "%s%d";
//            String expected = "Vladivostok2000";
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            ConsoleIOService ioService = new ConsoleIOService(new PrintStream(outputStream),
//                    new ByteArrayInputStream(new byte[0]));
//            ioService.outputString(template, "Vladivostok", 2000);
//            String actual = outputStream.toString();
//            Assertions.assertEquals(expected + System.getProperty("line.separator"), actual);
//
//            System.out.printf("\"%s\" passed %n", scenario);
//        } catch (Throwable e) {
//            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
//        }
//    }
//}
