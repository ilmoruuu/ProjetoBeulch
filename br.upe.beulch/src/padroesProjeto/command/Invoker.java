package padroesProjeto.command;

import padroesProjeto.command.commandInterface.Command;

public class Invoker {
    Command command;

    public void setCommand(Command command){
        this.command = command;
        executeCommand();
    }

    public void executeCommand(){
        command.execute();
    }
}
