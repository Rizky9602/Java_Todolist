package TodoList;

import TodoList.Repository.TodoListRepository;
import TodoList.Repository.TodoListRepositoryImpl;
import TodoList.Service.TodoListService;
import TodoList.Service.TodoListServiceImpl;
import TodoList.View.ViewTodoList;
import TodoList.util.DatabaseUtil;

import javax.sql.DataSource;

public class TodoList {
    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        ViewTodoList viewTodoList = new ViewTodoList(todoListService);
        viewTodoList.showTodoList();



    }
}
