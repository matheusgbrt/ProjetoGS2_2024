package View;

import Utils.Debug;
import Utils.Evaluator.EvalReturn;
import Utils.Evaluator.Evaluator;
import Utils.ScreenWriter;

import java.util.ArrayList;
import java.util.Arrays;

public class InitialState extends BaseState {
    public void AskMain(){
        WriteStart();
        Evaluator eval = new Evaluator("seleção",getSelectionPattern(new ArrayList<>(Arrays.asList(0,1, 2, 3, 4))));
        EvalReturn evalReturn = eval.EvalData();
        if (!evalReturn.valid){
            evalReturn.errors.forEach(ScreenWriter::Write);
            AskMain();
        }else{
            Decider(Integer.parseInt(evalReturn.message));
        }
    }

    public void WriteOptions(){
        ScreenWriter.WriteEmptyLine();
        ScreenWriter.Write("1. Login");
        ScreenWriter.Write("2. Cadastrar novo usuário");
        ScreenWriter.Write("3. Demonstrar aplicação");
        ScreenWriter.Write("0. Sair");
        ScreenWriter.WriteEmptyLine();
    }

    public void WriteStart(){
        ScreenWriter.WriteEmptyLine();
        ScreenWriter.WritePadded("Bem vindo ao sistema SCROOL Investimentos");
        ScreenWriter.Write("O que deseja fazer? Escolha nas opções abaixo!");
        WriteOptions();
        ScreenWriter.WriteEmptyLine();
    }

    private void Decider(Integer selection){
        switch(selection){
            case 0:
                ScreenWriter.Write("Até mais!");
                break;
            case 1:
                LoginState login = new LoginState();
                login.GetUserData();
                break;
            case 2:
                RegisterState  register = new RegisterState();
                register.GetUserData();
                break;
            case 3:
                Debug.debug();
                AskMain();
                break;
        }
    }
}
