package TodoList.Service;

import TodoList.Entity.TodoList;
import TodoList.Repository.TodoListRepository;
import TodoList.Repository.TodoListRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class TodoListServiceImpl  implements TodoListService{
    
    private final TodoListRepository todoListRepository;
    
    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }


    public void showTodoList() {
        int no = 1;
        List<TodoList> model = todoListRepository.getAll();
        for (int i = 0; i < model.size();i++){
            TodoList todo = model.get(i);
            if(todo != null){
                System.out.println(no+". "+todo.getTodo());
                no++;
            }
        }
        System.out.println();
        
    }


    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
    }

    public void removeTodoList(Integer number) {
            boolean success = todoListRepository.remove(number);
            if (success) {
                System.out.println("Berhasil Menghapus TodoList No-"+number);
            } else {
                System.out.println("Gagal Menghapus TodoList No-"+number);
            }

        } 
        
    }

    
    


