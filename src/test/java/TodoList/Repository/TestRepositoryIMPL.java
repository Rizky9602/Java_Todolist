package TodoList.Repository;

import TodoList.Entity.TodoList;
import TodoList.util.DatabaseUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRepositoryIMPL {
    private DataSource dataSource;
    private TodoListRepository todoListRepository;
    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void AddTest() {
        TodoList todoList = new TodoList();
        todoList.setTodo("Test4");
        todoListRepository.add(todoList);
        Assertions.assertNotNull(todoListRepository);
    }

    @Test
    void RemoveTest() {
        System.out.println(todoListRepository.remove(1));

    }

    @Test
    void showTest() {
        List<TodoList> repository =  todoListRepository.getAll();

        for (int i = 0; i < repository.size(); i++) {
            System.out.println(repository.get(i).getTodo());
        }
    }
}
