package TodoList.Repository;

import TodoList.Entity.TodoList;

import java.util.List;

public interface TodoListRepository {

    List<TodoList> getAll();

    void add(TodoList todo);

     boolean remove(Integer number);
}
