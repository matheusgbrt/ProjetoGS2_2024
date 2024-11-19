package View;

import Utils.Evaluator.EvalReturn;
import Utils.Evaluator.Evaluator;
import Utils.ScreenWriter;

import java.util.Objects;

public class RegisterProject extends BaseState {
    Evaluator eval = new Evaluator("Usuário");
    String _projectName;
    int _projectVolume;
    int _startingTemp;
    int _finalTemp;


    public RegisterProject() {
        ScreenWriter.WritePadded("Cadastro do projeto");
        ScreenWriter.Write("Digite as informações requisitadas. Caso deseje cancelar a operação, digite SAIR a qualquer momento.");
        GetProject();
    }

    public void GetProject() {
        GetProjectName();
        GetProjectVolume();
        GetProjectStartingTemp();
        GetProjetFinalTemp();
    }


    private void GetProjectVolume() {
        ScreenWriter.WriteEmptyLine();
        ScreenWriter.Write("Volume de água utilizada por dia:");
        eval.setField("Volume de água");
        eval.setPattern(getBasicintegerPattern());
        EvalReturn _ret = eval.EvalData();
        if (Objects.equals(_ret.message, "SAIR")) {
            InitialState state = new InitialState();
            state.AskMain();
            return;
        }
        if (!_ret.valid) {
            _ret.errors.forEach(ScreenWriter::Write);
            GetProjectVolume();
        } else {
            _projectVolume = Integer.parseInt(_ret.message);
        }
    }

    private void GetProjectStartingTemp() {
        ScreenWriter.WriteEmptyLine();
        ScreenWriter.Write("Temperatura de entrada da água em ºC:");
        eval.setField("Temperatura de entrada");
        eval.setPattern(getBasicintegerPattern());
        EvalReturn _ret = eval.EvalData();
        if (Objects.equals(_ret.message, "SAIR")) {
            InitialState state = new InitialState();
            state.AskMain();
            return;
        }
        if (!_ret.valid) {
            _ret.errors.forEach(ScreenWriter::Write);
            GetProjectStartingTemp();
        } else {
            _startingTemp = Integer.parseInt(_ret.message);
        }
    }

    private void GetProjetFinalTemp() {
        ScreenWriter.WriteEmptyLine();
        ScreenWriter.Write("Temperatura de saída da água em ºC:");
        eval.setField("Temperatura de saída");
        eval.setPattern(getMinMaxIntegerPattern(_startingTemp,99999999));
        EvalReturn _ret = eval.EvalData();
        if (Objects.equals(_ret.message, "SAIR")) {
            InitialState state = new InitialState();
            state.AskMain();
            return;
        }
        if (!_ret.valid) {
            _ret.errors.forEach(ScreenWriter::Write);
            GetProjetFinalTemp();
        } else {
            _finalTemp = Integer.parseInt(_ret.message);
        }
    }





    private void GetProjectName() {
        ScreenWriter.WriteEmptyLine();
        ScreenWriter.Write("Nome do projeto:");
        eval.setField("Nome do projeto");
        eval.setPattern(getProjectNamePattern());
        EvalReturn _ret = eval.EvalData();
        if (Objects.equals(_ret.message, "SAIR")) {
            InitialState state = new InitialState();
            state.AskMain();
            return;
        }
        if (!_ret.valid) {
            _ret.errors.forEach(ScreenWriter::Write);
            GetProjectName();
        } else {
            _projectName = _ret.message;
        }
    }



}
