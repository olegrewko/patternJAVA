package com.company.pattern;

public class CommandApp {
    public static void main(String[] args) {
        Comp c = new Comp();
        User u = new User(new StartCommand(c), new StopCommand(c), new ResetCommand(c));
        u.startComputer();
        u.stopComputer();
        u.resetComputer();

    }
}
interface Command {
    void execute();
}
class Comp {
    void start(){
        System.out.println("Start");
    }
    void stop(){
        System.out.println("Stop");
    }
    void reset(){
        System.out.println("Reset");
    }
}
class StartCommand implements Command {
Comp computer;
public StartCommand(Comp computer) {this.computer = computer;}

    @Override
    public void execute() {
    computer.start();
    }
}
class StopCommand implements Command {
    Comp computer;
    public StopCommand(Comp computer) {this.computer = computer;}

    @Override
    public void execute() {
        computer.stop();
    }
}
class ResetCommand implements Command {
    Comp computer;
    public ResetCommand(Comp computer) {this.computer = computer;}

    @Override
    public void execute() {
        computer.reset();
    }
}
class User {
    Command start;
    Command stop;
    Command reset;
    public User (Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    void startComputer() {
        start.execute();
    }
    void stopComputer() {
        stop.execute();
    }
    void resetComputer() {
        reset.execute();
    }
}
