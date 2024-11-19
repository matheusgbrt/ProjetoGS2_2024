package Services;

import Entities.Project;
import Utils.DBConnection;
import Utils.ScreenWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDAO{

    public List<Project> GetProjects(Integer idusuario) {
        String sql = "SELECT GP.* FROM DBO_USUARIOS USR inner join RM551223.GREEN_PROJECTS GP on USR.IDUSUARIO = GP.USER_ID  where USR.IDUSUARIO = ?";
        List<Project> ret = new ArrayList<Project>();

        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idusuario);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Project _project = new Project(rs.getString("PROJECT_NAME"),rs.getInt("PROJECT_VOLUME"),rs.getInt("PROJECT_INITIAL_TEMP"),rs.getInt("PROJECT_FINAL_TEMP"));
                    ret.add(_project);
                }
            }
        } catch (SQLException e) {
            ScreenWriter.Write("Erro de seleção! " + e.getMessage());
            ret.clear();
        }
        return ret;
    }


}

