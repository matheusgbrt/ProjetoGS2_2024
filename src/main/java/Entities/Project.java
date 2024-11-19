package Entities;

public class Project {


    String _project_name;
    private final int _project_volume;
    private final int _project_initial_temp;
    private final int _project_final_temp;

    public Project(String project_name, int project_volume, int project_initial_temp, int project_final_temp) {
        this._project_name = project_name;
        this._project_volume = project_volume;
        this._project_initial_temp = project_initial_temp;
        this._project_final_temp = project_final_temp;
    }

    public String getProject_name() {
        return _project_name;
    }

    public int getProject_volume() {
        return _project_volume;
    }
    public int getProject_initial_temp() {
        return _project_initial_temp;
    }
    public int getProject_final_temp() {
        return _project_final_temp;
    }

}
