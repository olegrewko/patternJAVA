package com.company.pattern;

public class ChainApp {
    public static void main(String[] args) {
        SMSLogger logger01 = new SMSLogger(Level.ERROR);
        FileLogger logger02 = new FileLogger(Level.DEBUG);
        EmailLogger logger03 = new EmailLogger(Level.INFO);
        logger01.setNext(logger02);
        logger02.setNext(logger03);
        logger01.writeMessage("Все хорошо", Level.INFO);
        logger01.writeMessage("Идет режим отладки", Level.DEBUG);
        logger01.writeMessage("Система упала", Level.ERROR);
    }

}
class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}
interface Logger {
    void writeMessage(String message, int level);
}
class SMSLogger implements Logger {
    int priority;
    public SMSLogger(int priority) {this.priority = priority;}
    Logger next;
    public void setNext(Logger next) {this.next = next;}
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("СМС: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }

    }
}
class FileLogger implements Logger {
    int priority;
    public FileLogger(int priority) {this.priority = priority;}
    Logger next;
    public void setNext(Logger next) {this.next = next;}
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("Записываем в файл: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }

    }
}
class EmailLogger implements Logger {
    int priority;
    public EmailLogger(int priority) {this.priority = priority;}
    Logger next;
    public void setNext(Logger next) {this.next = next;}
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            System.out.println("E-mail сщщбщение: " + message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }

    }
}
