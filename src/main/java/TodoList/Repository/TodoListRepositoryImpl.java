package TodoList.Repository;

import TodoList.Entity.TodoList;
import TodoList.util.DatabaseUtil;

import javax.sql.DataSource;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository{
    private DataSource dataSource;
    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<TodoList> getAll() {
        try (Connection connection = DatabaseUtil.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement
                     ("SELECT todo FROM todolist;");
             ResultSet resultSet = statement.executeQuery();){
            List<TodoList> list = new ArrayList<>();
            while (resultSet.next()){
                list.add(new TodoList(
                        resultSet.getString("todo")
                ));
            }
            return list;
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    
    @Override
    public void add(TodoList todo) {
        try (Connection connection = DatabaseUtil.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement
                     ("INSERT INTO todolist(todo) VALUES(?);")){
            statement.setString(1, todo.getTodo());
            statement.executeUpdate();
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }
    
    public Boolean isExist(Integer number){
        try (Connection connection = DatabaseUtil.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement
                     ("SELECT id FROM todolist WHERE todo = ?;")){
            statement.setString(1, conversi(number-1));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return true;
            }else{
                return  false;
            }
        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }
    @Override
    public boolean remove(Integer number) {
      if (isExist(number)) {
          try (Connection connection = DatabaseUtil.getDataSource().getConnection();
               PreparedStatement statement = connection.prepareStatement
                       ("DELETE FROM todolist WHERE todo = ?")) {
              statement.setString(1,conversi(number-1));
              statement.executeUpdate();
              return true;
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }else{
          return false;
      }
    }

    public String conversi(Integer number){
        List<TodoList> list = getAll();
        return list.get(number).getTodo();
    }

}
